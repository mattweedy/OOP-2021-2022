package ie.tudublin;

public class Cat extends Animal
{
    private int numLives;
    
    public void kill() {
        if (numLives > 0) {
            System.out.println("Ouch!");
            numLives --;
        } else {
            System.out.println("Dead");
        }
    }
    public int getNumLives() {
        return numLives;
    }

    public void setNumLives(int numLives) {
        this.numLives = numLives;
    }


    public Cat(String name)
    {
        super(name);
        // this sets the value to 9 in the cat object being created
        numLives = 9;
    }
}