package ru.parser.textProcessing;
import ru.parser.SymbolStat;

import java.io.*;

public class TextHandler {

    private BufferedReader _reader;
    private FileWriter _writer;
    private String _line;
    private int _indexInLine;
    private boolean _oneLineHaveRead;

    public String getLine(){
        return _line;
    }

    public TextHandler(String fileName){
        _reader = null;
        _indexInLine = 0;
        _line = "";
        _oneLineHaveRead = false;
        try
        {
            String resFileName = "D:\\NSU\\JAVA_NSU_LABS\\Lab1\\src\\main\\resources\\result\\resultStatistics.txt";
            _reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            _writer = new FileWriter(resFileName);
        }
        catch (IOException e)
        {
            System.err.println("Error while reading file or file for writing results isn't avaliable: " + e.getLocalizedMessage());
        }
    }

    public boolean readTextLine(){
        try
        {
            _line = _reader.readLine();

            if(!_oneLineHaveRead) {
                _oneLineHaveRead = true;
            }
        }
        catch (IOException e)
        {
            System.err.println("Error while reading symbol: " + e.getLocalizedMessage());
        }

        return _line != null;
    }

    public char getSymbol(){
        char symbol = '@';

        if( _indexInLine >= _line.length() || !_oneLineHaveRead ){
            _indexInLine = 0;
            readTextLine();
            symbol = _line.charAt(_indexInLine);
        } else if( _indexInLine < _line.length() ){
            symbol = _line.charAt(_indexInLine);
        }

        ++_indexInLine;

        return symbol;
    }

    public void writeSymbolsStatistics(SymbolStat symbolStat){
        try {
            for (var i: symbolStat.getSymbolsStatistics().keySet()){
                    _writer.write(i.toString() + ": " + symbolStat.getSymbolsStatistics().get(i).toString() + "\n");
            }
            _writer.close();
        } catch (IOException e) {
            System.err.println("Error while printing results: " + e.getLocalizedMessage());
        }
    }

}
