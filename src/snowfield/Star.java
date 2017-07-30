package snowfield;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;

import java.util.Arrays;

public class Star {
    private Pane pane = new Pane();
    private Line[] star = new Line[11];
    private double centerX;
    private double centerY;
    private double radius;

    public Star(Pane pane, double centerX, double centerY, double radius){
        this.pane = pane;
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }


    public void ruinStar(){
        pane.getChildren().removeAll(star);
        Arrays.fill(star, null);
    }

    public void drawStar(){
        double alpfa = Math.PI*2/10;
        int j = -1;
        for (int i=11; i >0; i--){
            double r = radius*(i % 2 + 1)/2;
            double omega = alpfa * i;
            j++;
            star[j] = new Line();
            star[j].setStrokeWidth(3);
            star[j].setStroke(Paint.valueOf("#FFDEAD"));
            if (i == 11){
                star[j].setStartX(r * Math.sin(omega) + centerX);
                star[j].setStartY(r * Math.cos(omega) + centerY);
            } else {
                star[j-1].setEndX(r * Math.sin(omega) + centerX);
                star[j-1].setEndY(r * Math.cos(omega) + centerY);
                pane.getChildren().add(star[j-1]);
                star[j].setStartX(r * Math.sin(omega) + centerX);
                star[j].setStartY(r * Math.cos(omega) + centerY);
            }
        }
    }
}
