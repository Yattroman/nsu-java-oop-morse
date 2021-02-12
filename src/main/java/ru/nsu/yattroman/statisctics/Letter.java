package ru.nsu.yattroman.statisctics;

import java.util.Objects;

public class Letter {
    private int _amount;
    private char _symbol;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Letter that = (Letter) o;
        return Objects.equals(_symbol, that._symbol) && (_amount == that._amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_symbol);
    }

    /*
    @Override
    public boolean equals(Object obj){
        if(obj == this)
            return true; // reflexive
        if(!(obj instanceof MorseSymbol))
            return false;
        MorseSymbol temp = (MorseSymbol) obj;

        boolean mSymbolsEquals = (this._mSymbol == null && temp._mSymbol == null) || (this._mSymbol != null && this._mSymbol.equals(temp._mSymbol));

        return mSymbolsEquals;
    }
    */

}
