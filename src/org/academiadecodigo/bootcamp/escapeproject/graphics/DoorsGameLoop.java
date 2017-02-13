package org.academiadecodigo.bootcamp.escapeproject.graphics;

import org.academiadecodigo.bootcamp.escapeproject.Scenable;
import org.academiadecodigo.bootcamp.escapeproject.gameObjects.Grelha;
import org.academiadecodigo.bootcamp.escapeproject.gameObjects.KeyboardInput;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by codecadet on 10/02/17.
 */
public class DoorsGameLoop implements  Runnable, Scenable {

    private Doors door;
    private Questions question;
    private boolean caughtAttention;
    private Rectangle scene;
    private Grelha grelha;

    public DoorsGameLoop(KeyboardInput keyboardInput, Grelha grelha) throws InterruptedException {
        door = new Doors();
        question = new Questions();
        this.grelha = grelha;

//        Mouse m = new Mouse(this);
//        m.addEventListener(MouseEventType.MOUSE_CLICKED);
//        m.addEventListener(MouseEventType.MOUSE_MOVED);

        KeyboardInput k = keyboardInput;
        keyboardInput.setDoorsGameLoop(this);
       /* KeyboardEvent event = new KeyboardEvent();
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
        k.addEventListener(event2);*/

    }

    public void test() throws InterruptedException {



        scene = new Rectangle(10.0, 10.0, 900, 900.0);
        scene.setColor(Color.BLACK);
        scene.draw();
    }

    //TODO set para boolean de boneco a bloquear movimento e set para boolean de porta a abrir e fechar


    public void prompt() {
        run();
    }

    @Override
    public void run() {

        grelha.setSceneOff(false);

        System.out.println(Thread.currentThread());

        System.out.println("Aqui!!");

        door.getBackground().draw();
        door.getNumber1Joana().draw();
        door.getNumber2Jorge().draw();
        door.getNumber3Rodolfo().draw();

        caughtAttention = false;

        //Enter cycle of showing random pictures of Padawans
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
                break;
            }



        }
        try {
            Thread.sleep(300);
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }

        closePrompt();
        return;


    }


    public void closePrompt() {
        grelha.setSceneOff(true);
        door.deleteDoors();
        door.getBackground().delete();
        door.deleteNumbers();
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
/*

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_1:
                if (door.getTheOnePayingAttention() != -1 && door.getIsPayingAttention()[0]) {
                    if (!caughtAttention) {
                        door.getPicsPadawan()[door.getTheOnePayingAttention()][3].grow(16.0, 50.0);
                    }
                    caughtAttention = true;

                }
                break;


            case KeyboardEvent.KEY_2:
                if (door.getTheOnePayingAttention() != -1 && door.getIsPayingAttention()[1]) {
                    if (!caughtAttention) {
                        door.getPicsPadawan()[door.getTheOnePayingAttention()][3].grow(20.0, 50.0);
                    }
                    caughtAttention = true;

                }
                break;



            case KeyboardEvent.KEY_3:
                if (door.getTheOnePayingAttention() != -1 && door.getIsPayingAttention()[2]) {
                    if (!caughtAttention) {
                        door.getPicsPadawan()[door.getTheOnePayingAttention()][3].grow(20.0, 50.0);
                    }
                    caughtAttention = true;

                }
                break;


        }
    }
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
*/


    public Doors getDoor() {
        return door;
    }

    public boolean isCaughtAttention() {
        return caughtAttention;
    }

    public void setCaughtAttention(boolean caughtAttention) {
        this.caughtAttention = caughtAttention;
    }


}
