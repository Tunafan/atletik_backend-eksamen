package kea3.atletik_backend.athlete;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AthleteIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AthleteRepository athleteRepository;

    @Test
    public void testDeleteAthlete() throws Exception {
        // Først opretter vi en atlet
        mockMvc.perform(post("/athletes/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Pernille Landmose\", \"gender\":\"Kvinde\", \"age\":25, \"clubName\":\"Sparta Atletik\"}"))
                .andExpect(status().isOk());

        // Hent "Pernille Lundmose" direkte
        Athlete athlete = athleteRepository.findByName("Pernille Landmose");
        if (athlete == null) {
            throw new RuntimeException("Athlete not found");
        }

        // Slet atleten
        mockMvc.perform(delete("/athletes/" + athlete.getId()))
                .andExpect(status().isNoContent());

        // Bekræft atleten er slettet
        Optional<Athlete> deletedAthlete = athleteRepository.findById(athlete.getId());
        assertThat(deletedAthlete).isEmpty();
    }
}
