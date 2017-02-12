package org.academiadecodigo.bootcamp.escapeproject.Graphics;

import org.academiadecodigo.bootcamp.escapeproject.Graphics.Doors;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

/**
 * Created by codecadet on 07/02/17.
 */
public class Questions implements KeyboardHandler{



    private final String[][] Q_AND_A = {{"In what year was the first Apple computer released?" , "1976", "1982", "1974"},
            {"In a website browser address bar, what does 'www' stand for?", "World Wide Web", "Web World Wide", "World Web Wide"},
            {"In what year did Nintendo release its first game console in North America?","1985","1987","1990"},
            {"Steve Jobs, Steve Wozniak, and Ronald Wayne founded what company in 1976?","Apple Computer, Inc.","Sun Microsystems","Microsoft"},
            {"One kilobyte is equal to how many bytes?","1024","512","256"},
            {"What is the name given to an ancient analog computer that was discovered by divers off a Greek island in 1900?","Antikythera mechanism","Datapoint 2200","Apple One"},
            {"What Harvard dropout co-founded Microsoft","Bill Gates","Steve Wozniak","Larry Page"},
            {"What was the name of the first electronic general-purpose computer?","ENIAC","Datapoint 2200","Kenbak-1"},
            {"What does HTTP stand for in a website address?","HyperText Transfer Protocol","High Traduction Transference Protocol","Hexa Traduction Test Protocol"},
            {"What year was Facebook founded?","2004","2001","2006"},
            {"In computer science, what does \"GUI\" stand for?","Graphical user interface","Grand universe interface","Growing user interface"},
            {"CERN launched the very first website in what year?","1990","1987","1992"},
            {"In the world of video games, what does NES stand for?","Nintendo Entertainment System","Neural Enterprise Systems","Never Ending Systems"},
            {"The companies HP, Microsoft and Apple were all started in a what?","Garage","small village","café"},
            {"What is the name of the main protagonist in the Legend of Zelda series of video games?","Link","Zelda","Drake"},
            {"Fonts that contain small decorative lines at the end of a stroke are known as what?","Serif Fonts","Hobeaux Rococeaux","Niveau Grotesk"},
            {"In what year was the iPhone first released?","2007","2002","2005"},
            {"When referring to computer memory, what does that acronym RAM stand for?","Random Access Memory","Radical Alternative Memory","Regnus Agnus Mundi"},
            {"What do the letters HTML, a markup language used to create web pages, stand for?","HyperText Markup Language","High Textual Mashed Language","Hexa Translate Markup Language"},
            {"With over 17 million units produced, what was the highest selling single model of personal computer ever?","The Commodore 64","Apple One","zx spectrum"},
            {"Who is credited with inventing the first mechanical computer?","Charles Babbage","Bill Gates","Steve Jobs"},
            {"1,024 Gigabytes is equal to one what?","Terabyte","Kilogram","Tirabyte"},
            {"In what year was the Nintendo 64 officially released?","1996","1994","1964"},
            {"From the computer world: What does the word \"modem\" abbreviate?","Modulation and Demodulation","Modification and Destination","Modemaster"},
            {"What is the most commonly used element in computers today?","Hafnium","Silicio","Tungsten"},
            {".EXE extension refers usually to what kind of file?","System File","Hexa File","Exit File"},
            {"What is CIH also known as?","Chernobyl Virus","Common Interface Header","C++, a programming language"},
            {".JIF extension refers usually to what kind of file?","Image file","Audio file","Word Document file"}};


    private boolean[] questionsAsked = new boolean[Q_AND_A.length];
    private boolean[] answersShowed = new boolean[4];
    private boolean rigthAnswer;
    private boolean wrongAnswer;
    private String Q;
    private String A;
    private String B;
    private String C;
    private int rightAnswerIndex;

    private Rectangle rect;
    private Rectangle rect1;
    private Rectangle rect2;
    private Rectangle rect3;
    private Text text;
    private Text text1;
    private Text text2;
    private Text text3;
    private Text text4;


    //private Doors door = new Doors();

    public Questions() throws InterruptedException {
    }

    public void start(Doors doors) throws InterruptedException {
        test();

        while (true){
            Thread.sleep(300);
            if (rigthAnswer){
                doors.openDoor();
                break;
            }
            if (wrongAnswer){
                //deleteEverything();
                doors.deletePadPictures();
                //doors.getBackground().delete();
                break;
                //text4.draw();
            }
        }
        return;


    }

    public String[][] getQuestion(){
        return Q_AND_A;
    }

    public static int random(int min, int max) {
        int rand = (int) ((Math.random() * (max - min)) + min);
        return rand;
    }

    public int questionI(){
        int q = random(0, getQuestion().length);
        return q;
    }

    public int answers(){
        int a = random(1, 3);
        return a;
    }


    public int questionsAndAnswers(){
        rightAnswerIndex = questionI();


        if (questionsAsked[rightAnswerIndex] == true){
            questionsAndAnswers();
        }
        else {
            //System.out.println(q + " " + Q_AND_A[q][0]);
            Q = Q_AND_A[rightAnswerIndex][0];
        }

        int a = answers();

        A = Q_AND_A[rightAnswerIndex][a];
        //System.out.println(Q_AND_A[q][a]);
        answersShowed[0] = true;
        answersShowed[a] = true;

        for (int i = 0; i < answersShowed.length; i++) {
            if (answersShowed[i] != true) {
                B = Q_AND_A[rightAnswerIndex][i];
                answersShowed[i] = true;
                break;
            }
        }

        for (int i = 0; i < answersShowed.length; i++) {
            if (answersShowed[i] != true) {
                C = Q_AND_A[rightAnswerIndex][i];

            }
        }

        return rightAnswerIndex;

        //selectOneAnswer(q);
    }

    /*public boolean selectOneAnswer(int q){

        if (MouseEventType.MOUSE_CLICKED == Q_AND_A[q][1]){
            System.out.println("Right answer!");
            return true;
        }
        System.out.println("wrong answer");
        return false;
    }*/

    public void test() throws InterruptedException {

        questionsAndAnswers();
        Keyboard k = new Keyboard(this);
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_A);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);

        KeyboardEvent event1 = new KeyboardEvent();
        event1.setKey(KeyboardEvent.KEY_B);
        event1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event1);

        KeyboardEvent event2 = new KeyboardEvent();
        event2.setKey(KeyboardEvent.KEY_C);
        event2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event2);

        rect = new Rectangle(60, 630, 800, 200);
        rect.setColor(Color.BLACK);
        rect.fill();

        rect1 = new Rectangle(70, 703, 780, 20);
        rect1.setColor(Color.BLACK);
        rect1.draw();

        rect2 = new Rectangle(70, 733, 780, 20);
        rect2.setColor(Color.BLACK);
        rect2.draw();

        rect3 = new Rectangle(70, 763, 780, 20);
        rect3.setColor(Color.BLACK);
        rect3.draw();

        text = new Text(70, 665, Q);
        text.setColor(Color.WHITE);
        text.draw();

        text1 = new Text(80, 705, "A - " + A);
        text1.setColor(Color.WHITE);
        text1.draw();

        text2 = new Text(80, 735, "B - " + B);
        text2.setColor(Color.WHITE);
        text2.draw();

        text3 = new Text(80, 765, "C - " + C);
        text3.setColor(Color.WHITE);
        text3.draw();

        text4 = new Text(80, 765, "Try again");
        text4.setColor(Color.WHITE);


    }

    public void deleteEverything(){
        rect.delete();
        rect1.delete();
        rect2.delete();
        rect3.delete();
        text.delete();
        text1.delete();
        text2.delete();
        text3.delete();
    }




    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_A:
                if (A == Q_AND_A[rightAnswerIndex][1]) {
                    rigthAnswer = true;
                } else {
                    wrongAnswer = true;
                    break;
                }


            case KeyboardEvent.KEY_B:
                if (B == Q_AND_A[rightAnswerIndex][1]) {
                    rigthAnswer = true;
                }else {
                    wrongAnswer = true;
                    break;
                }

            case KeyboardEvent.KEY_C:
                if (C == Q_AND_A[rightAnswerIndex][1]) {
                    rigthAnswer = true;
                }else {
                    wrongAnswer = true;
                    break;
                }

        }
    }



    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }



}
