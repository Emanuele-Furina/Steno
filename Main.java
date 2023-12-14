package steganografia;

import java.nio.charset.Charset;
import java.nio.file.*;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String inputFileName = args[0];
        String outputFileName = args[1];
        String message = args[2] + ((char) 0);

        List<String> imageLines = LettorePGM.leggi(inputFileName);
        byte[] messageBytes = message.getBytes();
        for (int i=0; i < messageBytes.length; i++){
            System.out.println(messageBytes[i]);
        }
        Verifica.calcolaBit(messageBytes, imageLines);
        List<String> stegoImage = LSB.incorpora(imageLines, messageBytes);
        Scrittore.scrivifile(outputFileName, stegoImage);

        String decodedMessage = LSB.decodifica(stegoImage);
        System.out.println("Messaggio decodificato: " + decodedMessage);
    }
}
