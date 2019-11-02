import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

public class USER    {
    public Button L1;
    public Button L2;
    public Button L3;
    String name;
    String username;
    int level;
   public USER(String name,String username)
    {this.name=name;
    this.username=username;
    level=1;
    }
//    private void hey()
//    {}
 public   USER()
    {
        name="";
        username="";
        level=0;
    }



    public void LEVELSELECTED(ActionEvent actionEvent) throws IOException {

        if (((Button)actionEvent.getSource()).getId().equals("L1"))
            System.out.println("level 1 selected");
        if (((Button)actionEvent.getSource()).getId().equals("L2"))
            System.out.println("level 2 selected");
        if (((Button)actionEvent.getSource()).getId().equals("L3"))
            System.out.println("level 3 selected");
        Parent root ;

        root= FXMLLoader.load(getClass().getResource("SELECT-LEVEL.fxml"));

        Stage window=(Stage)((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(new Scene(root, 600  , 400));
    }
     void select_level(Window n1) throws IOException
    { Parent root ;
        root= FXMLLoader.load(USER.class.getResource("SELECT-LEVEL.fxml"));
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
