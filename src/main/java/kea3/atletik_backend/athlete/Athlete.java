package kea3.atletik_backend.athlete;

import jakarta.persistence.*;
import kea3.atletik_backend.club.Club;
import kea3.atletik_backend.discipline.Discipline;
import kea3.atletik_backend.result.resulttype.ResultType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Athlete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String gender;
    private int age;

    @ManyToOne
    private Club club;
    @ManyToMany
    private List<Discipline> disciplines;
    @OneToMany(mappedBy = "athlete", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ResultType> results;
    public Athlete(){

    }
    public Athlete(String name, String gender, int age, Club club, List<Discipline> disciplines, List<ResultType> results) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.club = club;
        this.disciplines = disciplines;
        this.results = results;
    }

    public Athlete(String name, String gender, int age, Club club, List<Discipline> disciplines) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.club = club;
        this.disciplines = disciplines;
    }
    public Athlete(String name, int age, Club club) {
        this.name = name;
        this.age = age;
        this.club = club;
    }

    public Athlete(String name, String gender, int age, Club club) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.club = club;
    }
}