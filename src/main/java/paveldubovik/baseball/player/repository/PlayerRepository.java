package paveldubovik.baseball.player.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import paveldubovik.baseball.player.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, String> {
}
