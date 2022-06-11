package bullscows;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {

    private int length;
    private int numberOfSymbols;
    private boolean isCorrectInput;

    protected boolean isCorrectInput() {
        return isCorrectInput;
    }

    protected Generator(int length, int numberOfSymbols) {
        if (length > 10 || length < 1) {
            System.out.println("Error! Length of secret code must be > 0 and <= 10!");
        } else if (numberOfSymbols < length) {
            System.out.println("Error! Number of possible symbols must be >= length of secret code");
        } else if (numberOfSymbols > 36) {
            System.out.println("Error! Max number of possible symbols is 36 (0-9, a-z)");
        } else {
            this.length = length;
            this.numberOfSymbols = numberOfSymbols;
            isCorrectInput = true;
        }
    }

    protected String generate() {
        StringBuilder code = new StringBuilder();
        List<Character> possibleSymbols = new ArrayList<>();
        for (char i = '0'; i <= '9'; i++) {
            possibleSymbols.add(i);
        }
        for (char i = 'a'; i <= 'z'; i++) {
            possibleSymbols.add(i);
        }
        Random random = new Random();
        while (code.length() != this.length) {
            char symbol = possibleSymbols.get(random.nextInt(this.numberOfSymbols));
            if (code.indexOf(Character.toString(symbol)) == -1)
                code.append(symbol);
        }
        System.out.print("The secret is prepared: ");
        for (int i = 0; i < this.length; i++) {
            System.out.print("*");
        }
        if (this.numberOfSymbols < 11) {
            System.out.println(" (0-" + (numberOfSymbols - 1) + ").");
        } else {
            System.out.println(" (0-9, a-" + (char) (numberOfSymbols + 86) + ").");
        }
        return code.toString();
    }
}
