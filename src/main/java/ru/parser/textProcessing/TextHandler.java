package ru.parser.textProcessing;
import ru.parser.SymbolStat;

import java.io.*;

public class TextHandler {

    private BufferedReader _reader;
    private FileWriter _writerSS;
    private FileWriter _writerResultText;
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

            String resSSFileName = "D:\\NSU\\JAVA_NSU_LABS\\Lab1\\src\\main\\resources\\result\\resultStatistics.txt";
            _writerSS = new FileWriter(resSSFileName);

            _writerResultText = null;
        }
        catch (IOException e)
        {
            System.err.println("Error while reading file: " + e.getLocalizedMessage());
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

    public void writeSymbolsStatistics(SymbolStat symbolStat){
        try {
            for (var i: symbolStat.getSymbolsStatistics().keySet()){
                    _writerSS.write(i.toString() + ": " + symbolStat.getSymbolsStatistics().get(i).toString() + "\n");
            }
            _writerSS.close();
        } catch (IOException e) {
            System.err.println("Error while printing symbol statistics: " + e.getLocalizedMessage());
        }
    }

    public void writeResultInFile(String filename, String resultString){
        try {
            _writerResultText = new FileWriter("D:\\NSU\\JAVA_NSU_LABS\\Lab1\\src\\main\\resources\\result\\" + filename);
            _writerResultText.write(resultString);
            _writerResultText.close();
            System.out.println("Successfully worked! You can see result in: " + filename);
        } catch (IOException e) {
            System.err.println("Error while printing results: " + e.getLocalizedMessage());
        }
    }

}
