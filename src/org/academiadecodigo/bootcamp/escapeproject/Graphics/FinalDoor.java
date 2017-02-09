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
public class FinalDoor implements MouseHandler {

    private Rectangle scene;
    private Rectangle mobile0;
    private Rectangle mobile1;
    private Picture background;
    private Picture smallMobille;
    private Picture bigMobille;

    //Text box for mobile screen
    private Text mobileText1;
    private Text mobileText2;
    private Text mobileText3;

    //Text to appear on Text box
    private String mobileStr1;
    private String mobileStr2;
    private String mobileStr3;

    //Checked text
    private Text checkT1;
    private Text checkF1;
    private Text checkF2;
    private Text checkT2;
    private Text checkF3;
    private Text checkT3;


    //Final Doors
    private Picture fdoor1;
    private Picture fdoor2;
    private Picture fdoor3;
    private Picture fdoor4;
    private Picture fdoor5;
    private Picture fdoor6;
    private Picture fdoor7;


    private int clickCounter;

    private static final int MAX_NUMBER_OF_CLICKS = 5;


    public FinalDoor() throws InterruptedException {

        this.init();

    }

    private void init() throws InterruptedException {

        Mouse m = new Mouse(this);
        m.addEventListener(MouseEventType.MOUSE_CLICKED);
        m.addEventListener(MouseEventType.MOUSE_MOVED);
        scene = new Rectangle(10.0, 10.0, 900, 900.0);
        scene.setColor(Color.BLACK);
        scene.draw();

        background = new Picture(60.0, 60.0, "resources/pics/finalback.png");
        background.draw();

        fdoor1 = new Picture(430, 235, "resources/pics/fd1.png");
        fdoor2 = new Picture(430, 235, "resources/pics/fd2.png");
        fdoor3 = new Picture(430, 235, "resources/pics/fd3.png");
        fdoor4 = new Picture(430, 235, "resources/pics/fd4.png");
        fdoor5 = new Picture(430, 235, "resources/pics/fd5.png");
        fdoor6 = new Picture(430, 235, "resources/pics/fd6.png");
        fdoor7 = new Picture(430, 235, "resources/pics/fd7.png");

        this.start();

    }

    public void start() throws InterruptedException {

        smallMobille = new Picture(586.0, 503.0, "resources/pics/mbsmall.png");
        smallMobille.draw();


        bigMobille = new Picture(270.0, 80.0, "resources/pics/mobile.png");
        bigMobille.draw();

        mobile0 = new Rectangle(350, 509, 45, 30);
        mobile0.setColor(Color.YELLOW);
        mobile0.draw();

        mobile1 = new Rectangle(290, 397, 45, 30);
        mobile1.setColor(Color.YELLOW);
        mobile1.draw();


        mobileStr1 = "";
        mobileStr2 = "";
        mobileStr3 = "";

        mobileText1 = new Text(325, 230, mobileStr1);
        mobileText2 = new Text(325, 250, mobileStr2);
        mobileText3 = new Text(325, 270, mobileStr3);

        mobileText1.draw();
        mobileText2.draw();
        mobileText3.draw();

        //first Line code check
        checkT1 = new Text(400, 230, "true");
        checkT1.draw();
        checkF1 = new Text(400, 230, "false");

        //second Line code check
        checkT2 = new Text(400, 250, "true");
        checkT2.draw();
        checkF2 = new Text(400, 250, "false");

        //Third Line code check
        checkT3 = new Text(400, 270, "true");
        checkT3.draw();
        checkF3 = new Text(400, 270, "false");

        //this.openDoor();

    }


    private void openDoor() throws InterruptedException {

        try {
            while (true) {

                fdoor1.draw();
                fdoor7.delete();

                Thread.sleep(200);

                fdoor2.draw();
                fdoor1.delete();

                Thread.sleep(200);

                fdoor3.draw();
                fdoor2.delete();

                Thread.sleep(200);

                fdoor4.draw();
                fdoor3.delete();

                Thread.sleep(200);

                fdoor5.draw();
                fdoor4.delete();

                Thread.sleep(200);

                fdoor6.draw();
                fdoor5.delete();

                Thread.sleep(200);

                fdoor7.draw();
                fdoor6.delete();

                Thread.sleep(1000);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();

        }

    }


    @Override
    public void mouseClicked(MouseEvent e) {

        if (DoorsUtil.isWithin(e, mobile0) && mobileStr1.length()<=8) {
            write0ln1();
        }
        if (DoorsUtil.isWithin(e, mobile1) && mobileStr1.length()<=8) {
            write1ln1();
        }
        if (DoorsUtil.isWithin(e, mobile0) && mobileStr1.length()>8 && mobileStr2.length()<=8) {
            write0ln2();
        }
        if (DoorsUtil.isWithin(e, mobile1) && mobileStr1.length()>8 && mobileStr2.length()<=8 ) {
            write1ln2();
        }
        if (DoorsUtil.isWithin(e, mobile0) && mobileStr1.length()>8 && mobileStr2.length()>8 && mobileStr3.length()<=8) {
            write0ln3();
        }
        if (DoorsUtil.isWithin(e, mobile1) && mobileStr1.length()<=8 && mobileStr2.length()>8 && mobileStr3.length()<=8) {
            write1ln3();
        }











        System.out.println(e);
    }



    private void write1ln1 () {
        mobileStr1+= "1";
        mobileText1.setText(mobileStr1);
        mobileText1.draw();
    }

    private void write0ln1() {
        mobileStr1 += "0";
        mobileText1.setText(mobileStr1);
        mobileText1.draw();
    }

    private void write1ln2 () {
        mobileStr2+= "1";
        mobileText2.setText(mobileStr2);
        mobileText2.draw();
    }

    private void write0ln2() {
        mobileStr2 += "0";
        mobileText2.setText(mobileStr2);
        mobileText2.draw();
    }

    private void write1ln3 () {
        mobileStr3+= "1";
        mobileText3.setText(mobileStr3);
        mobileText3.draw();
    }

    private void write0ln3() {
        mobileStr3 += "0";
        mobileText3.setText(mobileStr3);
        mobileText3.draw();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println(e);

    }

}