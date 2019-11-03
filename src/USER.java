import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

public class USER    {
    @FXML
    public Button L1;
    @FXML

    public Button L2;
    public Button L3;
    private GAME g1;
    private String name;
    private String username;
    private int level;
   public USER(String name,String username)
    {this.name=name;
    this.username=username;
    g1=new GAME(1);
    }
//    private void hey()
//    {}
 public   USER()
    {
        name="";
        username="";
        level=0;
        g1=new GAME();
    }



    public void LEVELSELECTED(ActionEvent actionEvent) throws IOException {
int selecetdlevel=0;
        if (((Button)actionEvent.getSource()).getId().equals("L1"))
        {    System.out.println("level 1 selected");
       selecetdlevel=1;
            Window n1=((Node)actionEvent.getSource()).getScene().getWindow();
       g1.startlevel(selecetdlevel, n1);
        }
      else  if (((Button)actionEvent.getSource()).getId().equals("L2"))
        {System.out.println("level 2 selected");
selecetdlevel=2;        }
      else  if (((Button)actionEvent.getSource()).getId().equals("L3"))
        {     System.out.println("level 3 selected");
selecetdlevel=3;        }
        if(g1.Level_CHECK(selecetdlevel)){
        Parent root ;

        root= FXMLLoader.load(getClass().getResource("BACKYARD.fxml"));

        Stage window=(Stage)((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(new Scene(root, 600  , 400));
    }
   else
       System.out.println("level not unlocked");
   }
    void StartNewGame(Window n1) throws IOException
    {   Parent root  ;
        root= FXMLLoader.load(USER.class.getResource("SELECT-LEVEL.fxml"));
        Node btn =new Button();
        ((AnchorPane)root).getChildren().add(btn);
        Stage window= (Stage) n1;
        window.setScene(new Scene(root, 600  , 400));

        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(2500));
        //Set node to be animated
        pathTransition.setNode(btn);
        //Rotate button through a circular path locate at (200,200) with radius 50
        pathTransition.setPath(new Circle(200, 200, 50));

        pathTransition.play();

//        if(g1.getLevel()>=1)
//            {System.out.println("heyyyyyyyy");
//                L1.setVisible(true);
//            }
//        if(g1.getLevel()>=2)
//            {
//                L2.setVisible(true);
//            }
//        if(g1.getLevel()>=3)
//            {
//                L3.setVisible(true);
//            }

        }


    public void GOBACK(ActionEvent actionEvent) throws IOException {
        Parent root ;

        root= FXMLLoader.load(getClass().getResource("front-page.fxml"));

        Stage window=(Stage)((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(new Scene(root, 600  , 400));
    }
}