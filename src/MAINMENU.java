import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class MAINMENU extends Application {
    public Button newgamebtn;
    public Button almnacbtn;
    public Label error;
    public Button BT1;
    int choice;
    USER u1;
    public TextField namefield;
    public TextField username;

    public void SUBMIT(ActionEvent actionEvent) throws IOException {
       String name =namefield.getText();
       String user_name=username.getText();

        if((name.equals("")))
        {

            username.setText((""));
            error.setVisible(true);
            error.setText("NAME SHOULDN'T BE EMPTY");

        }
        else if(user_name.equals("")){
            namefield.setText("");
            error.setVisible(true);
            error.setText("USER-NAME SHOULDN'T BE EMPTY");


        }
    else
        {
            u1=new USER(name,user_name);
        Window n1=    ((Node)actionEvent.getSource()).getScene().getWindow();
            u1.select_level(n1);

        }}
    public void StartScreen()
{   choice=1;
    launch();
}

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root;

        root= FXMLLoader.load(getClass().getResource("front-page.fxml"));
        primaryStage.setTitle("PLANT VS ZOMBIE");
        primaryStage.setScene(new Scene(root, 600  , 400));
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public void NewGame(ActionEvent actionEvent) throws IOException {
        Parent root ;

        root= FXMLLoader.load(getClass().getResource("CREATE_USER.fxml"));

       Stage window=(Stage)((Node) actionEvent.getSource()).getScene().getWindow();

       window.setScene(new Scene(root, 600  , 400));

}

    public void displayalmnac(ActionEvent actionEvent) throws IOException {
        Parent root ;

        root= FXMLLoader.load(getClass().getResource("ALMNAC.fxml"));
        Stage window=(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(new Scene(root, 600  , 400));
    }

    public void goback(ActionEvent actionEvent) throws IOException {
        Parent root ;

        root= FXMLLoader.load(getClass().getResource("front-page.fxml"));
        Stage window=(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(new Scene(root, 600  , 400));
    }
}
