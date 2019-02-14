import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        int randomNumber = (int) (Math.random() * 100) + 1;
        // System.out.print(randomNumber);
        System.out.print("there's a random number between [0,100] \n" +
                "and you have 10 guesses if any of them is right you WIN.. \n" +
                "good Luck");
        boolean hasWon = false;

        for (int i = 0; i < 10; i++) {
            System.out.println("Guess number " + i + " put your number: ");
            int guess = input.nextInt();
            if (guess == randomNumber) {
                hasWon = true;
                break;
            } else if (guess > randomNumber) {
                System.out.println("nobe you are wrong " + guess + " is greater ");
            } else
                System.out.println("nobe you are wrong " + guess + " is smaller ");
        }
        if (hasWon)
            System.out.println("YOU WIN Congrats you make it");
        else System.out.println("Unfortunately you lose :(  the RandomNumber is " + randomNumber);
    }
}
