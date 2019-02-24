import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GuessTheMovie {


    public static void main(String[] args) throws FileNotFoundException {
        //get the movies list

        File moviesFile = new File("movies.txt");
        if (!moviesFile.exists()) {
            System.out.println("File not found");
            return;
        }

        String movieTitle = getRandomMovieTitle(moviesFile);

        Game newGame = new Game(movieTitle);
        boolean hasWon = newGame.init();

        String finalMsg = getFinalMessage(hasWon, movieTitle);
        System.out.println(finalMsg);

    }

    private static String getFinalMessage(boolean hasWon, String movieTitle) {
        return (hasWon)
                ? "You Win!\nYou have guessed '" + movieTitle + "' correctly."
                : "You Lost!\nThe correct Answer is '" + movieTitle + "'";
    }

    private static String getRandomMovieTitle(File moviesFile) throws FileNotFoundException {
        Scanner input = new Scanner(moviesFile);
        List<String> list = new LinkedList<>();
        while (input.hasNextLine())
            list.add(input.nextLine());

        //pick a random movieTitle
        int randomMovieNum = (int) (Math.random() * list.size());
        return list.get(randomMovieNum);
    }
}
