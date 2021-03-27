import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Worm extends Actor
{
    public void act() 
    {
        Actor worm = getOneIntersectingObject(Wood.class);
        
        if(worm != null){
            setLocation(getX() + 20, getY() - 20); 
        }
    }    
}
