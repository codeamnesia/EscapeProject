package org.academiadecodigo.bootcamp.escapeproject.Graphics;

import org.academiadecodigo.bootcamp.escapeproject.Scenable;
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
public class FinalDoor implements MouseHandler, Scenable {

    private Rectangle scene;
    private Rectangle mobile0;
    private Rectangle mobile1;
    private Rectangle smallMobile;
    private Picture background;
    private Picture smallMobille;
    private Picture bigMobille;
    private Picture godRui;


    //Text box for mobile screen
    private Text mobileText1;
    private Text mobileText2;
    private Text mobileText3;

    //Text to appear on Text box
    private String mobileStr1;
    private String mobileStr2;
    private String mobileStr3;

    //Text to compare de Text Box
    private String mobileStr1T;
    private String mobileStr2T;
    private String mobileStr3T;

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

    //boolean for checked string
    private boolean checked1;
    private boolean checked2;
    private boolean checked3;

    //boolean to check open door
    private boolean openDoor;

    //boolean to check if the small mobile phone has been clicked
    private boolean mobileActive;

    public FinalDoor() {

        checkF1 = new Text(400, 230, "false");
        checkT1 = new Text(400, 230, "true");
        checkF2 = new Text(400, 250, "false");
        checkT2 = new Text(400, 250, "true");
        checkF3 = new Text(400, 270, "false");
        checkT3 = new Text(400, 270, "true");

        checked1 = false;
        checked2 = false;
        checked3 = false;
    }

    @Override
    public void prompt() throws InterruptedException {

        Mouse m = new Mouse(this);
        m.addEventListener(MouseEventType.MOUSE_CLICKED);
        m.addEventListener(MouseEventType.MOUSE_MOVED);
        scene = new Rectangle(10.0, 10.0, 900, 900.0);
        scene.setColor(Color.BLACK);
        scene.draw();

        background = new Picture(60.0, 60.0, "resources/pics/finalback.png");
        background.draw();

        this.start();

    }

    public void start() throws InterruptedException {


        smallMobille = new Picture(586.0, 503.0, "resources/pics/mbsmall.png");
        smallMobille.draw();

        bigMobille = new Picture(270.0, 80.0, "resources/pics/mobile.png");

        mobile0 = new Rectangle(350, 509, 45, 30);
        mobile0.setColor(Color.YELLOW);
        //mobile0.draw();


        mobile1 = new Rectangle(290, 397, 45, 30);
        mobile1.setColor(Color.YELLOW);
        //mobile1.draw();


        smallMobile = new Rectangle(590, 503, 45, 30);
        smallMobile.setColor(Color.YELLOW);
        //smallMobile.draw();

        mobileStr1 = "";
        mobileStr2 = "";
        mobileStr3 = "";

        mobileStr1T = "00000000";
        mobileStr2T = "00000000";
        mobileStr3T = "00000000";

        mobileText1 = new Text(325, 230, mobileStr1);
        mobileText2 = new Text(325, 250, mobileStr2);
        mobileText3 = new Text(325, 270, mobileStr3);

        while (!mobileActive) {
            Thread.sleep(5);
        }
        startBigMobile();

        while (!openDoor) {
            Thread.sleep(5);
        }

        this.openDoor();
    }

    private void startBigMobile () throws InterruptedException {

        bigMobille.grow(-80,-200);
        bigMobille.draw();

        Thread.sleep(100);

        bigMobille.grow(20,50);
        bigMobille.draw();

        Thread.sleep(100);

        bigMobille.grow(20,50);
        bigMobille.draw();

        Thread.sleep(100);

        bigMobille.grow(20,50);
        bigMobille.draw();

        Thread.sleep(100);

        bigMobille.grow(20,50);
        bigMobille.draw();

        mobileActive = true;
        mobileText1.draw();
        mobileText2.draw();
        mobileText3.draw();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        //TODO remove all of this for a method don't know how for sure

        if (DoorsUtil.isWithin(e,smallMobile) ){
           mobileActive = true;
        }

        if (DoorsUtil.isWithin(e, mobile0) && mobileStr1.length() < 8 && mobileActive) {
            write0ln1();
        } else if (DoorsUtil.isWithin(e, mobile1) && mobileStr1.length() < 8 && mobileActive) {
            write1ln1();

        }
        checkF1.delete();
        if (mobileStr1.length() == 8 && !checked1) {
            if (!mobileStr1.equals(mobileStr1T)) {
                mobileStr1 = "";
                checkF1.draw();

                return;
            }
            checkT1.draw();
            checked1 = true;
            return;
        }

        if (DoorsUtil.isWithin(e, mobile0) && mobileStr1.length() >= 8 && mobileStr2.length() < 8 && mobileActive) {
            write0ln2();
        } else if (DoorsUtil.isWithin(e, mobile1) && mobileStr1.length() >= 8 && mobileStr2.length() < 8 && mobileActive) {
            write1ln2();
        }
        checkF2.delete();
        if (mobileStr2.length() == 8 && !checked2) {
            if (!mobileStr2.equals(mobileStr2T)) {
                mobileStr2 = "";

                checkF2.draw();
                return;
            }
            checkT2.draw();
            checked2 = true;
            return;
        }

        if (DoorsUtil.isWithin(e, mobile0) && mobileStr1.length() >= 8 && mobileStr2.length() >= 8 && mobileStr3.length() < 8 && mobileActive) {
            write0ln3();
        } else if (DoorsUtil.isWithin(e, mobile1) && mobileStr1.length() >= 8 && mobileStr2.length() >= 8 && mobileStr3.length() < 8 && mobileActive) {
            write1ln3();
        }
        checkF3.delete();
        if (mobileStr3.length() == 8 && !checked3) {
            if (!mobileStr3.equals(mobileStr3T)) {
                checked3 = true;
                mobileStr3 = "";
                checkF3.draw();
                System.out.println(openDoor);
                return;
            }
            checkT3.draw();
            openDoor = true;

        }
        System.out.println(e);
    }

    //final animation for exit doors
    private void openDoor() throws InterruptedException {

        checkT3.delete();
        checkT1.delete();
        checkT2.delete();
        mobileText1.delete();
        mobileText2.delete();
        mobileText3.delete();
        mobileText1.delete();
        mobileText2.delete();
        mobileText3.delete();

        fdoor1 = new Picture(430, 235, "resources/pics/fd1.png");
        fdoor2 = new Picture(430, 235, "resources/pics/fd2.png");
        fdoor3 = new Picture(430, 236, "resources/pics/fd3.png");
        fdoor4 = new Picture(430, 228, "resources/pics/fd4.png");
        fdoor5 = new Picture(430, 230, "resources/pics/fd5.png");
        fdoor6 = new Picture(430, 230, "resources/pics/fd6.png");
        fdoor7 = new Picture(430, 230, "resources/pics/fd7.png");


        bigMobille.delete();
        smallMobille.delete();

        Thread.sleep(500);

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

        Thread.sleep(2000);

        this.finished();
    }

    //GOD'S appearence
    private void finished() {

        godRui = new Picture(60.0, 60.0, "resources/pics/godRui.jpg");

        background.delete();

        godRui.draw();

    }

    //TODO passar como argumento a propr

    //Writes on Mobile screen 1 line 1

    private void write1ln1() {
        mobileStr1 += "1";
        mobileText1.setText(mobileStr1);
        mobileText1.draw();
    }

    //Writes on Mobile screen 0 line 1
    private void write0ln1() {
        mobileStr1 += "0";
        mobileText1.setText(mobileStr1);
        mobileText1.draw();
    }

    //Writes on Mobile screen 1 line 2
    private void write1ln2() {
        mobileStr2 += "1";
        mobileText2.setText(mobileStr2);
        mobileText2.draw();
    }

    //Writes on Mobile screen 0 line 2
    private void write0ln2() {
        mobileStr2 += "0";
        mobileText2.setText(mobileStr2);
        mobileText2.draw();
    }

    //Writes on Mobile screen 1 line 3
    private void write1ln3() {
        mobileStr3 += "1";
        mobileText3.setText(mobileStr3);
        mobileText3.draw();
    }

    //Writes on Mobile screen 0 line 3
    private void write0ln3() {
        mobileStr3 += "0";
        mobileText3.setText(mobileStr3);
        mobileText3.draw();

    }

    @Override
    public void mouseMoved(MouseEvent e) {

        // System.out.println(e);

    }

}







