// These import statements bring Java utility classes from the java.util package
// They allow to use these without having to write them from scratch
import java.util.ArrayList; // Stores the player's guess history
import java.util.Random; // Picks a random secret number
import java.util.Scanner; // Lets the player enter guesses

// This class implements the Game interface, it defines the methods: start(), play() ans isOver()
// This uses the implements keyword to create the interface, this was part of the project requirements
public class GuessTheNumberGame implements Game {
    // These are the instance variables 
    private final int maxAttempts = 5; //Controls the number of guesses
    private final int lowerBound = 1; // Lower range of the numbers in the game
    private final int upperBound = 100; // Upper range of the numbers in the game
    private int secretNumber; // Stores the random number the user has to guess
    private int attempts; // Keeps track of how many guesses the player has made
    private boolean gameOver; // This is a condition which checks if the game is over or not
    private ArrayList<Integer> guessHistory; // Stores the list of guesses using ArrayList from Java Collection Framework
    private Scanner scanner; // This is used to read the input from the player

    // This initializes the scanner and guessHistory list
    // Calls reset() to set up the game, generates the random number and resets the player attempts
    // Uses ArrayList data structure from Java Collection Framework
    public GuessTheNumberGame() {
        scanner = new Scanner(System.in);
        guessHistory = new ArrayList<>();
        reset();
    }

    // In Java, functions must be defined inside a class and they are called methods
    // This is the reset() method, it generates the random number using the lowerBound and upperBound
    // Clears the guessHistory so we can start a new game
    // Resets the gameOver and attempts the player has made
    private void reset() {
        Random rand = new Random();
        secretNumber = rand.nextInt(upperBound - lowerBound + 1) + lowerBound;
        attempts = 0;
        gameOver = false;
        guessHistory.clear();
    }

    // This is the start() method from the interface, @Override shows this is fullfilling the Game interface
    // It starts the game, welcomes the player and explains the rules of the game
    @Override
    public void start() {
        System.out.println("🕹️ Welcome to Guess the Secret Number using Java! 🎯");
        System.out.println();
        System.out.printf("I'm thinking of a number between %d and %d.\n", lowerBound, upperBound);
        System.out.printf("You have %d attempts to guess the secret number.\n", maxAttempts);
    }

    // This is the play() method from the interface, it is a loop that runs until the game is over
    // It gets the user's guess and stores it in guessHistory
    // Each time the player guesses a number, it increments the number of attempts
    @Override
    public void play() {
        while (!isOver()) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            guessHistory.add(guess);
            attempts++;

            if (guess == secretNumber) {
                System.out.println("🎉 You are too smart! Congratulations! You guessed the secret number! 🎉"); // If the player guesses the secret number, the game ends with this nice message
                gameOver = true;
            } else if (guess < secretNumber) {
                System.out.println("⬇️ Your guess is too low!"); // I give feedback on weather the number guessed was too low or too high 
            } else {
                System.out.println("⬆️ Your guess is too high!");
            }

            if (attempts >= maxAttempts && !gameOver) {
                System.out.println("❌ Sorry! You've used all your attempts. ❌ "); // if the user reached the max number of guesses and still din't guess right, the game ends with this message
                System.out.println("The secret number was: " + secretNumber); // The secret number is shown when the player loses the game
                gameOver = true;
            }
        }

        System.out.println("➡️ These were your guesses: " + guessHistory); // After the game loop, it prints out all the player guesses as an array
    }

    // This isOver() method checks and returns if the game is over 
    @Override
    public boolean isOver() {
        return gameOver;
    }
}
