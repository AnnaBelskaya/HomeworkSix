package snowfield;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import sample.Main;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SnowTower {
    private Pane root;
    private int n, minR, maxR;
    private Circle nose;
    private Circle[] eyes = new Circle[2];
    private Circle[] body;

    public SnowTower(Pane root, int n, int minR, int maxR){
        this.root = root;
        this.n = n;
        this.minR = minR;
        this.maxR = maxR;
    }

    public void drawSnowTower(){
        drawBody();
        drawEyes();
        drawNose();
        root.getChildren().addAll(body);
        root.getChildren().addAll(eyes);
        root.getChildren().addAll(nose);
    }

    public void ruinTower(){
        root.getChildren().removeAll(body);
        root.getChildren().removeAll(eyes);
        root.getChildren().removeAll(nose);
    }

    public void paintTowerRed() {
        for (int i = 0; i < n; i++) {
            body[i].setFill(Paint.valueOf("#FF0000"));
        }
    }

    private void drawBody(){
        body = new Circle[n];
        for (int i = 0; i < n; i++){
            int radius = ThreadLocalRandom.current().nextInt(minR,maxR+1);
            if (i == 0) {
                float y = Main.HEIGHT-30-radius;
                body[i] = new Circle(Main.WIDTH/2+50, y, radius,
                        Paint.valueOf(getColor().toString()));
            } else {
                double y = body[i-1].getCenterY() - body[i-1].getRadius() - radius;
                body[i] = new Circle(Main.WIDTH/2+50, y, radius,
                        Paint.valueOf(getColor().toString()));
            }
        }
    }


    private void drawNose(){
        nose = new Circle(
                body[n-1].getCenterX(),
                body[n-1].getCenterY() + body[n-1].getRadius()/8,
                body[n-1].getRadius()/10);
    }

    private void drawEyes(){
        double r = body[n-1].getRadius()/8;
        double x = body[n-1].getCenterX() -
                body[n-1].getRadius()/3;
        double y = body[n-1].getCenterY() - body[n-1].getRadius()/3;
        eyes[0] = new Circle(x,y,r);
        x = body[n-1].getCenterX() + body[n-1].getRadius()/3;
        eyes[1] = new Circle(x,y,r);
    }


    private Color getColor(){
        Random rand = new Random();
        return Color.color(rand.nextDouble(),
                rand.nextDouble(),
                rand.nextDouble(),
                0.7f);
    }

}
