package org.academiadecodigo.bootcamp.escapeproject.Game;

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
            {"One kilobyte is equal to how many bytes?","1024","+","*"},
            {"What is the name given to an ancient analog computer that was discovered by divers off a Greek island in 1900?","Antikythera mechanism","+","*"},
            {"What Harvard dropout co-founded Microsoft","Bill Gates","+","*"},
            {"What was the name of the first electronic general-purpose computer?","ENIAC","+","*"},
            {"What does HTTP stand for in a website address?","HyperText Transfer Protocol","+","*"},
            {"What year was Facebook founded?","2004","+","*"},
            {"In computer science, what does \"GUI\" stand for?","Graphical user interface","+","*"},
            {"CERN launched the very first website in what year?","1990","+","*"},
            {"In the world of video games, what does NES stand for?","Nintendo Entertainment System","+","*"},
            {"The companies HP, Microsoft and Apple were all started in a what?","Garage","+","*"},
            {"What is the name of the main protagonist in the Legend of Zelda series of video games?","Link","+","*"},
            {"Fonts that contain small decorative lines at the end of a stroke are known as what?","Serif Fonts","+","*"},
            {"In what year was the iPhone first released?","2007","+","*"},
            {"When referring to computer memory, what does that acronym RAM stand for?","Random Access Memory","+","*"},
            {"What do the letters HTML, a markup language used to create web pages, stand for?","Hypertext Markup Language","+","*"},
            {"With over 17 million units produced, what was the highest selling single model of personal computer ever?","The Commodore 64","+","*"},
            {"Who is credited with inventing the first mechanical computer?","Charles Babbage","+","*"},
            {"1,024 Gigabytes is equal to one what?","Terabyte","+","*"},
            {"In what year was the Nintendo 64 officially released?","1996","+","*"},
            {"From the computer world: What does the word \"modem\" abbreviate?","Modulation and Demodulation","+","*"},
            {"What is the most commonly used element in computers today?","Halfium","+","*"},
            {".EXE extension refers usually to what kind of file?","System File","",""},
            {"What is CIH also known as?","Chernobyl Virus","Common Interface Header","C++, a programming language"},
            {".JIF extension refers usually to what kind of file?","Image file","Audio file","Word Document file"},
            {"what is the top down design?","When you get the big problem and break it fown into smaller sub-problems so that each sub-problem can be solved into a few steps.","Breaking down smaller problems into smaller problems.","You need to keep in mind what your program needs to fulfill its requirements and determine the needs of the users ."}};

    //TODO
    //Não repetir perguntas.
    //selecionar uma resposta.

    /*private int c;

    public Questions(){
        this.c = 0;
    }
*/
    private boolean[] questionsAsked = new boolean[Q_AND_A.length];
    private boolean[] answersShowed = new boolean[4];
    private boolean rigthAnswer;
    private String Q;
    private String A;
    private String B;
    private String C;

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
        int q = questionI();


        if (questionsAsked[q] == true){
            questionsAndAnswers();
        }
        else {
            //System.out.println(q + " " + Q_AND_A[q][0]);
            Q = Q_AND_A[q][0];
        }

        int a = answers();

        A = Q_AND_A[q][a];
        //System.out.println(Q_AND_A[q][a]);
        answersShowed[0] = true;
        answersShowed[a] = true;

        for (int i = 0; i < answersShowed.length; i++) {
            if (answersShowed[i] != true) {
                B = Q_AND_A[q][i];
                answersShowed[i] = true;
                break;
            }
        }

        for (int i = 0; i < answersShowed.length; i++) {
            if (answersShowed[i] != true) {
                C = Q_AND_A[q][i];

            }
        }

        return q;

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

        Rectangle rect = new Rectangle(60, 600, 800, 200);
        rect.setColor(Color.BLACK);
        rect.draw();

        Rectangle rect1 = new Rectangle(70, 653, 780, 20);
        rect1.setColor(Color.BLACK);
        rect1.draw();

        Rectangle rect2 = new Rectangle(70, 683, 780, 20);
        rect2.setColor(Color.BLACK);
        rect2.draw();

        Rectangle rect3 = new Rectangle(70, 713, 780, 20);
        rect3.setColor(Color.BLACK);
        rect3.draw();

        Text text = new Text(70, 615, Q);
        text.setColor(Color.BLACK);
        text.draw();

        Text text1 = new Text(80, 655, "A - " + A);
        text1.setColor(Color.BLACK);
        text1.draw();

        Text text2 = new Text(80, 685, "B - " + B);
        text2.setColor(Color.BLACK);
        text2.draw();

        Text text3 = new Text(80, 715, "C - " + C);
        text3.setColor(Color.BLACK);
        text3.draw();

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }


    public void keyPressed(KeyboardEvent keyboardEvent, int q) {

        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_A:
                if (A == Q_AND_A[q][1]){
                    rigthAnswer = true;
                }
                break;

            case KeyboardEvent.KEY_B:
                if (B == Q_AND_A[q][1]){
                    rigthAnswer = true;
                }
                break;

            case KeyboardEvent.KEY_C:
                if (B == Q_AND_A[q][1]){
                    rigthAnswer = true;
                }
                break;
    }


    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }


}
