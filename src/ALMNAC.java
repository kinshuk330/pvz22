import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
        box.setText("Peashooters are your first line of defense. They shoot peas at attacking zombies.");
        box1.setText("Unlocked: at the beginning");
        box11.setText("Sun-cost: 100");


    }

    public void RPdetails(ActionEvent actionEvent) {
        box.setText("Repeaters fire two peas at a time");
        box1.setText("Unlocked: after completing level 3");
        box11.setText("Sun-cost: 200");

    }

    public void WNdetails(ActionEvent actionEvent) {
        box.setText("Wall-nuts have hard shells which you can use to protect your other plants.");
        box1.setText("Unlocked: after completing level 2");
        box11.setText("Sun-cost: 50");

    }

    public void TNdetails(ActionEvent actionEvent) {
        box.setText("Tall-nuts are heavy-duty wall plants that can't be vaulted over.");
        box1.setText("Unlocked: after completing level 4");
        box11.setText("Sun-cost: 125");

    }

    public void SFdetails(ActionEvent actionEvent) {
        box.setText("Sunflowers are essential for you to produce extra sun. Try planting as many as you can!");
        box1.setText("Unlocked: after completing level 1");
        box11.setText("Sun-cost: 50");

    }

    public void CBdetails(ActionEvent actionEvent) {
        box.setText("Cherry Bombs can blow up all zombies in an area. They have a short fuse so plant them near zombies.");
        box1.setText("Unlocked: after completing level 2");
        box11.setText("Sun-cost: 150");

    }

    public void Zdetails(ActionEvent actionEvent) {
        ox.setText("A normal zombie.");
        ox1.setText("Health: 200");
    }

    public void CZdetails(ActionEvent actionEvent) {
        ox.setText("Headwear zombie uses a traffic cone to protect itself");
        ox1.setText("Health: 560");

    }

    public void FZdetails(ActionEvent actionEvent) {
        ox.setText("Moves slightly faster and signals a huge wave incoming.");
        ox1.setText("Health: 200");
    }

    public void BZdetails(ActionEvent actionEvent) {
        ox.setText("Headwear zombie has a bucket that is extremely resistant to damage");
        ox1.setText("Health: 1300");
    }

    public void NZdetails(ActionEvent actionEvent) {
        ox.setText("Shield zombie, moves slowly at first, moves twice as fast and grunts after its newspaper is destroyed.\t");
        ox1.setText("Health: 350");
    }


    public void Goback1(ActionEvent actionEvent) throws IOException {

            Parent root ;

            root= FXMLLoader.load(getClass().getResource("front-page.fxml"));
            Stage window=(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
            window.setScene(new Scene(root, 600  , 400));

    }
}