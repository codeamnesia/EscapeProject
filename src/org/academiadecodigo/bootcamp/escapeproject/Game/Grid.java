package org.academiadecodigo.bootcamp.escapeproject.Game;

import org.academiadecodigo.bootcamp.escapeproject.CollisionDetector;
import org.academiadecodigo.bootcamp.escapeproject.Game.gameObjects.ScenePrompt;
import org.academiadecodigo.bootcamp.escapeproject.Game.gameObjects.Sprite;
import org.academiadecodigo.bootcamp.escapeproject.Game.gameObjects.Room;
import org.academiadecodigo.bootcamp.escapeproject.Game.gameObjects.Wall;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 05/02/17.
 */
public class Grid {

    private Rectangle theMap;       //the bigger rectangle
    private static int PADDING = 10;
    private Room[] rooms;          //each Room has an array of Pictures on it. Their size must be adjusted first (growth method?) and their position set from the beginning .
    private Wall[] walls;          //the group of walls;
    private ScenePrompt[] doors;   //the group of doors;
    private Sprite sprite;
    private Picture[] spritePictures;
    private CollisionDetector collisionDetector;

    public static int getPADDING() {
        return PADDING;
    }

    /**
     *        0      300     600     900
     *     0 -|-------|-------|-------|-
     *       _|_     _|_      |       |
     *       _E_     ___      |       |
     *        |       |       |       |
     *   300 -|--|J|--|--| |--|--| |--|-
     *        |      _|_     _|_      |
     *        |      ___     ___      |
     *        |       |       |       |
     *   600 -|-------|--| |--|-------|-
     *        |      _|_     _|_      |
     *        |      ___     ___      |
     *        |       |       |       |
     *   900 -|-------|-------|-------|-
     */
    public void init() {

        theMap = new Rectangle(PADDING, PADDING, 900, 900);

        walls = new Wall[17];           //17 walls
        defineWalls();

        doors = new ScenePrompt[11];    //11 doors
        defineDoors();

        rooms = new Room[9];            //9 rooms
        defineRooms();


    //todo: sprite pictures spritePictures = {the 4 pictures};
        sprite = new Sprite(spritePictures, 10);

    }

    private void defineRooms() {
        for (int i = PADDING; i < (900 - PADDING); i += 300) {
            for (int j = PADDING; j < (900 - PADDING); j += 300) {

                Rectangle roomRec = new Rectangle(i, j, 300, 300);
                roomRec.setColor(Color.BLACK);
                roomRec.fill();
                rooms[i] = new Room(roomRec);


            }
        }


    }


    //auxilairy method to put all the Doors into its array
    private void defineDoors() {

    //11 doors
    //VERTICAL DOORS
        Rectangle EXIT = new Rectangle(PADDING + 25,100 + 25 + PADDING, 50, 100);   //The exit door
        //group 1, the left
        Rectangle V1D1 = new Rectangle(275 + PADDING, PADDING + 100, 50, 100);
        Rectangle V1D2 = new Rectangle(275 + PADDING, PADDING + 400, 50, 100);
        Rectangle V1D3 = new Rectangle(275 + PADDING, PADDING + 700, 50, 100);

        //group 2, the right
            //Rectangle V2D1 = new Rectangle(575 + PADDING, PADDING + 100, 50, 100);    //not used
        Rectangle V2D2 = new Rectangle(575 + PADDING, PADDING + 400, 50, 100);
        Rectangle V2D3 = new Rectangle(575 + PADDING, PADDING + 700, 50, 100);

    //HORIZONTAL DOORS

        //group 1, the top
        Rectangle JOKE = new Rectangle(PADDING + 100, PADDING + 275, 100, 50);  //The Fake door (i = 6 in the array)
        Rectangle H1D2 = new Rectangle(400 + PADDING, PADDING + 275, 100, 50);
        Rectangle H1D3 = new Rectangle(700 + PADDING, PADDING + 275, 100, 50);

        //group 2, the bottom
        Rectangle H2 = new Rectangle(PADDING, 575 + PADDING, 400, 50);
        Rectangle H2a = new Rectangle(PADDING + 500, 575 + PADDING, 400, 50);

    Rectangle[] doorsrec = {EXIT, V1D1,V1D2,V1D3,V2D2,V2D3,JOKE,H1D2,H1D3,H2,H2a};
        for (int i = 0; i <doorsrec.length; i++) {
            doorsrec[i].setColor(Color.BLUE);
            doorsrec[i].fill();
            doors[i] = new ScenePrompt(doorsrec[i]);
        }

    }


    //auxiliary method to put all the walls into its array
    private void defineWalls() {

    //(17 walls, 4 groups)
    //VERTICAL WALLS

        //group 0, the leftmost
        Rectangle V0 = new Rectangle(PADDING, PADDING, 25, 900);

        //group 1
        Rectangle V1a1 = new Rectangle(275 + PADDING, PADDING, 50, 100);
        Rectangle V1a2 = new Rectangle(275 + PADDING, PADDING + 200, 50, 200);
        Rectangle V1b1 = new Rectangle(275 + PADDING, PADDING + 500, 50, 200);
        Rectangle V1b2 = new Rectangle(275 + PADDING, PADDING + 800, 50, 100);

        //group 2
        Rectangle V2a = new Rectangle(575 + PADDING, PADDING, 50, 400);
        Rectangle V2b = new Rectangle(575 + PADDING, PADDING + 500, 50, 200);
        Rectangle V2c = new Rectangle(575 + PADDING, PADDING + 800, 50, 100);

        //group 3, the rightmost
        Rectangle V3 = new Rectangle(875 + PADDING, PADDING, 25, 900);


    //HORIZONTAL WALLS (4 groups)

        //group 0, the top
        Rectangle H0 = new Rectangle(PADDING, PADDING, 900, 25);

        //group 1
        Rectangle H1 = new Rectangle(PADDING, 275 + PADDING, 100, 50);
        Rectangle H1a = new Rectangle(PADDING + 200, 275 + PADDING, 200, 50);
        Rectangle H1b = new Rectangle(PADDING + 500, 275 + PADDING, 200, 50);
        Rectangle H1c = new Rectangle(PADDING + 800, 275 + PADDING, 100, 50);

        //group2
        Rectangle H2 = new Rectangle(PADDING, 575 + PADDING, 400, 50);
        Rectangle H2a = new Rectangle(PADDING + 500, 575 + PADDING, 400, 50);

        //group 3
        Rectangle H3 = new Rectangle(PADDING, 875 + PADDING, 900, 25);


    //Converting them to walls and painting them (they won't be visible though - it's just handy dfor testing)

        Rectangle [] wallRec = {V0, V1a1, V1a2, V1b1, V1b2, V2a, V2b, V2c, V3, H0, H1, H1a, H1b, H1c, H2, H2a, H3}; // aux array

        for (int i = 0; i < wallRec.length; i++) {

            wallRec[i].setColor(Color.LIGHT_GRAY);
            wallRec[i].fill();
            walls[i] = new Wall(wallRec[i]);

        }
    }






    public void openScreen() {
        if (sprite.isDoor) {
            ;
        }
    }


}
