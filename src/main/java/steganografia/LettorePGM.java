package steganografia;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LettorePGM {
        public static List<String> leggi(String fileName) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        return lines;
    }
}
