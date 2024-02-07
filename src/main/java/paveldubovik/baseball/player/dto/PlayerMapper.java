package paveldubovik.baseball.player.dto;

import org.mapstruct.Mapper;
import paveldubovik.baseball.player.entity.Player;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    PlayerDto toPlayerDto(Player player);

    Player toPlayer(PlayerDto playerDto);
}
