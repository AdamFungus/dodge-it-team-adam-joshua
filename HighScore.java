import greenfoot.*;
import java.util.List;

public class HighScore extends Actor
{
    private int highScore = 0;

    public HighScore()
    {
        updateHighscore();
    }

    public void act()
    {
        List<Score> scores = getWorld().getObjects(Score.class);
        
        if (!scores.isEmpty()) {
            Score currentScore = scores.get(0);
            if (currentScore.getScore() > highScore) {
                highScore = currentScore.getScore();
                updateHighscore();
            }
        }
    }
    
    private void updateHighscore() 
    {
        GreenfootImage img = new GreenfootImage(120, 30);
        img.setColor(Color.WHITE);
        img.drawString("High Score: " + highScore, 5, 20);
        setImage(img);
    }
    
    public int getHighScore() {
        return highScore;
    }
}

