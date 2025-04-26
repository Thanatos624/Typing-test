import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TypingTestEngine engine = new TypingTestEngine();
        try {
            engine.startTest();
            
            Scanner choiceScanner = new Scanner(System.in);
            while (true) {
                System.out.println("\nWould you like to try again? (yes/no)");
                String choice = choiceScanner.nextLine().toLowerCase();
                if (!choice.equals("yes")) {
                    System.out.println("Goodbye! Keep practicing!");
                    break;
                }
                engine.startTest();
            }
        } finally {
            engine.close();
        }
    }
}
