package com.lt.movieservice.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NaturalId
    @Column(nullable = false, unique = true)
    private String nameId;

    @Column
    private String primaryName;

    @Column
    private Date birthDay;

    @Column
    private Date deathDay;

    @Column
    private String primaryProfession;

    @ManyToMany
    @JoinColumn(name = "nameId", referencedColumnName = "titleId")
    private List<Title> titles;

}
