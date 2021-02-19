package ru.nsu.yattroman;
import ru.nsu.yattroman.alphabet.Alphabet;
import ru.nsu.yattroman.decoder.Decoder;
import ru.nsu.yattroman.encoder.Encoder;
import ru.nsu.yattroman.exception.MorseHandlerException;
import ru.nsu.yattroman.modes.DecodeMode;
import ru.nsu.yattroman.modes.EncodeMode;
import ru.nsu.yattroman.modes.Mode;
import ru.nsu.yattroman.statisctics.SymbolStat;
import ru.nsu.yattroman.textProcessing.TextHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class MorseHandler {

    private final Decoder _decoder;
    private final Encoder _encoder;
    private TextHandler _mainTextHandler;
    private final Alphabet _alphabet;
    private String _mode;
    private final SymbolStat _symbolsStatistics;
    private HashMap<String, Mode> _modes;

    public MorseHandler(){
        BufferedReader _reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] temp = _reader.readLine().split(" ");
            if( (temp[0].equals("code") || temp[0].equals("decode"))){
                _mode = temp[0];
                _mainTextHandler = new TextHandler("D:\\NSU\\JAVA_NSU_LABS\\Lab1\\src\\main\\resources\\testTexts\\" + temp[1]);
            } else {
                throw new MorseHandlerException("Invalid command. Try to use \"decode\", \"code\". ");
            }
        } catch (IOException e) {
            System.err.println("Error while reading line. " + e.getLocalizedMessage());
        } catch (MorseHandlerException e) {
            throw e;
        }

        _decoder = new Decoder();
        _encoder = new Encoder();
        _alphabet = new Alphabet();
        _symbolsStatistics = new SymbolStat();
        _modes = new HashMap<String, Mode>();
        _modes.put(_mode, new DecodeMode());
        _modes.put(_mode, new EncodeMode());
        _alphabet.uploadMorseAlphabet("D:\\NSU\\JAVA_NSU_LABS\\Lab1\\src\\main\\resources\\alphabets\\morse_english.txt");
    }

    public void doWork(){
        try {
            Mode currentMode = _modes.get(_mode);
            if(currentMode != null){
                currentMode.executeMode(_mainTextHandler, _alphabet, _symbolsStatistics, _encoder, _decoder);
            }
        } catch (MorseHandlerException e){
            throw e;
        }

        _mainTextHandler.writeSymbolsStatistics(_symbolsStatistics);
    }

}
