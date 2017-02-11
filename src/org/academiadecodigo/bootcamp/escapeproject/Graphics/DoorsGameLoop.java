package org.academiadecodigo.bootcamp.escapeproject.Graphics;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

import static org.academiadecodigo.bootcamp.escapeproject.Graphics.Doors.MAX_NUMBER_OF_CLICKS;

/**
 * Created by codecadet on 10/02/17.
 */
public class DoorsGameLoop implements MouseHandler {

    private Doors door;
    private Questions question;
    private int clickCounter;
    private boolean caughtAttention;
    private Rectangle scene;

    public DoorsGameLoop() throws InterruptedException {
        door = new Doors();
        question = new Questions();

        Mouse m = new Mouse(this);
        m.addEventListener(MouseEventType.MOUSE_CLICKED);
        m.addEventListener(MouseEventType.MOUSE_MOVED);
        scene = new Rectangle(10.0, 10.0, 900, 900.0);
        scene.setColor(Color.BLACK);
        scene.draw();
    }


    public void start() throws InterruptedException{

        clickCounter = 0;
        caughtAttention = false;



        while(true) {

            door.deletePadPictures();

            door.randomizeCharacters();

            Thread.sleep(DoorsUtil.randomTime());

            if (caughtAttention) {

                question.start(door);

                //this.openDoor();
                break;
                //TODO sir dos whioles com retun;
            }

            /*if (clickCounter >= MAX_NUMBER_OF_CLICKS) {
                door.looseChance();
                break;
            }*/

        }

        Thread.sleep(300);
        closePrompt();
        return;


    }

    //TODo apagar quadrado quando resposta correcta e acrescentar return nos metodos void!

    public void closePrompt() {
        door.deleteDoors();
        door.getBackground().delete();
        question.deleteEverything();

    }

    @Override
    public void mouseClicked(MouseEvent e){

        if (door.getTheOnePayingAttention() != -1 && DoorsUtil.isWithin(e,
                door.getPicsPadawan()[door.getTheOnePayingAttention()][3])
                && door.getIsPayingAttention()[door.getTheOnePayingAttention()]) {
            if (!caughtAttention) {
                door.getPicsPadawan()[door.getTheOnePayingAttention()][3].grow(20.0, 50.0);
            }
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
