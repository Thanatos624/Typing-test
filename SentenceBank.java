import java.util.Random;

public class SentenceBank {
    private final String[] sentences = {
        "The quick brown fox jumps over the lazy dog.",
        "Programming is the art of telling another human what one wants the computer to do.",
        "Java is a popular programming language that is used to develop mobile and web applications.",
        "Practice makes perfect when it comes to improving your typing speed and accuracy.",
        "The early bird catches the worm but the second mouse gets the cheese."
    };
    
    public String getRandomSentence() {
        Random random = new Random();
        return sentences[random.nextInt(sentences.length)];
    }
}