import javafx.animation.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

import java.awt.event.ActionListener;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class GAME implements Serializable {
    static  int sun=0;
      int sun12=0;
      double prog;

              ProgressBar progress;
    USER player;
   static  public Label counter;
  static  public Button peashooter;
  static  public Button savebtn;
    static public Button sunflower;
    static public Button bomb;
    static public Button walnut;

    private int level;
    private Parent root ;
static int pro;
static int level1;
    private String plantselect;
    Button finish;
    int ROW[]=new int[]{54, 144, 220, 280, 354};
    static int Buttonstime[]=new int[]{0, 0, 0, 0, 0,0};

    int COL[]=new int[]{186, 238, 297, 356, 400,481,550,600,640};
    static ArrayList<String> activatedbuttons=new ArrayList<>();
   static ArrayList<PLANTS> planted=new ArrayList<>();
   static ArrayList<ZOMBIES> alivezombies=new ArrayList<>();
   static ArrayList<LAWNMOVER> moverss=new ArrayList<>();
     ArrayList<String> activatedbuttons12=new ArrayList<>();
     ArrayList<PLANTS> planted12=new ArrayList<>();
     ArrayList<ZOMBIES> alivezombies12=new ArrayList<>();
     ArrayList<LAWNMOVER> moverss12=new ArrayList<>();
    public int azombie;
    public Label wavev;

    public GAME(USER u) {
        player=u;
        sun=50;
    }


    public void setuser(USER u)
    {
        this.player=u;


    }
    Boolean Level_CHECK(int i)
    {
        return i<=level;
    }
public GAME()
    {
//        level=0;
//        sun=50;

        plantselect="";

    }

    public int getLevel() {
        return level;
    }
    public void startwave(Parent n1)
    {    if  (azombie<=(level+1)*4&&azombie!=-1) {
        for (Node n : ((AnchorPane) root).getChildren()) {
            if (n.getId() != null)
                if (n.getId().equals("wavev")) {
                    wavev = (Label) n;
                    wavev.setVisible(true);
                }
        }

        ZOMBIES z1=null;
        Random random=new Random();
        int rand=random.nextInt(level);
        if (rand==0)
            z1= new BASICZOMBIE(root);

        if (rand==1)
            z1 = new FLAGZOMBIE(root);
        if (rand==2)
            z1 = new CONEZOMBIE(root);
        if (rand==3)
            z1 = new NEWSPAPERZOMBIE(root);

        if (rand==4)
            z1 = new SPECIALZOMBIE(root);


        alivezombies.add(z1);
        IntegerProperty seconds = new SimpleIntegerProperty();
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(seconds, 0)),
                new KeyFrame(Duration.minutes(0.05), e -> {
                    // do anything you need here on completion...
                    zombies(n1);

//                        azombie.getAndSet(azombie.get()+1) ;
//                        if (azombie.get()==3)
//                            System.out.println("hello");
                }, new KeyValue(seconds, 1))
        );
        timeline.play();
        azombie++;


//        System.out.println("hello assssssssssssss " + azombie);
        if (azombie == (level + 1) * 4) {
            System.out.println("Wave ended");

        }
    }}
public void zombies(Parent n1)
        { if  (azombie<=(level+2)*4) {
            ZOMBIES z1=null;
            Random random=new Random();
            int rand=random.nextInt(level);
                if (rand==0)
                     z1= new BASICZOMBIE(root);

            if (rand==1)
                z1 = new FLAGZOMBIE(root);
            if (rand==2)
                z1 = new CONEZOMBIE(root);
            if (rand==3)
                z1 = new NEWSPAPERZOMBIE(root);

            if (rand==4)
                z1 = new SPECIALZOMBIE(root);


        alivezombies.add(z1);
            IntegerProperty seconds = new SimpleIntegerProperty();
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(seconds, 0)),
                    new KeyFrame(Duration.minutes(0.1), e-> {
                        // do anything you need here on completion...
                        zombies(n1);
                    }, new KeyValue(seconds, 1))
            );
            timeline.play();
            azombie++;
//            System.out.println((level + 2) * 2+"  hello sad " + azombie);

            if (azombie == (level + 2) * 2)
                startwave(n1);
        }}


    public void MAINSUN(Parent n1)
    {
        Image image = new Image("sun.gif", 45, 45, false, false);
        ImageView i1 = new ImageView(image);

        Button b1=new Button();
        b1.setStyle("-fx-background-color: transparent");

        Random r=new Random();
        int lane= r.nextInt(9);
        b1.setGraphic(i1);
        b1.setTranslateX(COL[lane]);
        b1.setTranslateY(100);
//        i1.maxHeight(55);
//        i1.maxWidth(53);



        Path path = new Path();
        //Moving to the starting point
//        MoveTo moveTo = new MoveTo(COL[lane], 100);
//
//        //Creating 1st line
//        LineTo line1 = new LineTo(COL[lane], 100);
        MoveTo moveTo = new MoveTo(COL[lane], 30);

        //Creating 1st line
        LineTo line1 = new LineTo(COL[lane], 300);

        //Adding all the elements to the path
        path.getElements().add(moveTo);
        path.getElements().add(line1);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(15000));
        pathTransition.setPath(path);
        pathTransition.setNode(b1);
        pathTransition.play();
        ((AnchorPane)n1).getChildren().add(b1);
        b1.setOnAction(click -> {
            b1.setVisible(false);
            GAME.sun+=50;
            GAME.update();
        });
        IntegerProperty seconds = new SimpleIntegerProperty();
        Timeline timeline=new Timeline();
        Timeline finalTimeline = timeline;
        timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(seconds, 0)),
                new KeyFrame(Duration.minutes(0.1), e-> {
                    if (azombie>=(level+2)*4 && alivezombies.isEmpty())
                        finalTimeline.stop();
                    // do anything you need here on completion...
                    MAINSUN(root);
                }, new KeyValue(seconds, lane/2))
        );
        timeline.play();
        if (azombie>=(level+2)*4 && alivezombies.isEmpty())
        {  // wavev.setMaxSize(200,200);
            wavev.autosize();
            wavev.setFont(Font.font(("Arial"), 150));
            wavev.setText("GAME WON");
            timeline.stop();
            for (Node n : ((AnchorPane) root).getChildren()) {
                if (n.getId() != null)
                    if (n.getId().equals("finish")) {
                        Button b=(Button)n;
                        b.setDisable(false);
                        b.setVisible(true);
                        // action event
//                        System.out.println("level      kinshuk                "+player.level);
                        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent e)
                            {
                                try {
//                                    System.out.println("level             game          "+player.level);
                                    if (level==player.level)
                                    { player.level++;
//                                        System.out.println("level            game          "+level);
                                        ArrayList<PLANTS> p2=new ArrayList<>(planted);
                                        for (PLANTS p:p2
                                             ) {
                                            p.plantdead();

                                        }
                                    }
                                    player.StartNewGame();
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        };

                        // when button is pressed
                        b.setOnAction(event);
                    }}


        }

        ArrayList<ZOMBIES> arr=new ArrayList<>(alivezombies);
        for (ZOMBIES z:arr
        ) {
            if(z.x-117<0)
            {azombie=-1;
                for (Node n : ((AnchorPane) root).getChildren()) {
                    if (n.getId() != null)
                        if (n.getId().equals("wavev")) {
                            wavev = (Label) n;
                            System.out.println("kkkkkkkkkkkkkkk");
                            wavev.setVisible(true);
                        }}
                wavev.setText("LEVEL LOST ");

                Timeline timeline1 = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(seconds, 0)),
                        new KeyFrame(Duration.millis(2000), e-> {
                            // do anything you need here on completion...
                            ((AnchorPane) root).getChildren().remove(wavev);
                            ArrayList<PLANTS> p2=new ArrayList<>(planted);
                            for (PLANTS p:p2
                            ) {
                                p.plantdead();

                            }

                            try {
                                player.StartNewGame();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }, new KeyValue(seconds, 1))
                );

                timeline1.play();
                break;
            }

        }
        if(azombie==-1)
        {
            for (ZOMBIES z:arr
            ) {
                z.zombiedead();
            }
        }
    }

    void startlevel(int a, Window n1) throws IOException {


        root = FXMLLoader.load(getClass().getResource("backyard.fxml"));

        Stage window = (Stage) n1;
level=a;
        mower();
level1=a;
System.out.println(a);



         progress = new ProgressBar();
        progress.setMinWidth(200);
        progress.setMaxWidth(Double.MAX_VALUE);
        IntegerProperty seconds = new SimpleIntegerProperty();
        progress.progressProperty().bind(seconds.divide(150.0));
        Timeline timeline = new Timeline();
//        new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(seconds, 0)),new KeyFrame(Duration.minutes(1), new KeyValue(seconds, 150)));
        for (int i = 0 ;i <6000 ; i+=6) {
           int b=i;
            timeline.getKeyFrames().add(new KeyFrame(new Duration(500+500*i),t-> {prog=500+500*b;},new KeyValue(seconds, 1.5+1.5*i)));


        }


        progress.setTranslateX(382);
        progress.setTranslateY(16);
        timeline.setCycleCount(1);
        timeline.play();
        for (Node n : ((AnchorPane) root).getChildren()) {
            if (n.getId() != null) {
                if (n.getId().equals("topwood")) {

                    for (Node m : ((AnchorPane) n).getChildren()) {
                        if (m.getId() != null){
                            if (m.getId().equals("peashooter"))
                                peashooter = (Button) m;
                                if (m.getId().equals("sunflower"))
                                    sunflower = (Button) m;
                            if (m.getId().equals("walnut"))
                                walnut = (Button) m;
                            if (m.getId().equals("bomb"))
                                bomb = (Button) m;

                            }
                    }
                    ((AnchorPane)n).getChildren().add(progress);}
                    if (n.getId().equals("counter"))
                        counter = (Label) n;
                    if(n.getId().equals("finish"))
                        finish=(Button)n;
                if(n.getId().equals("save")) {
                    savebtn = (Button) n;
                    EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e)
                        {
                            try {
                                save();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                    };
                savebtn.setOnAction(event1);
                }
                }

            }

            sunflower.setGraphic(new ImageView(new Image(("sunflower_inactive.jpg"), 59, 40, false, false)));
        peashooter.setGraphic(new ImageView(new Image(("pea_inactive.jpg"), 59, 40, false, false)));


            window.setScene(new Scene(root, 800, 400));
        zombies(root);
        MAINSUN(root);





    }

        public void plantdrop (ActionEvent actionEvent) throws InterruptedException, PLANTDEADEXCEPTION {
          if (plantselect.equals("shovel")){
              if (activatedbuttons.contains(((Button) actionEvent.getSource()).getId()))
              {PLANTS p2 = null;
                  for (PLANTS p1 :planted) {
                      if (p1.btn.getId().equals(((Button) actionEvent.getSource()).getId())) {
                          p2 = p1;
                          break;
                      }
                  }
                  if (p2!=null)
              p2.plantdead();
                  return;
              }
          }
            PLANTS p1 = null;
            if (!activatedbuttons.contains(((Button) actionEvent.getSource()).getId())) {
                Button b1 = (Button) (actionEvent.getSource());
                if (plantselect.equals("peashooter") && sun >= 100) {

                        p1 = new PEASHOOTER(b1);
                        planted.add(p1);
                        Timeline timer=new Timeline();
                        Buttonstime[0]=1;
                        timer.getKeyFrames().add(new KeyFrame(new Duration(6000) ,t->
                            {
                                Buttonstime[0]=0;
                        update();
                            }));
                        timer.play();
                        sun -= 100;
                    activatedbuttons.add(((Button) actionEvent.getSource()).getId());
                    System.out.println(activatedbuttons.get(0));
                } else if (plantselect.equals("sunflower") && sun >= 50&& level1>1) {
                    p1 = new SUNFLOWER(b1);
                    sun -= 50;
                    activatedbuttons.add(((Button) actionEvent.getSource()).getId());
                    planted.add(p1);
                    Timeline timer=new Timeline();
                    Buttonstime[1]=1;
                    timer.getKeyFrames().add(new KeyFrame(new Duration(7000) ,t->
                    {
                        Buttonstime[1]=0;
                        update();
                    }));
                    timer.play();


                }
                else if (plantselect.equals("walnut") && sun >= 50&&level1>2) {
                    p1 = new WALNUT(b1);
                    sun -= 50;
                    activatedbuttons.add(((Button) actionEvent.getSource()).getId());
                    planted.add(p1);
                    Timeline timer=new Timeline();
                    Buttonstime[2]=1;
                    timer.getKeyFrames().add(new KeyFrame(new Duration(5000) ,t->
                    {
                        Buttonstime[2]=0;
                        update();
                    }));
                    timer.play();


                }
                else if (plantselect.equals("bomb") && sun >= 25&&level1>3) {
                    p1 = new BOMB(b1);
                    sun -= 25;
                    activatedbuttons.add(((Button) actionEvent.getSource()).getId());
                    planted.add(p1);
                    Timeline timer=new Timeline();
                    Buttonstime[3]=1;
                    timer.getKeyFrames().add(new KeyFrame(new Duration(7000) ,t->
                    {
                        Buttonstime[3]=0;
                        update();
                    }));
                    timer.play();


                }
//

            }
            plantselect="";
            update();


        }

        public void plantshooter (ActionEvent actionEvent){
            plantselect = ((Button) actionEvent.getSource()).getId();
            System.out.println(plantselect);
        }



        public static void update () {
            counter.setText(Integer.toString(sun));
            if (sun >= 100&&Buttonstime[0]==0) {
                peashooter.setGraphic(new ImageView(new Image(("pea_active.jpg"), 59, 49, false, false)));
            }
            if (sun < 100||Buttonstime[0]==1) {
                peashooter.setGraphic(new ImageView(new Image(("pea_inactive.jpg"), 59, 49, false, false)));

            }
            if (sun >= 50&&Buttonstime[1]==0&&level1>1) {
                sunflower.setGraphic(new ImageView(new Image(("sunflower_active.jpg"), 59, 49, false, false)));
            }
            if (sun <50||Buttonstime[1]==1) {
                sunflower.setGraphic(new ImageView(new Image(("sunflower_inactive.jpg"), 59, 49, false, false)));

            }
            if (sun >= 50&&Buttonstime[2]==0&&level1>2) {
                walnut.setGraphic(new ImageView(new Image(("wall_active.jpg"), 59, 49, false, false)));
            }
            if (sun <50||Buttonstime[2]==1) {
                walnut.setGraphic(new ImageView(new Image(("wall_inactive.jpg"), 59, 49, false, false)));

            }
            if (sun >= 25&&Buttonstime[3]==0&&level1>3) {
                bomb.setGraphic(new ImageView(new Image(("bomb_active.jpg"), 59, 40, false, false)));
            }
            if (sun <25||Buttonstime[3]==1) {
                bomb.setGraphic(new ImageView(new Image(("bomb_inactive.jpg"), 59, 40, false, false)));

            }
//            if (sun >= 200&&Buttonstime[5]==0) {
//                tallnut.setGraphic(new ImageView(new Image(("tall_active.jpg"), 59, 40, false, false)));
//            }
//            if (sun <200) {
//                tallnut.setGraphic(new ImageView(new Image(("tall_inactive.jpg"), 59, 40, false, false)));
//
//            }

        }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void mower() {
        for (int i = 0; i <5 ; i++) {
            moverss.add(new LAWNMOVER(root,i));
        }
    }
    void save() throws IOException {
        GAME gamesave=new GAME();
gamesave.level=level;
gamesave.sun12=sun;
gamesave.prog=prog;
System.out.println(sun);
USER u1=new USER();
u1.username=player.username;
u1.level=player.level;
gamesave.setuser(u1);
gamesave.activatedbuttons12=new ArrayList<>(GAME.activatedbuttons);
        for (int i = 0; i <activatedbuttons.size() ; i++) {
            System.out.println(activatedbuttons.get(i));

        }
System.out.println(gamesave.activatedbuttons12.size());
gamesave.planted12=new ArrayList<>(GAME.planted);
gamesave.moverss12=new ArrayList<>(GAME.moverss);
gamesave.alivezombies12=new ArrayList<>(GAME.alivezombies);


        ObjectOutputStream out = null;
        try {
            File folder = new File(".");

            File[] files = folder.listFiles();
if(files!=null)
    for (int i = 0; i < 10; i++) {

        int flag = 0;
        for (File file : files) {
            if (file.getName().equals(player.getUsername() + ".txt")) {
                player.username = player.username + "1";
            }
        }
        if (flag == 0)
            break;
    }
            out = new ObjectOutputStream(new FileOutputStream(player.getUsername()+".txt"));
            out.writeObject(gamesave);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            out.close();
        }

    }

    void continuegame(Window n1) throws IOException {
//        GAME.alivezombies = new ArrayList<>(this.alivezombies12);
//        GAME.moverss = new ArrayList<>(this.moverss12);
//        GAME.planted = new ArrayList<>(this.planted12);
        sun=sun12;
        level1=level;
System.out.println(sun12+"  "+sun+"  "+level+"  "+player.level);
        root = FXMLLoader.load(getClass().getResource("backyard.fxml"));
        progress = new ProgressBar();
        progress.setMinWidth(200);
        progress.setMaxWidth(Double.MAX_VALUE);
        IntegerProperty seconds = new SimpleIntegerProperty();
        progress.progressProperty().bind(seconds.divide(150.0));
        Timeline timeline = new Timeline();
        for (int i = 0 ;i <6000 ; i+=6) {
            int b=i;
            timeline.getKeyFrames().add(new KeyFrame(new Duration(500+500*i),t-> {prog=500+500*b;},new KeyValue(seconds, 1.5+1.5*i)));


        }

        progress.setTranslateX(382);
        progress.setTranslateY(16);
        timeline.setCycleCount(1);
        timeline.playFrom(Duration.millis(prog));

        Stage window = (Stage) n1;
        for (Node n : ((AnchorPane) root).getChildren()) {
            if (n.getId() != null) {
                if (n.getId().equals("topwood")) {

                    for (Node m : ((AnchorPane) n).getChildren()) {
                        if (m.getId() != null) {
                            if (m.getId().equals("peashooter"))
                                peashooter = (Button) m;
                            if (m.getId().equals("sunflower"))
                                sunflower = (Button) m;
                            if (m.getId().equals("walnut"))
                                walnut = (Button) m;
                            if (m.getId().equals("bomb"))
                                bomb = (Button) m;

                        }
                    }
                    ((AnchorPane)n).getChildren().add(progress);

            }


                if (n.getId().equals("counter"))
                    counter = (Label) n;
                if (n.getId().equals("finish"))
                    finish = (Button) n;
                if (n.getId().equals("save")) {
                    savebtn = (Button) n;

                }
            }

        }
        for (Node n : ((AnchorPane) root).getChildren()) {
if(n.getId()!=null)
            for (String name:this.activatedbuttons12) {

            System.out.println(n.getId());
            if(n.getId().equals(name))
            {
                for (PLANTS incomplant:planted12) {
                    System.out.println(incomplant.x+"   "+incomplant.y);
                    if (incomplant.x==n.getLayoutX()&&incomplant.y==n.getLayoutY())
                    {Button b1=(Button)n ;
                        incomplant.conti1(b1);
                        GAME.planted.add(incomplant);
                        System.out.println("nitin");
                    }
                }
            }

        }}
        for (ZOMBIES z:alivezombies12
             ) {
            z.conti(root);
            GAME.alivezombies.add(z);
        }
        for (PLANTS p:planted
             ) {
            p.conti();

        }
        for (LAWNMOVER m1:moverss12
             ) {
            m1.conti(root);
            GAME.moverss.add(m1);
        }
        this.player.n1=n1;

        window.setScene(new Scene(root, 800, 400));
//        GAME.alivezombies = new ArrayList<>(this.alivezombies12);
//        GAME.moverss = new ArrayList<>(this.moverss12);
//        GAME.planted = new ArrayList<>(this.planted12);
        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                try {
                    save();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        };
        savebtn.setOnAction(event1);
        activatedbuttons=new ArrayList<>(activatedbuttons12);
        update();

        zombies(root);
        MAINSUN(root);




    }
}
