package ru.nsu.yattroman;
import ru.nsu.yattroman.alphabet.Alphabet;
import ru.nsu.yattroman.decoder.Decoder;
import ru.nsu.yattroman.encoder.Encoder;
import ru.nsu.yattroman.statisctics.SymbolStat;
import ru.nsu.yattroman.textProcessing.TextHandler;

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
            if(temp[0].equals("code") || temp[0].equals("decode")){
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
        String resultText = "";
        if(_mode.equals("code")){
            while(_mainTextHandler.readTextLine()){
                String temp = _encoder.encodeLine(_mainTextHandler.getLine(), _alphabet, _symbolsStatistics);
                resultText += temp + '\n';
            }
            _mainTextHandler.writeResultInFile("encoderRes.txt", resultText);
        } else if(_mode.equals("decode")){
            while(_mainTextHandler.readTextLine()){
                String temp = _decoder.decodeLine(_mainTextHandler.getLine(), _alphabet, _symbolsStatistics);
                resultText += temp + '\n';
            }
            _mainTextHandler.writeResultInFile("decoderRes.txt", resultText);
        } else {
            // exception
        }

        _mainTextHandler.writeSymbolsStatistics(_symbolsStatistics);
    }

}
