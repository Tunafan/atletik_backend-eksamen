package kea3.atletik_backend.athlete;

import kea3.atletik_backend.club.Club;
import kea3.atletik_backend.club.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AthleteService {

    @Autowired
    private AthleteRepository athleteRepository;

    @Autowired
    private ClubRepository clubRepository;

    public AthleteDTO createAthlete(AthleteDTO athleteDTO) {
        Athlete athlete = new Athlete();
        athlete.setName(athleteDTO.getName());
        athlete.setGender(athleteDTO.getGender());
        athlete.setAge(athleteDTO.getAge());
        
        Club club = clubRepository.findByName(athleteDTO.getClubName());
        if (club == null) {
            throw new RuntimeException("Club not found: " + athleteDTO.getClubName());
        }
        athlete.setClub(club);

        Athlete savedAthlete = athleteRepository.save(athlete);
        return convertToDTO(savedAthlete);
    }

    public List<AthleteDTO> getAllAthletes() {
        List<Athlete> athletes = athleteRepository.findAll();
        return athletes.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public AthleteDTO getAthleteById(Long id) {
        Athlete athlete = athleteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Athlete not found"));
        return convertToDTO(athlete);
    }

    public void deleteAthlete(Long id) {
        athleteRepository.deleteById(id);
    }
    public AthleteDTO updateAthlete(Long id, AthleteDTO athleteDTO) {
        Athlete athlete = athleteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Athlete not found"));

        athlete.setName(athleteDTO.getName());
        athlete.setGender(athleteDTO.getGender());
        athlete.setAge(athleteDTO.getAge());
        Club club = clubRepository.findByName(athleteDTO.getClubName());
        athlete.setClub(club);

        Athlete updatedAthlete = athleteRepository.save(athlete);
        return convertToDTO(updatedAthlete);
    }


    private AthleteDTO convertToDTO(Athlete athlete) {
        AthleteDTO athleteDTO = new AthleteDTO();
        athleteDTO.setMemberId(athlete.getId());
        athleteDTO.setName(athlete.getName());
        athleteDTO.setGender(athlete.getGender());
        athleteDTO.setAge(athlete.getAge());
        athleteDTO.setClubName(athlete.getClub().getName());
        return athleteDTO;
    }
}
