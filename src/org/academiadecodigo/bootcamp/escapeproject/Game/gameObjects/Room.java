package org.academiadecodigo.bootcamp.escapeproject.Game.gameObjects;

import org.academiadecodigo.bootcamp.escapeproject.CollisionDetector;
import org.academiadecodigo.bootcamp.escapeproject.Game.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
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
     * It has a rectangle to orient the position of the picture.
     *
     */
    //private int roomNumber;             //There are 9 rooms, numbered from 0 to 8;
    private Sprite sprite;              //the room knows if it has the sprite in it or not
    private Picture[] roomPics;
    private Picture current;
    private Rectangle roomPosition;     //it orients the position of the room pictures. It can be all black first.
    private boolean hidden;             //if True, the room will be represented by a black rectangle. If false, one of the pics.

    public Room(Rectangle roomPosition){
        this.roomPosition = roomPosition;

    }

    //changes the room Picture to the one desired within the array;
    //TODO might need adjustments cos the pictures must be in the right position and with the right size


    public Picture changePic (){

        current = roomPics[arrPos];
        return current;

    }



}
