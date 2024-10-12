package Game;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunnner {

//    private MarioGame game;
    private Game.GamingConsole game;

    public GameRunnner(@Qualifier("SuperContraGameQualifier") Game.GamingConsole game) {
        this.game = game;
    }

    public void run() {
        System.out.println("Running game:" + game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
