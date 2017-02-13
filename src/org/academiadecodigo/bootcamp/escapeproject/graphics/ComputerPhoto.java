package org.academiadecodigo.bootcamp.escapeproject.graphics;

import org.academiadecodigo.bootcamp.escapeproject.Scenable;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 11/02/17.
 */
public class ComputerPhoto implements Scenable, MouseHandler {

    //Class to only prompt photo of computer screen with ascii int
    private Picture computer;


    @Override
    public void prompt() throws InterruptedException {
        computer = new Picture(60, 60, "resources/pics/computer.jpg");
        computer.draw();

        Mouse m = new Mouse(this);
        m.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        computer.delete();

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
