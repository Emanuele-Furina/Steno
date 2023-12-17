package steganografia;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Scrittore {
        
    public static void scrivifile(String fileName, List<String> lines) throws IOException {
        Files.write(Paths.get(fileName), lines, StandardOpenOption.CREATE);
        File file = new File(fileName);
        System.out.println("Scrittura completata con successo");
        System.out.println("Posizione immagine: " + file.getAbsolutePath());
    }
}
