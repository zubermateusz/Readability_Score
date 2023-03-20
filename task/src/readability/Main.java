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

        double score = (4.71 * ((double)characters/ words.size()) + 0.5 * (double)words.size()/ sentences.size() - 21.43);
        System.out.format("The score is: %.2f%n", score);

        String outputYears = "";
        int tempScore = (int) Math.ceil(score);
        if (tempScore <= 13) {
            outputYears = "" + tempScore + 4 + "-" + tempScore + 5;
        } else if (tempScore == 14) {
            outputYears = "" + tempScore + 4 + "-" + tempScore + 8;
        }



        System.out.println("This text should be understood by " + outputYears+ " year-olds.");
        /*
        //String output = sum / wordCounter.length > 10 ? "HARD" : "EASY";
        //System.out.println(output);
         */



    }
}
