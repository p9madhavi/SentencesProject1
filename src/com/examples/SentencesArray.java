package com.examples;

import java.util.Scanner;

public class SentencesArray{

    String[] sentences = new String[10];
    int currentIndex=0;
    String vowel = "aeiou";

    public void showMenu(){

        System.out.println();
        System.out.println("Menu :::::");
        System.out.println("1.Enter a full sentence");
        System.out.println("2.Print out all sentences entered thus far in the given order");
        System.out.println("3.Print out the number of sentences that have been entered thus far");
        System.out.println("4.Print out all sentences entered thus far in the reverse order");
        System.out.println("5.the number of characters in all sentences combined");
        System.out.println("6.the total number of vowels contained in all stored sentences");
        System.out.println("7.search for a given word using case insensitive comparisons");
        System.out.println("8.search for a given word using case sensitive comparisons");
        System.out.println("9.Exit");
        System.out.println();
    }

    public void enterSentence(String aSentence){

        try {

            sentences[currentIndex] = aSentence;
            currentIndex++;

        }catch(ArrayIndexOutOfBoundsException exception){
            System.out.println("Array size is full,can not enter sentences");
        }

    }

    public void printSentence(){
        System.out.println();
        System.out.println("Sentences in the Array are::");
        for(int i=0;i<currentIndex;i++){
            System.out.println( (i+1) + " "+sentences[i]);
        }
    }

    public void countSentences(){
        System.out.println("The number of sentences that have been entered " + currentIndex);
    }

    public void printReverseSentences() {
        System.out.println();
        System.out.println("The Reverse order of Sentences are :: ");

        for(int i=currentIndex-1;i>=0;i--){
            System.out.println((i + 1) + " " + sentences[i]);
        }
        System.out.println();
    }

    public int printNumberOfCharacters(){

        int charCount = 0;
        for(int i=0;i<currentIndex;i++) {
            String tempString = new String(sentences[i]);
            tempString = tempString.replaceAll("\\s+","");
            charCount = charCount +tempString.length();
        }
        return charCount;
    }

    public int printNumberOfVowels(){

        int vowelCount = 0;
        for(int i=0;i<currentIndex;i++) {

            for (int count = 0; count < sentences[i].length(); count++) {

                if (vowel.contains(String.valueOf(sentences[i].toLowerCase().charAt(count)))) {
                    vowelCount = vowelCount + 1;
                }
            }
//            System.out.println("the vowelcount of " + (i+1) + "  is " + vowelCount);
        }
//            System.out.println("the vowelcount is " + vowelCount);
              return vowelCount;
    }
    public void searchWordCaseInsensitive(String searchWord){

        for(int i=0; i<currentIndex;i++){
            if(sentences[i].toLowerCase().contains(searchWord.toLowerCase())){
                System.out.println(sentences[i]);
            }
        }
//        System.out.println("Word Search Case Insensitive");
//        System.out.println("Enter the Word to Search:: ");
//        String findWord = null;
//        for(int i=0;i<sentences.length;i++){
//            String[] tempString = sentences[i].split("\\s");
//            System.out.println("temp string is "+ tempString);
//
//                for(int j=0;j<tempString.length;j++){
//                    System.out.println("temp string splits is "+ tempString[j]);
//                    System.out.println("temp string splits lenght is "+ tempString.length);
//                    if(searchWord == tempString[j]){
//                        findWord = tempString[j];
//                    }
//                }
//
//        }
//        return findWord;
    }

    public void searchWordCaseSensitive(String searchWord) {

        for (int i = 0; i < currentIndex; i++) {
            if (sentences[i].contains(searchWord)) {
                System.out.println(sentences[i]);
            }
        }
    }
}


