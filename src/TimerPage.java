import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerPage extends JFrame {
    private JLabel timerLabel;
    private JButton stopButton;
    private long startTime;
    private long totalTimeWatched;

    public TimerPage(String topic) {
        // Setup the frame
        setTitle("Tracking Time: " + topic);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        timerLabel = new JLabel("Time: 0 seconds", JLabel.CENTER);
        stopButton = new JButton("Stop and Proceed");

        // Layout
        setLayout(new BorderLayout());
        add(timerLabel, BorderLayout.CENTER);
        add(stopButton, BorderLayout.SOUTH);

        // Start the timer
        startTime = System.currentTimeMillis();
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long elapsed = (System.currentTimeMillis() - startTime) / 1000;
                timerLabel.setText("Time: " + elapsed + " seconds");
            }
        });
        timer.start();

        // Stop button action
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
                totalTimeWatched = (System.currentTimeMillis() - startTime) / 1000;
                JOptionPane.showMessageDialog(null, "You watched for " + totalTimeWatched + " seconds.");
                new QuestionPage(topic, totalTimeWatched).setVisible(true);
                dispose();
            }
        });
    }
}
