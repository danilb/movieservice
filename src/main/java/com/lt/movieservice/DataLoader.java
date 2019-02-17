package com.lt.movieservice;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonArray;
import com.couchbase.client.java.document.json.JsonObject;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import rx.Observable;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@Component
public class DataLoader implements CommandLineRunner {

    private static final Logger LOG
            = LoggerFactory.getLogger(DataLoader.class);

    @Autowired
    private Bucket cbBucket;

    @Override
    public void run(String... args) throws Exception {

        if (!Arrays.asList(args).contains("init")) return;

        LOG.info("INIT DATA LOAD TO COUCHBASE");

        File titleBasicsInfo = new ClassPathResource("data/title.basics.tsv").getFile();
        File titleCrewInfo = new ClassPathResource("data/title.crew.tsv").getFile();
        File titleRatingsInfo = new ClassPathResource("data/title.ratings.tsv").getFile();

        FileReader basicInfoReader = new FileReader(titleBasicsInfo);
        FileReader crewInfoReader = new FileReader(titleCrewInfo);
        FileReader ratingsInfoReader = new FileReader(titleRatingsInfo);

        CSVParser basicInfoParser = new CSVParserBuilder().withSeparator('\t').build();
        CSVParser crewInfoParser = new CSVParserBuilder().withSeparator('\t').build();
        CSVParser ratingsInfoParser = new CSVParserBuilder().withSeparator('\t').build();

        CSVReader basicInfo = new CSVReaderBuilder(basicInfoReader).withCSVParser(basicInfoParser).build();
        CSVReader crewInfo = new CSVReaderBuilder(crewInfoReader).withCSVParser(crewInfoParser).build();
        CSVReader ratingsInfo = new CSVReaderBuilder(ratingsInfoReader).withCSVParser(ratingsInfoParser).build();

        basicInfo.skip(1);
        crewInfo.skip(1);
        ratingsInfo.skip(1);

/*
        Observable
                .from(basicInfo)
                .map(
                        line -> {
                            JsonObject jsonObject = JsonObject.create();

                            jsonObject.put("tconst", line[0]);
                            jsonObject.put("titleType", line[1]);
                            jsonObject.put("primaryTitle", line[2]);
                            jsonObject.put("originalTitle", line[3]);
                            jsonObject.put("isAdult", line[4]);
                            jsonObject.put("startYear", line[5]);
                            jsonObject.put("endYear", line[6]);
                            jsonObject.put("runtimeMinutes", line[7]);
                            jsonObject.put("genres", (line.length == 9) ? getJsonArray(line[8]) : "[]");
                            jsonObject.put("directors", JsonArray.create());
                            jsonObject.put("writers", JsonArray.create());
                            jsonObject.put("averageRating", "");
                            jsonObject.put("numVotes", "");

                            JsonDocument document = JsonDocument.create(line[0], jsonObject);

                            return document;
                        }
                )
                .subscribe(document -> cbBucket.upsert(document), error -> LOG.error(error.getMessage()));
*/

        Observable
                .from(crewInfo)
                .map(
                        line -> {

                            JsonDocument document = cbBucket.get(line[0]);
                            JsonObject jsonObject = document.content();
                            jsonObject.put("directors", getJsonArray(line[1]));
                            jsonObject.put("writers", getJsonArray(line[2]));

                            return document;
                        }
                )
                .subscribe(document -> cbBucket.upsert(document), error -> LOG.error(error.getMessage()));

        Observable
                .from(ratingsInfo)
                .map(
                        line -> {

                            JsonDocument document = cbBucket.get(line[0]);
                            JsonObject jsonObject = document.content();
                            jsonObject.put("averageRating", getJsonArray(line[1]));
                            jsonObject.put("numVotes", getJsonArray(line[2]));

                            return document;
                        }
                )
                .subscribe(document -> cbBucket.upsert(document), error -> LOG.error(error.getMessage()));


    }

    private JsonArray getJsonArray(String s) {

        JsonArray jsonArray = JsonArray.create();

        for (String g : s.split(",")) {
            jsonArray.add(g);
        }

        return jsonArray;
    }

}
