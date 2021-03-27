import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Fish extends Actor
{
    public Fish(){
        turn(225); //diagonal fish be lyke :"D
    }
    
    public void act() 
    {
        Actor fish = getOneIntersectingObject(Wood.class);
        if(fish != null){
            setLocation(getX() + 20, getY() - 20); 
        }

    }    
}
