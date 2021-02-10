package ru.parser.encoder;

import ru.parser.SymbolStat;
import ru.parser.alphabet.Alphabet;

public class Encoder {

    public String encodeLine(String line, Alphabet alpha, SymbolStat symbolStat){

        StringBuilder result = new StringBuilder();
        line = line.toUpperCase();

        for(int i = 0; i < line.length(); ++i){
            if(alpha.getEncoderMap().containsKey(line.charAt(i))){
                result.append(alpha.getEncoderMap().get(line.charAt(i)).getMorseSymbol());
                if(!symbolStat.getSymbolsStatistics().containsKey(line.charAt(i))){
                    symbolStat.getSymbolsStatistics().put(line.charAt(i), 1);
                } else {
                    symbolStat.getSymbolsStatistics().replace(line.charAt(i),
                            symbolStat.getSymbolsStatistics().get(line.charAt(i)), symbolStat.getSymbolsStatistics().get(line.charAt(i)) + 1) ;
                }
            } else if(line.charAt(i) == ' '){
                result.append(' ');
            } else {
                // Кинуть эксепшн
            }
        }

        return result.toString();
    }

}
