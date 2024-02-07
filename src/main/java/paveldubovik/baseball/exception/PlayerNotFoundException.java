package paveldubovik.baseball.exception;

public class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException(String playerId) {
        super(String.format("Player with id %s does not exist", playerId));
    }
}
