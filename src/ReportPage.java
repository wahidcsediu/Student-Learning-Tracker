import javax.swing.*;

public class ReportPage extends JFrame {
    public ReportPage(String topic, long watchTime, int correctAnswers, int totalQuestions) {
        // Setup frame
        setTitle("Report on " + topic);
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create report
        String report = "<html>Topic: " + topic + "<br>"
                + "Time Watched: " + watchTime + " seconds<br>"
                + "Correct Answers: " + correctAnswers + "/" + totalQuestions + "<br>"
                + "Suggestion: " + (correctAnswers < totalQuestions / 2 ? "Needs Improvement" : "Good Job!") + "</html>";

        JLabel reportLabel = new JLabel(report, JLabel.CENTER);
        add(reportLabel);
    }
}
