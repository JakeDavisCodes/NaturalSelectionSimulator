import java.util.ArrayList;
import java.util.ArrayList;
import java.util.ArrayList;

public class Creature
{
    private int energy;
    private int speed;
    private int x;
    private int y;
    private Field field;
    private int eaten;
    
    public Creature(int speed, int energy, Field field)
    {
        this.speed = speed;
        this.energy = energy;
        this.field = field;
        eaten = 0;
                
        if((int)(Math.random() *2) < 1)
        {
            if((int)(Math.random() *2) < 1) //broken
            {
                x = 0;
                y = (int)(Math.random() * field.findFieldSize());
            }
            else
            {
                x = field.findFieldSize();
                y = (int)(Math.random() * field.findFieldSize());
            }
        }
        else
        {
            if((int)(Math.random() *2) < 1)
            {
                y = 0;
                x = (int)(Math.random() * field.findFieldSize());
            }
            else
            {
                y = field.findFieldSize();
                x = (int)(Math.random() * field.findFieldSize());
            }
        }
    }
    
    public String info()
    {
        return "Pos: " + x + "," + y + "\nEnergy: " + energy + "\nSpeed: " + speed  + "\nFoodNum: " + eaten + "\n";
    }
    public int time()
    {
        return energy/(speed*speed);
    }
    
    public boolean detectFood()
    {
        ArrayList<Food> food = field.retFood();
        for(Food f : food)
        {
            if(f.position().equals((x+1)+","+y) || f.position().equals((x-1)+","+y) || f.position().equals(x+","+(y+1)) || f.position().equals(x+","+(y-1)))
            {
                //System.out.println("FOOD LOCATED: " + f.position());
                return true;
            }
        }
        return false;
    }
    public void onFood()
    {
        ArrayList<Food> food = field.retFood();
        for(Food f : food)
        {
            if(f.position().equals(x+","+y))
            {
                System.out.println("ON FOOD: " + f.position());
                f.kill();
                eaten++;
            }
        }
    }
    
    public boolean available(String direction)
    {
        if(direction.equals("up"))
        {
            if(y+1 > field.findFieldSize())
            {
                return false;
            }
        }
        else if(direction.equals("down"))
        {
            if(y-1 < 0)
            {
                return false;
            }
        }
        else if(direction.equals("left"))
        {
            if(x-1 < 0)
            {
                return false;
            }
        }
        else if(direction.equals("right"))
        {
            if(x+1 > field.findFieldSize())
            {
                System.out.println("RIGHT AVAILABLE ");return false;
                
            }
        }
        return true;
    }
    public void move()
    {
        int direction = (int)(4 * Math.random());
        for(int i = 0; i < speed; i ++)
        {
            if(detectFood())
            {
                ArrayList<Food> food = field.retFood();
                System.out.println("MOVING TO FOOD, I AM AT: "+ x+","+y);
                for(Food f : food)
                {
                    if(f.x()-x==-1)
                    {
                        x--;
                    }
                    else if(f.x()-x==1)
                    {
                        x+=1;
                        System.out.println("RIGHT MOVE F ");
                    }
                    else if(f.y()-y==-1)
                    {
                        y--;
                    }
                    else if(f.y()-y==1)
                    {
                        y++;
                    }
                    
                }
            }
            else
            {
                    if(direction == 0 && available("up"))
                {
                    y++;
                }
                else if(direction == 1 && available("down"))
                {
                    y--;
                }
                else if(direction == 2 && available("left"))
                {
                    x--;
                }
                else if(direction == 3 && available("right"))
                {
                    x++;
                    System.out.println("RIGHT MOVE R ");
                }
                else
                {
                    i--;
                    direction = (int)(4 * Math.random());
                }
            }
            //onFood();
        }
        energy -= speed*speed;
    }
}