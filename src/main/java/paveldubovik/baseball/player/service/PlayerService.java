package paveldubovik.baseball.player.service;

import paveldubovik.baseball.player.dto.PlayerDto;

import java.util.List;

public interface PlayerService {
    List<PlayerDto> getPlayers();
    PlayerDto getPlayerByID(String playerId);
}
