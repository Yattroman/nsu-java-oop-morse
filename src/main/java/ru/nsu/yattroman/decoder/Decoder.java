package ru.nsu.yattroman.decoder;

import ru.nsu.yattroman.exception.MorseHandlerException;
import ru.nsu.yattroman.statisctics.SymbolStat;
import ru.nsu.yattroman.alphabet.Alphabet;

public class Decoder {

    public String decodeLine(String line, Alphabet alpha, SymbolStat symbolStat){
        StringBuilder result = new StringBuilder();

        String[] temp = line.split(" ");

        for(String a : temp){
            if(alpha.getDecoderMap().containsKey(a)) {
                char symbol = alpha.getDecoderMap().get(a);
                result.append(symbol);
                symbolStat.add(line.charAt(symbol));
            } else if(a.equals("")) {
                result.append(' ');
            } else {
                throw new MorseHandlerException("There is invalid decoded symbol in text.");
            }
        }

        return result.toString();
    }

}
