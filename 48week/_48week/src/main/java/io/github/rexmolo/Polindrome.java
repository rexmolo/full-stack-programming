package io.github.rexmolo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Polindrome {

    static LinkedList<Character> charStack;
    // static LinkedList<Character> charQueue;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try {

            charStack = new LinkedList<>();
            // charQueue = new LinkedList<>();


            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder inputWord = new StringBuilder();
            while (br.ready()) {
                char c = (char) br.read();
                inputWord.append(c);
                pushCharacter(c);
            }

            int stackSize = charStack.size();
            StringBuilder reversedInputWord = new StringBuilder();
            for (int i = 0; i < stackSize; i++) {
                char r = popCharacter();
                reversedInputWord.append(r);
            }

            String inputS = inputWord.toString();
            // System.out.println(reversedInputWord.toString());
            // System.out.println(inputS);
            if(reversedInputWord.toString().equalsIgnoreCase(inputS)){

                System.out.printf("%s%s%s", "The word, ",inputS,", is a palindrome.");
            } else {
                System.out.printf("%s%s%s", "The word, ",inputS,", is not a palindrome.");
            }

        } catch(Exception e) {

        }

    }

    static void pushCharacter(char ch) {
        charStack.push(ch);
    }

    // static void enqueueCharacter(char ch){
    //     charQueue.addFirst(ch);
    // }

    static char popCharacter(){
        return charStack.pop();
    }

    // static char dequeueCharacter(){
    //     return charQueue.pollLast();
    // }
}
