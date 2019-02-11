package com.lt.movieservice.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "Rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "titleId", referencedColumnName = "titleId", nullable = false, unique = true)
    private Title title;

    @Column
    private Double averageRating;

    @Column
    private Integer numOfVotes;


    public String getId() {
        return id;
    }

    public Rating setId(String id) {
        this.id = id;
        return this;
    }

    public Title getTitle() {
        return title;
    }

    public Rating setTitle(Title title) {
        this.title = title;
        return this;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public Rating setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
        return this;
    }

    public Integer getNumOfVotes() {
        return numOfVotes;
    }

    public Rating setNumOfVotes(Integer numOfVotes) {
        this.numOfVotes = numOfVotes;
        return this;
    }
}
