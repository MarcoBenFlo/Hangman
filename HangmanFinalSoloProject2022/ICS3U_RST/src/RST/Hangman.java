/**
 * 
 */
package RST;
import simpleIO.Console;
/**
 * @author MarcoFlores
 *
 */
public class Hangman {
	/**
	 * @author Marco Flores
	 *ICS3UR
	 * Date: June 24
	 * Hangman.java
	 * 
	 *  An application that runs a game of Hangman

	/**
	 * @param args
	 */
/// variable created for when the user enters ! they may guess the whole word
	static final char FLAG = '!';

	public static void main(String[] args) {
/// welcome menu
		Console.print("Welcome to Hangman!");
		Console.print();
		Console.print();
		Console.print("Hangman is a simple word guessing game.");
		Console.print("You will try to figure out an unknown word by guessing letters");
		Console.print("If too many letters which do not appear in the word are guessed, you lose"); 
		Console.print("You have 16 lives before the man is hung. Save him!!"); 
		Console.print();
///variables created so when 0 is entered by the user at the start of every do loop, and question = QUIT the program ends
		final int QUIT = 0;
		int question;
do {
	
///variables set at the start of every do while loop as long as the user doesn't enter 0
	String wordSoFar = "";
	String wordGuess = "";
	char letterGuess;
	int livesLost = 0;
	String wordToBeGuessed = "";
	String newWord = "";
///user prompted for the question whether they'd like to continue or not
			question = Console.readInt("Would you like to run this program? Enter any number to continue or 0 to end the program");
			Console.print("");

			///user chooses from the 20 word categories from the category menu
			if (question > 0 || question < 0) {
				Console.print("");
				Console.print("There are 20 different categories of words to guess to chose from");
				Console.print("");
				Console.print("-----------------------------------------------------------------------------------------------------------------------------------------------------");
				Console.print("");
				Console.print("1 - Bonus Category    2 - Two Letter Word    3 - Three Letter Word    4 - Four Letter Word    5 - Five Letter Word    6- Six Letter Word");
				Console.print("");
				Console.print("7 - Seven Letter Word    8 - Eight Letter Word    9 - Nine Letter Word    10 - Ten Letter Word    11- Eleven Letter Word    12- Twelve Letter Word");
				Console.print("");
				Console.print("13 - Movies    14 - Books    15 - Star Wars    16 - Countries    17 - Elements    18 - Animals    19 - Food    20 - Computer Science Vocabulary");
				Console.print("");
				Console.print("-----------------------------------------------------------------------------------------------------------------------------------------------------");
				Console.print("");
				int wordCategory = Console.readInt("Enter a number between 1-20: ");
				///ensures the word is between 1-20
				if (wordCategory > 0 && wordCategory < 21) {
					///20 different arrays for words to be randomly selected for each category
					String[] bestteacherWord = { "spindler", "spindler", "spindler", "spindler", "spindler", "spindler", "spindler", "spindler", "spindler", "spindler", "spindler", "spindler" };
					String[] twoLetterWord = { "am", "in", "he", "hi", "do", "at", "go", "be", "as", "in", "on", "if" };
					String[] threeLetterWord = { "ace", "cat", "dog", "ham", "win", "not", "pan", "rat", "ion", "pig", "pot", "hat" };
					String[] fourLetterWord = { "pear", "code", "corn", "apes", "clue", "burn", "dock", "iron", "pack", "ears", "nose", "load"};
					String[] fiveLetterWord = { "stink", "phone", "trust", "scram", "alarm", "first", "right", "smack", "smash", "units", "bounce", "clash" };
					String[] sixLetterWord = { "should", "listen", "forest", "demand", "market", "danger", "symbol", "social", "bishop", "camera", "custom", "course" };
					String[] sevenLetterWord = { "chicken", "factory", "victory", "musical", "strange", "founder", "default", "auction", "convert", "husband", "violent", "student" };
					String[] eightLetterWord = { "industry", "numerous", "reaction", "romantic", "teaching", "tropical", "universe", "symbolic", "firewall", "graphics", "humanity", "judgment" };
					String[] nineLetterWord = { "equalizer", "fabulated", "macadamia", "quadratic", "adulthood", "political", "questions", "resources", "situation", "character", "knowledge", "available" };
					String[] tenLetterWord = { "government", "philosophy", "population", "university", "expression", "literature", "employment", "appearance", "successful", "technology", "determined", "revolution" };
					String[] elevenLetterWord = { "eagernesses", "fabricating", "vaccinating", "abandonment", "marshmallow", "belligerent", "imagination", "personality", "photography", "certificate", "exterminate", "agriculture" };
					String[] twelveLetterWord = { "alliteration", "unidentified", "championship", "civilization", "trigonometry", "onomatopoeia", "appreciation", "intimidating", "relationship", "organization", "professional", "colonization" };
					String[] moviesWord = { "megamind", "rango", "spiderman", "it", "scream", "ghostbusters", "lightyear", "morbius", "batman", "parasite", "godfather", "interstellar" };
					String[] booksWord = { "frankenstein", "hobbit", "hamlet", "matilda", "goosebumps", "twilight", "paddington", "dictionary", "wonder", "hungergames", "pinocchio", "cinderella" };
					String[] starwarsWord = { "luke", "leia", "skywalker", "yoda", "padawan", "republic", "chewbacca", "palpatine", "mandolorian", "grievous", "kenobi", "stormtrooper" };
					String[] countriesWord = { "italy", "germany", "russia", "china", "uruguay", "mexico", "canada", "australia", "croatia", "thailand", "portugal", "japan" };
					String[] elementsWord = { "hydrogen", "potassium", "titatium", "platinum", "tungsten", "flourine", "magnesium", "lithium", "beryllium", "chlorine", "lithium", "helium" };
					String[] animalsWord = { "monkey", "cheetah", "elephant", "snake", "bear", "birds", "turtle", "duck", "otter", "dolphin", "chicken", "giraffe" };
					String[] foodWord = { "cookies", "donuts", "popcorn", "poutine", "fajitas", "lasagna", "croissant", "pierogi", "hamburger", "sushi", "chocolate", "pancakes" };
					String[] csVocabWord = { "ergonomic", "repository", "github", "variable", "statement", "operator", "algorithm", "method", "array", "eclipse", "console", "dialog" };

					///switch case for each one of the categories, to randomly select one of the 12 words in the array then setting it as "wordToBeGuessed"
					switch (wordCategory) {
					case 1:
						Console.print("BONUS: Who is the best teacher");
						wordToBeGuessed = bestteacherWord[randomNumber(0,11)];
						break;
					case 2:
						wordToBeGuessed = twoLetterWord[randomNumber(0,11)];
						break;
					case 3:
						wordToBeGuessed = threeLetterWord[randomNumber(0,11)];
						break;
					case 4:
						wordToBeGuessed = fourLetterWord[randomNumber(0,11)];
						break;
					case 5:
						wordToBeGuessed = fiveLetterWord[randomNumber(0,11)];
						break;
					case 6:
						wordToBeGuessed = sixLetterWord[randomNumber(0,11)];
						break;
					case 7:
						wordToBeGuessed = sevenLetterWord[randomNumber(0,11)];
						break;
					case 8:
						wordToBeGuessed = eightLetterWord[randomNumber(0,11)];
						break;
					case 9:
						wordToBeGuessed = nineLetterWord[randomNumber(0,11)];
						break;
					case 10:
						wordToBeGuessed = tenLetterWord[randomNumber(0,11)];
						break;
					case 11:
						wordToBeGuessed = elevenLetterWord[randomNumber(0,11)];
						break;
					case 12:
						wordToBeGuessed = twelveLetterWord[randomNumber(0,11)];
						break;
					case 13:
						wordToBeGuessed = moviesWord[randomNumber(0,11)];
						break;
					case 14:
						wordToBeGuessed = booksWord[randomNumber(0,11)];
						break;
					case 15:
						wordToBeGuessed = starwarsWord[randomNumber(0,11)];
						break;
					case 16:
						wordToBeGuessed = countriesWord[randomNumber(0,11)];
						break;
					case 17:
						wordToBeGuessed = elementsWord[randomNumber(0,11)];
						break;
					case 18:
						wordToBeGuessed = animalsWord[randomNumber(0,11)];
						break;
					case 19:
						wordToBeGuessed = foodWord[randomNumber(0,11)];
						break;
					case 20:
						wordToBeGuessed = csVocabWord[randomNumber(0,11)];
						break;
					

					}
					/// sets wordSoFar as - for each variable
					for (int i = 0; i < wordToBeGuessed.length(); i++) {
						wordSoFar += '-';
					}
					///do statement for guessing the word
					do {
						///prints the dashes to be guessed
						Console.print("\n" + wordSoFar);
						///allows the user to enter a letter or ! to guess the whole word
						letterGuess = Console.readChar("Enter a letter (" + FLAG + " to guess entire word)");
						///sets all letters guessed to lowercase
						 letterGuess = Character.toLowerCase(letterGuess);
						 ///sets the newWord as the updated word with the dashes and correctly guessed letters
						newWord = updateWord(letterGuess, wordSoFar, wordToBeGuessed);
						///when wordSoFar remains unchanaged after a letter guess, the livesLost goes up
						if (wordSoFar == newWord) {
							livesLost++;
						}
						///if ! is entered by the user, this insures that the the program doesn't perceive ! as a variable being guessed by subtracting 1 live lost for the !
						if (letterGuess == FLAG) {
							livesLost = livesLost-1;
						}
						wordSoFar = newWord;
				///displays for the hangman all depending on how many lives are lost
						switch (livesLost) {
						case 0:
						Console.print("");
						Console.print("");
						Console.print("");
						Console.print("");
						Console.print("");
						Console.print("");
						Console.print("");
						Console.print("");
						Console.print("Lives Lost: " + livesLost);
							break;
						case 1:
							Console.print("");
							Console.print("");
							Console.print("");
							Console.print("");
							Console.print("");
							Console.print("");
							Console.print("|");
							Console.print("|");		
							Console.print("");
							Console.print("Lives Lost: " + livesLost);
							Console.print("");
							break;
						case 2:
							Console.print("");
							Console.print("");
							Console.print("");
							Console.print("");
							Console.print("|");
							Console.print("|");
							Console.print("|");
							Console.print("|");
							Console.print("");
							Console.print("Lives Lost: " + livesLost);
							Console.print("");
							break;
						case 3:
							Console.print("");
							Console.print("|");
							Console.print("|");
							Console.print("|");
							Console.print("|");
							Console.print("|");
							Console.print("|");
							Console.print("|");
							Console.print("");
							Console.print("Lives Lost: " + livesLost);
							Console.print("");
							break;
						case 4:
							Console.print("  _____");
							Console.print(" /    ");
							Console.print("|     ");
							Console.print("|");
							Console.print("|");
							Console.print("|");
							Console.print("|");
							Console.print("|");
							Console.print("");
							Console.print("Lives Lost: " + livesLost);
							Console.print("");
							break;
						case 5:
							Console.print("  _____");
							Console.print(" /    |");
							Console.print("|     *");
							Console.print("|");
							Console.print("|");
							Console.print("|");
							Console.print("|");
							Console.print("|");
							Console.print("");
							Console.print("Lives Lost: " + livesLost);
							Console.print("");
							break;
						case 6:
							Console.print("  _____");
							Console.print(" /    |");
							Console.print("|     *");
							Console.print("|     O");
							Console.print("|");
							Console.print("|");
							Console.print("|");
							Console.print("|");	
							Console.print("");
							Console.print("Lives Lost: " + livesLost);
							Console.print("");
							break;
						case 7:
							Console.print("  _____");
							Console.print(" /    |");
							Console.print("|     *");
							Console.print("|     O");
							Console.print("|     |");
							Console.print("|");
							Console.print("|");
							Console.print("|");	
							Console.print("");
							Console.print("Lives Lost: " + livesLost);
							Console.print("");
							break;
						case 8:
							Console.print("  _____");
							Console.print(" /    |");
							Console.print("|     *");
							Console.print("|     O");
							Console.print("|     |");
							Console.print("|     |");
							Console.print("|");
							Console.print("|");		
							Console.print("");
							Console.print("Lives Lost: " + livesLost);
							Console.print("");
							break;
						case 9:
							Console.print("  _____");
							Console.print(" /    |");
							Console.print("|     *");
							Console.print("|     O");
							Console.print("|    -|");
							Console.print("|     |");
							Console.print("|");
							Console.print("|");	
							Console.print("");
							Console.print("Lives Lost: " + livesLost);
							Console.print("");
							break;
						case 10:
							Console.print("  _____");
							Console.print(" /    |");
							Console.print("|     *");
							Console.print("|     O");
							Console.print("|   --|");
							Console.print("|     |");
							Console.print("|");
							Console.print("|");	
							Console.print("");
							Console.print("Lives Lost: " + livesLost);
							Console.print("");
							break;
						case 11:
							Console.print("  _____");
							Console.print(" /    |");
							Console.print("|     *");
							Console.print("|     O");
							Console.print("|  ---|");
							Console.print("|     |");
							Console.print("|");
							Console.print("|");		
							Console.print("");
							Console.print("Lives Lost: " + livesLost);
							Console.print("");
							break;
						case 12:
							Console.print("  _____");
							Console.print(" /    |");
							Console.print("|     *");
							Console.print("|     O");
							Console.print("|  ---|-");
							Console.print("|     |");
							Console.print("|");
							Console.print("|");	
							Console.print("");
							Console.print("Lives Lost: " + livesLost);
							Console.print("");
							break;
						case 13:
							Console.print("  _____");
							Console.print(" /    |");
							Console.print("|     *");
							Console.print("|     O");
							Console.print("|  ---|--");
							Console.print("|     |");
							Console.print("|");
							Console.print("|");		
							Console.print("");
							Console.print("Lives Lost: " + livesLost);
							Console.print("");
							break;
						case 14:
							Console.print("  _____");
							Console.print(" /    |");
							Console.print("|     *");
							Console.print("|     O");
							Console.print("|  ---|---");
							Console.print("|     |");
							Console.print("|");
							Console.print("|");
							Console.print("");
							Console.print("Lives Lost: " + livesLost);
							Console.print("");
							break;
						case 15:
							Console.print("  _____");
							Console.print(" /    |");
							Console.print("|     *");
							Console.print("|     O");
							Console.print("|  ---|---");
							Console.print("|     |");
							Console.print("|    /  ");
							Console.print("|");							
							Console.print("");
							Console.print("Lives Lost: " + livesLost);
							Console.print("");
							break;
						
						}

					
					

						///for the do statement of the word guessing, setting the do statement to end only when one of this is true 
					} while (letterGuess != FLAG && !wordSoFar.equals(wordToBeGuessed) && livesLost != 16);


					
					///when letter is !, the user is promped to guess the whole word
					if (letterGuess == FLAG) {
						wordGuess = Console.readString("You want to guess the word! What is your guess?");
					}
						
					///if the letter guess doesn't = !, all the variables are reset to be used in the closing statement.
				}else {
					wordSoFar = "";
					wordGuess = "";
					livesLost = 0;
					wordToBeGuessed = "not selected. Try again.";
					newWord = "";
				}
				/// when the word is guessed, the win message is displayed
					if (wordToBeGuessed.equalsIgnoreCase(wordGuess) || wordToBeGuessed.equals(wordSoFar)) {
						Console.print("You win!");
						/// when there is a loss because of the word not being guessed all at once, the lose message is displayed
					}else if (wordToBeGuessed != "not selected. Try again."){
						Console.print("You lose!");
					}
					
					
					/// when all 16 lives are lost, the full hangman is hung and the lose message is displayed
					if (livesLost == 16){
						Console.print("  _____");
						Console.print(" /    |");
						Console.print("|     *");
						Console.print("|     O");
						Console.print("|  ---|---");
						Console.print("|     |");
						Console.print("|    / \\ ");
						Console.print("|");		
						Console.print("You lose!");

					}
					///this closing message is always displayed, telling the user the lives lost and wordToBeGuessed, however wordToBeGuessed is replaced by "not selected. Try again." if the user guesses the wrong word
					Console.print("The secret word was " + wordToBeGuessed);
					Console.print("You lost " + livesLost + " lives.");




					 
		
		}
/// the while statement connected to the first do statement to end the game when the user enters 0 as question since QUIT=0
		} while (question != QUIT);


	
	}

///method to update word by replacing - with the correct letter guessed
    public static String updateWord(char letterGuess, String wordSoFar, String wordToBeGuessed) {

        // start looking at position 0
        int beginSearch = 0;

        //Check if this letter is actually in the word
        while (wordToBeGuessed.indexOf(letterGuess, beginSearch) >= 0) {
            // save the location of the found letter
            int index = wordToBeGuessed.indexOf(letterGuess, beginSearch);

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
///returns the updated word with the - replaced by the correctly guessed letters in that specific spot
        return wordSoFar;

    }
///takes the low and high number (in this case 0 and 11) and randomly selects a number equal or between the high and low number
		public static int randomNumber(int a, int b) {
			int highNum = Math.max(a, b);
			int lowNum = Math.min(a, b);
			int range = highNum - lowNum + 1;
			return (int) (Math.random() * range) + lowNum;
		}

	}

