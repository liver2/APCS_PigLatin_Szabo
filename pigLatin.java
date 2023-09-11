// Liver Szabo. 9/8/2023. Pig Latin Assignment.
import java.util.Scanner;
import java.util.ArrayList;

public class pigLatin {
    public static void main(String[] args) {
        System.out.println("Pig Latin Translator"); //Intro
        System.out.print("Please input a phrase: "); //Field for user to input

        Scanner stringScan = new Scanner(System.in); //Creates a new scanner
        String phrase = stringScan.nextLine() + " "; //note on debug1 8:51pm 9/8/2023: phrase scanning worked.
        int phraseLen = phrase.length();

        ArrayList<String> words = new ArrayList<String>(); // resizing arrays are important lmfao
        int cursorStart = 0;

        for (int i = 0; i < phraseLen; i++) {
            if (phrase.substring(i,i+1).equals(" ")) {
                words.add(phrase.substring(cursorStart, i));
                cursorStart = i+1;
            }
        }

        int numWords = words.size();

        for (int j = 0; j < numWords; j++) {
            for (int k = 0; k < words.get(j).length(); k++) {
                if (words.get(j).substring(0,1).toLowerCase().compareTo("a") != 0 && 
                    words.get(j).substring(0,1).toLowerCase().compareTo("e") != 0 && 
                    words.get(j).substring(0,1).toLowerCase().compareTo("i") != 0 && 
                    words.get(j).substring(0,1).toLowerCase().compareTo("o") != 0 && 
                    words.get(j).substring(0,1).toLowerCase().compareTo("u") != 0) {
                        words.set(j, words.get(j).substring(1) + words.get(j).substring(0,1));
                } else if (k == 0) {
                        words.set(j, words.get(j) + "way");
                        break;
                } else {
                        words.set(j, words.get(j) + "ay");
                        break;
                }
            }
        }

        System.out.println("Your phrase in Pig Latin (all in lowercase):");

        for (int k = 0; k < numWords; k++) {
            System.out.print(words.get(k).toLowerCase() + " ");
        }
    }
}