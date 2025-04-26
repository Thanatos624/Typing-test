public class TestResult {
    private final double wpm;
    private final double accuracy;
    private final double timeSeconds;
    
    public TestResult(double wpm, double accuracy, double timeSeconds) {
        this.wpm = wpm;
        this.accuracy = accuracy;
        this.timeSeconds = timeSeconds;
    }
    
    public double getWpm() {
        return wpm;
    }
    
    public double getAccuracy() {
        return accuracy;
    }
    
    public double getTimeSeconds() {
        return timeSeconds;
    }
}