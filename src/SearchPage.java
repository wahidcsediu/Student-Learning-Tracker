import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPage extends JFrame {
    private JTextField searchField;
    private JButton searchButton;

    public SearchPage() {
        // Setup the frame
        setTitle("Search Topics");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        searchField = new JTextField(20);
        searchButton = new JButton("Search on YouTube");

        // Add components to the frame
        setLayout(new FlowLayout());
        add(new JLabel("Enter a topic:"));
        add(searchField);
        add(searchButton);

        // Add action listener to the search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String topic = searchField.getText();
                if (!topic.isEmpty()) {
                    // Open YouTube in the browser
                    try {
                        Desktop.getDesktop().browse(new java.net.URI("https://www.youtube.com/results?search_query=" + topic));
                        new TimerPage(topic).setVisible(true); // Open the TimerPage
                        dispose(); // Close the current page
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Failed to open YouTube.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a topic!");
                }
            }
        });
    }
}
