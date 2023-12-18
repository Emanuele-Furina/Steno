import java.util.List;

public class Verifica {
    public static void calcolaBit(byte[] messageBytes, List<String> imageLines) {
        int messageLength = messageBytes.length;
        int pixelsNeeded = messageLength * 8;
        for (String line : imageLines) {
            String[] numbers = line.split("\\s+");
            if (numbers.length == 2) {
                for (String number : numbers) {
                    if (!number.matches("\\d+")) {
                    }
                }
                int num1 = Integer.parseInt(numbers[0]);
                int num2 = Integer.parseInt(numbers[1]);
                int Pixels = num1 * num2;
                if (pixelsNeeded > Pixels) {
                    System.out.println("L'immagine è troppo piccola per incorporare il messaggio");
                    System.exit(-1);
                 }

            }
        }
    }
}
