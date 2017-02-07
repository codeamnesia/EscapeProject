package org.academiadecodigo.bootcamp.escapeproject.Character;

import org.academiadecodigo.bootcamp.escapeproject.Game.Grid;
import org.academiadecodigo.bootcamp.escapeproject.Game.GridPosition;

/**
 * Created by codecadet on 06/02/17.
 */
public class CollisionDetector {

    private Sprite sprite;
    private Grid grid;
    private boolean collided;

        public CollisionDetector(Sprite sprite){
            this.sprite = sprite;
        }






    public void inDoor(Sprite sprite){
        if(sprite.getPos().equals(door.getPos)){
            collided = true;
        }

//TODO Make a collision detector
        /**
         * Checks for collisions with specific car
         * Requires iterating the array once
         * @param sprite
         */
        public void check(Sprite sprite) {

            for (Sprite sprite1: sprite) {

                // No point in checking collisions with self
                if (ic == car) {
                    continue;
                }

                if (ic.getPos().equals(car.getPos())) {
                    ic.crash();
                    car.crash();
                }
            }

        }

    }
}
