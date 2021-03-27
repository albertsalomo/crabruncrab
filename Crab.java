import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)



public class Crab extends Actor
{
    //speed, score, and lives variables
    public int lives = 100;
    public int score = 0;
    public int speed = 7;
    public int maxSpeed = 11; //max speed when using dash method
    
    //setting the image of the class
    public Crab()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth()-20, image.getHeight() - 20);
        setImage(image);
    }
    
    public void act() 
    {
        World myWorld = getWorld();
        CrabWorld cw = (CrabWorld)myWorld;
        Dashbar dashbar = cw.getDashBar();
        
        move(speed);
        Actor mainCrab = getOneIntersectingObject(Wood.class);
        
        if(mainCrab != null){
            setLocation(getX() + speed, getY() - speed); 
        }
        
        if(lives>100){
            lives = 100;
        }
        
        if(speed >= maxSpeed){
            speed = maxSpeed;
        }
        
        //keyboard inputs
        if(Greenfoot.isKeyDown("A") || Greenfoot.isKeyDown("left"))
        {
            turn(-3);   
        }
        
        if(Greenfoot.isKeyDown("D") || Greenfoot.isKeyDown("right"))
        {
            turn(3);   
        }
        if(Greenfoot.isKeyDown("shift") && dashbar.dashPoint > 2)
        {
            dashbar.minDash();
            dashbar.update();
            speed++;  
        }
        else
        {
            speed = 7;
        }
        
        showStatus();
        gameOver();
        increaseScore();
        goldenWorm();
        increaseHealth();
        decreaseHealth();
        
    } 
    
    //crab method
    public void increaseScore(){
        if(isTouching(Worm.class)){
            Greenfoot.playSound("eating.wav");
            World myWorld = getWorld();
            CrabWorld cw = (CrabWorld)myWorld;
            HpBar health = cw.getHpBar();
            cw.wormCount--;
            removeTouching(Worm.class);
            score++;
            health.gainHpWorm();
            lives+=1;
            
        }
    }
    
    public void goldenWorm(){
        if(isTouching(GoldenWorm.class)){
            Greenfoot.playSound("eatingGoldWorm.wav");
            World myWorld = getWorld();
            CrabWorld cw = (CrabWorld)myWorld;
            cw.goldenWormCount--;
            removeTouching(GoldenWorm.class);
            score+=100;
            
        }
    }
    
    public void increaseHealth(){
        if(isTouching(Fish.class)){
            Greenfoot.playSound("fishEat.wav");
            World myWorld = getWorld();
            CrabWorld cw = (CrabWorld)myWorld;
            HpBar health = cw.getHpBar();
            cw.fishCount--;
            health.gainHpFish();
            removeTouching(Fish.class);
            score+=2;
            lives+=10;
        }
    }
    
    public void decreaseHealth(){
        if(isTouching(Enemy.class) || isTouching(Knife.class)){
            Greenfoot.playSound("cutting.wav");
            World myWorld = getWorld();
            CrabWorld cw = (CrabWorld)myWorld;
            HpBar health = cw.getHpBar();
            health.minHp();
            health.update();
            lives--;
        }
    }
    
    private void gameOver(){
        if(lives<=0){
            Greenfoot.playSound("died.wav");
            GreenfootImage gameOver = new GreenfootImage("crab_dead.png");
            gameOver.scale(gameOver.getWidth()-20, gameOver.getHeight() - 20);
            setImage(gameOver);
            Greenfoot.stop();
            getWorld().showText("Game Over", 450, 280);
        }
 
    }
    
    private void showStatus(){
        if(lives>=0){
            getWorld().showText("Lives : ", 40, 480);
            getWorld().showText("Dashbar :", 50, 510);
            getWorld().showText("Score : ", 40, 540);
            getWorld().showText(String.valueOf(score), 130, 540);
        }
    }

}
