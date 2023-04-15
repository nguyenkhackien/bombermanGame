package uet.oop.bomberman;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import uet.oop.bomberman.graphics.Sprite;

public class MenuStart {
    Button buttonStart;
    Button buttonExit;
    GridPane menu;
    Scene sceneMenu;

    public MenuStart(Scene sceneGame, Stage stage) {
        buttonStart = new Button();
        buttonStart.setText("Start");
        buttonExit = new Button();
        buttonExit.setText("Exit");

        buttonStart.setOnAction(e -> {
            stage.setScene(sceneGame);
        });

        buttonExit.setOnAction(e -> {
            System.exit(0);
        });
        menu = new GridPane();
        menu.setPadding(new Insets(10, 10, 10, 10));
        menu.setVgap(10);
        menu.setHgap(10);
        menu.setAlignment(Pos.CENTER);
        menu.add(buttonStart, 1, 0);
        menu.add(buttonExit, 1, 1);
        sceneMenu = new Scene(menu, Sprite.SCALED_SIZE * 31, Sprite.SCALED_SIZE * 13);
//        sceneMenu.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(sceneMenu);
    }
}
