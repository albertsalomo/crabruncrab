import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * CrabGame
 * 
 * @author (albertsalomo) 
 * @version (21-03-2021) ver 1.0.0
 */

public class CrabWorld extends World
{
    //initialize mainCrab (Crab class)
    public Crab mainCrab = new Crab();
    
    //boolean value for generate enemies
    boolean a = false, b = false, c = false, d = false, e = false, f = false;
    
    //food count (max count food in the scenario)
    public int wormCount = 0;
    public int fishCount = 0;
    public int goldenWormCount = 0;
    
    // -- hp bar and dashbar --
    //initialize hpbar and dashbar class so can be accessed for other actor
    HpBar healthbar = new HpBar();
    Dashbar dashbar = new Dashbar();
    public HpBar getHpBar(){
        return healthbar;
    }
    
    public Dashbar getDashBar(){
        return dashbar;
    }
    
    //loop music
    private GreenfootSound music = new GreenfootSound("crabwalk.wav");
    public void started()
    {
        music.playLoop();
    }
    public void stopped()
    {
        music.stop();
    }
    
    //preparing the world
    public CrabWorld()
    {    
        super(900, 560, 1); 
        prepare();
    }
    
    //main function
    public void act()
    {
        //prevent worm breakout in the scenario
        if(wormCount<=20)
        {
            if(Greenfoot.getRandomNumber(60)<1)
            {
                wormCount++;
                generateWorm();
            }
        }
        
        //prevent golden worm breakout in the scenario
        if(goldenWormCount < 1)
        {
            if(Greenfoot.getRandomNumber(1000000)<1)
            {
                goldenWormCount++;
                generateGoldenWorm();
            }
        }
        
        //prevent fish breakout in the scenario
        if(fishCount<=3)
        {
            if(Greenfoot.getRandomNumber(2000)<2)
            {
                fishCount++;
                generateFish();
            }
        }
        
        //generate enemies dan knife
        if(mainCrab.score >= 25 && a == false)
        {
            a = true;
            generateEnemies();
        }
        
        if(mainCrab.score >= 50 && b == false)
        {
            b = true;
            generateEnemies();
            generateKnife();
        }
        
        if(mainCrab.score >= 100 && c == false)
        {
            c = true;
            generateEnemies();
        }
        
        if(mainCrab.score >= 200 && d == false)
        {
            d = true;
            generateEnemies();
            generateKnife();
        }
        
        if(mainCrab.score >= 500 && e == false)
        {
            e = true;
            generateEnemies();
            generateKnife();
        }

        
    }
    
    //generate food
    
    public void generateWorm()
    {
        addObject(new Worm() ,Greenfoot.getRandomNumber(900),Greenfoot.getRandomNumber(460));
        Greenfoot.delay(3);
    }
    
    public void generateFish()
    {
        addObject(new Fish(), Greenfoot.getRandomNumber(900),Greenfoot.getRandomNumber(560));     
        Greenfoot.delay(3);
    }
    
    public void generateGoldenWorm(){
        addObject(new GoldenWorm() ,Greenfoot.getRandomNumber(900),Greenfoot.getRandomNumber(560));
        Greenfoot.delay(3);
    }

    public void generateEnemies()
    {
        addObject(new Enemy(mainCrab) ,Greenfoot.getRandomNumber(900),Greenfoot.getRandomNumber(560));
    }
    
    public void generateKnife(){
        addObject(new Knife(), Greenfoot.getRandomNumber(900) , Greenfoot.getRandomNumber(560));
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Wood wood = new Wood();
        addObject(wood,120,515);
        addObject(healthbar,170,480);
        addObject(dashbar ,170 , 510);
        addObject(mainCrab,500, 300);
        addObject(dashbar, 800, 20);
    }
}
