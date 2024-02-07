package paveldubovik.baseball.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import paveldubovik.baseball.player.dto.PlayerDto;
import paveldubovik.baseball.player.service.PlayerService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class LoadData {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final PlayerService service;

    String filename = "./player.csv";

    @Bean
    public CommandLineRunner inti() {
        return args -> {
            log.debug("Loading data from file");

            loadFromFile(filename);
        };
    }

    public void loadFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine();
            log.info("Start to read file");
            while ((line = br.readLine()) != null) {
                String delimiter = ",";
                String[] data = line.split(delimiter);
                if (data.length < 24)
                    continue;
                String playerId = data[0];
                Integer birthYear = (data[1].isEmpty()) ? null : Integer.valueOf(data[1]);
                Byte birthMonth = (data[2].isEmpty()) ? null : Byte.parseByte(data[2]);
                Byte birthDay = (data[3].isEmpty()) ? null : Byte.parseByte(data[3]);
                String birthCountry = data[4];
                String birthState = data[5];
                String birthCity = data[6];
                Integer deathYear = (data[7].isEmpty()) ? null : Integer.parseInt(data[7]);
                Byte deathMonth = (data[8].isEmpty()) ? null : Byte.parseByte(data[8]);
                Byte deathDay = (data[9].isEmpty()) ? null : Byte.parseByte(data[9]);
                String deathCountry = data[10];
                String deathState = data[11];
                String deathCity = data[12];
                String nameFirst = data[13];
                String nameLast = data[14];
                String nameGiven = data[15];
                Integer weight = (data[16].isEmpty()) ? null : Integer.parseInt(data[16]);
                Integer height = (data[17].isEmpty()) ? null : Integer.parseInt(data[17]);
                Character battingHand = (data[18].isEmpty()) ? null : data[18].charAt(0);
                Character throwingHand = (data[19].isEmpty()) ? null : data[19].charAt(0);
                LocalDate debut = data[20].isEmpty() ? null : LocalDate.parse(data[20], formatter);
                LocalDate finalGame = (data[21].isEmpty()) ? null : LocalDate.parse(data[21], formatter);
                String retroID = data[22];
                String bbrefID = data[23];
                PlayerDto playerDto = new PlayerDto(playerId, birthYear, birthMonth, birthDay, birthCountry, birthState, birthCity, deathYear, deathMonth, deathDay,
                        deathCountry, deathState, deathCity, nameFirst, nameLast, nameGiven, weight, height, battingHand, throwingHand, debut, finalGame,
                        retroID, bbrefID);
                log.trace("Create object {}", playerDto);
                service.savePlayer(playerDto);
            }
        } catch (IOException e) {
            log.warn("File not found");
        }
        log.info("Finish to read file");
    }
}
