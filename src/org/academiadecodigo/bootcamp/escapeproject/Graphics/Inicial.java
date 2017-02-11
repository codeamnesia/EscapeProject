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
 * Created by codecadet on 11/02/17.
 */
public class Inicial implements MouseHandler, Scenable {

    private Picture inicial1;
    private Picture inicial2;
    private Picture inicial3;
    private Picture inicial4;
    private Picture inicial5;
    private Picture inicial6;
    private Picture inicial7;
    private Picture inicial8;
    private Picture inicial9;
    private Picture first;

    private Rectangle start;
    private boolean isStartPressed;


    @Override
    public void prompt() throws InterruptedException {

        Mouse m = new Mouse(this);
        m.addEventListener(MouseEventType.MOUSE_CLICKED);
        m.addEventListener(MouseEventType.MOUSE_MOVED);

        inicial1 = new Picture(10, 10, "resources/pics/9.jpg");
        inicial2 = new Picture(10, 10, "resources/pics/8.jpg");
        inicial3 = new Picture(10, 10, "resources/pics/7.jpg");
        inicial4 = new Picture(10, 10, "resources/pics/6.jpg");
        inicial5 = new Picture(10, 10, "resources/pics/5.jpg");
        inicial6 = new Picture(10, 10, "resources/pics/4.jpg");
        inicial7 = new Picture(10, 10, "resources/pics/3.jpg");
        inicial8 = new Picture(10, 10, "resources/pics/2.jpg");
        inicial9 = new Picture(10, 10, "resources/pics/1.jpg");
        first = new Picture(10, 10, "resources/pics/first.jpg");
        start = new Rectangle(670, 205, 100, 100);

        first.draw();
        start.setColor(Color.YELLOW);
        start.draw();

        while (!isStartPressed) {
            Thread.sleep(20);
        }
        this.start();
    }

    private void start() throws InterruptedException {

        inicial1.draw();


        Thread.sleep(1500);

        inicial1.delete();
        inicial2.draw();


        Thread.sleep(800);

        inicial2.delete();
        inicial3.draw();


        Thread.sleep(800);

        inicial3.delete();
        inicial4.draw();


        Thread.sleep(800);

        inicial4.delete();
        inicial5.draw();


        Thread.sleep(800);

        inicial5.delete();
        inicial6.draw();


        Thread.sleep(800);

        inicial6.delete();
        inicial7.draw();


        Thread.sleep(800);

        inicial7.delete();
        inicial8.draw();


        Thread.sleep(800);

        inicial8.delete();
        inicial9.draw();

        Thread.sleep(800);


    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (DoorsUtil.isWithin(e, start)) {
            System.out.println(e);
            isStartPressed = true;
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println(e);

    }


}