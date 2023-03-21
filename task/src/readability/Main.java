package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        //. ! ?
        // average > 10 HARD
        // average <= 10 EASY
            //Scanner scanner = new Scanner(new File(args[0]));
        StringBuilder text = new StringBuilder();
        /*
        while (scanner.hasNext()) {
            text.append(scanner.nextLine());
        }
        scanner.close();
        */
        text.append("This is the front page of the Simple English Wikipedia. Wikipedias are places where people work together to write encyclopedias in different languages. We use Simple English words and grammar here. The Simple English Wikipedia is for everyone! That includes children and adults who are learning English. There are 142,262 articles on the Simple English Wikipedia. All of the pages are free to use. They have all been published under both the Creative Commons License and the GNU Free Documentation License. You can help here! You may change these pages and make new pages. Read the help pages and other good pages to learn how to write pages here. If you need help, you may ask questions at Simple talk. Use Basic English vocabulary and shorter sentences. This allows people to understand normally complex terms or phrases.");

        System.out.println("The text is:");
        System.out.println(text);

        List<String> sentences = Arrays.asList(text.toString().split("[.?!]"));// add every sentence to table
        List<String> words = Arrays.asList(text.toString().split(" ")); // add every character to table
        int characters = text.toString().replaceAll(" ", "").length(); // add every character to table

        System.out.println("Words: " + words.size());
        System.out.println("Sentences: " + sentences.size());
        System.out.println("Characters: " + characters);

        // count syllable (a, e, i, o, u, y - vowels)
        int syllable = 0;
        int polysyllable = 0;
        for (int i = 0; i < words.size(); i++) { //[cat] [rat] [mat]
            int[] tab = countSyllables(words.get(i));
            syllable += tab[0];
            polysyllable += tab[1];
        }

        System.out.println("Syllables: " + syllable);


        System.out.println("Polysyllables: " + polysyllable);

        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        Scanner scanner2 = new Scanner(System.in);

        switch (scanner2.nextLine()) {
            case "ARI" -> {
                System.out.println();
                System.out.println(printScore(ARI(characters, words.size(), sentences.size())));
            }
            case "FK" -> {
                System.out.println();
                System.out.println(printScore(FK(syllable, words.size(), sentences.size())));
            }
            case "SMOG" -> {
                System.out.println();
                System.out.println(printScore(SMOG(polysyllable, sentences.size())));
            }
            case "CL" -> {
                System.out.println();
                System.out.println(printScore(CL(characters, words.size(), sentences.size())));
            }
            case "all" -> {
                System.out.println();
                System.out.println(printScore(ARI(characters, words.size(), sentences.size())));
                System.out.println(printScore(FK(syllable, words.size(), sentences.size())));
                System.out.println(printScore(SMOG(polysyllable, sentences.size())));
                System.out.println(printScore(CL(characters, words.size(), sentences.size())));
                // past every method
            }
        }

    }

    static int[] countSyllables(String word) {
        String i = "(?i)[aiou][aeiou]*|e[aeiou]*(?!d?\\b)";
        Matcher m = Pattern.compile(i).matcher(word);
        int syllables = 0;
        while (m.find()) {
                syllables++;
        }
        int[] tab = new int[2];
        // return at least 1
        tab[0] = Math.max(syllables, 1);  //number of syllables
        tab[1] += syllables >= 2 ? 1 : 0; //number of polysyllables
        return tab;
    }

    static double ARI(int NumberOfCharacters, int numberOfWords, int numberOfSentences) {
        return (4.71 * ((double)NumberOfCharacters/ numberOfWords) + 0.5 * (double)numberOfWords/ numberOfSentences - 21.43);
    }

    static double FK(int syllables, int numberOfWords, int numberOfSentences) {
        return (0.39 * ((double)numberOfWords/numberOfSentences) + 11.8 * (double)syllables/ numberOfWords - 15.59);
    }
    static double SMOG(int polysyllables,  int numberOfSentences) {
        return (1.043 * Math.sqrt((double)polysyllables * 30 / numberOfSentences) + 3.1291);
    }
    static double CL(int numberOfCharacters, int numberOfWords, int numberOfSentences) {
        return (0.0588 * (double)numberOfCharacters/numberOfWords * 100 - 0.296 * (double)numberOfSentences / numberOfWords - 15.8);
    }

    static String printScore(double score) {
        String outputYears = "";
        double tempScore = score;
        return("" + tempScore + " (about " + (tempScore + 6 )+ "-year-olds).");
    }

}
