import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class ALMNAC {
    public Label box;
    public Label box1;
    public Label box11;
    public Label ox;
    public Label ox1;
    public Label ox11;

    public void plantsdetails(ActionEvent actionEvent) throws IOException {
        Parent root ;

        root= FXMLLoader.load(getClass().getResource("plantsdetails.fxml"));
        Stage window=(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(new Scene(root, 600  , 400));
    }
    public void zombiedetails(ActionEvent actionEvent) throws IOException {
        Parent root ;

        root= FXMLLoader.load(getClass().getResource("zombiesdetails.fxml"));
        Stage window=(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(new Scene(root, 600  , 400));
    }
    public void Goback(ActionEvent actionEvent) throws IOException {
        Parent root ;

        root= FXMLLoader.load(getClass().getResource("ALMNAC.fxml"));
        Stage window=(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(new Scene(root, 600  , 400));
    }

    public void PSdetails(ActionEvent actionEvent) {
        Image image = new Image("p2.jpg", 220, 360, false, false);
        box.setGraphic(new ImageView(image));

    }

    public void RPdetails(ActionEvent actionEvent) {
        Image image = new Image("p6.jpg", 220, 360, false, false);
        box.setGraphic(new ImageView(image));

    }

    public void WNdetails(ActionEvent actionEvent) {
        Image image = new Image("p3.jpg", 220, 360, false, false);
        box.setGraphic(new ImageView(image));



    }

    public void TNdetails(ActionEvent actionEvent) {
        Image image = new Image("p4.jpg", 220, 360, false, false);
        box.setGraphic(new ImageView(image));

    }

    public void SFdetails(ActionEvent actionEvent) {
        Image image = new Image("p1.jpg", 220, 360, false, false);
        box.setGraphic(new ImageView(image));


    }

    public void CBdetails(ActionEvent actionEvent) {
        Image image = new Image("p5.jpg", 220, 360, false, false);
        box.setGraphic(new ImageView(image));
    }

    public void Zdetails(ActionEvent actionEvent) {
        Image image = new Image("z1.jpg", 220, 360, false, false);
        ox.setGraphic(new ImageView(image));

    }

    public void CZdetails(ActionEvent actionEvent) {
        Image image = new Image("z3.jpg", 220, 360, false, false);
        ox.setGraphic(new ImageView(image));

    }

    public void FZdetails(ActionEvent actionEvent) {
        Image image = new Image("z2.jpg", 220, 360, false, false);
        ox.setGraphic(new ImageView(image));
    }

    public void BZdetails(ActionEvent actionEvent) {
        Image image = new Image("z4.jpg", 220, 360, false, false);
        ox.setGraphic(new ImageView(image));
    }

    public void NZdetails(ActionEvent actionEvent) {
        Image image = new Image("z5.jpg", 220, 360, false, false);
        ox.setGraphic(new ImageView(image));
    }


    public void Goback1(ActionEvent actionEvent) throws IOException {

            Parent root ;

            root= FXMLLoader.load(getClass().getResource("front-page.fxml"));
            Stage window=(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
            window.setScene(new Scene(root, 600  , 400));

    }
}