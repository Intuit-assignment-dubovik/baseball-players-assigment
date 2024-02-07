package paveldubovik.baseball.player.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import paveldubovik.baseball.exception.PlayerNotFoundException;
import paveldubovik.baseball.player.dto.PlayerDto;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = "classpath:test_data.sql")
//('abadijo01', 1850, 11, 4, 'USA', 'PA', 'Philadelphia', 1905, 5, 17, 'USA', 'NJ', 'Pemberton', 'John', 'Abadie',
//        'John W.', 192, 72, 'R', 'R', '1875-04-26', '1875-06-10', 'abadj101', 'abadijo01'),

//('abbated01', 1877, 4, 15, 'USA', 'PA', 'Latrobe', 1957, 1, 6, 'USA', 'FL', 'Fort Lauderdale', 'Ed', 'Abbaticchio',
//        'Edward James', 170, 71, 'R', 'R', '1897-09-04', '1910-09-15', 'abbae101', 'abbated01');
class PlayerServiceTest {
    @Autowired
    private PlayerService service;

    @Test
    void testGetPlayers() {
        List<PlayerDto> players = service.getPlayers();
        assertNotNull(players);
        assertFalse(players.isEmpty());
        assertEquals(2, players.size());
    }

    @Test
    void getPlayerByID() {
        // Given
        String playerId = "abadijo01";
        int birthYear = 1850;
        byte birthMonth = 11;
        byte birthDay = 4;
        String birthCountry = "USA";
        String birthState = "PA";
        String birthCity = "Philadelphia";
        int deathYear = 1905;
        byte deathMonth = 5;
        byte deathDay = 17;
        String deathCountry = "USA";
        String deathState = "NJ";
        String deathCity = "Pemberton";
        String nameFirst = "John";
        String nameLast = "Abadie";
        String nameGiven = "John W.";
        int weight = 192;
        int height = 72;
        char battingHand = 'R';
        char throwingHand = 'R';
        LocalDate debut = LocalDate.of(1875, 04, 26);
        LocalDate finalGame = LocalDate.of(1875, 06, 10);
        String retroID = "abadj101";
        String bbrefID = "abadijo01";
        PlayerDto expectedPlayer = new PlayerDto(playerId, birthYear, birthMonth, birthDay, birthCountry, birthState, birthCity, deathYear, deathMonth, deathDay,
                deathCountry, deathState, deathCity, nameFirst, nameLast, nameGiven, weight, height, battingHand, throwingHand, debut, finalGame,
                retroID, bbrefID);
        // When
        PlayerDto player = service.getPlayerByID(playerId);
        // Then
        assertNotNull(player);
        assertEquals(expectedPlayer.toString(), player.toString());
    }

    @Test
    void getPlayerByIDIfNotExist() {
        // Given
        String playerId = "wrongId";
        // When
        // Then
        PlayerNotFoundException exception = assertThrows(PlayerNotFoundException.class, () -> service.getPlayerByID(playerId));
        assertEquals("Player with id wrongId does not exist", exception.getMessage());

    }
}