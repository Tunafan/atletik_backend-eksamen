package kea3.atletik_backend.club;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;

    public Club() {
    }
    public Club(Long id) {
        this.id = id;
    }
    public Club(String name) {
        this.name = name;
    }

    public Club(String name, String city) {
        this.name = name;
        this.city = city;
    }
    public Club(Long id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }
public Club(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}