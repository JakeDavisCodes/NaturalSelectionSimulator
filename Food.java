public class Food
{
    private int x;
    private int y;
    private boolean alive;
    public Food(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.alive = true;
    }
    
    public void kill()
    {
        alive = false;
    }
    public boolean alive()
    {
        return alive;
    }
    public String position()
    {
        return "" + x + "," + y;
    }
    public int x()
    {
        return x;
    }
    public int y()
    {
        return y;
    }
}