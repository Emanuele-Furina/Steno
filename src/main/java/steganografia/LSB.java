package steganografia;

import java.util.List;
import javax.xml.bind.DatatypeConverter;

public class LSB {
  public static List<String> incorpora(List<String> imageLines, byte[] messageBytes, boolean useXor, int xorKey) {
    if (useXor) {
      for (int i = 0; i < messageBytes.length; i++) {
        messageBytes[i] = (byte) ((messageBytes[i] & 0xFF) ^ xorKey);
      }
    }
    int messageIndex = 0;
    int bitIndex = 0;
    int i = 0;

    while (!imageLines.get(i).equals("255")) {  
      System.out.println("Saltata linea n°" + i);
      i++;
    }
    System.out.println("Saltata linea n°" + i);
    i++;
    System.out.println("Saltata linea n°" + i);
    for (; i < imageLines.size(); i++) {
      String[] imagePixels = imageLines.get(i).split("\\s+");
      for (int j = 0; j < imagePixels.length; j++) {
        if (messageIndex >= messageBytes.length) {
          break;
        }
        int pixel = Integer.parseInt(imagePixels[j]);
        String binaryString = Integer.toBinaryString(pixel);
        binaryString = binaryString.substring(0, binaryString.length() - 1)
        + ((messageBytes[messageIndex] >> (7 - bitIndex)) & 1);
        imagePixels[j] = Integer.toString(Integer.parseInt(binaryString, 2));
        bitIndex++;
        if (bitIndex > 7) {
          bitIndex = 0;
          messageIndex++;
        }
      }
      imageLines.set(i, String.join(" ", imagePixels));
    }
    return imageLines;
  }

// public static String decodifica(List<String> imageLines, boolean useXor, int xorKey) {
//    StringBuilder message = new StringBuilder();
//    int messageByte = 0;
//    int bitIndex = 0;

//    int i = 0;
//    while (!imageLines.get(i).equals("255")) {
//      i++;
//    }
//    i++;

//    for (; i < imageLines.size(); i++) {
//      String[] imagePixels = imageLines.get(i).split("\\s+");
//      for (int j = 0; j < imagePixels.length; j++) {
//        int pixel = Integer.parseInt(imagePixels[j]);
//        messageByte = (messageByte << 1) | (pixel & 1);
//        bitIndex++;

//        if (bitIndex > 7) {
//          if (messageByte == 0) {
//            return message.toString();
//          }

//          message.append((char) messageByte);
//          bitIndex = 0;
//          messageByte = 0;
//        }
//      }
//    }

//    if (useXor) {
//      for (int j = 0; j < message.length(); j++) {
//        message.setCharAt(j, (char) ((message.charAt(j) & 0xFF) ^ xorKey));
//      }
//    }
   
//    return message.toString();
//  }
}
