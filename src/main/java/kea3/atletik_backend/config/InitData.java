package kea3.atletik_backend.config;

import kea3.atletik_backend.athlete.Athlete;
import kea3.atletik_backend.athlete.AthleteRepository;
import kea3.atletik_backend.club.Club;
import kea3.atletik_backend.club.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private AthleteRepository athleteRepository;

    @Override
    public void run(String... args) {
        System.out.println("System booting");
        createData();
        System.out.println("Data created");
    }

    public void createData() {
        System.out.println("Creating data...");
        List<Club> clubs = List.of(
                new Club("Sparta Atletik", "København"),
                new Club("Kolbøttefabrikken", "Ikast"),
                new Club("Blovstrød Løverne", "Blovstrød"),
                new Club("Hellas Roskilde", "Roskilde"),
                new Club("Idrætsforeningen Gullfoss", "Aalborg")
        );
        for (Club club : clubs) {
            Club existingClub = clubRepository.findByName(club.getName());
            if (existingClub == null) {
                clubRepository.save(club);
                System.out.println("Saved club: " + club.getName());
            } else {
                System.out.println("Club already exists: " + club.getName());
            }
        }

        List<Athlete> athletes = List.of(
                new Athlete("Tycho Ibraheim", "Mand", 38, clubRepository.findByName("Sparta Atletik")),
                new Athlete("Henriette Lundmose", "Kvinde", 25, clubRepository.findByName("Kolbøttefabrikken")),
                new Athlete("Karen Mukupa", "Mand", 29, clubRepository.findByName("Blovstrød Løverne")),
                new Athlete("Mikkel Kessler", "Mand", 41, clubRepository.findByName("Hellas Roskilde")),
                new Athlete("Mette Frederiksen", "Kvinde", 43, clubRepository.findByName("Idrætsforeningen Gullfoss")),
                new Athlete("Malthe Ebert", "Mand", 22, clubRepository.findByName("Sparta Atletik")),
                new Athlete("Mikkel Hansen", "Mand", 33, clubRepository.findByName("Kolbøttefabrikken")),
                new Athlete("Theresa Ann Fallesen", "Kvinde", 27, clubRepository.findByName("Blovstrød Løverne")),
                new Athlete("Khadijah bint Khuwaylid", "Kvinde", 40, clubRepository.findByName("Hellas Roskilde")),
                new Athlete("Simone Frellsen", "Kvinde", 7, clubRepository.findByName("Sparta Atletik"))
        );
        for (Athlete athlete : athletes) {
            Athlete existingAthlete = athleteRepository.findByName(athlete.getName());
            if (existingAthlete == null) {
                athleteRepository.save(athlete);
                System.out.println("Saved athlete: " + athlete.getName());
            } else {
                System.out.println("Athlete already exists: " + athlete.getName());
            }
        }
    }
}
