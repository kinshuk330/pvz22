import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import sun.plugin.javascript.navig.Anchor;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class GAME {
    static  int sun;
   static  public Label counter;
  static  public Button peashooter;
    static public Button sunflower;
    private int level;
    Parent root ;

    String plantselect;
    int ROW[]=new int[]{54, 144, 220, 280, 354};
    ArrayList<String> activatedbuttons;
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
        sun=50;

        plantselect="";
        activatedbuttons=new ArrayList<String>();

    }

    public int getLevel() {
        return level;
    }

    public void startlevel(int a, Window n1) throws IOException {

        root = FXMLLoader.load(getClass().getResource("BACKYARD.fxml"));

        Stage window = (Stage) n1;
        Image image = new Image("zombiewalk.gif", 55, 55, false, false);
        Group g = new Group();
        for (int i = 0; i < 5; i++) {


            ImageView i1 = new ImageView(image);
//        i1.maxHeight(55);
//        i1.maxWidth(53);
            Node n = i1;
            n.setTranslateX(710);
            n.setTranslateY(ROW[i]);
            g.getChildren().add(n);
        }
        Path path = new Path();

        //Moving to the starting point
        MoveTo moveTo = new MoveTo(710, 200);

        //Creating 1st line
        LineTo line1 = new LineTo(300, 200);


        //Adding all the elements to the path
        path.getElements().add(moveTo);
        path.getElements().add(line1);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(15000));
        //Set node to be animated
        //Rotate button through a circular path locate at (200,200) with radius 50
        pathTransition.setPath(path);
        pathTransition.setNode(g);

        pathTransition.play();
        ((AnchorPane) root).getChildren().add(g);
        for (Node n : ((AnchorPane) root).getChildren()) {
            if (n.getId() != null) {
                if (n.getId().equals("topwood")) {
                    for (Node m : ((AnchorPane) n).getChildren()) {
                        if (m.getId() != null){
                            if (m.getId().equals("peashooter"))
                                peashooter = (Button) m;
                                if (m.getId().equals("sunflower"))
                                    sunflower = (Button) m;

                            }
                    }}
                    if (n.getId().equals("counter"))
                        counter = (Label) n;


                }

            }

//        root.setTranslateX(50);
//        root.setTranslateY(50);
            window.setScene(new Scene(root, 800, 400));

//        for (Node m1:((AnchorPane)root).getChildren()) {
//            if (m1 instanceof GridPane) {
//                System.out.println("hiii");;
//               ((GridPane)m1).add(i1,8,0);
//
//
//            }
//        }


        }

        public void plantdrop (ActionEvent actionEvent) throws InterruptedException {
            PLANTS p1;
            if (!activatedbuttons.contains(((Button) actionEvent.getSource()).getId())) {
                Button b1 = (Button) (actionEvent.getSource());
                if (plantselect.equals("peashooter") && sun >= 100) {
                    p1 = new PEASHOOTER(b1);
                    sun -= 100;
                    activatedbuttons.add(((Button) actionEvent.getSource()).getId());
                } else if (plantselect.equals("sunflower") && sun >= 0) {
                    p1 = new SUNFLOWER(b1);
                    sun -= 0;
                    activatedbuttons.add(((Button) actionEvent.getSource()).getId());
                }

            }
            update();


        }

        public void plantshooter (ActionEvent actionEvent){
            plantselect = ((Button) actionEvent.getSource()).getId();
            System.out.println(plantselect);
        }
        public static void update () {
            counter.setText(Integer.toString(sun));
            if (sun >= 100) {
                peashooter.setGraphic(new ImageView(new Image(("Peashooter1.png"), 59, 40, false, false)));
            }
            if (sun < 100) {
                peashooter.setGraphic(new ImageView(new Image(("inactive_peashooter.png"), 59, 40, false, false)));

            }
            if (sun >= 0) {
                sunflower.setGraphic(new ImageView(new Image(("Sunflower1.png"), 59, 40, false, false)));
            }
            if (sun < 0) {
                sunflower.setGraphic(new ImageView(new Image(("inactive_sunflower.png"), 59, 40, false, false)));

            }

        }
    }
