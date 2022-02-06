package com.algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HashTable<String> hashTable = new HashTable<>(30);

        try {
            Scanner read = new Scanner(new File("input.txt"));
            int wordKey = 0;

            while (read.hasNext()){
                String word = read.next().toLowerCase(Locale.ROOT).replaceAll("\\p{Punct}", "");
                hashTable.put(wordKey, word);
                wordKey++;

            }

            Scanner sw = new Scanner(System.in);
            int searchWord = 0;

            while (!Objects.equals(searchWord, -1)){

                System.out.print("\n\nEnter a word to find: ");
                searchWord = sw.nextInt();
                System.out.println("The word is " + hashTable.get(searchWord));


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
