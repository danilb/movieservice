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
    //@JoinColumn(name = "nameId", referencedColumnName = "titleId")
    private List<Title> titles;

    public Long getId() {
        return id;
    }

    public Person setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNameId() {
        return nameId;
    }

    public Person setNameId(String nameId) {
        this.nameId = nameId;
        return this;
    }

    public String getPrimaryName() {
        return primaryName;
    }

    public Person setPrimaryName(String primaryName) {
        this.primaryName = primaryName;
        return this;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public Person setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
        return this;
    }

    public Date getDeathDay() {
        return deathDay;
    }

    public Person setDeathDay(Date deathDay) {
        this.deathDay = deathDay;
        return this;
    }

    public String getPrimaryProfession() {
        return primaryProfession;
    }

    public Person setPrimaryProfession(String primaryProfession) {
        this.primaryProfession = primaryProfession;
        return this;
    }

    public List<Title> getTitles() {
        return titles;
    }

    public Person setTitles(List<Title> titles) {
        this.titles = titles;
        return this;
    }
}
