// Liner Feedback Shift Register
public class Lfsr {
  public static void main(String[] args) {
    if (args.length > 0) {
      String initialState = args[0];
      System.out.println("initial state " + initialState);
      String state = initialState;
      int counter = 1;
      while(true) {
        String[] result = shift(state);
        String newBit = result[0];
        state = result[1];
        System.out.print(newBit);
        if (state.equals(initialState)) {
          System.out.println("\n counted " + counter);
          return;
        }
        counter++;
      }
    }
    System.out.println("Please pass state");
  }

  private static String[] shift(String state) {
    StringBuilder buf = new StringBuilder();
    char bit = state.charAt(state.length() - 1);
    char b = state.charAt(state.length() - 2);
    String newBit = xor(bit, b);
    buf.append(newBit);
    for(int i = 0; i < state.length() - 1; i++) {
      buf.append(state.charAt((i)));
    }
    return new String[]{newBit, buf.toString()};
  }

  private static String xor(char a, char b) {
    return ((a == '0' && b == '0') || (a == '1' && b == '1')) ? "0" : "1";
  }
}

