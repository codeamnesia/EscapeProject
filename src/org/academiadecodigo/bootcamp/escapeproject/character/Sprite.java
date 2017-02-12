//package org.academiadecodigo.bootcamp.escapeproject.Character;
//
//
//import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
//import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
//import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
//import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
//
///**
// * Created by codecadet on 05/02/17.
// */
//
////I had to call it Player because character is reserved in Java, also Luis made the sprite movements Sofia is going to make the actual sprite
//
//
//
//
//public class Sprite implements KeyboardHandler {
//
//    private Keyboard keyboard;
//    private Position pos;
//    public boolean isDoor;
//
//
//    public void move(Keyboard keyboard) {
//        this.keyboard = new Keyboard;
//        pos = new Position();
//
//
//
//
//        KeyboardEvent event = new KeyboardEvent;
//        KeyboardEvent event1 = new KeyboardEvent;
//        KeyboardEvent event2 = new KeyboardEvent;
//        KeyboardEvent event3 = new KeyboardEvent;
//
//        event.setKey(KeyboardEvent.KEY_UP);
//        event1.setKey(KeyboardEvent.KEY_DOWN);
//        event2.setKey(KeyboardEvent.KEY_LEFT;
//        event3.setKey(KeyboardEvent.KEY_RIGHT);
//
//
//        keyboard.addEventListener(event);
//        keyboard.addEventListener(event1);
//        keyboard.addEventListener(event2);
//        keyboard.addEventListener(event3);
//
//    }
//
//
//    @Override
//    public void keyPressed(KeyboardEvent e) {
//        switch(e.getKey()){
//
//           /*
//           case KeyboardEvent.KEY_UP:
//                .translate(0, -100);
//                break;
//
//            case KeyboardEvent.KEY_DOWN:
//                pic.translate(0, 100);
//                break;
//
//            case KeyboardEvent.KEY_LEFT:
//                pic.translate(-50, 0);
//                break;
//
//            case KeyboardEvent.KEY_RIGHT:
//                pic.translate(50, 0);
//                break;
//
//*/
//        }
//
//
//
//
//    @Override
//    public void keyReleased(KeyboardEvent keyboardEvent) {
//
//    }
//
//    public void collision(){
//        if(pos.equals())
//    }
//    public Position getPos(){
//        return pos;
//    }
//
//
//
//}
