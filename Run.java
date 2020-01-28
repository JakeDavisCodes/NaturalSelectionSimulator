import java.util.ArrayList;

public class Run
{
    public static void main(String[] args)
    {
        ArrayList<Food>  food = new ArrayList<Food>();
        int fieldSize = 10;
        int maxFood = 10;
        for(int i = 0; i < maxFood; i ++)
        {
            food.add(new Food((int)(fieldSize * Math.random()),(int)(fieldSize * Math.random())));
        }
        Field field = new Field(maxFood,fieldSize,food);
        
        ArrayList<Creature> creatures = new ArrayList<Creature>();
        for(int i = 0; i < 10; i ++)
        {
            creatures.add(new Creature(2,20,field));
        }
        
        Test test = new Test(field,creatures);
        
        field.reset();
        int count = 0;
        for(int i = 0; i < 5; i ++)
        {
            count = 0;
            while(count < test.findSlow().time())
            {
                test.moveTest();
                for(Creature c : creatures)
                {
                    c.onFood();
                }
                for(Food f : field.retFood())
                {
                    System.out.println(f.position());
                    
                }
                for(int j = 0; j < field.retFood().size(); j ++)
                {
                    if(field.retFood().get(j).alive()==false)
                    {
                        field.removeFood(field.retFood().get(j));
                    }
                }
                count++;
            }
            
        }
        for(Creature c : creatures)
            {
                System.out.println(c.info());
            }
    }
}