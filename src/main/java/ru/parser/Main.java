package ru.parser;

public class Main {

    public static void main(String[] args) throws Exception {
        try {
            MorseHandler morseHandler = new MorseHandler();
            morseHandler.doWork();
        } catch (Throwable e){
            System.out.println("Error!");
        }
    }

}