import java.io.File;
import java.util.Scanner;

public class WordCount {

    public static void main(String[] args) throws Exception {
        // write your code here
        File file = new File("aTaleOfTwoCities.txt");
        Scanner input = new Scanner(file);
        int count = 0;
        while (input.hasNextLine())
            count += input.nextLine().split(" ").length;
        System.out.println("the book has " + count + " words");

    }
}
