package ru.parser;

import java.util.HashMap;

public class SymbolStat {

    private HashMap<Character, Integer> symbolsStatistics;

    public SymbolStat(){
        symbolsStatistics = new HashMap<Character, Integer>();
    }

    public HashMap<Character, Integer> getSymbolsStatistics() {
        return symbolsStatistics;
    }

    public void increaseSymbolAmount(Character symbol){
        symbolsStatistics.replace(symbol, symbolsStatistics.get(symbol), symbolsStatistics.get(symbol) + 1); // Но в классе все автоматически инициализируется
    }

    public void initSymbolAmount(Character symbol){
        symbolsStatistics.put(symbol, 1);
    }
}
