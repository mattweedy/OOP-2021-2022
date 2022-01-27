package ie.tudublin;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello world");

        Animal misty = new Animal("Misty");
        Animal lucy = new Animal("Lucy");

        lucy = misty;
        misty.setName("Tara");

        System.out.println(misty);
        System.out.println(lucy);

        Cat ginger = new Cat("Ginger");

        while (ginger.getNumLives() > 0) {
            ginger.kill();
        }
        ginger.kill();
        
        // Tara Misty
        // Tara Tara
        
    }
}