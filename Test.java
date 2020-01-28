import java.util.ArrayList;

public class Test
{
    private Field field;
    private ArrayList<Creature> c;
    
    public Test(Field field, ArrayList<Creature> c)
    {
        this.c = c;
        this.field = field;
    }
    
    /*public Test(int mf, int size, int n, int s, int e)
    {
        ArrayList<Creature> c = new ArrayList<Creature>();
        Field field = generateField(mf,size);
        for(int i = 0; i < n; i ++)
        {
            c.add(new Creature(s,e,field));
            //System.out.println(c.get(i).info());
        }
        System.out.println(c.get(1).info());
    }*/
    
    public int creatureNum()
    {
        return c.size();
    }
    public int foodNum()
    {
        return field.foodNum();
    }
    
    public void moveTest()
    {
        for(Creature creature : c)
        {
            creature.move();
        }
    }
    public Field generateField(int maxFood, int size)
    {
        ArrayList<Food> f = new ArrayList<Food>();
        for(int i = 0; i < maxFood; i ++)
        {
            f.add(new Food((int)(size * Math.random()),(int)(size * Math.random())));
        }
        return new Field(maxFood,size,f);
    }
    public Creature findSlow()
    {
        Creature longest = c.get(1);

        for(Creature cr : c)
        {
            if(cr.time() < longest.time())
            {
                 longest = cr;
            }
        }
        return longest;
    }
  
    public void test(int genNum)
    {
        System.out.println(c.get(1).info());
        Creature longest = c.get(1);
        int count = 0;
        for(Creature cr : c)
        {
            if(cr.time() < longest.time())
            {
                 longest = cr;
            }
        }
        for(int i = 0; i < genNum; i ++)
        {
            field.reset();
            while(count >= longest.time())
            {
                moveTest();
                for(Creature cr : c)
                {
                    cr.onFood();
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
    }
}