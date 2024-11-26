import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestionPage extends JFrame {
    private JLabel questionLabel;
    private JButton[] optionButtons;
    private int currentQuestion = 0;
    private int correctAnswers = 0;
    private String topic;
    private long watchTime;

    private String[][] questions = {
        {"What is Java?", "Programming Language", "Coffee", "Animal", "Planet", "Programming Language"},
        {"What does JVM stand for?", "Java Virtual Machine", "Java Vision Module", "Just Virtual Memory", "None", "Java Virtual Machine"},
        // Add more questions as needed
    };

    public QuestionPage(String topic, long watchTime) {
        this.topic = topic;
        this.watchTime = watchTime;

        // Setup frame
        setTitle("Questions on " + topic);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        questionLabel = new JLabel("", JLabel.CENTER);
        optionButtons = new JButton[4];
        JPanel optionsPanel = new JPanel(new GridLayout(2, 2));

        for (int i = 0; i < optionButtons.length; i++) {
            optionButtons[i] = new JButton();
            optionsPanel.add(optionButtons[i]);
            int index = i;
            optionButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    checkAnswer(optionButtons[index].getText());
                }
            });
        }

        setLayout(new BorderLayout());
        add(questionLabel, BorderLayout.NORTH);
        add(optionsPanel, BorderLayout.CENTER);

        loadNextQuestion();
    }

    private void loadNextQuestion() {
        if (currentQuestion < questions.length) {
            questionLabel.setText(questions[currentQuestion][0]);
            for (int i = 0; i < 4; i++) {
                optionButtons[i].setText(questions[currentQuestion][i + 1]);
            }
        } else {
            JOptionPane.showMessageDialog(this, "You answered " + correctAnswers + " out of " + questions.length);
            new ReportPage(topic, watchTime, correctAnswers, questions.length).setVisible(true);
            dispose();
        }
    }

    private void checkAnswer(String answer) {
        if (answer.equals(questions[currentQuestion][5])) {
            correctAnswers++;
        }
        currentQuestion++;
        loadNextQuestion();
    }
}
