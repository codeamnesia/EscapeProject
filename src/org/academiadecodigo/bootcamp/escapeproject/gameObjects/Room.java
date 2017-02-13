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
     * It has an array of Pictures to represent it, one at a time (currentPic).
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
    private Picture currentPic;         //the current picture
    private Rectangle roomPosition;     //it orients the position of the room pictures. It can be all black first.
    private boolean hidden;             //if True, the room will be represented by a black rectangle. If false, one of the org.academiadecodigo.bootcamp.escapeproject.resources.pics.




    public Room(Rectangle roomPosition){
        this.roomPosition = roomPosition;
//        this.roomPics = roomPics;

    }

    public void setCurrentPic(Picture currentPic) {
        this.currentPic = currentPic;
    }

    // TODO: 12/02/17 this method is to be used only when the sprite collides with the room (DON'T FORGET to print the sprite afterwards as well).
    public void printCurrentPic(){
        currentPic.draw();
        hidden = false;         //just to be safe
    }

    public Rectangle getRoomPosition() {
        return roomPosition;
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
    public Picture getPicture(int i){
        return roomPics[i];
    }




}
