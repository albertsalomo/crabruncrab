import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Knife extends Actor
{
    public int speed = 1;
    
    public void act() 
    {
        Actor knife = getOneIntersectingObject(Wood.class);
        if(knife != null){
            setLocation(getX() + speed, getY() - speed);
        }
        // Add your action code here.
        turn(speed);
        move(speed + 1);
    }  
}
