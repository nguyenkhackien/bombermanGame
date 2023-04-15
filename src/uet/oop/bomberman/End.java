package uet.oop.bomberman;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import uet.oop.bomberman.graphics.Sprite;

public class End {
    Text scoreLabel;
    Scene sceneEnd;
    Stage stage;

    public void setScene(int score) {
        scoreLabel.setText("Score: " + score);
        stage.setScene(sceneEnd);
    }

    public End(Stage stage) {
        this.stage = stage;
        StackPane layout = new StackPane();
        scoreLabel = new Text();
        scoreLabel.setFont(new Font("Roboto", 16));
        scoreLabel.setFill(Color.BLACK);
        layout.getChildren().addAll(scoreLabel);
        // scoreLabel.setX(score);
        sceneEnd = new Scene(layout, Sprite.SCALED_SIZE * BombermanGame.WIDTH,
                Sprite.SCALED_SIZE * BombermanGame.HEIGHT);
    }
}
