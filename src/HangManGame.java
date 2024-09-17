import java.util.ArrayList;
import java.util.Scanner;

public class HangManGame extends GameDB{
    private String word;
    private char guessedLetter = ' ';
    private int counter;
    private boolean won;

    public void start(){
        System.out.println("Welcome to the HangMan game:)\nYou need to guess the letters of the word and you will have 5 chances if you guessed wrong.\n");
        word = super.getRandomWord();
        counter=5;
        won = false;

        super.noMistake();
        for(int i=0;i<word.length();i++){
            System.out.print("_ ");
        }
        System.out.println();

        this.guessWord();

        if(won){
            this.hasWon();
        }else if(this.isLost()){
            this.hasLost();
        }
    }

    public void guessWord(){
        Scanner in = new Scanner(System.in);
        ArrayList<Character> hiddenWord = new ArrayList<>();
        for(int i=0;i<word.length();i++){
            hiddenWord.add('_');
        }

        while(!this.isWon(hiddenWord) && !this.isLost()){
            System.out.println("Guess a letter! you have " + counter + " chances.");
                while(true) {
                    try {
                        guessedLetter = in.next().charAt(0);
                        if (guessedLetter >= 65 && guessedLetter <= 122) {
                            break;
                        }
                    }catch (Exception e) {
                        System.out.println("Invalid input! try again");
                    }
                    System.out.println("Invalid input! try again");
                }
            boolean correct = false;

            for(int i=0;i<word.length();i++){
                if(word.charAt(i)==guessedLetter){
                    hiddenWord.set(i, guessedLetter);
                    correct = true;
                }
            }
            for(int i=0;i<word.length();i++){
                System.out.print(hiddenWord.get(i) + " ");
            }
            System.out.println();

            if(correct && !this.isWon(hiddenWord)) {
                System.out.println("You've got it right, keep going!\nYou still have " + counter + " chances.\n");
            }else if(!this.isLost() && !this.isWon(hiddenWord)){
                    counter--;
                    if(counter!=0) {
                        System.out.println("You've missed it.\nYou still have " + counter + "  chances.\n");
                    }else{
                        System.out.println("You've missed it.\nYou have no chances left.\n");
                    }
            }
            whichShape(counter);
        }

    }

    public boolean isWon(ArrayList<Character> hiddenWord){
        if(!hiddenWord.contains('_')){
            won = true;
            return true;
        }
        return false;
    }

    public boolean isLost(){
        return counter==0;
    }

    public void hasWon(){
        System.out.println("\n\nWell done, you have made it:)\nthe word was: " + this.word + "\n");
        this.playAgain();
    }

    public void hasLost(){
        System.out.println("\nHard luck next time, you lost :(\nthe word was: " + this.word + "\n");
        this.playAgain();
    }

    public void playAgain(){
        Scanner in = new Scanner(System.in);
        System.out.println("Do you want to play again? 'Y' for yes or 'N' for no: ");
        char choice = in.next().charAt(0);

        if(choice=='Y' || choice=='y'){
            System.out.println("\n\n");
            this.start();
        }else{
            System.out.println("\nthanks for playing the game :)");
            System.exit(0);
        }
    }

}
