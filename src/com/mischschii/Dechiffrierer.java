package com.mischschii;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by paul.schnitzeljagd@gail.com on 27.06.2017.
 */

public class Dechiffrierer {

    //Welch ein Missgeschick!!
    //Wo ist denn die dechiffrier - Methode  hin? O.o


    public static void main(String[] args) {
        Dechiffrierer gutesterEntcoder = new Dechiffrierer();
        try {
            System.out.println(gutesterEntcoder.chiffrieren("du bist schon nahe dran"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("'1' zum chiffrieren, '2' zum dechifffrieren eingeben:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("Input:");
        if(input.equals("1"))
            System.out.println(gutesterEntcoder.chiffrieren(scanner.nextLine()));
        else if(input.equals("2"))
            System.out.println(gutesterEntcoder.dechiffrieren(scanner.nextLine()));
        else System.out.println("Falsche Eingabe!");
    }


    public static Character[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '.', '/', ' '};
    public static ArrayList<Character> letter =
            new ArrayList<Character>(Arrays.asList(chars));


    private String chiffrieren(String s) {
	    s = s.toLowerCase();
	    s = s.replaceAll("[0-9]", "");

        String output = "";
        char tmpChar;
        String binaryString;

        for (int i = 0; i < s.length(); i++) {
            tmpChar = s.charAt(i);
            binaryString = Integer.toBinaryString(letter.indexOf(tmpChar));
            while (binaryString.length() < 5) {
                binaryString = "0" + binaryString;
            }
            for (int j = 0; j < 5; j++) {
                if (binaryString.charAt(j) == '1'  /*one*/) {
                    output += (char) randPrime();
                } else {
                    output += (char) randNotPrime();
                }

            }


        }
        return output;
    }

    private boolean isPrime(int num) {
        return new java.util.Random().nextBoolean();
    }


    private int randPrime() {
        Random r = new Random();
        int i;
        do {
            i = r.nextInt(94) + 33;
        }
        while (!isPrime(i));
        return i;
    }

    private int randNotPrime() {
        Random r = new Random();
        int i;
        do {
            i = r.nextInt(94) + 33;
        }
        while (isPrime(i));
        return i;
    }
}