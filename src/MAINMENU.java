import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MAINMENU extends Application {
    public Button newgamebtn;
    public Button almnacbtn;
    public Label error;
    public ComboBox box;
    public Button BT1;
    int choice;
    USER u1;
    public TextField namefield;

    public TextField username;

    public void SUBMIT(ActionEvent actionEvent) throws IOException {
       String name =namefield.getText();
       String user_name=username.getText();
        /*
        if((name.equals("")))
        {

            username.setText((""));
            error.setVisible(true);
            error.setText("NAME SHOULDN'T BE EMPTY");

        }

         */if(user_name.equals("")){
            namefield.setText("");
            error.setVisible(true);
            error.setText("USER-NAME SHOULDN'T BE EMPTY");


        }
    else
        {Window n1=    ((Node)actionEvent.getSource()).getScene().getWindow();
            u1=new USER(user_name,n1);
System.out.println(u1.level+"   hiiiiiiiiiii");
            u1.StartNewGame();

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
    public void EXIT(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void loadgame(ActionEvent actionEvent) throws IOException {
        Parent root;

        root = FXMLLoader.load(getClass().getResource("LOADGAME.fxml"));
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));

        ArrayList<String> arr1=new ArrayList<>();
        box=new ComboBox<String>();
                File folder = new File(".");

                File[] files = folder.listFiles();
box.setId("combo");
                for (File file : files)
                {
                    if(file.getName().contains(".txt"))
                        box.getItems().add(file.getName());
                }

                box.setLayoutX(171);
                box.setLayoutY(153);
                box.setPrefSize(207,33);
        ((AnchorPane) root).getChildren().add(box);

    }
    public void Startloadgame(ActionEvent actionEvent) throws IOException {
        ObjectInputStream in = null;
        GAME lgame = null;
        String name = null;
        for (Node node: ((AnchorPane)((Node)actionEvent.getSource()).getParent()).getChildren()){
            if(node!=null &&node.getId()!=null){
                if (node.getId().equals("combo"))
                    box=(ComboBox)node;}}
        if(box!=null)
         name= (String) box.getValue();
System.out.println(name);
if(name!=null){

        try {
            in = new ObjectInputStream (new FileInputStream(name));
            lgame = (GAME) in.readObject();

            in.close();


        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
//        System.out.println(lgame.planted12.size()+"  size of static" + lgame.planted12.get(0).getClass());
        lgame.continuegame(((Node) actionEvent.getSource()).getScene().getWindow());
    }}
}
