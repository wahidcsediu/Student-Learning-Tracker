import javax.swing.*;

public class MainApp {
    public static void main(String[] args) {
        // Launch the Search Page
        SwingUtilities.invokeLater(() -> {
            SearchPage searchPage = new SearchPage();
            searchPage.setVisible(true);
        });
    }
}
