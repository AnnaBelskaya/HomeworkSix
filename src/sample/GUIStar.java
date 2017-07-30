package sample;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.TextAlignment;
import snowfield.Star;

public class GUIStar {
    private Pane root;
    private Star star;
    private Button drawStar = new Button();
    private Button ruinStar = new Button();
    private Button nightMode = new Button();
    private TextField centerX = new TextField();
    private TextField centerY = new TextField();
    private TextField starRadius = new TextField();

    public GUIStar(Pane root){
        this.root = root;
    }
    
    public void drawGUIStar(){
        addStar();
        addRuinStar();
        addNightMode();

        setCenterX();
        setCenterY();
        setStarRadius();

        root.getChildren().addAll(drawStar,ruinStar, nightMode);
        root.getChildren().addAll(centerX,centerY,starRadius,
                addLabel(95,365, "x:"),
                addLabel(95,395, "y:"),
                addLabel(61,425, "Radius:"));
    }
    
    private void addStar() {
        drawStar.setText("Draw\nstar");
        drawStar.setTextAlignment(TextAlignment.CENTER);
        drawStar.setFont(Font.font("Verdana", FontPosture.REGULAR, 11));
        drawStar.setTranslateX(15);
        drawStar.setTranslateY(310);
        drawStar.setMinSize(60, 40);

        drawStar.setOnMouseClicked(event -> {
            setStar();
            try {
                star.drawStar();
            } catch (NullPointerException e){ }
        });
    }

    private void addRuinStar(){
        ruinStar.setText("Ruin\nstar");
        ruinStar.setTextAlignment(TextAlignment.CENTER);
        ruinStar.setFont(Font.font("Verdana", FontPosture.REGULAR, 11));
        ruinStar.setTranslateX(100);
        ruinStar.setTranslateY(310);
        ruinStar.setMinSize(60, 40);

        ruinStar.setOnMouseClicked(event -> {
            try {
                star.ruinStar();
            } catch (NullPointerException e){ }
        });
    }

    private void addNightMode() {
        nightMode.setText("Turn the night mode on");
        nightMode.setTextAlignment(TextAlignment.CENTER);
        nightMode.setFont(Font.font("Verdana", FontPosture.REGULAR, 11));
        nightMode.setTranslateX(20);
        nightMode.setTranslateY(510);
        nightMode.setMinSize(110, 10);

        nightMode.setOnMouseClicked(event -> {
            if (nightMode.getText().equals("Turn the night mode on")){
                root.setStyle("-fx-background: #301095;");
                nightMode.setText("Turn the day mode on");
            } else {
                nightMode.setText("Turn the night mode on");
                root.setStyle("-fx-background: #6495ED;");
            }
        });
    }
    
    private void setCenterX(){
        centerX.setPromptText("300-600");
        centerX.setMaxSize(60,10);
        centerX.setTranslateX(110);
        centerX.setTranslateY(360);
    }

    private void setCenterY(){
        centerY.setPromptText(">R");
        centerY.setMaxSize(60,10);
        centerY.setTranslateX(110);
        centerY.setTranslateY(390);
    }

    private void setStarRadius(){
        starRadius.setPromptText("1-100");
        starRadius.setMaxSize(60,10);
        starRadius.setTranslateX(110);
        starRadius.setTranslateY(420);
    }

    private void setStar(){
        try {
            star = new Star(root,
                    Double.parseDouble(centerX.getText()),
                    Double.parseDouble(centerY.getText()),
                    Double.parseDouble(starRadius.getText()));
        } catch (NumberFormatException e){ }
    }

    private Label addLabel(int x, int y, String text) {
        Label label1 = new Label(text);
        label1.setFont(Font.font("Verdana", FontPosture.ITALIC, 12));
        label1.setTranslateX(x);
        label1.setTranslateY(y);
        return label1;
    }
}
