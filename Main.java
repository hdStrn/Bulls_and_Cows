package bullscows;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Please, enter the secret's code length:");
        Scanner sc = new Scanner(System.in);
        int codeLength;
        int numberOfSymbols;
        try {
            codeLength = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Error! Invalid input");
            return;
        }
        System.out.println("Input the number of possible symbols in the code:");
        try {
            numberOfSymbols = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Error! Invalid input");
            return;
        }
        Generator generator = new Generator(codeLength, numberOfSymbols);
        if (generator.isCorrectInput()) {
            String code = generator.generate();
            System.out.println("Okay, let's start a game!");
            Grader grader = new Grader(code);
            int turn = 1;
            do {
                System.out.println("Turn " + turn++ + ":");
                String userTry = sc.nextLine();
                grader.setUserTry(userTry);
                grader.grade();
            } while (!grader.isCodeGuessed());
            System.out.println("Congratulations! You guessed the secret code.");
        }
    }
}
