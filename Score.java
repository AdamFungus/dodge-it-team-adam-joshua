import greenfoot.*;  // Import Greenfoot library

public class Score extends Actor
{
    private int score;  // Variable to hold the score
    private boolean gameOver;
    private int counter;
    public Score() 
    {
        score = 0;
        counter = 0;
        gameOver = false;
        updateImage();
    }

    public void act() 
    {
        if (!gameOver) {
            counter++;
            if (counter % 2 == 0) {
                score++; 
                updateImage(); 
            }
        }
    }

    private void updateImage() 
    {
        GreenfootImage img = new GreenfootImage(100, 20);
        img.setColor(Color.RED);  
        img.drawString("Score: " + score, 2, 15);
        setImage(img); 
    }

    public int getScore() {
        return score;
    }

    public void incrementScore(int value) {
        score+= value;  
        updateImage();
    }
    public void gameOver() 
    {
        gameOver = true;
    }
}
