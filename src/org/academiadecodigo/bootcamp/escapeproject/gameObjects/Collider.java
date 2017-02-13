package org.academiadecodigo.bootcamp.escapeproject.gameObjects;


import org.academiadecodigo.bootcamp.escapeproject.gameObjects.Wall;
import org.academiadecodigo.bootcamp.escapeproject.graphics.Doors;
import org.academiadecodigo.bootcamp.escapeproject.position.Direction;
import org.academiadecodigo.simplegraphics.graphics.Shape;

/**
 * Created by codecadet on 08/02/17.
 */
public class Collider {



    public Collider() {

    }

    /**
     * tX - - tW- -
     * |           |
     * |    T      |
     * |           |
     * tY - - tH- -
     * <p>
     * rX - - - rW- - -
     * |               |
     * |               |
     * |       R       |
     * |               |
     * |               |
     * rY - - - rH- - -
     */


    public boolean intersects(Shape t, Shape r, Direction direction, int mov) { //for the case when you will move
        double tw = t.getWidth();
        double th = t.getHeight();
        double rw = r.getWidth();
        double rh = r.getHeight();
        if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
            return false;
        }
        double tx = t.getX();
        double ty = t.getY();
        tw += tx;
        th += ty;

        double rx=0, ry=0;
        switch (direction){
            case UP:
                rx = r.getX();
                ry = r.getY()-mov;
                break;
            case DOWN:
                rx = r.getX();
                ry = r.getY()+mov;
                break;
            case LEFT:
                rx = r.getX()-mov;
                ry = r.getY();
                break;
            case RIGHT:
                rx = r.getX()+mov;
                ry = r.getY();
                break;
        }

        rw += rx;
        rh += ry;

        //      overflow || intersect
        return (rx>=tx && rx<=tw && ry>=ty && ry<=th) ||        //tx < rx < tw  &&  ty < ry < th
                (rw>=tx && rw<=tw && ry>=ty && ry<=th) ||       //tx < rw < tw  &&  ty < ry < th
                (rx>=tx && rx<=tw && rh>=ty && rh<=th) ||       //tx < rx < tw  &&  ty < rh < th
                (rw>=tx && rw<=tw && rh>=ty && rh<=th);         //tx < rw < tw  &&  ty < rh < th
    }

    public boolean intersectsWall (Wall[] walls, Shape r, Direction direction, int mov) {
        for (Wall wall : walls) {
            if (intersects(wall.getRectangle(),r,direction,mov)) {
                return true;
            }
        }
        return false;
    }

    public boolean intersectsRoom (Room[] rooms, Shape r, Direction direction, int mov) {
        for (Room room : rooms) {
            if (intersects(room.getRoomPosition(),r,direction,mov)) {
                return true;
            }
        }
        return false;
    }

    public boolean intersectsDoorsHitbox (GridDoor[] doors, Shape r, Direction direction, int mov) {
        for (GridDoor door : doors) {
            if (intersects(door.getHitBoxPrompt(),r,direction,mov)) {
                return true;
            }
        }
        return false;
    }

    public boolean intersectsDoors (GridDoor[] doors, Shape r, Direction direction, int mov) {
        for (GridDoor door : doors) {
            if (intersects(door.getRoomDoor(),r,direction,mov)) {
                return true;
            }
        }
        return false;
    }


    /**
     * tX - - - - - tW
     * |           |
     * |     T     |
     * |           |
     * tY - - - - - tH
     * <p>
     * rX - - - - - - - rW
     * |               |
     * |               |
     * |       R       |
     * |               |
     * |               |
     * rY - - - - - - - rH
     */

    public boolean intersects(Shape t, Shape r) { //for the case when you don't have to move. for instance, when you just want to check if you're in an hitpoint
        double tw = t.getWidth();
        double th = t.getHeight();
        double rw = r.getWidth();
        double rh = r.getHeight();
        if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
            return false;
        }
        double tx = t.getX();
        double ty = t.getY();
        tw += tx;
        th += ty;

        double rx=r.getX();
        double ry=r.getY();
        rw += rx;
        rh += ry;

        //      overflow || intersect
        return (rx>=tx && rx<=tw && ry>=ty && ry<=th) ||        //tx < rx < tw  &&  ty < ry < th
                (rw>=tx && rw<=tw && ry>=ty && ry<=th) ||       //tx < rw < tw  &&  ty < ry < th
                (rx>=tx && rx<=tw && rh>=ty && rh<=th) ||       //tx < rx < tw  &&  ty < rh < th
                (rw>=tx && rw<=tw && rh>=ty && rh<=th);         //tx < rw < tw  &&  ty < rh < th
    }


    public boolean intersects(GridDoor[] doors, Shape r, Direction direction, int mov) {
        for (GridDoor door : doors) {
            if (intersects(door.getRoomDoor(),r,direction,mov)) {
                return true;
            }
        }
        return false;
    }


}
