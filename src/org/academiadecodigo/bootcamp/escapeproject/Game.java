package org.academiadecodigo.bootcamp.escapeproject;

import org.academiadecodigo.bootcamp.escapeproject.gameObjects.Grelha;
import org.academiadecodigo.bootcamp.escapeproject.graphics.Inicial;

/**
 * Created by codecadet on 12/02/17.
 */


public class Game {

    public static void main(String[] args) {

        Inicial initi = new Inicial();

        try {
            initi.prompt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }



}
