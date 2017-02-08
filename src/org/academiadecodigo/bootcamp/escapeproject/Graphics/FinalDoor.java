package org.academiadecodigo.bootcamp.escapeproject.Graphics;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
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
    private Picture background;
    private Picture smallMobille;
    private Picture bigMobille;


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

        this.start();

    }

    public void start() {

        smallMobille = new Picture(586.0, 503.0, "resources/pics/mbsmall.png");
        smallMobille.draw();

        bigMobille = new Picture(270.0, 80.0, "resources/pics/mobile.png");
        bigMobille.draw();


    }

    @Override
    public void mouseClicked(MouseEvent e){
        System.out.println(e);

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println(e);

    }

}
