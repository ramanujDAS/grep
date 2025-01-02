import java.io.IOException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    if (args.length != 2 || !args[0].equals("-E")) {
      System.out.println("Usage: ./program.sh -E <pattern>");
      System.exit(1);
    }

    String pattern = args[1];
      System.out.println(pattern);
    Scanner scanner = new Scanner(System.in);
    String inputLine = scanner.nextLine();

      System.out.println(pattern.length());
    System.err.println("Logs from your program will appear here!");

     if (matchPattern(inputLine, pattern)) {
         System.exit(0);
     } else {
         System.exit(1);
     }
  }

  public static boolean matchPattern(String inputLine, String pattern) {
      if ("\\d".equals(pattern)) {
          return isContainDigit(inputLine);
      }
      else if("\\w".equals(pattern)){
          return isContainAlphaNumeric(inputLine);
      }else if (pattern.length() == 1) {
          return inputLine.contains(pattern);
      } else {
          throw new RuntimeException("Unhandled pattern: " + pattern);
      }


  }

  public static boolean isContainDigit(String inputLine) {
    return inputLine.matches(".*\\d.*");
  }

  public static boolean isContainAlphaNumeric(String inputLine) {
    return inputLine.matches(".*\\w.*");
  }
}
