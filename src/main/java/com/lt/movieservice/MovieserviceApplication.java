package com.lt.movieservice;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileReader;

@SpringBootApplication
public class MovieserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieserviceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadDataFromFiles() {
		return (args) ->{
/*
			JsonObject jsonObject = JsonObject.create();

			jsonObject.put("testfield1", "value1");

			JsonDocument document =  JsonDocument.create("test1" , jsonObject);

			cbBucket.upsert(document);

			System.out.println("");

			JsonObject jsonObject2 = JsonObject.create();

			jsonObject2.put("testfield2", "value2");

			JsonDocument document2 =  JsonDocument.create("test1" , jsonObject2);

			cbBucket.upsert(document2);

			System.out.println("");
*/
/*
            File file = new ClassPathResource("data/name.basics.tsv").getFile();
			FileReader fileReader = new FileReader(file);

			CSVParser csvParser = new CSVParserBuilder().withSeparator('\t').build();
			CSVReader csvReader = new CSVReaderBuilder(fileReader).withCSVParser(csvParser).build();

			String[] headers = csvReader.readNext();

			String[] line;
			while ((line = csvReader.readNext()) != null) {
				JsonObject jsonObject = JsonObject.create();

				for (int i = 0; i < headers.length; i++) {
					jsonObject.put(headers[i], line[i]);
				}


				JsonDocument document =  JsonDocument.create(line[0] , jsonObject);

				cbBucket.upsert(document);

			}

			fileReader.close();
			csvReader.close();
*/
		};
	}

}

