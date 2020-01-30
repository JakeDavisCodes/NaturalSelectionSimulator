import java.util.ArrayList;

public class Run
{
    public static void main(String[] args)
    {
        ArrayList<Food>  food = new ArrayList<Food>();
        int fieldSize = 20;
        int maxFood = 20;
        for(int i = 0; i < maxFood; i ++)
        {
            food.add(new Food((int)(fieldSize * Math.random()),(int)(fieldSize * Math.random())));
        }
        Field field = new Field(maxFood,fieldSize,food);
        
        ArrayList<Creature> creatures = new ArrayList<Creature>();
        for(int i = 0; i < 20; i ++)
        {
            creatures.add(new Creature(5,1000,field));
        }
        
        Test test = new Test(field,creatures);
        
        field.reset();
        int count = 0;
        for(int i = 0; i < 4; i ++)
        {
            for(Creature c : creatures)
            {
                c.reset();
                c.move();
            }
            for(int j = 0; j < creatures.size(); j ++)
            {
                if(creatures.get(j).replicate()!=null)
                {
                    
                    creatures.add(creatures.get(j).replicate());
                    System.out.println("Creature Born!");
                }
            }
            System.out.println("Gen Complete \n");
        }
        for(Creature c : creatures)
            {
                System.out.println(c.info());
            }
    }
}