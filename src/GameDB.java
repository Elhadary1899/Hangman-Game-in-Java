import java.util.ArrayList;
import java.util.Arrays;

public class GameDB {
    protected ArrayList<String> words = new ArrayList<>();

    GameDB(){
        this.setWords();
    }

    public void setWords(){
        words.addAll(Arrays.asList("apple", "tiger", "house", "water", "puzzle", "dragon",
                "mirror", "journey", "symphony", "hypothesis", "paradox", "phosphorus"));
    }

    public String getRandomWord(){
        int numIndx = (int)(Math.random()*12);
        return words.get(numIndx);
    }


    public void noMistake(){
        System.out.println("  ------");
        System.out.println(" |       ");
        System.out.println(" |       ");
        System.out.println(" |       ");
        System.out.println(" |       ");
        System.out.println(" |       ");
        System.out.println("---");

    }

    public void firstMistake(){
        System.out.println("  ------");
        System.out.println(" |      |");
        System.out.println(" |       ");
        System.out.println(" |       ");
        System.out.println(" |       ");
        System.out.println(" |       ");
        System.out.println("---");

    }

    public void secondMistake(){
        System.out.println("  ------");
        System.out.println(" |      |");
        System.out.println(" |      0");
        System.out.println(" |       ");
        System.out.println(" |       ");
        System.out.println(" |       ");
        System.out.println("---");

    }

    public void thirdMistake(){
        System.out.println("  ------");
        System.out.println(" |      |");
        System.out.println(" |      0");
        System.out.println(" |     /|\\");
        System.out.println(" |       ");
        System.out.println(" |       ");
        System.out.println("---");

    }

    public void fourthMistake(){
        System.out.println("  ------");
        System.out.println(" |      |");
        System.out.println(" |      0");
        System.out.println(" |     /|\\");
        System.out.println(" |      |");
        System.out.println(" |       ");
        System.out.println("---");
    }

    public void fifthMistake(){
        System.out.println("  ------");
        System.out.println(" |      |");
        System.out.println(" |      O");
        System.out.println(" |     /|\\");
        System.out.println(" |      |");
        System.out.println(" |     /|\\");
        System.out.println("---");
    }

    public void whichShape(int chances){
        switch(chances){
            case 5:
                noMistake();
                break;
            case 4:
                firstMistake();
                break;
            case 3:
                secondMistake();
                break;
            case 2:
                thirdMistake();
                break;
            case 1:
                fourthMistake();
                break;
            case 0:
                fifthMistake();
                break;
        }
    }

}
