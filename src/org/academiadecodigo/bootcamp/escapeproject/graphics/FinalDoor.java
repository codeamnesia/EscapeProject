
package org.academiadecodigo.bootcamp.escapeproject.graphics;

import org.academiadecodigo.bootcamp.escapeproject.Scenable;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


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

    //Final door pictures
    private Picture[] fdoors;

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

        background = new Picture(60.0, 60.0, "resources/org.academiadecodigo.bootcamp.escapeproject.resources.pics/finalback.png");
        background.draw();

        this.start();

    }

    public void start() throws InterruptedException {


        smallMobille = new Picture(586.0, 503.0, "resources/org.academiadecodigo.bootcamp.escapeproject.resources.pics/mbsmall.png");
        smallMobille.draw();

        bigMobille = new Picture(270.0, 80.0, "resources/org.academiadecodigo.bootcamp.escapeproject.resources.pics/mobile.png");

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

        mobileStr1T = "01010010";
        mobileStr2T = "01010101";
        mobileStr3T = "01001001";

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

        for (int i = 0; i < 4; i++) {
            Thread.sleep(100);

            bigMobille.grow(20,50);
            bigMobille.draw();
        }

        mobileActive = true;
        mobileText1.draw();
        mobileText2.draw();
        mobileText3.draw();
    }

    public void checkLines1inMobile(){



        checkF1.delete();
        if (mobileStr1.length() == 8 && !checked1) {
            if (!mobileStr1.equals(mobileStr1T)) {
                mobileStr1 = "";
                checkF1.draw();

                return;
            }
            checkT1.draw();
            checked1 = true;

        }


    }

    public void checkLines2inMobile() {

        checkF2.delete();
        if (mobileStr2.length() == 8 && !checked2) {
            if (!mobileStr2.equals(mobileStr2T)) {
                mobileStr2 = "";
                checkF2.draw();

                return;
            }
            checked2 = true;
            checkT2.draw();
            return;
        }

    }

    public void checkLines3inMobile() {

        checkF3.delete();
        if (mobileStr3.length() == 8 && !checked3) {
            if (!mobileStr3.equals(mobileStr3T)) {
                //checked3 = true;
                mobileStr3 = "";
                checkF3.draw();
                System.out.println(openDoor);
                return;
            }
            checkT3.draw();
            mobile0.delete();
            mobile1.delete();
            openDoor = true;
        }


    }

    //TODO replace this part with what's done in Francisco's PC
    @Override
    public void mouseClicked(MouseEvent e) {



        if (DoorsUtil.isWithin(e,smallMobile) ){
           mobileActive = true;
        }

        if(DoorsUtil.isWithin(e, mobile0) && mobileActive){
            if (mobileStr1.length() < 8){
                writeln1(0);
            }else if(mobileStr2.length()<8){
                writeln2(0);
            }else {
                writeln3(0);
            }
        }else if(DoorsUtil.isWithin(e, mobile1) && mobileActive){
            if (mobileStr1.length() < 8){
                writeln1(1);
            }else if(mobileStr2.length()<8){
                writeln2(1);
            }else {
                writeln3(1);
            }
        }

        this.checkLines1inMobile();
        this.checkLines2inMobile();
        this.checkLines3inMobile();


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

        fdoors = new Picture[7];

        fdoors[0] = new Picture(430, 235, "resources/org.academiadecodigo.bootcamp.escapeproject.resources.pics/fd1.png");
        fdoors[1] = new Picture(430, 235, "resources/org.academiadecodigo.bootcamp.escapeproject.resources.pics/fd2.png");
        fdoors[2] = new Picture(430, 236, "resources/org.academiadecodigo.bootcamp.escapeproject.resources.pics/fd3.png");
        fdoors[3] = new Picture(430, 228, "resources/org.academiadecodigo.bootcamp.escapeproject.resources.pics/fd4.png");
        fdoors[4] = new Picture(430, 230, "resources/org.academiadecodigo.bootcamp.escapeproject.resources.pics/fd5.png");
        fdoors[5] = new Picture(430, 230, "resources/org.academiadecodigo.bootcamp.escapeproject.resources.pics/fd6.png");
        fdoors[6] = new Picture(430, 230, "resources/org.academiadecodigo.bootcamp.escapeproject.resources.pics/fd7.png");


        bigMobille.delete();
        smallMobille.delete();

        Thread.sleep(200);

        fdoors[0].draw();

        Thread.sleep(200);

        for (int i = 0; i < fdoors.length - 1; i++) {

            fdoors[i + 1].draw();
            fdoors[i].delete();

            Thread.sleep(200);

        }

        fdoors[fdoors.length - 1].draw();

        this.finished();
    }

    //TODO Suavizar esta sequencia e melhorar imagem final
    //GOD'S appearence
    private void finished() {

        godRui = new Picture(60.0, 60.0, "resources/org.academiadecodigo.bootcamp.escapeproject.resources.pics/godRui.jpg");

        background.delete();

        godRui.draw();

    }



    //Writes on Mobile screen line 1
    //TODO substiruir estes metodos pelos que estao no computador do Francisco
    private void writeln1(int binary) {

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mobileStr1 += binary;
        mobileText1.setText(mobileStr1);
        mobileText1.draw();
    }

    //Writes on Mobile screen line 2
    private void writeln2(int binary) {
        mobileStr2 += binary;
        mobileText2.setText(mobileStr2);
        mobileText2.draw();
    }


    //Writes on Mobile screen line 3
    private void writeln3(int binary) {
        mobileStr3 += binary;
        mobileText3.setText(mobileStr3);
        mobileText3.draw();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

        // System.out.println(e);

    }

}
