package paveldubovik.baseball.player.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class PlayerDto {
    private String playerID;
    private Integer birthYear;
    private Byte birthMonth;
    private Byte birthDay;
    private String birthCountry;
    private String birthState;
    private String birthCity;
    private Integer deathYear;
    private Byte deathMonth;
    private Byte deathDay;
    private String deathCountry;
    private String deathState;
    private String deathCity;
    private String nameFirst;
    private String nameLast;
    private String nameGiven;
    private Integer weight;
    private Integer height;
    private Character battingHand;
    private Character throwingHand;
    private LocalDate debut;
    private LocalDate finalGame;
    private String retroID;
    private String bbrefID;
}
