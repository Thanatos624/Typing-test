Typing Speed Test - Java Application
Java

A console-based typing speed test application written in Java that measures your words-per-minute (WPM) and accuracy.

Features
🚀 Random sentence generation from a predefined bank

⏱️ Real-time timer showing elapsed seconds

📊 Detailed results including:

Typing speed (WPM)

Accuracy percentage

Time taken

📝 Side-by-side comparison of original vs typed text

🏆 Performance feedback based on your results

🔄 Option to retake the test immediately

How to Use
Clone the repository:

bash
git clone https://github.com/yourusername/typing-speed-test-java.git
Compile and run the application:

bash
javac *.java
java Main
Follow the on-screen instructions:

Read the sentence carefully

Press Enter when ready to start typing

Type the sentence as accurately and quickly as possible

View your results and decide whether to try again

Results Display
The application presents results in a clean box format:

╔════════════════════════════╗
║       TYPING RESULTS      ║
╠══════════════╦═══════════╣
║ Time: 12.34  ║ seconds   ║
╠══════════════╬═══════════╣
║ Speed: 45.67 ║ WPM       ║
╠══════════════╬═══════════╣
║ Accuracy: 98.76% ║           ║
╚══════════════╩═══════════╝
Performance Feedback
The application provides motivational feedback based on your performance:

Speed categories:

60 WPM: "Professional level!"

40-60 WPM: "Above average typist!"

30-40 WPM: "Average speed"

<30 WPM: "Below average speed"

Accuracy categories:

98%: "Perfect accuracy!"

95-98%: "Good accuracy"

<95%: "Needs improvement"

Requirements
Java JDK 17 or higher

Any terminal that supports ANSI escape codes (for screen clearing)

Customization
You can easily modify the application by:

Adding more sentences to SentenceBank.java

Adjusting the performance thresholds in TypingTestEngine.java

Changing the display format in the displayResults method
--------------------------------------------------------------------------

Happy typing! 🎯
