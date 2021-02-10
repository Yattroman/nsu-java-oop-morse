package ru.parser;
import ru.parser.alphabet.Alphabet;
import ru.parser.decoder.Decoder;
import ru.parser.encoder.Encoder;
import ru.parser.textProcessing.TextHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MorseHandler {

    private Decoder _decoder;
    private Encoder _encoder;
    private TextHandler _mainTextHandler;
    private Alphabet _alphabet;
    private String _mode;
    private SymbolStat _symbolsStatistics;

    public MorseHandler(){
        BufferedReader _reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] temp = _reader.readLine().split(" ");
            if(temp[0].equals("code") || temp[0].equals("encode")){
                _mode = temp[0];
                _mainTextHandler = new TextHandler("D:\\NSU\\JAVA_NSU_LABS\\Lab1\\src\\main\\resources\\testTexts\\" + temp[1]);
            } else {
                // Кидаем эксепшн
            }
        } catch (IOException e) {
            System.err.println("Invalid mode name or filename: " + e.getLocalizedMessage());
        }

        _decoder = new Decoder();
        _encoder = new Encoder();
        _alphabet = new Alphabet();
        _symbolsStatistics = new SymbolStat();
        _alphabet.uploadMorseAlphabet("D:\\NSU\\JAVA_NSU_LABS\\Lab1\\src\\main\\resources\\alphabets\\morse_english.txt");
    }

    public void doWork(){
        if(_mode.equals("code")){
            while(_mainTextHandler.readTextLine()){
                String temp = _encoder.encodeLine(_mainTextHandler.getLine(), _alphabet, _symbolsStatistics);
                System.out.println(temp);
            }
            _mainTextHandler.writeSymbolsStatistics(_symbolsStatistics);
        } else if(_mode.equals("decode")){

        }
    }

}
