package org.academiadecodigo.bootcamp.escapeproject.gameObjects;


//import org.academiadecodigo.bootcamp.escapeproject.game.Grid;
import org.academiadecodigo.bootcamp.escapeproject.position.Direction;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 05/02/17.
 */

//I had to call it Player because character is reserved in Java, also Luis made the sprite movements Sofia is going to make the actual sprite


public class Sprite{


    private Rectangle spriteCollisionDetector;                //the hitbox (going to be half the height of image)
//   todo private Picture[] spriteImages = new Picture[4];              //group of images to represent our character: DOWN, UP, LEFT, RIGHT
    private Picture currentSprite;
    private String pathpic="resources/sprite and rooms/spritefront.jpg";// the current image of the sprite
    private Direction direction;
//    private double x;           //left-top collision corner
//    private double y;             //left-bottom collision corner
//    private double w;   //right-top collision corner
//    private double h;  //right-bottom collision corner
    private Grelha grid;


    //private int mov = 10;                                     //the amount of pixels walked per move. 10 by default




    //Constructor. You can define the picture and the speed of the sprite.
//    public org.academiadecodigo.bootcamp.escapeproject.resources.Sprite(Picture [] org.academiadecodigo.bootcamp.escapeproject.resources.pics, int movSpeed) {
//        mov = movSpeed;
//        spriteImages = org.academiadecodigo.bootcamp.escapeproject.resources.pics;
//        currentSprite = org.academiadecodigo.bootcamp.escapeproject.resources.pics[0];
//        currentSprite.draw();
//        spriteCollisionDetector = new Rectangle(currentSprite.getX(), currentSprite.getY(), currentSprite.getWidth(), currentSprite.getHeight() / 2);
//        x = spriteCollisionDetector.getX();             //left-top collision corner
//        y = spriteCollisionDetector.getY();             //left-bottom collision corner
//        w = spriteCollisionDetector.getWidth() + x;     //right-top collision corner
//        h = spriteCollisionDetector.getHeight() + y;
//    }


    public Sprite() {
        //mov = movSpeed;
        currentSprite = new Picture(750,850,"resources/Sprite/spritefront.jpg");

       //currentSprite = pic;
//
        currentSprite.draw();
        spriteCollisionDetector = new Rectangle(currentSprite.getX(), currentSprite.getY(), currentSprite.getWidth(), currentSprite.getHeight());
//        x = spriteCollisionDetector.getX();             //left-top collision corner
//        y = spriteCollisionDetector.getY();             //left-bottom collision corner
//        w = spriteCollisionDetector.getWidth() + x;     //right-top collision corner
//        h = spriteCollisionDetector.getHeight() + y;


    }


    public Picture getCurrentSprite(){
        return currentSprite;
    }

    /**
     * Sets Player direction
     */

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * Retrieves actual Player direction
     */

    public Direction getDirection() {
        return direction;
    }
    public Rectangle getShape(){
        return spriteCollisionDetector;
    }

    public void centerSprite(Shape room){// a rever para centralizar bem.
        double x=room.getX();
        double y=room.getY();
        double h=spriteCollisionDetector.getHeight();
        double w=spriteCollisionDetector.getWidth();
        double hp=currentSprite.getHeight();
        double wp=currentSprite.getWidth();

        spriteCollisionDetector.delete();
        spriteCollisionDetector=new Rectangle(x+150-(w/2),y+150-(h/2),w,h);
        spriteCollisionDetector.draw();
        currentSprite.delete();
        currentSprite=new Picture(x+150-(wp/2),y+150-(hp/2),pathpic);
        currentSprite.draw();

    }





//    public void move(Direction direction) {
//
//        switch (direction) {
//            case UP:
//                grid.moveUp();
//                break;
//
//            case DOWN:
//                grid.moveDown();
//                break;
//
//            case LEFT:
//                grid.moveLeft();
//                break;
//
//            case RIGHT:
//                grid.moveRight();
//                break;
//        }
//    }
}

