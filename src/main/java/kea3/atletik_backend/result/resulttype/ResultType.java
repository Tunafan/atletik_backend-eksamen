package kea3.atletik_backend.result.resulttype;

import jakarta.persistence.*;
import kea3.atletik_backend.athlete.Athlete;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter

public class ResultType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    private ResultTypeEnum resultType;
    @ManyToOne
    private Athlete athlete;
}