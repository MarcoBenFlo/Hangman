package RST;
import simpleIO.Console;
public class WordGuessExampleCode {

	 //Constants
    static final String SECRET_WORD = "TECHNOLOGY";
    static final char FLAG = '!';

    public static void main(String[] args) {

        //Variables
        String wordSoFar = "", wordGuess = "";
        char letterGuess;
        int numGuesses = 0;

        Console.print("Welcome to Word Guess");

        //create the word to display to the screen, with each letter replaced by a dash
        for (int i = 0; i < SECRET_WORD.length(); i++) {
            wordSoFar += '-';
        }

        do {
            //print word (mix of dashes and letters) to the screen
            Console.print("\n" + wordSoFar);

            //get a guess from the user
            letterGuess = Console.readChar("Enter a letter (" + FLAG + " to guess entire word)");

            //Keep track of number of guesses user needed - this counts both correct & incorrect guesses,
            //as well as the option to guess the entire word
            numGuesses++;

            //update the word to be printed to the screen
            wordSoFar = updateWord(letterGuess, wordSoFar);

            //continue looping until they either choose to guess, or the word is fully revealed
        } while (letterGuess != FLAG && !wordSoFar.equals(SECRET_WORD));

        if (letterGuess == FLAG) {
            wordGuess = Console.readString("You want to guess the word! What is your guess?");
        }

        //user can win be either guessing the word, or getting all the letters
        if (SECRET_WORD.equalsIgnoreCase(wordGuess) || SECRET_WORD.equals(wordSoFar)) {
            Console.print("You win!");
        } else {
            Console.print("You lose");
        }

        //Final output to screen
        Console.print("The secret word is " + SECRET_WORD);
        Console.print("You made " + numGuesses + " guesses.");

    }

    public static String updateWord(char letterGuess, String wordSoFar) {

        // start looking at position 0
        int beginSearch = 0;

        //Convert guess to uppercase
        letterGuess = Character.toUpperCase(letterGuess);

        //Check if this letter is actually in the word
        while (SECRET_WORD.indexOf(letterGuess, beginSearch) >= 0) {
            // save the location of the found letter
            int index = SECRET_WORD.indexOf(letterGuess, beginSearch);

            // extract string in wordSoFar up to the letter guessed
            String updatedWord = wordSoFar.substring(0, index);
            // append guessed letter to that string.
            updatedWord += letterGuess;
            // extract rest of wordSoFar and append after the guessed letter
            updatedWord += wordSoFar.substring(index + 1, wordSoFar.length());

            // update the word
            wordSoFar = updatedWord;

            // continue to check for more of the same letter
            beginSearch = index + 1;
        }

        return wordSoFar;

    }
    

}