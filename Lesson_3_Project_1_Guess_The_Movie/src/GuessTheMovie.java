import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GuessTheMovie {


    public static void main(String[] args) throws FileNotFoundException {
        //get the movies list
        File moviesFile = new File("movies.txt");
        Scanner input = new Scanner(moviesFile);
        List<String> list = new LinkedList<>();
        while (input.hasNextLine())
            list.add(input.nextLine());

        //pick a random movieTitle
        int randomMovieNum = (int) (Math.random() * list.size());
        String movieTitle = list.get(randomMovieNum);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < movieTitle.length(); i++) {
            if (movieTitle.charAt(i) != ' ') builder.append("_");
            else builder.append(' ');
        }
        input = new Scanner(System.in);
        String movieGuess = builder.toString();
        StringBuilder wrongLetters = new StringBuilder();
        int guesses = 0;
        boolean hasWon = false;

        while (guesses != 10) {
            //Start the Game
            builder = new StringBuilder();
            builder.append("You are guessing :")
                    .append(movieGuess)
                    .append("\nYou have guessed (")
                    .append(guesses)
                    .append(") wrong letters:")
                    .append(wrongLetters.toString())
                    .append("\nGuess a letter :");
            System.out.print(builder.toString());
            //get Character from the user
            char guess = input.next().charAt(0);
            if (movieTitle.contains(Character.toString(guess))) {
                builder = new StringBuilder();
                for (int i = 0; i < movieGuess.length(); i++) {
                    char c = (guess != movieTitle.charAt(i)) ? movieGuess.charAt(i) : guess;

                    builder.append(c);
                }
                movieGuess = builder.toString();
            } else if (!wrongLetters.toString().contains(Character.toString(guess))) {
                wrongLetters.append(" ").append(guess);
                guesses++;
            }


            if (movieTitle.equals(movieGuess)) {
                hasWon = true;
                break;
            }
        }
        String finalMsg = (hasWon)
                ? "You Win!\nYou have guessed '" + movieTitle + "' correctly."
                : "You Lost!\nThe correct Answer is '" + movieTitle + "'";
        System.out.println(finalMsg);
        input.close();
    }
}
