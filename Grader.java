package bullscows;

public class Grader {

    private final String code;
    private String userTry;
    private boolean isCodeGuessed;

    protected Grader(String code) {
        this.code = code;
    }

    protected boolean isCodeGuessed() {
        return this.isCodeGuessed;
    }

    protected void setUserTry(String userTry) {
        this.userTry = userTry;
    }

    protected void grade() {
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < this.code.length(); i++) {
            if (this.userTry.charAt(i) == this.code.charAt(i)) bull++;
        }
        for (char c : this.code.toCharArray()) {
            for (char ch : this.userTry.toCharArray()) {
                if (ch == c) cow++;
            }
        }
        cow -= bull;
        if (cow > 0 && bull > 0) {
            System.out.println("Grade: " + bull + " bull(s) and " + cow + " cow(s)");
        } else if (cow == 0 && bull > 0) {

            System.out.println("Grade: " + bull + " bull(s)");
        } else if (cow > 0 && bull == 0) {
            System.out.println("Grade: " + cow + " cow(s)");
        } else {
            System.out.println("Grade: None");
        }
        this.isCodeGuessed = bull == this.code.length();
    }
}
