import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import sun.plugin.javascript.navig.Anchor;

import java.io.FileInputStream;
import java.io.IOException;

public class GAME {

    public GridPane gridddd;
    private int level;

    public GAME(int i) {
        level=i;
    }
    Boolean Level_CHECK(int i)
    {
        return i<=level;
    }
public GAME()
    {
        level=0;

    }

    public int getLevel() {
        return level;
    }

    public void startlevel(int a, Window n1) throws IOException {
        Parent root ;

        root= FXMLLoader.load(getClass().getResource("BACKYARD.fxml"));

        Stage window=(Stage)n1;
        Image image = new Image("zombiewalk.gif",55,55,false,false);
        ImageView i1=new ImageView(image);
        i1.maxHeight(55);
        i1.maxWidth(53);
        Node n=i1;
        n.setLayoutX(710);
        n.setLayoutY(34);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(2500));
        //Set node to be animated
        pathTransition.setNode(n);
        //Rotate button through a circular path locate at (200,200) with radius 50
        pathTransition.setPath(new Line( ));

        n.setOnMouseClicked(e->pathTransition.play());
        ((AnchorPane)root).getChildren().add(n);
        window.setScene(new Scene(root, 800  , 400));


//        for (Node m1:((AnchorPane)root).getChildren()) {
//            if (m1 instanceof GridPane) {
//                System.out.println("hiii");;
//               ((GridPane)m1).add(i1,8,0);
//
//
//            }
//        }


    }
}
