package kea3.atletik_backend.athlete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/athletes")
public class AthleteController {

    @Autowired
    private AthleteService athleteService;

    @PostMapping("/create")
    public ResponseEntity<AthleteDTO> createAthlete(@RequestBody AthleteDTO athleteDTO) {
        AthleteDTO savedAthlete = athleteService.createAthlete(athleteDTO);
        return ResponseEntity.ok(savedAthlete);
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<AthleteDTO>> getAllAthletes() {
        Iterable<AthleteDTO> athletes = athleteService.getAllAthletes();
        return ResponseEntity.ok(athletes);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AthleteDTO> getAthlete(@PathVariable Long id) {
        AthleteDTO athlete = athleteService.getAthleteById(id);
        return ResponseEntity.ok(athlete);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<AthleteDTO> updateAthlete(@PathVariable Long id, @RequestBody AthleteDTO athleteDTO) {
        AthleteDTO updatedAthlete = athleteService.updateAthlete(id, athleteDTO);
        return ResponseEntity.ok(updatedAthlete);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAthlete(@PathVariable Long id) {
        athleteService.deleteAthlete(id);
        return ResponseEntity.noContent().build();
    }
}
