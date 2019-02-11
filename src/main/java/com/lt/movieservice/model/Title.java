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

}
