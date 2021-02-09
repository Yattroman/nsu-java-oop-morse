package ru.parser;
import ru.parser.alphabet.Alphabet;
import ru.parser.alphabet.MorseSymbol;
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

    public MorseHandler(){
        BufferedReader _reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] temp = _reader.readLine().split(" ");
            if(temp[0] == "code" || temp[0] == "encode"){
                _mode = temp[0];
                _mainTextHandler = new TextHandler(temp[1]);
            } else {
                // Кидаем эксепшн
            }
        } catch (IOException e) {
            System.err.println("Invalid mode name or filename: " + e.getLocalizedMessage());
        }

        _decoder = new Decoder();
        _encoder = new Encoder();
        _alphabet = new Alphabet();
    }

    public void doWork(){
        if(_mode == "code"){
            while(_mainTextHandler.readTextLine()){
                String temp = _encoder.encodeLine(_mainTextHandler.getLine(), _alphabet);
                // Пока что так
                System.out.println(temp);
            }
        } else if(_mode == "decode"){

        }
    }

}
