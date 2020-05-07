import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.Serializable;

abstract class CORDINATES implements Serializable
{
    int x,y;

}
public abstract class CHARACTER extends CORDINATES implements Serializable {
     protected  int health;
    protected  int damage;
    protected int speed=0;
    transient protected Parent n1;
    protected int ROW[]=new int[]{57, 120, 187, 254, 314};
    protected int COL[]=new int[]{179, 208,238,267, 297,326, 356,386, 415,445,474,504,533,563,592,621,651};
    abstract void setHealth();
    abstract void setDamage();
  transient   Image image ;
 transient    ImageView i1 ;

}
