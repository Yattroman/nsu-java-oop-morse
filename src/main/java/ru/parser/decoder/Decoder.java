package ru.parser.decoder;

import ru.parser.SymbolStat;
import ru.parser.alphabet.Alphabet;
import ru.parser.alphabet.MorseSymbol;

public class Decoder {

    public String decodeLine(String line, Alphabet alpha, SymbolStat symbolStat){
        StringBuilder result = new StringBuilder();

        String[] temp = line.split(" ");
        for(String a : temp){
            MorseSymbol tempMorseSymb = new MorseSymbol(a);
            if(alpha.getDecoderMap().containsKey(tempMorseSymb)) {
                result.append(alpha.getDecoderMap().get(tempMorseSymb));
            } else if(a.equals("")) {
                result.append(' ');
            } else {
                result.append('#');
            }
        }

        return result.toString();
    }

}
