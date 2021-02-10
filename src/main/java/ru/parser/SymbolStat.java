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
}
