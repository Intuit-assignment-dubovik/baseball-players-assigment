package paveldubovik.baseball.player.service;

import org.springframework.stereotype.Service;
import paveldubovik.baseball.player.dto.PlayerDto;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Override
    public List<PlayerDto> getPlayers() {
        return null;
    }

    @Override
    public PlayerDto getPlayerByID(String playerId) {
        return null;
    }
}
