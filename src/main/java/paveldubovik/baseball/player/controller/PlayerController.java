package paveldubovik.baseball.player.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import paveldubovik.baseball.player.dto.PlayerDto;
import paveldubovik.baseball.player.service.PlayerService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService service;

    @GetMapping
    public ResponseEntity<List<PlayerDto>> getPlayers() {
        log.debug("Controller: get all players");
        List<PlayerDto> players = service.getPlayers();
        return ResponseEntity.ok(players);
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<PlayerDto> getPlayerByID(@PathVariable String playerId) {
        log.debug("Controller: get player by id - {}", playerId);
        return ResponseEntity.ok(service.getPlayerByID(playerId));
    }
}
