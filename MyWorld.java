import greenfoot.*;
public class MyWorld extends World {
    private Score score;  // Reference to the Score object
    private Hero hero;    // Reference to the Hero object
    private Banana banana;
    private HighScore highscore;
    public MyWorld() {
        super(600, 400, 1);
        Banana.increase = 3;
        hero = new Hero();
        addObject(hero, 100, 100);
        
        banana = new Banana();
        addObject(banana, 600, 100);
        
        score = new Score();
        addObject(score, 100, 20);
        
        GreenfootImage myImage = new GreenfootImage("road.png");
        setBackground(myImage);
        
        highscore = new HighScore();
        addObject(highscore, 500, 20);
    }
}
