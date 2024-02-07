package paveldubovik.baseball.player.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import paveldubovik.baseball.exception.PlayerNotFoundException;
import paveldubovik.baseball.player.dto.PlayerDto;
import paveldubovik.baseball.player.dto.PlayerMapper;
import paveldubovik.baseball.player.entity.Player;
import paveldubovik.baseball.player.repository.PlayerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository repository;
    private final PlayerMapper mapper;

    @Override
    public List<PlayerDto> getPlayers() {
        List<Player> players = repository.findAll();
        log.debug("All players got");
        return players.stream().map(mapper::toPlayerDto).collect(Collectors.toList());
    }

    @Override
    public PlayerDto getPlayerByID(String playerId) {
        log.debug("Service: got playerId - {}", playerId);
        Player player = repository.findById(playerId).orElseThrow(() ->
                new PlayerNotFoundException(playerId));
        log.debug("Service: player found {}", player);
        PlayerDto playerDto = mapper.toPlayerDto(player);
        log.debug("Service: player mapped {}", playerDto);
        return playerDto;
    }
}
