package org.academiadecodigo.bootcamp.escapeproject.Graphics;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

import static org.academiadecodigo.bootcamp.escapeproject.Graphics.Doors.MAX_NUMBER_OF_CLICKS;

/**
 * Created by codecadet on 10/02/17.
 */
public class DoorsGameLoop implements /*MouseHandler*/ KeyboardHandler, Runnable {

    private Doors door;
    private Questions question;
    private int clickCounter;
    private boolean caughtAttention;
    private Rectangle scene;

    public DoorsGameLoop() throws InterruptedException {
        door = new Doors();
        question = new Questions();

//        Mouse m = new Mouse(this);
//        m.addEventListener(MouseEventType.MOUSE_CLICKED);
//        m.addEventListener(MouseEventType.MOUSE_MOVED);

        Keyboard k = new Keyboard(this);
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_1);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);

        KeyboardEvent event1 = new KeyboardEvent();
        event1.setKey(KeyboardEvent.KEY_2);
        event1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event1);

        KeyboardEvent event2 = new KeyboardEvent();
        event2.setKey(KeyboardEvent.KEY_3);
        event2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event2);

    }

    public void test() throws InterruptedException {



        scene = new Rectangle(10.0, 10.0, 900, 900.0);
        scene.setColor(Color.BLACK);
        scene.draw();
    }

    //TODO set para boolean de boneco a bloquear movimento e set para boolean de porta a abrir e fechar

    //TODO ver se falta aqui um prompt

    public void run() {

        clickCounter = 0;
        caughtAttention = false;



        while(true) {

            door.deletePadPictures();

            door.randomizeCharacters();

            try {
                Thread.sleep(DoorsUtil.randomTime());
            } catch (Exception e) {
                e.printStackTrace();
            }


            if (caughtAttention) {

                try {
                    question.start(door);
                } catch(Exception e) {
                    e.printStackTrace();
                }


                //this.openDoor();
                break;
            }

            /*if (clickCounter >= MAX_NUMBER_OF_CLICKS) {
                door.looseChance();
                break;
            }*/

        }
        try {
            Thread.sleep(300);
        } catch (Exception e) {
            e.printStackTrace();
        }

        closePrompt();
        return;


    }

    //TODo apagar quadrado quando resposta correcta e acrescentar return nos metodos void!

    public void closePrompt() {
        door.deleteDoors();
        door.getBackground().delete();
        question.deleteEverything();
        door.resetIsPayingAttention();
        return;
    }

    /*@Override
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

    }*/

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_1:
                if (door.getTheOnePayingAttention() != -1 && door.getIsPayingAttention()[0]) {
                    if (!caughtAttention) {
                        door.getPicsPadawan()[door.getTheOnePayingAttention()][3].grow(20.0, 50.0);
                    }
                    caughtAttention = true;

                }


            case KeyboardEvent.KEY_2:
                if (door.getTheOnePayingAttention() != -1 && door.getIsPayingAttention()[1]) {
                    if (!caughtAttention) {
                        door.getPicsPadawan()[door.getTheOnePayingAttention()][3].grow(20.0, 50.0);
                    }
                    caughtAttention = true;

                }



            case KeyboardEvent.KEY_3:
                if (door.getTheOnePayingAttention() != -1 && door.getIsPayingAttention()[2]) {
                    if (!caughtAttention) {
                        door.getPicsPadawan()[door.getTheOnePayingAttention()][3].grow(20.0, 50.0);
                    }
                    caughtAttention = true;

                }


        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
