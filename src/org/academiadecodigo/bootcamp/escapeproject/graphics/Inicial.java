package org.academiadecodigo.bootcamp.escapeproject.graphics;

import org.academiadecodigo.bootcamp.escapeproject.Scenable;
import org.academiadecodigo.bootcamp.escapeproject.gameObjects.Grelha;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


/**
 * Created by codecadet on 11/02/17.
 */
public class Inicial implements MouseHandler, Scenable {

    private Picture[] inicialSeq;

    private Picture first;

    private Rectangle startRect;
    private boolean isStartPressed;
    private Rectangle sleepRect;
    private boolean isSleepRectPressed;

    private DoorsGameLoop doorsGameLoop;


    @Override
    public void prompt() throws InterruptedException {

        Mouse m = new Mouse(this);
        m.addEventListener(MouseEventType.MOUSE_CLICKED);
        m.addEventListener(MouseEventType.MOUSE_MOVED);

        inicialSeq = new Picture[9];

        inicialSeq[0] = new Picture(10, 10, "resources/pics/9.jpg");
        inicialSeq[1] = new Picture(10, 10, "resources/pics/8.jpg");
        inicialSeq[2] = new Picture(10, 10, "resources/pics/7.jpg");
        inicialSeq[3] = new Picture(10, 10, "resources/pics/6.jpg");
        inicialSeq[4] = new Picture(10, 10, "resources/pics/5.jpg");
        inicialSeq[5] = new Picture(10, 10, "resources/pics/4.jpg");
        inicialSeq[6] = new Picture(10, 10, "resources/pics/3.jpg");
        inicialSeq[7] = new Picture(10, 10, "resources/pics/2.jpg");
        inicialSeq[8] = new Picture(10, 10, "resources/pics/1.jpg");
        first = new Picture(10, 10, "resources/pics/first.jpg");
        startRect = new Rectangle(660, 205, 130, 100);
        sleepRect = new Rectangle (680, 450, 130, 100);

        first.draw();
        startRect.setColor(Color.YELLOW);
        //startRect.draw();

        sleepRect.setColor(Color.YELLOW);
        //sleepRect.draw();

        enterCycle();

    }

    //TODO por ZZZZZZZ a funcionar no Blumel

    private void enterCycle() throws InterruptedException {
        while (true) {
            Thread.sleep(20);
            if (isStartPressed) {
                this.start();
                return;
            }
            if (isSleepRectPressed) {
                this.initDoorLoopTester();
                return;
            }
        }
    }

    private void initDoorLoopTester() throws InterruptedException {
        //doorsGameLoop = new DoorsGameLoop();
        //doorsGameLoop.prompt();
        isSleepRectPressed = false;
        enterCycle();
        return;
    }


    private void start() throws InterruptedException {

        inicialSeq[0].draw();


        Thread.sleep(1500);

        for (int i = 0; i < inicialSeq.length - 1; i++) {
            inicialSeq[i].delete();
            inicialSeq[i + 1].draw();

            Thread.sleep(800);
        }

        Grelha mygrid = new Grelha();

        mygrid.init();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (DoorsUtil.isWithin(e, startRect)) {
            System.out.println();
            isStartPressed = true;
        }

        if (DoorsUtil.isWithin(e, sleepRect)) {
           isSleepRectPressed = true;
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //System.out.println(e);

    }


}