package org.academiadecodigo.bootcamp.escapeproject.gameObjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 10/02/17.
 */
public class Room {

    /**
     * The Room is the only space in the grid where the org.academiadecodigo.bootcamp.escapeproject.resources.Sprite can walk.
     *
     * It has an array of Pictures to represent it, one at a time (current).
     * This picture:
     * - is above the walls
     * - is below the sprite
     *
     * It has a rectangle to orient the position of the picture.
     *
     */
    // private int roomNumber;             //There are 9 rooms, numbered from 0 to 8;
//    private org.academiadecodigo.bootcamp.escapeproject.resources.Sprite sprite;              //the room knows if it has the sprite in it or not
    private Picture[] roomPics;
    private Picture current;
    private Rectangle roomPosition;     //it orients the position of the room pictures. It can be all black first.
    private boolean hidden;             //if True, the room will be represented by a black rectangle. If false, one of the org.academiadecodigo.bootcamp.escapeproject.resources.pics.

    public Rectangle getRoomPosition() {
        return roomPosition;
    }

    public Room(Rectangle roomPosition){
        this.roomPosition = roomPosition;
//        this.roomPics = roomPics;
        current = new Picture();

    }

    public void setRoomPics(Picture[] roomPics) {
        this.roomPics = roomPics;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    //changes the room Picture to the one desired within the array;
    //TODO might need adjustments cos the pictures must be in the right position and with the right size


    public Picture getPicture(int i){
        return roomPics[i];
    }

    public void setPicture(Picture pic){

    }


    public void changePic (Picture pic ){
        hidden = false;
        double x = pic.getX();
        double y = pic.getY();

        if (current == null){
            pic.translate(roomPosition.getX()-x,roomPosition.getY()-y);     //move the ???
            current = pic;
            current.draw();
        } else {
            current.delete();
            pic.translate(roomPosition.getX()-x,roomPosition.getY()-y);
            current = pic;
            current.draw();

        }


    }



}
