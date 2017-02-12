package org.academiadecodigo.bootcamp.escapeproject.Graphics;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.swing.*;

/**
 * Created by codecadet on 08/02/17.
 */
public class Doors {


    private Picture background;
    private Picture[][] picsPadawan;

    private Questions questions;

    private Picture door1;
    private Picture door2;
    private Picture door3;
    private Picture door4;
    private Picture door5;
    private Picture door6;
    private Picture door7;

    private Text number1Joana;
    private Text number2Jorge;
    private Text number3Rodolfo;

    private int theOnePayingAttention;
    private boolean[] isPayingAttention = {false, false, false};


    public static final int MAX_NUMBER_OF_CLICKS = 5;


    public Doors() throws InterruptedException{

        this.init();

    }

    private void init() throws InterruptedException{

        //TODO só pode haver um objecto questions no jogo todo, criar este objecto na grid ou no game
        questions = new Questions();

        //Creates Background picture for questions levels
        background = new Picture(60.0, 60.0, "resources/pics/fundo.jpg");
        background.draw();

        number1Joana = new Text(200.0, 180.0, "1");
        number1Joana.setColor(Color.WHITE);
        number1Joana.grow(10.0,10.0);
        number1Joana.draw();

        number2Jorge = new Text(440.0, 180.0, "2");
        number2Jorge.setColor(Color.WHITE);
        number2Jorge.grow(10.0,10.0);
        number2Jorge.draw();

        number3Rodolfo = new Text(640.0, 180.0, "3");
        number3Rodolfo.setColor(Color.WHITE);
        number3Rodolfo.grow(10.0,10.0);
        number3Rodolfo.draw();

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

        //Instance level doors

        door1 = new Picture(315.0, 125.0, "resources/pics/d1.png");
        door2 = new Picture(315.0, 125.0, "resources/pics/d2.png");
        door3 = new Picture(315.0, 125.0, "resources/pics/d3.png");
        door4 = new Picture(315.0, 125.0, "resources/pics/d4.png");
        door5 = new Picture(315.0, 125.0, "resources/pics/d5.png");
        door6 = new Picture(315.0, 125.0, "resources/pics/d6.png");
        door7 = new Picture(315.0, 125.0, "resources/pics/d7.png");

        return;

    }




    public void openDoor() throws InterruptedException {

        makePadawansDisapear();

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

        return;

    }

    public void makePadawansDisapear() throws InterruptedException{

        for (int k = 0; k < 10; k++) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    picsPadawan[i][j].grow(-3.5, -10.0);
                    Thread.sleep(15);
                }
            }
        }
        deletePadPictures();
        Thread.sleep(30);
        return;
    }

    public void looseChance() {
        Text text = new Text(300, 200, "You lost your chance!!!");
        text.grow(200.0, 20.0);
        text.setColor(Color.MAGENTA);
        text.draw();
        return;
    }

    public void deletePadPictures() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                picsPadawan[i][j].delete();
            }
        }
        return;

    }

    public boolean randomizeCharacters() {

        theOnePayingAttention = -1;
        for (int i = 0; i < isPayingAttention.length; i++) {
            isPayingAttention[i] = false;
        }

        if (DoorsUtil.isSomeOnePayingAttention()) {
            theOnePayingAttention = DoorsUtil.whoIsPayingAttention();
            picsPadawan[theOnePayingAttention][3].draw();
            isPayingAttention[theOnePayingAttention] = true;
        }

        for(int i = 0; i < picsPadawan.length; i++){
            if (i != theOnePayingAttention) {
                picsPadawan[i][DoorsUtil.randomizeDistracted()].draw();
            }
        }

        return false;
    }

    public void deleteDoors(){
        door1.delete();
        return;
    }

    public int getTheOnePayingAttention() {
        return theOnePayingAttention;
    }

    public Picture[][] getPicsPadawan() {
        return picsPadawan;
    }

    public boolean[] getIsPayingAttention() {
        return isPayingAttention;
    }

    public void resetIsPayingAttention() {
        for (int i = 0; i < isPayingAttention.length; i++) {
            isPayingAttention[i] = false;
        }
    }

    public void deleteNumbers() {
        number1Joana.delete();
        number2Jorge.delete();
        number3Rodolfo.delete();
    }

    public Picture getBackground() {
        return background;
    }
}
