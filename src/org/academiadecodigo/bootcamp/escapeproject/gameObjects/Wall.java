package org.academiadecodigo.bootcamp.escapeproject.gameObjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 10/02/17.
 */
public class Wall {
    /**
     * The Walls are rectangles that will be invisible but touchable by the sprite.
     */


    private Rectangle rectangle;
//    private String name;


    public Rectangle getRectangle() {
        return rectangle;
    }

    public Wall(Rectangle rectangle){

        this.rectangle = rectangle;
//        this.name = rectangle.toString();

    }



}
