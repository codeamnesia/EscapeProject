package org.academiadecodigo.bootcamp.escapeproject.Game;

import org.academiadecodigo.bootcamp.escapeproject.Character.Player;

/**
 * Created by codecadet on 05/02/17.
 */
public class Game {

    private Grid grid;
    private Player[] player;
    int numCharacter = 1;




    Game (){
        grid = new Grid();

    }


    //creates Grid and Player;
    public void init(){

        grid.init();


        player = new Player[numCharacter];


        for (int i = 0; i < numCharacter; i++) {

        }




    }

    //onde efetivamente se inicia o jogo;

    public void start(){

    }

}
