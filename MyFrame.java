import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {

    private JRadioButton birdButton, catButton, dogButton, rabbitButton, pigButton;
    private JLabel imageLabel;

    MyFrame() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("RadioButtonDemo");
        this.setSize(400, 250);
        this.setLocationRelativeTo(null); // Center the frame on the screen
        this.getContentPane().setBackground(Color.green);

        // Create a panel for the radio buttons
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));
        radioPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding

        // Create radio buttons
        birdButton = createRadioButton("Bird");
        catButton = createRadioButton("Cat");
        dogButton = createRadioButton("Dog");
        rabbitButton = createRadioButton("Rabbit");
        pigButton = createRadioButton("Pig");

        // Add radio buttons to the radio panel
        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(dogButton);
        radioPanel.add(rabbitButton);
        radioPanel.add(pigButton);

        // Group the radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(rabbitButton);
        group.add(pigButton);

        // Load a default image (optional, can start with no image)
        imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(200, 200)); // Set preferred size for image display
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center the image horizontally

        // Create a main panel to hold the radio buttons and image label
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Align components to the left
        mainPanel.add(radioPanel); // Add the radio buttons panel
        mainPanel.add(imageLabel); // Add the image label to the right

        // Add the main panel to the frame
        add(mainPanel);

        // Make the frame visible
        this.setVisible(true);
    }

    private JRadioButton createRadioButton(String name) {
        JRadioButton button = new JRadioButton(name);
        button.addActionListener(new RadioButtonListener());
        return button;
    }

    private class RadioButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String buttonName = ((JRadioButton) e.getSource()).getText(); // Get the button text
            // Load the corresponding image based on the button name
            String imagePath = "assets/" + buttonName.toLowerCase() + ".jpeg"; // Update with your image path
            ImageIcon imageIcon = new ImageIcon(imagePath);
            imageLabel.setIcon(imageIcon); // Set the icon for the JLabel
        }
    }
}
