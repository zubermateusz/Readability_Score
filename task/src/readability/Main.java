package readability;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //. ! ?
        // average > 10 HARD
        // average <= 10 EASY
        Scanner scanner = new Scanner(System.in);

        String[] sentences = scanner.nextLine().split("[.?!]"); // add every sentence to table

        int[] wordCounter = new int[sentences.length];
        for (int i = 0; i < sentences.length; i++) {
            wordCounter[i] = sentences[i].split(" ").length;
        }

        int sum = 0;
        for (int j : wordCounter) {
            sum += j;
        }

        String output = sum / wordCounter.length > 10 ? "HARD" : "EASY";
        System.out.println(output);
    }
}
