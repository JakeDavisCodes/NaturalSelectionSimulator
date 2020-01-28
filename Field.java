import java.util.ArrayList;

public class Field
{
    private int maxFood;
    private int fieldSize;
    public ArrayList<Food> food;
   
    public Field(int maxFood, int fieldSize, ArrayList<Food> food)
    {
        this.maxFood = maxFood;
        this.fieldSize = fieldSize;
        this.food = food;
    }
    
    public void removeFood(Food f)
    {
        food.remove(f);
    }
    public int myRandom()
    {
        return (int)(fieldSize * Math.random());
    }
    public void reset()
    {
        for(int i = maxFood; i < maxFood; i ++)
        {
            food.remove(0);
        }
        for(int i = maxFood; i < maxFood; i ++)
        {
            food.add(new Food(myRandom(),myRandom()));
        }
    }
    public int foodNum()
    {
        return food.size();
    }
    public int findFieldSize()
    {
        return fieldSize;
    }
    public ArrayList<Food> retFood()
    {
        return food;
    }
}