package ru.parser;

import ru.parser.alphabet.Alphabet;
import ru.parser.textProcessing.TextHandler;

public class Main {

    public static void main(String[] args) throws Exception {
        try {
            //MorseHandler morseHandler = new MorseHandler();
            Alphabet alpha = new Alphabet();
            alpha.uploadMorseAlphabet("D:\\NSU\\JAVA_NSU_LABS\\Lab1\\src\\main\\resources\\alphabets\\morse_english.txt");
            alpha.test();
        } catch (Throwable e){
            System.out.println("Error!");
        }
    }

}