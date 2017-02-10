package org.academiadecodigo.bootcamp.escapeproject;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;

/**
 * Created by codecadet on 06/02/17.
 */
public class CollisionDetector {


    /**


     tX - - - - - - - tW
     |               |
     |               |
     |       t       |
     |               |
     |               |
     tY - - - - - - - tH




     */

    public static boolean intersects (Shape t, double x, double y){

        double tx = t.getX();
        double ty = t.getY();
        double tw = t.getWidth() + tx;
        double th = t.getHeight() + ty;


        if ((  (x>=tx && x<=tw) && (y>=ty && y<=th) )){

            return true;
        }

        return false;

    }





    public static boolean intersects(Shape[] r, double x, double y) {
        for (Shape shape : r) {
            if (intersects(shape, x, y)) {
                if(shape instanceof Rectangle){
                    ((Rectangle)shape).setColor(Color.MAGENTA);
                    ((Rectangle)shape).fill();
                }

                return true;
            }
            if(shape instanceof Rectangle) {
                ((Rectangle) shape).setColor(Color.LIGHT_GRAY);
                ((Rectangle) shape).fill();
            }
        }
        return false;
    }



}