package ru.parser.encoder;

import ru.parser.alphabet.Alphabet;

public class Encoder {

    public String encodeLine(String line, Alphabet alpha){

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < line.length(); ++i){
            result.append(alpha.getEncoderMap().get(line.charAt(i)));
        }

        return result.toString();
    }

}
