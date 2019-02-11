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
    @JoinColumn(name = "titleId", referencedColumnName = "titleId")
    private Title title;

    @Column
    private Double averageRating;

    @Column
    private Integer numOfVotes;

}
