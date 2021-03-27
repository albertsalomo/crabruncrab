import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GoldenWorm extends Actor
{
    /**
     * Act - do whatever the GoldenWorm wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        Actor goldenWorm = getOneIntersectingObject(Wood.class);
        
        if(goldenWorm != null){
            setLocation(getX() + 20, getY() - 20); 
        }
    }    
}
