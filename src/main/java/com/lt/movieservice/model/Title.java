package com.lt.movieservice.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Title")
public class Title {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NaturalId
    @Column(nullable = false, unique = true)
    private String titleId;

    @Column
    private String titleType;

    @Column
    private String primaryTitle;

    @Column
    private String originalTitle;

    @Column
    private Boolean isAdult;

    @Column
    private Date startYear;

    @Column
    private Date endYear;

    @Column
    private Integer runtimeMinutes;

    @Column
    private String genres;

    public Long getId() {
        return id;
    }

    public Title setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitleId() {
        return titleId;
    }

    public Title setTitleId(String titleId) {
        this.titleId = titleId;
        return this;
    }

    public String getTitleType() {
        return titleType;
    }

    public Title setTitleType(String titleType) {
        this.titleType = titleType;
        return this;
    }

    public String getPrimaryTitle() {
        return primaryTitle;
    }

    public Title setPrimaryTitle(String primaryTitle) {
        this.primaryTitle = primaryTitle;
        return this;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public Title setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
        return this;
    }

    public Boolean getAdult() {
        return isAdult;
    }

    public Title setAdult(Boolean adult) {
        isAdult = adult;
        return this;
    }

    public Date getStartYear() {
        return startYear;
    }

    public Title setStartYear(Date startYear) {
        this.startYear = startYear;
        return this;
    }

    public Date getEndYear() {
        return endYear;
    }

    public Title setEndYear(Date endYear) {
        this.endYear = endYear;
        return this;
    }

    public Integer getRuntimeMinutes() {
        return runtimeMinutes;
    }

    public Title setRuntimeMinutes(Integer runtimeMinutes) {
        this.runtimeMinutes = runtimeMinutes;
        return this;
    }

    public String getGenres() {
        return genres;
    }

    public Title setGenres(String genres) {
        this.genres = genres;
        return this;
    }
}
