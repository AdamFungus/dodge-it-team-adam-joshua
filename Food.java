import greenfoot.*;
import java.util.List;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Food here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Food extends Actor
{
    /**
     * Act - do whatever the Food wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean actionPerformed = false;
    private int move = 0;
    public void act()
    {
        // Add your action code here.
        
        if (!actionPerformed) {
            setFood();
            actionPerformed = true;
        }
        move(-move);
        if(getX() <= 0) 
        {
            if (getWorld() != null) getWorld().removeObject(this);
            return;
        }
        
        if(isTouching(Hero.class)) 
        {   
            List<Score> scores = getWorld().getObjects(Score.class);
            if (!scores.isEmpty()) 
            {
                Score score = scores.get(0);
                score.incrementScore(1000);
            }
            Banana.increase -= 1 + Greenfoot.getRandomNumber(3);
            getWorld().removeObject(this);
        }
    }
    public void setFood() 
    {
        int num = Greenfoot.getRandomNumber(2); 
        move = 2+ Greenfoot.getRandomNumber(3);
        if (num == 0) 
        {
            setLocation(600, 100);
        }
        else 
        {
            setLocation(600, 300);
        }
    }
}
