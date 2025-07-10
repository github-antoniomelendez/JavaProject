// This is the main function used to run the program
// It starts the game and uses the code in GuessTheNumberGame to play the game
public class Main {
    public static void main(String[] args) {
        Game game = new GuessTheNumberGame();
        game.start();
        game.play();
    }
}
