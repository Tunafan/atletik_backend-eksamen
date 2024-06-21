package kea3.atletik_backend.club;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/clubs")
public class ClubController {

        @Autowired
        private ClubService clubService;

        @PostMapping("/create")
        public ClubDTO createClub(ClubDTO clubDTO) {
            return clubService.createClub(clubDTO);
        }

        @GetMapping("/all")
        public Iterable<ClubDTO> getAllClubs() {
            return clubService.getAllClubs();
        }

        @GetMapping("/{id}")
        public ClubDTO getClub(Long id) {
            return clubService.getClub(id);
        }

}
