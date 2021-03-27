import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.concurrent.TimeUnit;

public class Enemy extends Actor
{
    Crab crab;
    public int speed = 4;
    boolean a = true;
    boolean b = true;
    boolean c = true;
    boolean d = true;
    
    public Enemy(Crab mainCrab){
        GreenfootImage image = getImage();
        image.scale(image.getWidth(), image.getHeight());
        setImage(image);
        crab = mainCrab;
    }
    
    public void act() 
    {
        Actor gear = getOneIntersectingObject(Wood.class);
        if(gear != null){
            setLocation(getX() + speed, getY() - speed);
        }
        turn(10);
        moveAround();
        bounce();
        
    } 
    
    
    public void bounce(){
        if(isTouching(Crab.class) || isTouching(Enemy.class)){
           int a = Greenfoot.getRandomNumber(10);
           if(a%2==0)
           {
               setLocation(getX() + 2 , getY() + 2);
           }
           else
           {
               setLocation(getX() - 2, getY() - 2);
           }
        }
    }
    
    public void moveAround()
    {
        GreenfootImage image = getImage();
        if(crab.score == 50 && a == true){
            move(speed + 1);
            image.scale(image.getWidth() + 5, image.getHeight() + 5);
            a = false;
        }
        else if(crab.score == 100 && b == true){
            move(speed + 2);
            image.scale(image.getWidth() + 5, image.getHeight() + 5);
            b = false;
        }
        else if(crab.score == 200 && c == true){
            move(speed + 3);
            image.scale(image.getWidth() + 10, image.getHeight() + 10);
            c = false;
        }
        else if(crab.score == 500 && d == true){
            move(speed + 5);
            image.scale(image.getWidth() + 10, image.getHeight() + 10);
            d = false;
        }
        else{
            move(speed);
        }
        turnTowards(crab.getX(), crab.getY());
        
    }
    
}
