package ru.parser.alphabet;

import ru.parser.textProcessing.TextHandler;

import java.util.HashMap;

public class Alphabet {

    private HashMap<Character, MorseSymbol> encoderMap;
    private HashMap<MorseSymbol, Character> decoderMap;

    public Alphabet(){
        encoderMap = new HashMap<Character, MorseSymbol>();
        decoderMap = new HashMap<MorseSymbol, Character>();
    }

    public void uploadMorseAlphabet(String alphabetFileName) {
        TextHandler txtH = new TextHandler(alphabetFileName);
        while(txtH.readTextLine()) {
            String box = txtH.getLine();
            encoderMap.put( box.charAt(0), new MorseSymbol( box.substring( 2, box.length() )));
            decoderMap.put( new MorseSymbol( box.substring( 2, box.length() )), box.charAt(0));
        }
    }

    public void test(){
        String test = encoderMap.get('A').getMorseSymbol();
        System.out.println(encoderMap.get('A').getMorseSymbol());
        System.out.println(encoderMap.get('9').getMorseSymbol());
    }

}
