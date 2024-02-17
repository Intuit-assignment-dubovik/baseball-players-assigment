package paveldubovik.baseball.player.dto;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDto {
    @CsvBindByName
    private String playerID;
    @CsvBindByName
    private Integer birthYear;
    @CsvBindByName
    private Byte birthMonth;
    @CsvBindByName
    private Byte birthDay;
    @CsvBindByName
    private String birthCountry;
    @CsvBindByName
    private String birthState;
    @CsvBindByName
    private String birthCity;
    @CsvBindByName
    private Integer deathYear;
    @CsvBindByName
    private Byte deathMonth;
    @CsvBindByName
    private Byte deathDay;
    @CsvBindByName
    private String deathCountry;
    @CsvBindByName
    private String deathState;
    @CsvBindByName
    private String deathCity;
    @CsvBindByName
    private String nameFirst;
    @CsvBindByName
    private String nameLast;
    @CsvBindByName
    private String nameGiven;
    @CsvBindByName
    private Integer weight;
    @CsvBindByName
    private Integer height;
    @CsvBindByName(column = "bats")
    private Character battingHand;
    @CsvBindByName(column = "throws")
    private Character throwingHand;
    @CsvBindByName
    @CsvDate("yyyy-MM-dd")
    private LocalDate debut;
    @CsvBindByName
    @CsvDate("yyyy-MM-dd")
    private LocalDate finalGame;
    @CsvBindByName
    private String retroID;
    @CsvBindByName
    private String bbrefID;
}
