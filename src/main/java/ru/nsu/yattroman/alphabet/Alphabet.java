package ru.nsu.yattroman.alphabet;

import ru.nsu.yattroman.textProcessing.TextHandler;

import java.util.HashMap;

public class Alphabet {

    private HashMap<Character, String> encoderMap;
    private HashMap<String, Character> decoderMap;

    public Alphabet(){
        encoderMap = new HashMap<Character, String>();
        decoderMap = new HashMap<String, Character>();
    }

    public void uploadMorseAlphabet(String alphabetFileName) {
        TextHandler txtH = new TextHandler(alphabetFileName);
        while(txtH.readTextLine()) {
            String box = txtH.getLine();
            encoderMap.put( box.charAt(0), box.substring( 2, box.length() ));
            decoderMap.put( box.substring( 2, box.length() ), box.charAt(0));
        }
    }

    public HashMap<Character, String> getEncoderMap(){
        return encoderMap;
    }

    public HashMap<String, Character> getDecoderMap(){
        return decoderMap;
    }

}
