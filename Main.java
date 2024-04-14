//M04 Programming Assignment (1)
//Ivy Tech Community College
//SDEV 200 - Java
//Professor Bumgardner
//Nativida Muhammad
//14 April 2024

import java.io.IOException;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Java Main | M04 Programming Assignment.1");
      return;
    }

    String fileName = args[0];
    try {
      if (checkGroupingSymbols(fileName)) {
        System.out.println("All symbols are correctly matched with their twin symbol.");
      } else {
        System.out.println("Some symbols are not correctly matched.");
      }
    } catch (IOException e) {
      System.out.println("Please try again.  There was an error reading file: " + e.getMessage());
    }
  }

  private static boolean checkGroupingSymbols(String fileName) throws IOException {
    Stack<Character> stack = new Stack<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
      String line;
      while ((line = reader.readLine()) != null) {
        for (char c : line.toCharArray()) {
          if (c == '(' || c == '{' || c == '[') {
            stack.push(c);
          } else if (c == ')' || c == '}' || c == ']') {
            if (stack.isEmpty() || !isMatchingPair(stack.pop(), c)) {
              return false;
            }
          }
        }
      }
    }
    return stack.isEmpty();
  }

  private static boolean isMatchingPair(char left, char right) {
    return (left == '(' && right == ')') || (left == '{' && right == '}') || (left == '[' && right == ']');
  }
}
