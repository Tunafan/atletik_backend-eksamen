package kea3.atletik_backend.result.resultpoints;

import jakarta.persistence.Entity;
import kea3.atletik_backend.result.resulttype.ResultType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ResultPoints extends ResultType {
        private int points;
}