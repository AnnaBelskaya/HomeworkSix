package sample;

import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.TextAlignment;

import javafx.scene.control.Button;
import snowfield.SnowTower;

public class GUISnowTower {
    private GUISnowman snowMan;
    private Pane root;
    private SnowTower snowTower;
    private Button buildTower = new Button();
    private Button ruinTower = new Button();
    private Button paintRed = new Button();
    private TextField number = new TextField();
    private TextField minRadius = new TextField();
    private TextField maxRadius = new TextField();

    public GUISnowTower(Pane root, GUISnowman snowMan){
        this.root = root;
        this.snowMan = snowMan;
    }

    public void drawSnowTowerInterface(){
        root.setStyle("-fx-background: #6495ED;");
        addBuildTowerButton();
        addRuinTowerButton();
        addPaintTowerRedButton();
        root.getChildren().addAll(buildTower,ruinTower,paintRed);
        addTextFieldNumber();
        addTextFieldMinRadius();
        addTextFieldMaxRadius();
        root.getChildren().addAll(number,maxRadius,minRadius,
                addHorizontalSeparator(),
                addLabel(10,15, "Circles amount:"),
                addLabel(10,45, "Min radius:"),
                addLabel(10,75, "Max radius:"));
    }


    private void addBuildTowerButton(){
        buildTower.setText("Build\ntower");
        buildTower.setTextAlignment(TextAlignment.CENTER);
        buildTower.setFont(Font.font("Verdana", FontPosture.REGULAR, 11));
        buildTower.setTranslateX(20);
        buildTower.setTranslateY(100);
        buildTower.setShape(new Circle(50));
        buildTower.setMinSize(50, 50);

        buildTower.setOnMouseClicked(event -> {
            createSnowTowerClass();
            try {
                snowTower.ruinTower();
            } catch (NullPointerException e){ }
            try {
                snowMan.getSnowMan().ruinSnowMan();
            } catch (NullPointerException e){ }

            try {
                snowTower.drawSnowTower();
            } catch (NullPointerException e){ }
        });
    }

    private void addRuinTowerButton() {
        ruinTower.setText("Ruin\ntower");
        ruinTower.setTextAlignment(TextAlignment.CENTER);
        ruinTower.setFont(Font.font("Verdana", FontPosture.REGULAR, 11));
        ruinTower.setTranslateX(100);
        ruinTower.setTranslateY(100);
        ruinTower.setShape(new Circle(50));
        ruinTower.setMinSize(50, 50);

        ruinTower.setOnMouseClicked(event -> {
            try {
                snowTower.ruinTower();
            } catch (NullPointerException e){ }
        });

    }

    private void addPaintTowerRedButton() {
        paintRed.setText("Make the tower red");
        paintRed.setTextAlignment(TextAlignment.CENTER);
        paintRed.setFont(Font.font("Verdana", FontPosture.REGULAR, 11));
        paintRed.setTranslateX(25);
        paintRed.setTranslateY(160);
        paintRed.setMinSize(110, 10);

        paintRed.setOnMouseClicked(event -> {
            try {
                snowTower.paintTowerRed();
            } catch (NullPointerException e){ }
        });
    }

    private void addTextFieldNumber(){
        number.setPromptText("1-10");
        number.setMaxSize(60,10);
        number.setTranslateX(110);
        number.setTranslateY(10);
    }

    private void addTextFieldMinRadius(){
        minRadius.setPromptText("1");
        minRadius.setMaxSize(60,10);
        minRadius.setTranslateX(110);
        minRadius.setTranslateY(40);
    }

    private void addTextFieldMaxRadius(){
        maxRadius.setPromptText("50");
        maxRadius.setMaxSize(60,10);
        maxRadius.setTranslateX(110);
        maxRadius.setTranslateY(70);
    }

    private void createSnowTowerClass(){
        try {
            snowTower = new SnowTower(root,
                    Integer.parseInt(number.getText()),
                    Integer.parseInt(minRadius.getText()),
                    Integer.parseInt(maxRadius.getText()));
        } catch (NumberFormatException e){ }
    }

    private Label addLabel(int x, int y, String text) {
        Label label1 = new Label(text);
        label1.setFont(Font.font("Verdana", FontPosture.ITALIC, 12));
        label1.setTranslateX(x);
        label1.setTranslateY(y);
        return label1;
    }

    private Separator addHorizontalSeparator() {
        Separator separator = new Separator();
        separator.setMinWidth(180);
        separator.setTranslateY(200);
        return separator;
    }
}