package org.academiadecodigo.bootcamp.escapeproject.Graphics;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 08/02/17.
 */
public class Doors implements MouseHandler{


    private Rectangle scene;
    private Picture backgroud;
    private Picture[][] picsPadawan;

    private Picture door1;
    private Picture door2;
    private Picture door3;
    private Picture door4;
    private Picture door5;
    private Picture door6;
    private Picture door7;

    private int theOnePayingAttention;
    private boolean[] isPayingAttention = {false, false, false};
    boolean caughtAttention;
    int clickCounter;

    private static final int MAX_NUMBER_OF_CLICKS = 5;


    public Doors() throws InterruptedException{

        this.init();

    }

    private void init() throws InterruptedException{

        Mouse m = new Mouse(this);
        m.addEventListener(MouseEventType.MOUSE_CLICKED);
        m.addEventListener(MouseEventType.MOUSE_MOVED);
        scene = new Rectangle(10.0, 10.0, 900, 900.0);
        scene.setColor(Color.BLACK);
        scene.draw();

        backgroud = new Picture(60.0, 60.0, "resources/pics/fundo.jpg");
        backgroud.draw();

        picsPadawan = new Picture[3][4];

        picsPadawan[0][0] = new Picture(160.0, 250.0, "resources/pics/j1.png");
        picsPadawan[0][1] = new Picture(160.0, 250.0, "resources/pics/j2.png");
        picsPadawan[0][2] = new Picture(160.0, 250.0, "resources/pics/j4.png");
        picsPadawan[0][3] = new Picture(160.0, 250.0, "resources/pics/jpointer.png");

        picsPadawan[1][0] = new Picture(400.0, 215.0, "resources/pics/jo1.png");
        picsPadawan[1][1] = new Picture(400.0, 215.0, "resources/pics/jo2.png");
        picsPadawan[1][2] = new Picture(400.0, 215.0, "resources/pics/jo3.png");
        picsPadawan[1][3] = new Picture(400.0, 215.0, "resources/pics/jopointer.png");

        picsPadawan[2][0] = new Picture(600.0, 225.0, "resources/pics/r1.png");
        picsPadawan[2][1] = new Picture(600.0, 225.0, "resources/pics/r3.png");
        picsPadawan[2][2] = new Picture(600.0, 225.0, "resources/pics/r4.png");
        picsPadawan[2][3] = new Picture(600.0, 225.0, "resources/pics/Rpointer.png");

        door1 = new Picture(315.0, 125.0, "resources/pics/d1.png");
        door2 = new Picture(315.0, 125.0, "resources/pics/d2.png");
        door3 = new Picture(315.0, 125.0, "resources/pics/d3.png");
        door4 = new Picture(315.0, 125.0, "resources/pics/d4.png");
        door5 = new Picture(315.0, 125.0, "resources/pics/d5.png");
        door6 = new Picture(315.0, 125.0, "resources/pics/d6.png");
        door7 = new Picture(315.0, 125.0, "resources/pics/d7.png");


        this.start();

    }

    private void start() throws InterruptedException{

        clickCounter = 0;
        caughtAttention = false;

        while(true) {

            this.deleteRectangles();

            this.randomizeCharacters();

            Thread.sleep(this.randomTime());

            if (caughtAttention) {
                this.openDoor();
                break;
            }

            if (clickCounter >= MAX_NUMBER_OF_CLICKS) {
                this.looseChance();
                break;
            }

        }



    }

    private void openDoor() throws InterruptedException {

        while(true) {

            door7.draw();
            door1.delete();

            Thread.sleep(200);

            door6.draw();
            door7.delete();

            Thread.sleep(200);

            door5.draw();
            door6.delete();

            Thread.sleep(200);

            door4.draw();
            door5.delete();

            Thread.sleep(200);

            door3.draw();
            door4.delete();

            Thread.sleep(200);

            door2.draw();
            door3.delete();

            Thread.sleep(200);

            door1.draw();
            door2.delete();

            Thread.sleep(1000);

        }

    }


    private void looseChance() {
        Text text = new Text(200, 180, "You lost your chance!!!");
        text.setColor(Color.MAGENTA);
        text.draw();
    }

    private void deleteRectangles() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                picsPadawan[i][j].delete();
            }
        }

    }

    private long randomTime() {
        return 800 + (long) (Math.random() * 500);
    }

    private boolean randomizeCharacters() {

        theOnePayingAttention = -1;
        for (boolean b : isPayingAttention) {
            b = false;
        }

        if (this.isSomeOnePayingAttention()) {
            theOnePayingAttention = this.whoIsPayingAttention();
            picsPadawan[theOnePayingAttention][3].draw();
            isPayingAttention[theOnePayingAttention] = true;
        }

        for(int i = 0; i < picsPadawan.length; i++){
            if (i != theOnePayingAttention) {
                picsPadawan[i][this.randomizeColors()].draw();
            }
        }

        return false;
    }

    private int randomizeColors() {
        return (int) (Math.random() * 3);
    }

    private int whoIsPayingAttention() {
        return (int) (Math.random() * 3);
    }

    private boolean isSomeOnePayingAttention() {
        return Math.random() < 0.3;
    }

    @Override
    public void mouseClicked(MouseEvent e){

        if (theOnePayingAttention != -1 && e.getX() >= picsPadawan[theOnePayingAttention][3].getX()
                && e.getX() <= picsPadawan[theOnePayingAttention][3].getX() + picsPadawan[theOnePayingAttention][3].getWidth()
                && e.getY() - 23 >= picsPadawan[theOnePayingAttention][3].getY()
                && e.getY() - 23 <= picsPadawan[theOnePayingAttention][3].getY() + picsPadawan[theOnePayingAttention][3].getHeight()
                && isPayingAttention[theOnePayingAttention]) {
            picsPadawan[theOnePayingAttention][3].grow(20.0, 50.0);
            caughtAttention = true;
        }
        clickCounter++;
        System.out.println(e);

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println(e);

    }






}
