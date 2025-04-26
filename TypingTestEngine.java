import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class TypingTestEngine {
    private final SentenceBank sentenceBank = new SentenceBank();
    private final Scanner scanner = new Scanner(System.in);
    
    private class TimerThread extends Thread {
        private final AtomicBoolean running = new AtomicBoolean(true);
        private final long startTime;
        
        public TimerThread(long startTime) {
            this.startTime = startTime;
        }
        
        public void stopTimer() {
            running.set(false);
        }
        
        @Override
        public void run() {
            while (running.get()) {
                try {
                    Thread.sleep(1000);
                    long elapsed = (System.currentTimeMillis() - startTime) / 1000;
                    System.out.print("\rTime elapsed: " + elapsed + " seconds");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }
    
    
    
    private TestResult calculateResults(String original, String typed, long start, long end) {
        double timeSeconds = (end - start) / 1000.0;
        double minutes = timeSeconds / 60.0;
        
        int wordCount = original.trim().split("\\s+").length;
        double wpm = wordCount / minutes;
        
        int correctChars = 0;
        int minLength = Math.min(original.length(), typed.length());
        
        for (int i = 0; i < minLength; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                correctChars++;
            }
        }
        
        double accuracy = ((double) correctChars / original.length()) * 100;
        
        return new TestResult(wpm, accuracy, timeSeconds);
    }
    
    private void displayResults(TestResult result) {
        System.out.println("\n\n╔════════════════════════════╗");
        System.out.println("║       TYPING RESULTS      ║");
        System.out.println("╠══════════════╦═══════════╣");
        System.out.printf("║ Time: %-7.2f ║ seconds   ║\n", result.getTimeSeconds());
        System.out.println("╠══════════════╬═══════════╣");
        System.out.printf("║ Speed: %-6.2f ║ WPM       ║\n", result.getWpm());
        System.out.println("╠══════════════╬═══════════╣");
        System.out.printf("║ Accuracy: %-4.2f%% ║           ║\n", result.getAccuracy());
        System.out.println("╚══════════════╩═══════════╝");
        
        // Performance feedback
        System.out.println("\nPerformance Feedback:");
        if (result.getWpm() > 60) {
            System.out.println("★ Excellent typing speed! Professional level!");
        } else if (result.getWpm() > 40) {
            System.out.println("★ Good speed! Above average typist!");
        } else if (result.getWpm() > 30) {
            System.out.println("★ Average speed. Keep practicing!");
        } else {
            System.out.println("★ Below average speed. Try to type faster!");
        }
        
        if (result.getAccuracy() > 98) {
            System.out.println("★ Perfect accuracy! Great attention to detail!");
        } else if (result.getAccuracy() > 95) {
            System.out.println("★ Good accuracy. Just a few mistakes!");
        } else {
            System.out.println("★ Accuracy needs improvement. Focus on precision!");
        }
    }
    
    public void startTest() {
        // Clear screen (works on most terminals)
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        System.out.println("\n══════════════════════════════════════");
        System.out.println("         TYPING SPEED TEST          ");
        System.out.println("══════════════════════════════════════");
        
        String sentence = sentenceBank.getRandomSentence();
        System.out.println("\nType the following sentence:\n");
        System.out.println("  \"" + sentence + "\"");
        
        System.out.println("\n══════════════════════════════════════");
        System.out.print("Press Enter when you're ready to start...");
        scanner.nextLine();
        
        long startTime = System.currentTimeMillis();
        System.out.print("\033[H\033[2J"); // Clear screen again
        System.out.flush();
        
        System.out.println("\nSTART TYPING NOW:\n");
        System.out.println("  \"" + sentence + "\"");
        System.out.print("\n> ");
        
        TimerThread timer = new TimerThread(startTime);
        timer.start();
        
        String userInput = scanner.nextLine();
        timer.stopTimer();
        long endTime = System.currentTimeMillis();
        
        System.out.print("\033[H\033[2J"); // Clear screen for results
        System.out.flush();
        
        TestResult result = calculateResults(sentence, userInput, startTime, endTime);
        displayResults(result);
        
        // Display comparison
        System.out.println("\nOriginal vs Your Typing:");
        System.out.println("Original:  " + sentence);
        System.out.print("You typed: ");
        for (int i = 0; i < Math.max(sentence.length(), userInput.length()); i++) {
            if (i >= userInput.length()) {
                System.out.print("_"); // Missing characters
            } else if (i >= sentence.length()) {
                System.out.print(userInput.charAt(i)); // Extra characters
            } else if (userInput.charAt(i) == sentence.charAt(i)) {
                System.out.print(userInput.charAt(i)); // Correct
            } else {
                System.out.print(userInput.charAt(i)); // Incorrect
            }
        }
        System.out.println();
    }
    
    public void close() {
        scanner.close();
    }
}