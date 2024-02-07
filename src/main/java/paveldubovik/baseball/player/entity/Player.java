package paveldubovik.baseball.player.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "players")
@Data
public class Player {
    @Id
    @Column(name = "player_id")
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
    @Column(name = "retro_id")
    private String retroID;
    @Column(name = "bbref_id")
    private String bbrefID;
}
