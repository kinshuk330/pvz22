import javafx.animation.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import javax.swing.text.PlainDocument;
import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

class PLANTDEADEXCEPTION extends Exception
{}

public abstract class PLANTS extends  CHARACTER implements Serializable {

   transient Button btn;
    transient  Image image1;
    transient  ImageView i2;
    transient  Image image2;
    transient  ImageView i3;
    void plantdead()
         {
            this.btn.setGraphic(null);
            GAME.activatedbuttons.remove(this.btn.getId());
            GAME.planted.remove(this);
            ((AnchorPane)n1).getChildren().remove(i1);
             ((AnchorPane)n1).getChildren().remove(i2);


        ((AnchorPane)n1).getChildren().remove(i3);
    }

    abstract void conti();
    abstract void conti1(Button B1);


}

class SUNFLOWER extends PLANTS implements Serializable{
    void conti1(Button B1){        btn=B1;
    }
      void conti()
    {
        image = new Image(("sun_flower.gif"),59,60,false,false);
        n1=btn.getParent();


        this.sun();
    }

    SUNFLOWER(Button B1) throws InterruptedException ,PLANTDEADEXCEPTION{
        image = new Image(("sun_flower.gif"),59,60,false,false);
        btn=B1;
        n1=btn.getParent();

        this.setHealth();
        this.setDamage();
        this.sun();

    }

    private void sun()  {

        btn.setGraphic(new ImageView(image));
        IntegerProperty seconds = new SimpleIntegerProperty();
        x= (int) btn.getLayoutX();
        y= (int) btn.getLayoutY();

       sunrelease();

    }

    private void sunrelease() {
        Node n = (Node) (btn);
        image1 = new Image("sun.gif", 20, 20, false, false);
        x = (int) btn.getLayoutX();
        y = (int) btn.getLayoutY();
//        i1.maxHeight(55);
//        i1.maxWidth(53);
        Button b1 = new Button();
        b1.setStyle("-fx-background-color: transparent");
        b1.setGraphic(new ImageView(image1));

        b1.setTranslateX(x);
        b1.setTranslateY(y + 40);

        ((AnchorPane) (n.getParent())).getChildren().add(b1);
        b1.setOnAction(click -> {
            b1.setVisible(false);
            GAME.sun += 50;
            GAME.update();
        });

        Timeline timer=new Timeline();
        timer.getKeyFrames().add(new KeyFrame(new Duration(5000) ,t->{
            if(health > 0&& ((AnchorPane) (n.getParent())).getChildren().contains(i1)){
                b1.setVisible(true);
                }
            else
                timer.stop();
        }));
        timer.setCycleCount(Animation.INDEFINITE);
        timer.play();
    }


    @Override
    void setHealth() {
        health=80;
    }

    @Override
    void setDamage() {
damage=0;
    }


}

class PEASHOOTER extends PLANTS implements Serializable
       { void conti1(Button B1){        btn=B1;
       }
           void conti()
           {
               image = new Image("pea_shooter.gif", 55, 55, false, false);

               n1=btn.getParent();
               btn.setGraphic(new ImageView(image));
               x= (int) btn.getLayoutX();
               y= (int) btn.getLayoutY();
               image1 = new Image("Pea.png", 20, 20, false, false);
               i2 = new ImageView(image1);


               btn.setVisible(true);
               i2.setTranslateX(x + 20);
               i2.setTranslateY(y + 20);
               ((AnchorPane) (n1)).getChildren().add(i2);

//               this.setHealth();
//               this.setDamage();
               this.ShootPea();
           }
           PEASHOOTER(Button B1)  {
               image = new Image("pea_shooter.gif", 55, 55, false, false);

               btn=B1;
               n1=btn.getParent();
               btn.setGraphic(new ImageView(image));
               x= (int) btn.getLayoutX();
               y= (int) btn.getLayoutY();
               image1 = new Image("Pea.png", 20, 20, false, false);
               i2 = new ImageView(image1);


               btn.setVisible(true);
               i2.setTranslateX(x + 20);
               i2.setTranslateY(y + 20);
               ((AnchorPane) (n1)).getChildren().add(i2);

               this.setHealth();
               this.setDamage();
               this.ShootPea();
           }



           void ShootPea() {

               Timeline pathanimation = new Timeline();

               for (int i = 0; i < 900; i += 1) {
                   int b = i;
                   pathanimation.getKeyFrames().add(new KeyFrame(new Duration(15 + 15 * i), t -> collision(pathanimation, b + 20 + x), new KeyValue(i2.translateXProperty(), i + 20 + x)));


               }
               Timeline timer=new Timeline();
               pathanimation.play();
               timer.getKeyFrames().add(new KeyFrame(new Duration(10000) ,t->{
                   if(health > 0){
                       i2.setTranslateX(x + 20);
                       i2.setVisible(true);
                   pathanimation.playFromStart();}
                   else
                       timer.stop();
               }));
               timer.setCycleCount(Animation.INDEFINITE);
                    timer.play();
//                wait(3000);
//                for (int i = 0; i <100000 ; i++) {
//
//                }
//

           }


           private void collision(Timeline p1,int a) {
               if (health<=0)
               {
                   p1.stop();
                   plantdead();

               }
               for (ZOMBIES z:GAME.alivezombies) {
//                   System.out.println(a+"  "+z.x+"    peaaa   "+y+"  "+z.y);

                   if(z.x-a<=40&&y==z.y) {
                       p1.stop();
                       i2.setVisible(false);
                                              System.out.println(z.health+" ::::::::::::::  "+this.health);

                       z.damage(this.damage);
                       if (z.damage<=0)
                           return;
                       break;
//                       System.out.println(z.health+" ::::::::::::::");


                   }
               }
           }


           @Override
           void setHealth() {
               health=80;
           }

           @Override
           void setDamage() {
               damage=40;
           }


           }
class WALNUT extends PLANTS  implements Serializable
{
WALNUT(Button B1)
{
    image = new Image("walnutfull.gif", 55, 55, false, false);

    btn=B1;
    n1=btn.getParent();
    btn.setGraphic(new ImageView(image));
    x= (int) btn.getLayoutX();
    y= (int) btn.getLayoutY();
    this.setHealth();
    this.setDamage();
}
    @Override
    void setHealth() {
health=150;
    }

    @Override
    void setDamage() {
damage=0;
    }
    void conti1(Button B1){        btn=B1;
    }
    @Override
    void conti() {
         image = new Image("walnutfull.gif", 55, 55, false, false);

        n1=btn.getParent();
        btn.setGraphic(new ImageView(image));
        x= (int) btn.getLayoutX();
        y= (int) btn.getLayoutY();
    }
}
class BOMB extends PLANTS implements Serializable
{
    BOMB(Button B1)
    {
        image = new Image("potato.gif", 55, 55, false, false);

        btn=B1;
        n1=btn.getParent();
        btn.setGraphic(new ImageView(image));
        x= (int) btn.getLayoutX();
        y= (int) btn.getLayoutY();
        this.setHealth();
        this.setDamage();
        this.blast();
    }
    @Override
    void setHealth() {
        health=150;
    }
    void blast()
    {
        Timeline pathanimation = new Timeline();

        pathanimation.getKeyFrames().add(new KeyFrame(new Duration(15), t -> {
            for (ZOMBIES z:GAME.alivezombies) {
                System.out.println(x+"  "+z.x+ "       "+y+"   "+z.y);
                if(0<z.x-x&&z.x-x<50 &&z.y==y)
                {
                    z.zombiedead();
                    pathanimation.stop();
                    plantdead();
                    break;
                }

            }
        }));
    pathanimation.setCycleCount(Animation.INDEFINITE);
        pathanimation.play();
    }

    @Override
    void setDamage() {
        damage=0;
    }

    @Override
    void conti1(Button B1){        btn=B1;
    }
    void conti() {
        image = new Image("bomb_over.jpg", 55, 55, false, false);

        n1=btn.getParent();
        btn.setGraphic(new ImageView(image));
        x= (int) btn.getLayoutX();
        y= (int) btn.getLayoutY();

        this.blast();
    }
}


