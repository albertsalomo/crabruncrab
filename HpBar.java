import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;

public class HpBar extends Actor
{
    int health = 100;
    int healthBarWidth = 100 ;
    int healthBarHeight = 15;
    int pixelsPerHealthPoint = (int)healthBarWidth/health;
    
    public HpBar(){
        update();
    }
    
    public void act() 
    {
        // Add your action code here.
        if(health>=100){
            health = 100;
        }
        update();
    }    
    
    public void update()
    {
        setImage(new GreenfootImage(healthBarWidth + 2, healthBarHeight + 2 ));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.BLACK);
        myImage.drawRect(0, 0, healthBarWidth + 1, healthBarHeight + 1);
        myImage.setColor(Color.RED);
        myImage.fillRect(1, 1, health * pixelsPerHealthPoint, healthBarHeight); 
    } 
    
    public void minHp(){
        health--;
    }
    
    public void gainHpWorm(){
        health+=1;
    }
    
    public void gainHpFish(){
        health+=10;
    }
}
