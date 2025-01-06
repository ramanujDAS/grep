import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Stream;

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
      System.out.println(inputLine);
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
      }
      else if(isPositiveChar(pattern)){
          return isContainWord(inputLine, pattern);
      }else if (pattern.length() == 1) {
          return inputLine.contains(pattern);
      } else {
          throw new RuntimeException("Unhandled pattern: " + pattern);
      }


  }

  public static boolean isContainDigit(String inputLine) {
      return inputLine.chars().filter(Character::isDigit).findFirst().isPresent();
  }

  public static boolean isContainAlphaNumeric(String inputLine) {
    return inputLine.chars().filter(Character::isLetterOrDigit).findFirst().isPresent();
  }

    public static boolean isContainWord(String inputLine, String pattern) {
        String regex = pattern.substring(1, pattern.length() - 1);
        return regex.chars().anyMatch(ch -> inputLine.contains(String.valueOf((char) ch)));
    }


    private static boolean isPositiveChar(String pattern) {
        return pattern.startsWith("[") && pattern.endsWith("]");
    }

    private static boolean isNegativeChar(String pattern) {
        return pattern.startsWith("[^") && pattern.endsWith("]");
    }



}
