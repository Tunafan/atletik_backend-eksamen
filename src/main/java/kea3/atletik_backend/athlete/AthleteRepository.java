package kea3.atletik_backend.athlete;

import kea3.atletik_backend.club.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AthleteRepository extends JpaRepository<Athlete, Long> {
    Athlete getById(Long id);
    Athlete findByName(String name);
}

