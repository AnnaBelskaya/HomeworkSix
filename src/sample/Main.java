package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();

        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);
        primaryStage.setTitle("Let it snow!");
        primaryStage.setResizable(false);

        GUISnowman guiSnowman = new GUISnowman(root);
        guiSnowman.addGUISnowman();

        GUISnowTower guiSnowTower = new GUISnowTower(root,
                guiSnowman);
        guiSnowTower.drawSnowTowerInterface();

        GUIStar guiStar = new GUIStar(root);
        guiStar.drawGUIStar();

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}