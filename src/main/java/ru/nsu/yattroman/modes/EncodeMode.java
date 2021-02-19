package ru.nsu.yattroman.modes;

import ru.nsu.yattroman.alphabet.Alphabet;
import ru.nsu.yattroman.decoder.Decoder;
import ru.nsu.yattroman.encoder.Encoder;
import ru.nsu.yattroman.statisctics.SymbolStat;
import ru.nsu.yattroman.textProcessing.TextHandler;

public class EncodeMode extends Mode{

    @Override
    public void executeMode(TextHandler mainTextHandler, Alphabet alphabet, SymbolStat symbolsStatistics, Encoder encoder, Decoder decoder){
        String resultText = "";

        while (mainTextHandler.readTextLine()) {
            String temp = encoder.encodeLine(mainTextHandler.getLine(), alphabet, symbolsStatistics);
            resultText += temp + '\n';
        }
        mainTextHandler.writeResultInFile("encoderRes.txt", resultText);
    }

}
