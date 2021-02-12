package ru.nsu.yattroman.encoder;

import ru.nsu.yattroman.exception.MorseHandlerException;
import ru.nsu.yattroman.statisctics.SymbolStat;
import ru.nsu.yattroman.alphabet.Alphabet;

public class Encoder {

    public String encodeLine(String line, Alphabet alpha, SymbolStat symbolStat) {

        StringBuilder result = new StringBuilder();
        line = line.toUpperCase();

        for(int i = 0; i < line.length(); ++i){
            if(alpha.getEncoderMap().containsKey(line.charAt(i))){
                result.append(alpha.getEncoderMap().get(line.charAt(i)) + ' ');
                symbolStat.add(line.charAt(i));
            } else if(line.charAt(i) == ' '){
                result.append(' ');
            } else {
                throw new MorseHandlerException("There is symbol which isn't exist alphabet");
            }
        }

        return result.toString();
    }

}
