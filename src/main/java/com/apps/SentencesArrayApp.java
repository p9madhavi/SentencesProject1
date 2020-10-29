package com.apps;

import com.examples.SentencesArray;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Scanner;

public class SentencesArrayApp {
    public static void main(String[] args) {

        SentencesArray anArray = new SentencesArray();
        Scanner scan = new Scanner(System.in);
        String input = "start";

        while(!input.equals("9")) {

            anArray.showMenu();
            System.out.print("Select Option from the menu::: ");
            input = scan.nextLine();

            switch(input) {
                case "1":
                    System.out.print("Enter Sentence : ");
                    input = scan.nextLine();
                    anArray.enterSentence(input);
                    System.out.println();
                    System.out.println("Saved the sentence");
                    break;
                case "2":
                    anArray.printSentence();
                    break;
                case "3":
                    anArray.countSentences();
                    break;
                case "4":
                    anArray.printReverseSentences();
                    break;
                case "5":
                    int characterCount = anArray.printNumberOfCharacters();
//                    System.out.println();
                    System.out.println("The Character Count is : " + characterCount);
                    break;
                case "6":
                    int vowelCount = anArray.printNumberOfVowels();
//                    System.out.println();
                    System.out.println("The Vowel count is :" + vowelCount);
                    break;
                case "7":
                    System.out.println();
                    System.out.println("Enter a word to be searched For Insensitive Comparisons: ");
                    input = scan.nextLine();
                    System.out.println();
                    anArray.searchWordCaseInsensitive(input);
                    break;
                case "8":
                    System.out.println();
                    System.out.print("Enter a word to be searched For Sensitive Comparisons: ");
                    input = scan.nextLine();
                    System.out.println();
                    anArray.searchWordCaseSensitive(input);
                    break;

                case "9":
                    break;

                default:
                    System.out.println();
                    System.out.println("The value you entered is not correct. Please enter a value between 1 and 9.");
                    System.out.println("try again.");
                    System.out.println();
                    break;
            }

        }


//        while (!choice.equals("9")) {
//            System.out.println("Select Option from the menu:::");
//            choice = scan.nextLine();
//            if (choice.equals("1")) {
//                anArray.enterSentence();
//            } else if (choice.equals("2")) {
//                anArray.printSentence();
//            } else if (choice.equals("3")) {
//                anArray.countSentences();
//            } else if (choice.equals("4")) {
//                anArray.printReverseSentences();
//            } else if (choice.equals("5")) {
//                anArray.printNumberOfCharacters();
//            } else if (choice.equals("6")) {
//                anArray.printNumberOfVowels();
//            } else if (choice.equals("9")) {
//                break;
//            }
//         }

//        int choice = 1;
////        System.out.println("Select Option from the menu:::    ");
//        while(choice !=9) {
//            System.out.println(" Inside while method");
//            System.out.println("Select Option from the menu:::    ");
//
//            switch(choice) {
//                case 1:
//                    anArray.enterSentence();
//                    break;
//                case 2:
//                    anArray.printSentence();
//                    break;
//                case 3:
//                    anArray.countSentences();
//                    break;
//                case 4:
//                    anArray.printReverseSentences();
//                    break;
//                case 5:
//                    int characterCount = anArray.printNumberOfCharacters();
//                    System.out.println("The Character Count is : " + characterCount);
//                    break;
//                case 6:
//                    int vowelCount = anArray.printNumberOfVowels();
//                    System.out.println("The Vowel count is :" + vowelCount);
//                    break;
//                case 9:
//                    break;
//                default:
//                    System.out.println("Please enter a valid input");
//                    break;
//            }
//
//
//        }

    }
}
