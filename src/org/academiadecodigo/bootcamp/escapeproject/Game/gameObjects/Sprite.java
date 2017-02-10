package org.academiadecodigo.bootcamp.escapeproject.Game.gameObjects;


import org.academiadecodigo.bootcamp.escapeproject.CollisionDetector;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 05/02/17.
 */

//I had to call it Player because Character is reserved in Java, also Luis made the sprite movements Sofia is going to make the actual sprite


public class Sprite implements KeyboardHandler {

    private Rectangle spriteCollisionDetector;                //the hitbox (going to be half the height of image)
    private Picture spriteImage;                              //any image to represent our character

    private int x = spriteCollisionDetector.getX();             //left-top collision corner
    private int y = spriteCollisionDetector.getY();             //left-bottom collision corner
    private int w = spriteCollisionDetector.getWidth() + x;     //right-top collision corner
    private int h = spriteCollisionDetector.getHeight() + y;    //right-bottom collision corner

    private int mov = 10;                                     //the amount of pixels walked per move. 10 by default
    private Shape[] walls;                                   //group of walls
    private Shape[] doors;                                   //scenePrompts

    public boolean isDoor;                                    //is door open, to prompt new screen


    //Constructor. You can define the picture and the speed of the sprite.
    public Sprite(Picture pic, int movSpeed) {
        mov = movSpeed;
        spriteImage = pic;
        spriteCollisionDetector = new Rectangle(pic.getX(), pic.getY(), pic.getWidth(), pic.getHeight() / 2);
    }


    private Keyboard keyboard;

    public void move(Keyboard keyboard) {
        this.keyboard = new Keyboard;


        Keyboard k = new Keyboard(this);
        KeyboardEvent event = new KeyboardEvent();
        KeyboardEvent eventU = new KeyboardEvent();
        KeyboardEvent eventD = new KeyboardEvent();
        KeyboardEvent eventL = new KeyboardEvent();
        KeyboardEvent eventR = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_SPACE);
        eventU.setKey(KeyboardEvent.KEY_UP);
        eventD.setKey(KeyboardEvent.KEY_DOWN);
        eventL.setKey(KeyboardEvent.KEY_LEFT);
        eventR.setKey(KeyboardEvent.KEY_RIGHT);

        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);

        eventU.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventU);

        eventD.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventD);

        eventL.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventL);

        eventR.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventR);

    }


    @Override
    public void keyPressed(KeyboardEvent e) {


        switch (e.getKey()) {
            case KeyboardEvent.KEY_UP:

                if ((!CollisionDetector.intersects(walls, x, y - mov)) && (!CollisionDetector.intersects(walls, w, h - mov)) &&
                        (!CollisionDetector.intersects(walls, x, h - mov)) && (!CollisionDetector.intersects(walls, w, y - mov))) {
                    spriteCollisionDetector.translate(0, -mov);
                    spriteImage.translate(0, -mov);
                } else {
                    break;
                }


                break;


            case KeyboardEvent.KEY_DOWN:


                if ((!CollisionDetector.intersects(walls, x, y + mov)) && (!CollisionDetector.intersects(walls, w, h + mov)) &&
                        (!CollisionDetector.intersects(walls, x, h + mov)) && (!CollisionDetector.intersects(walls, w, y + mov))) {
                    spriteCollisionDetector.translate(0, mov);
                    spriteImage.translate(0, mov);
                } else {
                    break;
                }
                break;


            case KeyboardEvent.KEY_LEFT:

                if ((!CollisionDetector.intersects(walls, x - mov, y)) && (!CollisionDetector.intersects(walls, w - mov, h)) &&
                        (!CollisionDetector.intersects(walls, x - mov, h)) && (!CollisionDetector.intersects(walls, w - mov, y))) {
                    spriteCollisionDetector.translate(-mov, 0);
                    spriteImage.translate(-mov, 0);
                } else {
                    break;
                }
                break;


            case KeyboardEvent.KEY_RIGHT:

                if ((!CollisionDetector.intersects(walls, x + mov, y)) && (!CollisionDetector.intersects(walls, w + mov, h)) &&
                        (!CollisionDetector.intersects(walls, x + mov, h)) && (!CollisionDetector.intersects(walls, w + mov, y))) {
                    spriteCollisionDetector.translate(mov, 0);
                    spriteImage.translate(mov, 0);
                } else {
                    break;
                }
                break;
        }


    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }


}
}
