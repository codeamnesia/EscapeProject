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
private Picture [] spriteImage = new Picture[4];              //group of images to represent our character: DOWN, UP, LEFT, RIGHT

    private Picture currentSprite;                            // the current image of the sprite

    private int x = spriteCollisionDetector.getX();             //left-top collision corner
    private int y = spriteCollisionDetector.getY();             //left-bottom collision corner
    private int w = spriteCollisionDetector.getWidth() + x;     //right-top collision corner
    private int h = spriteCollisionDetector.getHeight() + y;    //right-bottom collision corner

    private int mov = 10;                                     //the amount of pixels walked per move. 10 by default
    private int steps;                                        //number of moves made so far. it's reset when a door is found

    private Shape[] walls;                                   //group of walls
    private Shape[] doors;                                   //scenePrompts
    private Shape[] rooms;                                   //group of rooms

    private boolean sceneOff = true;                         //When true, the sprite can move around.
    private boolean [] inRoom = new boolean [9];             //When true, the room will stop being dark permanently;


    public boolean isInRoom( int roomNumber) {
        return inRoom[roomNumber];
    }

    public void setInRoom(int roomNumber, boolean inRoom) {
        this.inRoom[roomNumber] = inRoom;
    }

    public boolean isSceneOff() {
        return sceneOff;
    }

    public void setSceneOff(boolean sceneOff) {
        this.sceneOff = sceneOff;
    }



    //Constructor. You can define the picture and the speed of the sprite.
    public Sprite(Picture [] pics, int movSpeed) {
        mov = movSpeed;
        spriteImage = pics;
        currentSprite = pics[0];
        spriteCollisionDetector = new Rectangle(currentSprite.getX(), currentSprite.getY(), currentSprite.getWidth(), currentSprite.getHeight() / 2);
    }


    private Keyboard keyboard;

    public void move(Keyboard keyboard) {
        this.keyboard = new Keyboard(this);


        Keyboard k = new Keyboard(this);               //TODO carregar no espaço para interagir com objecto (portas, computador sala secreta)
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
        if(sceneOff) {

            if ((CollisionDetector.intersects(doors, x, y)) && (CollisionDetector.intersects(doors, w, h)) &&
                (CollisionDetector.intersects(doors, x, h)) && (CollisionDetector.intersects(doors, w, y))) {
                if (steps >= 3) {
                    sceneOff = false;
                    steps = 0;
                }
            }


            for (int i = 0; i < rooms.length; i++) {
                if ((CollisionDetector.intersects(rooms[i], x, y)) && (CollisionDetector.intersects(rooms[i], w, h)) &&
                    (CollisionDetector.intersects(rooms[i], x, h)) && (CollisionDetector.intersects(rooms[i], w, y))) {

                    inRoom[i] = true;

                }
            }



            switch (e.getKey()) {
                case KeyboardEvent.KEY_UP:

                    currentSprite = spriteImage[1];

                    if ((!CollisionDetector.intersects(walls, x, y - mov)) && (!CollisionDetector.intersects(walls, w, h - mov)) &&
                        (!CollisionDetector.intersects(walls, x, h - mov)) && (!CollisionDetector.intersects(walls, w, y - mov))) {
                            spriteCollisionDetector.translate(0, -mov);
                            currentSprite.translate(0, -mov);
                            steps++;
                    } else {
                        break;
                    }


                    break;


                case KeyboardEvent.KEY_DOWN:

                    currentSprite = spriteImage[0];

                    if ((!CollisionDetector.intersects(walls, x, y + mov)) && (!CollisionDetector.intersects(walls, w, h + mov)) &&
                        (!CollisionDetector.intersects(walls, x, h + mov)) && (!CollisionDetector.intersects(walls, w, y + mov))) {
                            spriteCollisionDetector.translate(0, mov);
                            currentSprite.translate(0, mov);
                            steps++;
                    } else {
                        break;
                    }
                    break;


                case KeyboardEvent.KEY_LEFT:

                    currentSprite = spriteImage[3];

                    if ((!CollisionDetector.intersects(walls, x - mov, y)) && (!CollisionDetector.intersects(walls, w - mov, h)) &&
                        (!CollisionDetector.intersects(walls, x - mov, h)) && (!CollisionDetector.intersects(walls, w - mov, y))) {
                            spriteCollisionDetector.translate(-mov, 0);
                            currentSprite.translate(-mov, 0);
                            steps++;
                    } else {
                        break;
                    }
                    break;


                case KeyboardEvent.KEY_RIGHT:

                    currentSprite = spriteImage[2];

                    if ((!CollisionDetector.intersects(walls, x + mov, y)) && (!CollisionDetector.intersects(walls, w + mov, h)) &&
                        (!CollisionDetector.intersects(walls, x + mov, h)) && (!CollisionDetector.intersects(walls, w + mov, y))) {
                            spriteCollisionDetector.translate(mov, 0);
                            currentSprite.translate(mov, 0);
                            steps++;
                    } else {
                        break;
                    }
                    break;
            }
        }

    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }


}

