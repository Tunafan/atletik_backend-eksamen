package kea3.atletik_backend.club;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClubService {

    @Autowired
    private final ClubRepository clubRepository;

    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    public ClubDTO createClub(ClubDTO clubDTO) {
        Club club = new Club(clubDTO.getName(), clubDTO.getCity());
        clubRepository.save(club);
        return new ClubDTO(club.getId(), club.getName(), club.getCity());
    }

    public ClubDTO getClub(Long id) {
        Club club = clubRepository.getById(id);
        return new ClubDTO(club.getId(), club.getName(), club.getCity());
    }
    public Iterable<ClubDTO> getAllClubs() {
        return clubRepository.findAll().stream().map(club -> new ClubDTO(club.getId(), club.getName(), club.getCity())).toList();
    }
    public ClubDTO getClubByName(String name) {
        Club club = clubRepository.findByName(name);
        return new ClubDTO(club.getId(), club.getName(), club.getCity());
    }

    public ClubDTO updateClub(ClubDTO clubDTO) {
        Club club = clubRepository.getById(clubDTO.getId());
        club.setName(clubDTO.getName());
        club.setCity(clubDTO.getCity());
        clubRepository.save(club);
        return new ClubDTO(club.getId(), club.getName(), club.getCity());
    }

    public void deleteClub(Long id) {
        clubRepository.deleteById(id);
    }
public ClubDTO convertToDTO(Club club) {
        ClubDTO clubDTO = new ClubDTO();
        clubDTO.setId(club.getId());
        clubDTO.setName(club.getName());
        clubDTO.setCity(club.getCity());
        return clubDTO;
    }
}
