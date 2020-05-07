import javafx.animation.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public  abstract class ZOMBIES extends CHARACTER implements Serializable
{
    int currenttime=0;
   transient Timeline pathanimation;
    int lane;
   abstract void setSpeed();
    void damage(int a)
    {this.health-=a;
        if(this.health<=0)
            zombiedead();}
  void zombiedead()
{ {
    pathanimation.stop();

    i1.setTranslateX(900);
    GAME.alivezombies.remove(this);
    ((AnchorPane) n1).getChildren().remove(i1);
}
}
ZOMBIES(Parent o1)
{
    this.n1=o1;
    this.setHealth();
    this.setDamage();
    Random r=new Random();
    lane= r.nextInt(5);
}
    void collision(int p1,int lane1)
    {
// System.out.println("hi4 "+GAME.planted.size());
        x=lane1;
        currenttime=p1;
        for (PLANTS p : GAME.planted) {
//         System.out.println(p.btn.getLayoutX()+" X "+i1.getTranslateX());
//         System.out.println(p.btn.getLayoutY()+" Y "+i1.getTrans=lateY());
            if (p.btn.getLayoutY()==ROW[lane]&&p.btn.getLayoutX()==lane1-40){
//     System.out.println("hi3"+i1.getTranslateX());


                pathanimation.stop();
                attack(p,p1);

                return;
            }}
        ArrayList<LAWNMOVER> mo=new ArrayList<>(GAME.moverss);
        for (LAWNMOVER m1:mo) {
            if(m1.x==(lane1-20)&&m1.y==ROW[lane])
            {
                m1.move();
            }
        }

    }
    void attack(PLANTS pla,int p1) {
        pla.health-=this.damage;
//         System.out.println(pla.health+"  "+this.health);
        if(this.health>0&&pla.health>0&&GAME.planted.contains(pla)){
            IntegerProperty seconds = new SimpleIntegerProperty();
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(seconds, 0)),
                    new KeyFrame(Duration.minutes(0.15), e-> {
                        // do anything you need here on completion...

                        attack(pla,p1);

                    }, new KeyValue(seconds, 3))
            );
            timeline.play();}
        else
        {if (pla.health<=0||!GAME.planted.contains(pla))

        {pla.plantdead();
            pathanimation.playFrom(Duration.millis(p1));}
        else {
            pathanimation.stop();
        zombiedead();
        }
        }}
abstract  void conti(Parent o);}
 class BASICZOMBIE extends ZOMBIES implements Serializable {

      BASICZOMBIE(Parent o1) {
          super(o1);

          image = new Image("zombiewalk.gif", 55, 55, false, false);
          i1 = new ImageView(image);


         i1.setTranslateX(710);
         i1.setTranslateY(ROW[lane]);



          x=COL[15];

           pathanimation =new Timeline();
          int j=0;
          for (int i = 710 ;i >120 ; i-=1,j++) {
              int b=i;
              int m=j;
              pathanimation.getKeyFrames().add(new KeyFrame(new Duration(25+25*j),t-> collision(25+25*m,b-10),new KeyValue(i1.translateXProperty(), i-10)));


          }
          pathanimation.play();




         y= (int) i1.getTranslateY();
         ((AnchorPane)n1).getChildren().add(i1);


 }

     @Override
     void conti(Parent o) {
         this.n1=o;

         image = new Image("zombiewalk.gif", 55, 55, false, false);
         i1 = new ImageView(image);


         i1.setTranslateX(x);
         i1.setTranslateY(ROW[lane]);

         pathanimation =new Timeline();
         int j=0;
         for (int i = 710 ;i >110 ; i-=1,j++) {
             int b=i;
             int m=j;
             pathanimation.getKeyFrames().add(new KeyFrame(new Duration(25+25*j),t-> collision(25+25*m,b-10),new KeyValue(i1.translateXProperty(), i-10)));


         }
         pathanimation.playFrom(Duration.millis(currenttime));




         y= (int) i1.getTranslateY();
         ((AnchorPane)n1).getChildren().add(i1);

     }


     @Override
    void setHealth() {
        health=100;
    }

    @Override
    void setDamage() {
damage=20;
    }


    @Override
    public void setSpeed() {
speed=5;
    }
}

class  SPECIALZOMBIE extends ZOMBIES implements Serializable
{

    SPECIALZOMBIE(Parent o1) {
        super(o1);
        image = new Image("Special_Zombie.gif", 70, 70, false, false);
        i1 = new ImageView(image);


        i1.setTranslateX(710);
        i1.setTranslateY(ROW[lane]);



        x=COL[15];

        pathanimation =new Timeline();
        int j=0;
        for (int i = 710 ;i >110 ; i-=1,j++) {
            int b=i;
            int m=j;
            pathanimation.getKeyFrames().add(new KeyFrame(new Duration(35+35*j),t-> collision(35+35*m,b-10),new KeyValue(i1.translateXProperty(), i-10)));


        }
        pathanimation.play();
        y= (int) i1.getTranslateY();
        ((AnchorPane)n1).getChildren().add(i1);



    }

    @Override
    void conti(Parent o) {
        this.n1=o;

        image = new Image("Special_Zombie.gif", 70, 70, false, false);
        i1 = new ImageView(image);


        i1.setTranslateX(x);
        i1.setTranslateY(ROW[lane]);




        pathanimation =new Timeline();
        int j=0;
        for (int i = 710 ;i >110 ; i-=1,j++) {
            int b=i;
            int m=j;
            pathanimation.getKeyFrames().add(new KeyFrame(new Duration(35+35*j),t-> collision(35+35*m,b-10),new KeyValue(i1.translateXProperty(), i-10)));


        }
        pathanimation.playFrom(Duration.millis(currenttime));
        y= (int) i1.getTranslateY();
        ((AnchorPane)n1).getChildren().add(i1);

    }

    @Override
    void setSpeed() {

    }

    @Override
    void setHealth() {
        health=150;
    }

    @Override
    void setDamage() {
damage=40;
    }
}
class  CONEZOMBIE extends ZOMBIES implements Serializable {

    CONEZOMBIE(Parent o1) {
        super(o1);
        image = new Image("conezombie.gif", 70, 70, false, false);
        i1 = new ImageView(image);


        i1.setTranslateX(710);
        i1.setTranslateY(ROW[lane]);


        x = COL[15];

        pathanimation = new Timeline();
        int j = 0;
        for (int i = 710; i > 120; i -= 1, j++) {
            int b = i;
            int m = j;
            pathanimation.getKeyFrames().add(new KeyFrame(new Duration(30 + 30 * j), t -> collision(30 + 30 * m, b - 10), new KeyValue(i1.translateXProperty(), i - 10)));


        }
        pathanimation.play();
        y = (int) i1.getTranslateY();
        ((AnchorPane) n1).getChildren().add(i1);


    }

    @Override
    void conti(Parent o) {
        this.n1=o;
        image = new Image("conezombie.gif", 70, 70, false, false);
        i1 = new ImageView(image);


        i1.setTranslateX(x);
        i1.setTranslateY(ROW[lane]);



        pathanimation = new Timeline();
        int j = 0;
        for (int i = 710; i > 120; i -= 1, j++) {
            int b = i;
            int m = j;
            pathanimation.getKeyFrames().add(new KeyFrame(new Duration(30 + 30 * j), t -> collision(30 + 30 * m, b - 10), new KeyValue(i1.translateXProperty(), i - 10)));


        }
        pathanimation.playFrom(Duration.millis(currenttime));
        y = (int) i1.getTranslateY();
        ((AnchorPane) n1).getChildren().add(i1);


    }

    @Override
    void setSpeed() {

    }

    @Override
    void setHealth() {
        health = 100;
    }

    @Override
    void setDamage() {
        damage = 30;
    }
}
class NEWSPAPERZOMBIE extends ZOMBIES implements Serializable {

    NEWSPAPERZOMBIE(Parent o1) {
        super(o1);

        image = new Image("newspaper.gif", 55, 55, false, false);
        i1 = new ImageView(image);


        i1.setTranslateX(710);
        i1.setTranslateY(ROW[lane]);



        x=COL[15];

        pathanimation =new Timeline();
        int j=0;
        for (int i = 710 ;i >120 ; i-=1,j++) {
            int b=i;
            int m=j;
            pathanimation.getKeyFrames().add(new KeyFrame(new Duration(25+25*j),t-> collision(25+25*m,b-10),new KeyValue(i1.translateXProperty(), i-10)));


        }
        pathanimation.play();




        y= (int) i1.getTranslateY();
        ((AnchorPane)n1).getChildren().add(i1);


    }

    @Override
    void conti(Parent o) {
        this.n1=o;

        image = new Image("zombiewalk.gif", 55, 55, false, false);
        i1 = new ImageView(image);


        i1.setTranslateX(x);
        i1.setTranslateY(ROW[lane]);

        pathanimation =new Timeline();
        int j=0;
        for (int i = 710 ;i >110 ; i-=1,j++) {
            int b=i;
            int m=j;
            pathanimation.getKeyFrames().add(new KeyFrame(new Duration(25+25*j),t-> collision(25+25*m,b-10),new KeyValue(i1.translateXProperty(), i-10)));


        }
        pathanimation.playFrom(Duration.millis(currenttime));




        y= (int) i1.getTranslateY();
        ((AnchorPane)n1).getChildren().add(i1);

    }


    @Override
    void setHealth() {
        health=120;
    }

    @Override
    void setDamage() {
        damage=40;
    }


    @Override
    public void setSpeed() {
        speed=5;
    }
}
class FLAGZOMBIE extends ZOMBIES implements Serializable {

    FLAGZOMBIE(Parent o1) {
        super(o1);

        image = new Image("flag.gif", 55, 55, false, false);
        i1 = new ImageView(image);


        i1.setTranslateX(710);
        i1.setTranslateY(ROW[lane]);



        x=COL[15];

        pathanimation =new Timeline();
        int j=0;
        for (int i = 710 ;i >120 ; i-=1,j++) {
            int b=i;
            int m=j;
            pathanimation.getKeyFrames().add(new KeyFrame(new Duration(25+25*j),t-> collision(25+25*m,b-10),new KeyValue(i1.translateXProperty(), i-10)));


        }
        pathanimation.play();




        y= (int) i1.getTranslateY();
        ((AnchorPane)n1).getChildren().add(i1);


    }

    @Override
    void conti(Parent o) {
        this.n1=o;

        image = new Image("zombiewalk.gif", 55, 55, false, false);
        i1 = new ImageView(image);


        i1.setTranslateX(x);
        i1.setTranslateY(ROW[lane]);

        pathanimation =new Timeline();
        int j=0;
        for (int i = 710 ;i >110 ; i-=1,j++) {
            int b=i;
            int m=j;
            pathanimation.getKeyFrames().add(new KeyFrame(new Duration(25+25*j),t-> collision(25+25*m,b-10),new KeyValue(i1.translateXProperty(), i-10)));


        }
        pathanimation.playFrom(Duration.millis(currenttime));




        y= (int) i1.getTranslateY();
        ((AnchorPane)n1).getChildren().add(i1);

    }


    @Override
    void setHealth() {
        health=120;
    }

    @Override
    void setDamage() {
        damage=20;
    }


    @Override
    public void setSpeed() {
        speed=5;
    }
}
