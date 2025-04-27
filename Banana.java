import greenfoot.*; 
import java.util.List;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class banana here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Banana extends Actor
{
    
    public static int increase = 3;
    public int count = 0; 
    public void act()
    {
        // Add your action code here.
        
        move(-increase);
        if(getX() <= 0 || increase <= 0) 
        {
        resetBanana();
        }
        
        if(isTouching(Hero.class)) 
        {
            if (getWorld() != null) {
                List<Score> scores = getWorld().getObjects(Score.class);
                if (!scores.isEmpty()) {
                    Score score = scores.get(0); // Assuming there is only one Score object
                    score.gameOver(); // Call gameOver() from Score
                }
            }
            GameOver over = new GameOver();
            getWorld().addObject(over, 300, 200);
            getWorld().removeObject(this);
        }
    }
    public void resetBanana() 
    {
        int num = Greenfoot.getRandomNumber(2); 
        count += 1+Greenfoot.getRandomNumber(2);
            List<Score> scores = getWorld().getObjects(Score.class);
            if (!scores.isEmpty()) 
            {
                Score score = scores.get(0);
                score.incrementScore(100);
            }
        if (num == 0) 
        {
            setLocation(600, 100);
        }
        else 
        {
            setLocation(600, 300);
        }
        if (count >= 5) 
        {
            count = 0;
            increase+= 1+Greenfoot.getRandomNumber(2);
            if(increase >= 5) 
            {  
                Food food = new Food();
                getWorld().addObject(food, 600, 100);
            }
        }
    }
}
