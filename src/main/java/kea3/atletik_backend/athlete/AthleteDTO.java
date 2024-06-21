package kea3.atletik_backend.athlete;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AthleteDTO {
    private Long memberId;
    private String name;
    private String gender;
    private int age;
    private String clubName;

}