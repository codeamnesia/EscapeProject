package org.academiadecodigo.bootcamp.escapeproject.Game;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

/**
 * Created by codecadet on 07/02/17.
 */
public class Questions implements MouseHandler{



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
            {"what is debugging?","Running the program","A list of instructions","Requirements and specifications."},
            {"what is a computer program?","A list of instructions","A set of steps in order approach to solve a problem","Requirements and specifications."},
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

    public void questionsAndAnswers(){
        int q = questionI();

        if (questionsAsked[q] == true){
            questionsAndAnswers();
        }
        else {
            System.out.println(q + " " + Q_AND_A[q][0]);

        }
        int a = answers();

        Q = Q_AND_A[q][a];
        //System.out.println(Q_AND_A[q][a]);
        answersShowed[0] = true;
        answersShowed[a] = true;

        for (int i = 0; i < answersShowed.length; i++) {
            if (answersShowed[i] != true) {
                System.out.println(Q_AND_A[q][i]);
                answersShowed[i] = true;
            }
        }

        selectOneAnswer(q);
    }

    public boolean selectOneAnswer(int q){

        /*if (MouseEventType.MOUSE_CLICKED == Q_AND_A[q][1]){
            System.out.println("Right answer!");
            return true;
        }
        System.out.println("wrong answer");*/
        return false;
    }

    public void test() throws InterruptedException {
        Mouse m = new Mouse(this);
        m.addEventListener(MouseEventType.MOUSE_CLICKED);
        m.addEventListener(MouseEventType.MOUSE_MOVED);

        Text text = new Text(20, 180, Q);
        text.setColor(Color.BLACK);
        text.draw();

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println(mouseEvent);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        System.out.println(mouseEvent);
    }
}
