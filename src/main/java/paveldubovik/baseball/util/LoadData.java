package paveldubovik.baseball.util;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import paveldubovik.baseball.player.dto.PlayerDto;
import paveldubovik.baseball.player.service.PlayerService;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class LoadData {
    private final PlayerService service;

    @Value("${app.baseball.file:./player.csv}")
    private String filename;

    @Bean
    public CommandLineRunner inti() {
        return args -> {
            log.debug("Loading data from file");
            loadFromFile();
        };
    }

    private void loadFromFile() {
        try (FileReader reader = new FileReader(filename)) {
            log.info("Start to read file");
            List<PlayerDto> players = new CsvToBeanBuilder<PlayerDto>(reader).withType(PlayerDto.class).build().parse();
            for (PlayerDto playerDto : players) {
                log.trace("Create object {}", playerDto);
                service.savePlayer(playerDto);
            }
            log.info("Finish to read file");
        } catch (IOException e) {
            log.warn("Error reading file");
            throw new RuntimeException(e);
        }
    }
}
