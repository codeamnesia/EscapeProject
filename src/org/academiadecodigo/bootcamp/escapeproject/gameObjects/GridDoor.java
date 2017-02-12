package org.academiadecodigo.bootcamp.escapeproject.gameObjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 10/02/17.
 */
public class GridDoor {

    /**
//     * The GridDoor is basically where the doors are in the map.
//     * It's represented by 2 rectangles, both invisible:
//     *  - the true location on the map (which is touchable, between the walls' holes)
//     *  - the hit box, larger, to trigger the prompt of the different scene --> added by Sofi no need for this.
     */


    private Rectangle hitBoxPrompt;     //The hitbox to trigger the questions prompt

    private Rectangle roomDoor;         //Called like this to not make confusion with the class Doors. It's where the door actually is.

    private boolean doorClosed;         //When True, the hitBoxPrompt will trigger the questions prompt and the sprite will be able to collide with the roomDor.

    private boolean locked;             //When True, the door is locked; When false, hide the rectangles, remove the collisions



    public GridDoor(Rectangle roomDoor){
        this.roomDoor = roomDoor;
        hitBoxPrompt = new Rectangle (roomDoor.getX() - 5, roomDoor.getY() - 5, roomDoor.getWidth() + 10, roomDoor.getHeight() + 10);   // changed from 10 to 5
        locked = true;

    }

    public Rectangle getHitBoxPrompt() {
        return hitBoxPrompt;
    }

    public Rectangle getRoomDoor() {
        return roomDoor;
    }

    public boolean isLocked(){
        return locked;
    }

    public boolean isDoorClosed(){
        return doorClosed;
    }
}
