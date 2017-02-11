package org.academiadecodigo.bootcamp.escapeproject.Game.gameObjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 10/02/17.
 */
public class ScenePrompt {

    /**
     * The ScenePrompt is basically where the doors are in the map.
     * It's represented by 2 rectangles, both invisible:
     *  - the true location on the map (which is touchable, between the walls' holes)
     *  - the hit box, larger, to trigger the prompt of the different scene
     */




    private Rectangle hitBoxPrompt;     //The hitbox to trigger the questions prompt

    private Rectangle roomDoor;         //Called like this to not make confusion with the class Doors. It's where the door actually is.

    private boolean doorClosed;         //When True, the hitBoxPrompt will trigger the questions prompt and the sprite will be ablt to collide with the roomDor.

    private boolean locked;             //When True, the door is locked; When false, hide the rectangles, remove the collisions

    public ScenePrompt(Rectangle roomDoor){
        this.roomDoor = roomDoor;
        hitBoxPrompt = new Rectangle (roomDoor.getX() - 10, roomDoor.getY() - 10, roomDoor.getWidth() + 10, roomDoor.getHeight() + 10);



    }

    public Rectangle getHitBoxPrompt() {
        return hitBoxPrompt;
    }

    public Rectangle getRoomDoor() {
        return roomDoor;
    }



}
