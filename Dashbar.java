import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Dashbar extends Actor
{
    int min = 0;
    int max = 100;
    int dashPoint = 100;
    int dashPointWidth = 100;
    int dashPointHeight = 15;
    int pixelsPerDashPoint = (int)dashPointWidth/dashPoint;
    
    public Dashbar(){
        update();
    }
    
    public void act() 
    {
        //barrier for the dashbar
        if(dashPoint>=max){
            dashPoint = 100;
        }
        else if(dashPoint<=min){
            dashPoint = 0;
        }
        if(dashPoint<100){
            regenDash(); //keep regenerating until 100 when dash point is below 100 
        }

        update();
    }    
    
    public void update()
    {
        setImage(new GreenfootImage(dashPointWidth + 2, dashPointHeight + 2 ));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.BLACK);
        myImage.drawRect(0, 0, dashPointWidth + 1, dashPointHeight + 1); //fill color
        myImage.setColor(Color.BLUE); //setting the color for dashbar
        myImage.fillRect(1, 1, dashPoint * pixelsPerDashPoint, dashPointHeight); //fillRect(x,y,width,height)
    } 
    
    public void minDash(){
        dashPoint-=2;
    }
    
    public void regenDash(){
        dashPoint++;
    }
}
