package ru.nsu.yattroman.decoder;

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

                if(!symbolStat.getSymbolsStatistics().containsKey(symbol)){
                    symbolStat.initSymbolAmount(symbol);
                } else {
                    symbolStat.increaseSymbolAmount(symbol);
                }

            } else if(a.equals("")) {
                result.append(' ');
            } else {
                result.append('#');

                if(!symbolStat.getSymbolsStatistics().containsKey('#')){
                    symbolStat.initSymbolAmount('#');
                } else {
                    symbolStat.increaseSymbolAmount('#');
                }
            }
        }

        return result.toString();
    }

}
