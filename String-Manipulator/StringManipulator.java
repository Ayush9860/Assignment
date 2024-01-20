package com.ign_hub.stringmanipulator;

import java.util.Scanner;

public class StringManipulator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence : ");
        String inputSentence = scanner.nextLine();

        int wordCount = countWords(inputSentence);

        String reversedSentence = reverseWords(inputSentence);

        String hyphenatedSentence = replaceSpacesWithHyphens(inputSentence);

        // Display the results
        System.out.println("Number of words : " + wordCount);
        System.out.println("Reversed sentence : " + reversedSentence);
        System.out.println("Sentence with hyphens : " + hyphenatedSentence);

        scanner.close();
    }

    // Function to count the number of words in a sentence
    private static int countWords(String sentence) {
        int count = 0;
        boolean isWord = false;

        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);

            if (Character.isWhitespace(c)) {
                isWord = false;
            } else if (!isWord) {
                isWord = true;
                count++;
            }
        }

        return count;
    }

    // Function to reverse the order of words in a sentence
    private static String reverseWords(String sentence) {
        StringBuilder reversedSentence = new StringBuilder();
        StringBuilder currentWord = new StringBuilder();

        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);

            if (Character.isWhitespace(c)) {
                reversedSentence.insert(0, currentWord).insert(0, ' ');
                currentWord.setLength(0);
            } else {
                currentWord.append(c);
            }
        }

        reversedSentence.insert(0, currentWord);
        return reversedSentence.toString();
    }

    // Function to replace spaces with hyphens in a sentence
    private static String replaceSpacesWithHyphens(String sentence) {
        char[] chars = new char[sentence.length()];

        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            chars[i] = Character.isWhitespace(c) ? '-' : c;
        }

        return new String(chars);
    }
}
