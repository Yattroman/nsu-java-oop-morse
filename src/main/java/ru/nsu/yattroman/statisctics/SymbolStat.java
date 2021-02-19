package ru.nsu.yattroman.statisctics;

import java.util.HashSet;

public class SymbolStat {

    private final HashSet<Letter> symbolsStatistics;

    public SymbolStat(){
        symbolsStatistics = new HashSet<Letter>();
    }

    public HashSet<Letter> getSymbolsStatistics() {
        return symbolsStatistics;
    }

    public void add(char symbol){
        symbolsStatistics.add(new Letter(symbol));
    }
}
