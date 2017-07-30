package snowfield;

import javafx.scene.layout.Pane;
import javafx.scene.paint.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import sample.Main;

import java.util.Arrays;

public class SnowMan {
    Pane root = new Pane();
    double radius = 90;
    double x = Main.WIDTH/2+50;
    double y =  Main.HEIGHT-30 - radius;
    public Circle[] body = new Circle[3];
    public Circle[] eyes = new Circle[2];
    public Line[] nose = new Line[2];

    public SnowMan(Pane root){
        this.root = root;
    }

    public void drawSnowMan(){
        drawBody();
        drawEyes();
        drawNose();
        root.getChildren().addAll(body);
        root.getChildren().addAll(eyes);
        root.getChildren().addAll(nose);
    }


    public void paintGradient(){
        Stop[] stops = new Stop[] { new Stop(0, Color.BLACK), new Stop(1, Color.GREY)};
        LinearGradient lg1 = new LinearGradient(0, 1, 0, 0, true,
                CycleMethod.NO_CYCLE, stops);
        stops = new Stop[] { new Stop(0, Color.GRAY), new Stop(1, Color.web("#DCDCDC"))};
        LinearGradient lg2 = new LinearGradient(0, 1, 0, 0, true,
                CycleMethod.NO_CYCLE, stops);
        stops = new Stop[] { new Stop(0, Color.web("#DCDCDC")), new Stop(1, Color.WHITE)};
        LinearGradient lg3 = new LinearGradient(0, 1, 0, 0, true,
                CycleMethod.NO_CYCLE, stops);

        body[0].setFill(lg1);
        body[1].setFill(lg2);
        body[2].setFill(lg3);
    }

    public void ruinSnowMan(){
        root.getChildren().removeAll(body);
        root.getChildren().removeAll(eyes);
        root.getChildren().removeAll(nose);
        Arrays.fill(body,null);
        Arrays.fill(nose,null);
        Arrays.fill(eyes,null);
        radius = 90;
        x = Main.WIDTH/2+50;
        y =  Main.HEIGHT-30 - radius;
    }

    private void drawBody(){
        for (int i = 0; i < 3; i++) {
            if (i > 0){
                radius/=1.5;
                y = body[i-1].getCenterY() - body[i-1].getRadius() - radius;
                body[i] = new Circle(x, y, radius,
                        Paint.valueOf("#FFFFFF"));
            } else {
                body[i] = new Circle(x, y, radius,
                        Paint.valueOf("#FFFFFF"));
            }
            body[i].setStroke(Paint.valueOf("#00000050"));
        }
    }

    private void drawEyes(){
        double r = body[2].getRadius()/8;
        double x = body[2].getCenterX() - body[2].getRadius()/3;
        double y = body[2].getCenterY() - body[2].getRadius()/3;
        eyes[0] = new Circle(x,y,r);
        x = body[2].getCenterX() + body[2].getRadius()/3;
        eyes[1] = new Circle(x,y,r);
    }

    private void drawNose(){
        nose[0] = prepareNose();
        nose[1] = prepareNose();
        nose[0].setStartY(nose[0].getStartY() + 10);
    }

    private Line prepareNose(){
        Line line = new Line();
        double x = body[2].getCenterX()+3;
        double y = body[2].getCenterY();
        line.setStartX(x);
        line.setStartY(y);
        line.setEndX(x+20);
        line.setEndY(y+10);
        line.setStroke(Paint.valueOf("#FF0000"));
        line.setStrokeWidth(3);
        return line;
    }
}