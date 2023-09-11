// Liver Szabo. 9/8/2023. Pig Latin Assignment.
import java.util.Scanner;
import java.util.ArrayList;

// public class pigLatin {
//     public static void main(String[] args) {
//         System.out.println("Pig Latin Translator\n"); //Intro
//         System.out.print("Please input a phrase: "); //Field for user to input

//         Scanner stringScan = new Scanner(System.in); //Creates a new scanner
//         String phrase = stringScan.nextLine(); //note on debug1 8:51pm 9/8/2023: phrase scanning worked.

//         int phraseLen = phrase.length(); //length
//         System.out.println("phraseLen = " + phraseLen);

//         int numSpaces = 0; //used to count the number of spaces => words in phrase
//         ArrayList<Integer> spacePosition = new ArrayList<Integer>();

//         // -- Count the number of spaces in the phrase. -- 
//         for (int i = 0; i < phraseLen; i++) { //looping through phrase individual characters
//             if (phrase.substring(i,i+1).equals(" ")) {
//                 numSpaces++; //count up number of spaces
//                 spacePosition.add(numSpaces); //add a space position marker at i. CAREFUL, index starts at i=0, I think.
//                 System.out.println("spacePosition #" + numSpaces + " set at string position " + i); // DEBUG
//             } else {
//                 spacePosition.add(0); //zero for nothing
//             }
//         }

//         int numWords = (numSpaces + 1); //number of words will be important for the next array: words[]
//         System.out.println("numWords = " + numWords);

//         String[] words = new String[numWords]; //make a new array words to store words. we will use this array and turn these words into piglat
//         int spacePositionCursor = -1; //setting this to negative 1 so that the substring index will start at 0.

//         for (int j = 0; j < numSpaces; j++) { //substring with loop
//             words[j] = phrase.substring(spacePositionCursor + 1, spacePosition.get(j));
//             spacePositionCursor = spacePosition.get(j);
//             System.out.println("word #" + j + ": " + words[j]);
//         }

//         for (int k = 0; k < numWords; k++) {
//             System.out.println(words[k]); //debug
//         }
//     }
// }

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
                if (words.get(j).substring(0,1) != "a" && words.get(j).substring(0,1) != "e" && 
                    words.get(j).substring(0,1) != "i" && words.get(j).substring(0,1) != "o" && 
                    words.get(j).substring(0,1) != "u" && words.get(j).substring(0,1) != "A" && 
                    words.get(j).substring(0,1) != "E" && words.get(j).substring(0,1) != "I" && 
                    words.get(j).substring(0,1) != "O" && words.get(j).substring(0,1) != "U") {
                        words.set(j, words.get(j).substring(1) + words.get(j).substring(0,1) + "yay");
                }
            }
        }

        System.out.println("Your phrase in Pig Latin:");

        for (int k = 0; k < numWords; k++) {
            System.out.print(words.get(k) + " ");
        }
    }
}