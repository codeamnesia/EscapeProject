package org.academiadecodigo.bootcamp.escapeproject.Game.gameObjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 10/02/17.
 */
public class Room {

    /**
     * The Room is the only space in the grid where the Sprite can walk.
     *
     * It has an array of Pictures to represent it, one at a time (current).
     * This picture:
     * - is above the walls
     * - is below the sprite
     *
     */


    private Picture[] roomPics;
    private Picture current;

    public Room(Picture [] roomPics){

        this.roomPics = roomPics;
        current = roomPics[0];

    }



    //changes the room Picture to the one desired within the array;
    //TODO might need adjustments cos the pictures must be in the right position and with the right size
    public Picture changePic (int arrPos){

        current = roomPics[arrPos];
        return current;

    }



}
