package org.academiadecodigo.bootcamp.escapeproject.Game;

import org.academiadecodigo.bootcamp.escapeproject.CollisionDetector;
import org.academiadecodigo.bootcamp.escapeproject.Game.gameObjects.Sprite;
import org.academiadecodigo.bootcamp.escapeproject.Game.gameObjects.Room;

/**
 * Created by codecadet on 05/02/17.
 */
public class Grid {


    private Room room;
    private int width;
    private int height;
    private Sprite sprite;
    private CollisionDetector collisionDetector;





    Grid(int height, int width){
        this.height = height;
        this.width = width;
        sprite = new Sprite();



    }



    public void init() {



    }


    public int getHeigth(){
        return height;
    }



    public void openScreen(){
        if (sprite.isDoor){
            ;
        }
    }



}
