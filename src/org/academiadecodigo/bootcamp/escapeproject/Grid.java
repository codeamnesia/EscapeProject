package org.academiadecodigo.bootcamp.escapeproject;

/**
 * Created by Renato on 03/02/17.
 */
public class Grid implements Representable {

    private int width;
    private int height;

    //Grid Construtor (it will depend on Library)

    public Grid(int width, int height) {
       width = this.width;
       height =  this.height;

    }

    //Getters to total size of the grid (can help to position the player on the grid)

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void init(){

        //Creates new grid
        Grid grid = new Grid();

        //grid.   depends on the library and the method to show on the screen

        //TODO: CLASS PLAYERS
        //Creates one Player and sets his position on the grid
        Player player = new Player;
        player.getPosition;

        //TODO: CLASS OBJECTS
        //Creates objects and places them on the grid to be used later
        //Object object = new Object;
        //Object.getPosition;

    }

    //TODO: NOT SURE IF THIS IS SUPPOSED TO BE HERE OR IN GAME CLASS!!!!!
    //Method that checks if the player is at the limit of the grid

    public void openDoor(){

        //Checks if the player is at the middle of the border
     if (player.getPosition == (width/2)){

         //Changes the cenario
         Object object = new Object;

     }


    }


}
