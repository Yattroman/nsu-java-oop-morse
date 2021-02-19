package ru.nsu.yattroman.statisctics;

import java.util.Objects;

public class Letter {
    private int _amount;
    private final char _symbol;

    public Letter(char symbol){
        _symbol = symbol;
        _amount = 1;
    }

    public int getAmount(){
        return _amount;
    }

    public char getSymbol(){
        return _symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Letter that = (Letter) o;
        if(Objects.equals(_symbol, that._symbol)){
            ++that._amount;
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_symbol);
    }

}
