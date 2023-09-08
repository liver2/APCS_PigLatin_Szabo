// Liver Szabo. 9/8/2023. Pig Latin Assignment.
import java.util.Scanner;
import java.util.ArrayList;

public class pigLatin {
    public static void main(String[] args) {
        System.out.println("Pig Latin Translator\n"); //Intro
        System.out.println("Please input a phrase: "); //Field for user to input

        Scanner stringScan = new Scanner(System.in); //Creates a new scanner
        String phrase = stringScan.nextLine();
        int phraseLen = phrase.length(); //length
        int numSpaces = 0; //used to count the number of spaces => words in phrase
        ArrayList<Integer> spacePosition = new ArrayList<Integer>();

        // -- Count the number of spaces in the phrase. -- 
        for (int i = 0; i < phraseLen; i++) { //looping through phrase individual characters
            if (phrase.substring(i,i).equals(" ")) {
                spacePosition.set(numSpaces, i); //add a space position marker at i. CAREFUL, index starts at zero i think.
                numSpaces++; //count up number of spaces
            }
        }

        int numWords = (numSpaces + 1); //number of words will be important for the next array: words[]

        String words[] = new String[numWords]; //make a new array words to store words. we will use this array and turn these words into piglat
        int spacePositionCursor = -1; //setting this to negative 1 so that the substring index will start at 0.

        for (int j = 0; j < numSpaces; j++) { //substring with loop
            words[j] = phrase.substring(spacePositionCursor + 1, spacePosition.get(j));
            spacePositionCursor = spacePosition.get(j);
        }

        System.out.println(words); //debug
    }
}