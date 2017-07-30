package sample;

import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.TextAlignment;
import snowfield.SnowMan;

public class GUISnowman {
    private Pane root;
    private SnowMan snowMan;
    private Button buildSnowman = new Button();
    private Button ruinSnowman = new Button();
    private Button addGradient = new Button();

    public GUISnowman(Pane root){
        this.root = root;
    }

    public void addGUISnowman(){
        setSnowMan();
        addBuildSnowman();
        addRuinSnowman();
        addPaintRed();

        root.getChildren().addAll(buildSnowman, ruinSnowman,
                addGradient, addHorizontalSeparator());
    }

    private void addBuildSnowman(){
        buildSnowman.setText("Build\nsnowman");
        buildSnowman.setTextAlignment(TextAlignment.CENTER);
        buildSnowman.setFont(Font.font("Verdana", FontPosture.REGULAR, 11));
        buildSnowman.setTranslateX(10);
        buildSnowman.setTranslateY(210);
        buildSnowman.setMinSize(60, 40);
        
        buildSnowman.setOnMouseClicked(event -> {
            try{
                snowMan.ruinSnowMan();
            } catch (NullPointerException e){ }
            snowMan.drawSnowMan();
        });
    }

    private void addRuinSnowman(){
        ruinSnowman.setText("Ruin\nsnowman");
        ruinSnowman.setTextAlignment(TextAlignment.CENTER);
        ruinSnowman.setFont(Font.font("Verdana", FontPosture.REGULAR, 11));
        ruinSnowman.setTranslateX(100);
        ruinSnowman.setTranslateY(210);
        ruinSnowman.setMinSize(60, 40);

        ruinSnowman.setOnMouseClicked(event -> {
            snowMan.ruinSnowMan();
        });
    }

    private void addPaintRed() {
        addGradient.setText("Make snowman dirty");
        addGradient.setTextAlignment(TextAlignment.CENTER);
        addGradient.setFont(Font.font("Verdana", FontPosture.REGULAR, 11));
        addGradient.setTranslateX(25);
        addGradient.setTranslateY(260);
        addGradient.setMinSize(110, 10);

        addGradient.setOnMouseClicked(event -> {
            try {
                snowMan.paintGradient();
            } catch (NullPointerException e){ }
        });
    }

    private void setSnowMan(){
        snowMan = new SnowMan(root);
    }

    public SnowMan getSnowMan() {
        return snowMan;
    }

    private Separator addHorizontalSeparator() {
        Separator separator = new Separator();
        separator.setMinWidth(180);
        separator.setTranslateY(300);
        return separator;
    }
}
