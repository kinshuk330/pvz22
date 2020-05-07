import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
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
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class USER implements Serializable   {
    @FXML
    public Button L1;
    @FXML
public Window n1;
    public Button L2;
    public Button L3;
    public Button back;
    private GAME g1;
    public String username;
    public int level;

    public USER() {

    }

    void update()
{

}

    String getUsername()
    {return username;}

   public USER(String username,Window o1)
    {this.n1=o1;
    level=1;
    this.username=username;


    }
//    private void hey()
//    {}
// public   USER()
//    {
//        username="";
//        g1=new GAME();
//
//        level=-1;
//    }
static void savegame(USER u1) throws IOException {

    USER s1 = u1;

    ObjectOutputStream out = null;
    try {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        out = new ObjectOutputStream(new FileOutputStream(u1.getUsername() + formatter.format(date)+".txt"));
        out.writeObject(s1);
    } catch (IOException e) {
        e.printStackTrace();
    } finally {

        out.close();
    }
}
    public void LEVELSELECTED(ActionEvent actionEvent) throws IOException {
        int selectdlevel = 0;
        n1 = ((Node) actionEvent.getSource()).getScene().getWindow();
        g1=new GAME(this);
        if (((Button) actionEvent.getSource()).getId().equals("L1")) {
            System.out.println("level 1 selected");
            selectdlevel = 1;
//            System.out.println(g1.player+" nitinnnn                      "+level);

            g1.startlevel(selectdlevel, n1);
        } else if (((Button) actionEvent.getSource()).getId().equals("L2")) {
            System.out.println("level 2 selected");
            selectdlevel = 2;
            g1.startlevel(selectdlevel, n1);

        } else if (((Button) actionEvent.getSource()).getId().equals("L3")) {
            System.out.println("level 3 selected");
            selectdlevel = 3;
            g1.startlevel(selectdlevel, n1);
        }
        else if (((Button) actionEvent.getSource()).getId().equals("L4")) {
            System.out.println("level 4 selected");
            selectdlevel = 4;
            g1.startlevel(selectdlevel, n1);
        }

//        Parent root;
//
//        root = FXMLLoader.load(getClass().getResource("BACKYARD.fxml"));
//
//        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//
//        window.setScene(new Scene(root, 600, 400));
    }
    void StartNewGame() throws IOException
    {   Parent root  ;
//    System.out.println(username+" l evel                      "+level);
//        g1.setuser(this);
//        System.out.println(g1.player.username+" l evel                      "+g1.player.level);

        root= FXMLLoader.load(USERcontroller.class.getResource("SELECT-LEVEL.fxml"));
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                try {
                    LEVELSELECTED(e);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }};EventHandler<ActionEvent> bac = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            try { GOBACK(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }};
        for (Node node: ((AnchorPane)root).getChildren()){
            if(node!=null &&node.getId()!=null){
                if (node.getId().equals("backk"))
                    ((Button)node).setOnAction(bac);
            if (node.getId().equals("L1") && level>=1) {


                        ((Button) node).setOnAction(event);
            }
              else  if (node.getId().equals("L2") && level>=2) {
                node.setVisible(true);


                    ((Button) node).setOnAction(event);
                }
else  if (node.getId().equals("L3")&& level>=3 )
            {
                node.setVisible(true);
//                System.out.println("");
                ((Button) node).setOnAction(event);

            }
            else  if (node.getId().equals("L4") && level>=4)
            {
                node.setVisible(true);
                ((Button) node).setOnAction(event);

            }
            else  if (node.getId().equals("L5") && level>=5)
            {
                node.setVisible(true);
                ((Button) node).setOnAction(event);

            }

        }}
        Stage window= (Stage) n1;
        window.setScene(new Scene(root, 600  , 400));


       

        }


    public void GOBACK(ActionEvent actionEvent) throws IOException {
        Parent root ;

        root= FXMLLoader.load(getClass().getResource("front-page.fxml"));

        Stage window=(Stage)((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(new Scene(root, 600  , 400));
    }
}