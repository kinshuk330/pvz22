import javafx.animation.PathTransition;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import javax.swing.text.Element;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;

import static java.lang.Thread.sleep;

public class PLANTS {
    protected Image image;
    PLANTS (String iname)
    {         image = new Image((iname),59,60,false,false);

    }

}
class SUNFLOWER extends PLANTS{
    Button btn;

    SUNFLOWER(Button B1) throws InterruptedException {
        super("sun_flower.gif");
        btn=B1;
        this.sun();
    }

    private void sun() throws InterruptedException {

        btn.setGraphic(new ImageView(image));
        sunrelease();

    }

    private void sunrelease() throws InterruptedException {
        Node n = (Node) (btn);
        image = new Image("sun.gif", 20, 20, false, false);
        int x = (int) btn.getLayoutX();
        int y = (int) btn.getLayoutY();
//        i1.maxHeight(55);
//        i1.maxWidth(53);
        Button b1=new Button();
        b1.setStyle("-fx-background-color: transparent");
        b1.setGraphic(new ImageView(image));

        b1.setTranslateX(x);
        b1.setTranslateY(y+40);

        Path path = new Path();
        ((AnchorPane) (n.getParent())).getChildren().add(b1);
b1.setOnAction(click -> {
    b1.setVisible(false);
    GAME.sun+=50;
    GAME.update();
});
sunrelease();
    }

    }

 class PEASHOOTER extends PLANTS
        {   Button btn;
            PEASHOOTER(Button B1) throws InterruptedException {
                super("pea_shooter.gif");
                btn=B1;
                this.shoot();
            }

            private void shoot() throws InterruptedException {


                btn.setGraphic(new ImageView(image));

                Pea();
            }

            void Pea() throws InterruptedException {
                Node n = (Node) (btn);
                image = new Image("Pea.png", 20, 20, false, false);
                int x = (int) btn.getLayoutX();
                int y = (int) btn.getLayoutY();
//        i1.maxHeight(55);
                btn.setVisible(true);
//        i1.maxWidth(53);
                    Node n1 = new ImageView(image);

                    n1.setTranslateX(610);
                    n1.setTranslateY(300);
                    Path path = new Path();
                    ((AnchorPane) (n.getParent())).getChildren().add(n1);
                    //Moving to the starting point
                    MoveTo moveTo = new MoveTo(x + 60, y);

                    //Creating 1st line
                    LineTo line1 = new LineTo(900, y);
                    path.getElements().add(moveTo);
                    path.getElements().add(line1);
                    PathTransition pathTransition = new PathTransition();
                    pathTransition.setDuration(Duration.millis(6000));
                    //Set node to be animated
                    //Rotate button through a circular path locate at (200,200) with radius 50
                    pathTransition.setPath(path);
                    pathTransition.setNode(n1);
                    pathTransition.play();
//                wait(3000);

//                for (int i = 0; i <100000 ; i++) {
//
//                }
//                Pea();
            }
            }



