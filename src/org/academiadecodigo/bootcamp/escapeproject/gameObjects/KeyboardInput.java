package org.academiadecodigo.bootcamp.escapeproject.gameObjects;

import org.academiadecodigo.bootcamp.escapeproject.graphics.DoorsGameLoop;
import org.academiadecodigo.bootcamp.escapeproject.position.Direction;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;



/**
 * Created by codecadet on 11/02/17.
 */
public class KeyboardInput implements KeyboardHandler{


    private int steps;//number of moves made so far. it's reset when a door is found
//    private int mov = 10;
    private Grelha grid;
    private DoorsGameLoop doorsGameLoop;


    public KeyboardInput(Grelha grid, DoorsGameLoop doorsGameLoop) {
        //this.doorsGameLoop = doorsGameLoop;
        this.grid=grid;
        start ();
    }



public void start(){




    Keyboard k = new Keyboard(this);               //TODO carregar no espaço para interagir com objecto (portas, computador sala secreta)
//    KeyboardEvent event = new KeyboardEvent();
    KeyboardEvent up = new KeyboardEvent();
    KeyboardEvent down = new KeyboardEvent();
    KeyboardEvent left = new KeyboardEvent();
    KeyboardEvent right = new KeyboardEvent();
//    event.setKey(KeyboardEvent.KEY_SPACE);



    up.setKey(KeyboardEvent.KEY_UP);
    down.setKey(KeyboardEvent.KEY_DOWN);
    left.setKey(KeyboardEvent.KEY_LEFT);
    right.setKey(KeyboardEvent.KEY_RIGHT);



    up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
    down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
    left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
    right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

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


    event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
    k.addEventListener(event);



    k.addEventListener(up);
    k.addEventListener(down);
    k.addEventListener(left);
    k.addEventListener(right);

}


    @Override
    public void keyPressed(KeyboardEvent e) {
        switch (e.getKey()) {
            case KeyboardEvent.KEY_UP:
                grid.move(Direction.UP);
                if(grid.isItTimeToPrompt(Direction.UP)){
                    //arrancar aqui o prompt.
                }
                break;
            case KeyboardEvent.KEY_DOWN:
                grid.move(Direction.DOWN);
                if(grid.isItTimeToPrompt(Direction.DOWN)) {
                    //arrancar aqui o prompt.
                }
                break;
            case KeyboardEvent.KEY_LEFT:
                grid.move(Direction.LEFT);
                if(grid.isItTimeToPrompt(Direction.LEFT)) {
                    System.out.println("Prompt here");
                    //arrancar aqui o prompt.
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                grid.move(Direction.RIGHT);
                if(grid.isItTimeToPrompt(Direction.RIGHT)) {
                    //arrancar aqui o prompt.
                }
                break;
            case KeyboardEvent.KEY_1:
                if (doorsGameLoop.getDoor().getTheOnePayingAttention() != -1 && doorsGameLoop.getDoor().getIsPayingAttention()[0]) {
                    if (!doorsGameLoop.isCaughtAttention()) {
                        doorsGameLoop.getDoor().getPicsPadawan()[doorsGameLoop.getDoor().getTheOnePayingAttention()][3].grow(16.0, 50.0);
                    }
                    doorsGameLoop.setCaughtAttention(true);

                }
                break;


            case KeyboardEvent.KEY_2:
                if (doorsGameLoop.getDoor().getTheOnePayingAttention() != -1 && doorsGameLoop.getDoor().getIsPayingAttention()[1]) {
                    if (!doorsGameLoop.isCaughtAttention()) {
                        doorsGameLoop.getDoor().getPicsPadawan()[doorsGameLoop.getDoor().getTheOnePayingAttention()][3].grow(16.0, 50.0);
                    }
                    doorsGameLoop.setCaughtAttention(true);

                }
                break;



            case KeyboardEvent.KEY_3:
                if (doorsGameLoop.getDoor().getTheOnePayingAttention() != -1 && doorsGameLoop.getDoor().getIsPayingAttention()[2]) {
                    if (!doorsGameLoop.isCaughtAttention()) {
                        doorsGameLoop.getDoor().getPicsPadawan()[doorsGameLoop.getDoor().getTheOnePayingAttention()][3].grow(16.0, 50.0);
                    }
                    doorsGameLoop.setCaughtAttention(true);

                }
                break;
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void setDoorsGameLoop(DoorsGameLoop doorsGameLoop) {
        this.doorsGameLoop = doorsGameLoop;
    }
}
