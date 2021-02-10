package ru.parser.alphabet;

import java.util.Objects;

public class MorseSymbol {

    private String _mSymbol;

    public MorseSymbol(String mSymbol){
        _mSymbol = mSymbol;
    }

    public String getMorseSymbol() {
        return _mSymbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MorseSymbol that = (MorseSymbol) o;
        return Objects.equals(_mSymbol, that._mSymbol);
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

    @Override
    public int hashCode() {
        return Objects.hash(_mSymbol);
    }
}
