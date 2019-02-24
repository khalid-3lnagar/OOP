import java.util.Scanner;

public class Game {
    private String movieTitle, unknownLetters;
    private int wrongGuesses = 0;
    private StringBuilder wrongLetters;


    public Game(String movieTitle) {
        this.movieTitle = movieTitle;
        unknownLetters = getUnknownLetters();
        wrongLetters = new StringBuilder();

    }

    public boolean init() {
        //Start the Game
        Scanner input = new Scanner(System.in);
        while (wrongGuesses != 10) {
            System.out.print(getStartMessage());

            //get Character from the user
            char guess = input.next().charAt(0);

            if (movieTitle.contains(Character.toString(guess)))
                addKnownLetter(guess);
            else
                wrongLetter(guess);

            if (movieTitle.equals(unknownLetters)) {
                input.close();
                return true;

            }
        }
        input.close();
        return false;
    }

    private String getStartMessage() {
        return "You are guessing :" + unknownLetters +
                "\nYou have guessed (" + wrongGuesses + ") wrong letters:" + wrongLetters.toString() +
                "\nGuess a letter :";
    }

    private String getUnknownLetters() {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < movieTitle.length(); i++) {
            char c = (movieTitle.charAt(i) == ' ') ? ' ' : '_';
            builder.append(c);
        }
        return builder.toString();

    }

    private void addKnownLetter(char guess) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < unknownLetters.length(); i++) {
            char c = (guess != movieTitle.charAt(i)) ? unknownLetters.charAt(i) : guess;

            builder.append(c);
        }
        unknownLetters = builder.toString();
    }

    private void wrongLetter(char c) {
        if ((!wrongLetters.toString().contains(Character.toString(c)))) {
            wrongLetters.append(" ").append(c);
            this.wrongGuesses++;
        }


    }


}
