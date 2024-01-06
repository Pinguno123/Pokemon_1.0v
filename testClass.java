import java.util.Random;

public class testClass {

    public static void main(String[] args) {

        Random generator = new Random();

        int number1 = generator.nextInt(19);
        int number2 = generator.nextInt(3) + 1;

        System.out.println("Number1: " + number1 + " Number2: " + number2);
    }
}
