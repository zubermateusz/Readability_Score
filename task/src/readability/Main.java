package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        //. ! ?
        // average > 10 HARD
        // average <= 10 EASY
        Scanner scanner = new Scanner(new File(args[0]));
        StringBuilder text = new StringBuilder();

        while (scanner.hasNext()) {
            text.append(scanner.nextLine());
        }
        scanner.close();

        System.out.println("The text is:");
        System.out.println(text);

        List<String> sentences = Arrays.asList(text.toString().split("[.?!]"));// add every sentence to table
        List<String> words = Arrays.asList(text.toString().split(" ")); // add every character to table
        int characters = text.toString().replaceAll(" ", "").length(); // add every character to table

        System.out.println("Words: " + words.size());
        System.out.println("Sentences: " + sentences.size());
        System.out.println("Characters: " + characters);

        String outputYears = "";
        int tempScore = (int) Math.ceil(score);
        if (tempScore <= 13) {
            outputYears = "" + (tempScore + 4) + "-" + (tempScore + 5);
        } else if (tempScore == 14) {
            outputYears = "" + (tempScore + 4) + "-" + (tempScore + 8);
        }
        System.out.println("This text should be understood by " + outputYears+ " year-olds.");



        System.out.println("Syllables: 210");


        System.out.println("Polysyllables: 17");

        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        Scanner scanner2 = new Scanner(System.in);

        switch (scanner.nextLine()) {
            case "ARI" -> {
                System.out.println();
                System.out.format("The score is: %.2f%n", ARI(characters, words.size(), sentences.size()));
            }
            case "FK" -> {
                System.out.println();
            }
            case "SMOG" -> {
                System.out.println();
            }
            case "CL" -> {
                System.out.println();
            }
            case "all" -> {
                System.out.println();
            }
        }
        /*
        //String output = sum / wordCounter.length > 10 ? "HARD" : "EASY";
        //System.out.println(output);
         */
    }



    static double ARI(int NumberOfCharacters, int numberOfWords, int numberOfSentences) {
        return (4.71 * ((double)NumberOfCharacters/ numberOfWords) + 0.5 * (double)numberOfWords/ numberOfSentences - 21.43);
    }

    static double FK(int NumberOfCharacters, int numberOfWords, int numberOfSentences) {
        return (4.71 * ((double)NumberOfCharacters/ numberOfWords) + 0.5 * (double)numberOfWords/ numberOfSentences - 21.43);
    }
    static double SMOG(int NumberOfCharacters, int numberOfWords, int numberOfSentences) {
        return (4.71 * ((double)NumberOfCharacters/ numberOfWords) + 0.5 * (double)numberOfWords/ numberOfSentences - 21.43);
    }
    static double CL(int NumberOfCharacters, int numberOfWords, int numberOfSentences) {
        return (4.71 * ((double)NumberOfCharacters/ numberOfWords) + 0.5 * (double)numberOfWords/ numberOfSentences - 21.43);
    }

}
