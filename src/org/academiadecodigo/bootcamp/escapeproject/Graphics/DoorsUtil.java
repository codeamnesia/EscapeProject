package org.academiadecodigo.bootcamp.escapeproject.Graphics;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 08/02/17.
 */
public class DoorsUtil {

    public static long randomTime() {
        return 500 + (long) (Math.random() * 300);
    }

    public static int randomizeDistracted() {
        return (int) (Math.random() * 3);
    }

    public static int whoIsPayingAttention() {
        return (int) (Math.random() * 3);
    }

    public static boolean isSomeOnePayingAttention() {
        return Math.random() < 0.10;
    }

    public static boolean isWithin(MouseEvent e, Picture p) {
        return e.getX() >= p.getX() && e.getX() <= p.getX() + p.getWidth() && e.getY() - 23 >= p.getY()
                && e.getY() - 23 <= p.getY() + p.getHeight();
    }

    public static boolean isWithin(MouseEvent e, Rectangle p) {
        return e.getX() >= p.getX() && e.getX() <= p.getX() + p.getWidth() && e.getY() - 23 >= p.getY()
                && e.getY() - 23 <= p.getY() + p.getHeight();
    }

}
