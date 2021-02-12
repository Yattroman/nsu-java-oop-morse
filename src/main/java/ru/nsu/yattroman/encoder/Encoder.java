package ru.nsu.yattroman.encoder;

import ru.nsu.yattroman.statisctics.SymbolStat;
import ru.nsu.yattroman.alphabet.Alphabet;

public class Encoder {

    public String encodeLine(String line, Alphabet alpha, SymbolStat symbolStat){

        StringBuilder result = new StringBuilder();
        line = line.toUpperCase();

        for(int i = 0; i < line.length(); ++i){
            if(alpha.getEncoderMap().containsKey(line.charAt(i))){
                result.append(alpha.getEncoderMap().get(line.charAt(i)) + ' ');

                if(!symbolStat.getSymbolsStatistics().containsKey(line.charAt(i))){
                    symbolStat.initSymbolAmount(line.charAt(i));
                } else {
                    symbolStat.increaseSymbolAmount(line.charAt(i));
                }

            } else if(line.charAt(i) == ' '){
                result.append(' ');
            } else {
                result.append("# ");

                if(!symbolStat.getSymbolsStatistics().containsKey(line.charAt(i))){
                    symbolStat.initSymbolAmount(line.charAt(i));
                } else {
                    symbolStat.increaseSymbolAmount(line.charAt(i));
                }
            }
        }

        return result.toString();
    }

}
