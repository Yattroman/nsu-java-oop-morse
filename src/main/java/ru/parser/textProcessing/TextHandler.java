package ru.parser.textProcessing;
import java.io.*;

public class TextHandler {

    private BufferedReader _reader;
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
            _reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            //_reader = new BufferedReader(new FileReader(fileName));
            //readTextLine();
        }
        catch (IOException e)
        {
            System.err.println("Error while reading file: " + e.getLocalizedMessage());
        }
        /*finally
        {
            if (null != _reader)
            {
                try
                {
                    _reader.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace(System.err);
                }
            }
        }
         */
    }

    public boolean readTextLine(){
        try
        {
            _line = _reader.readLine();

            if(!_oneLineHaveRead) {
                _oneLineHaveRead = true;
            }

            return true;
        }
        catch (IOException e)
        {
            System.err.println("Error while reading symbol: " + e.getLocalizedMessage());
        }

        return false;
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

    public void writeSymbol(){

    }

    public void writeText(){

    }

}
