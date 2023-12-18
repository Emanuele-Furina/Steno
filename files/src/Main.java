import java.nio.charset.Charset;
import java.nio.file.*;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length < 3){
            System.out.println("Usage: Steno.jar <input.pgm> <out.pgm> \"messaggio\" [--xor [chiave]]");
            System.out.println("Error: Not enough arguments. At least 3 arguments are required.");
            System.exit(-1);
        }  

        String inputFileName = args[0];
        String outputFileName = args[1];
        String message = args[2] + ((char) 0);
        boolean usaXor = false;
        int keyXor = 0;
            
        for (int i = 3; i < args.length; i++) {
            if (args[i].equals("--xor")) {
                usaXor = true;
                keyXor = Integer.parseInt(args[i + 1]);
                System.out.println("Xor attivato con chiave " + keyXor);
                break;
            }
        }

        List<String> imageLines = LettorePGM.leggi(inputFileName);
        byte[] messageBytes = message.getBytes();

        Verifica.calcolaBit(messageBytes, imageLines);
        List<String> stegoImage = LSB.incorpora(imageLines, messageBytes, usaXor, keyXor);
        Scrittore.scrivifile(outputFileName, stegoImage);
        // String decodedMessage = LSB.decodifica(stegoImage, usaXor, keyXor);
        // System.out.println("Messaggio decodificato: " + decodedMessage);
    }
}
