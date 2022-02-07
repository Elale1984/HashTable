package com.algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MyHashTable hashTable = new MyHashTable(30);

        try {
            Scanner read = new Scanner(new File("input.txt"));

            while (read.hasNext()){
                String word = read.next().toLowerCase(Locale.ROOT).replaceAll("\\p{Punct}", "");
                hashTable.addToHashTable(word);

            }

            Scanner sw = new Scanner(System.in);
            String searchWord = "";


            while (!Objects.equals(searchWord, "-1")){

                System.out.print("\n\nEnter a word to find: ");
                searchWord = sw.next();
                int level = hashTable.findInHashTable(searchWord);

                if(level == -1)
                    System.out.println("The word " + searchWord + " was not found;");
                else
                    System.out.println("The word " + searchWord + " was found at level " + level);


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
