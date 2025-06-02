package part2.app;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ShowPanel extends JPanel {
    private Image image;
    private final String imagePath = "C:\\Users\\SETUP CO\\JavaSwingExercise\\part2\\app\\images\\photo.png";

    public ShowPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        loadImage();
    }

    public void loadImage() {
        try {
            File imgFile = new File(imagePath);
            if (!imgFile.exists()) {
                System.err.println("Image not found at: " + imgFile.getAbsolutePath());
                JOptionPane.showMessageDialog(this, "Image file not found: " + imgFile.getAbsolutePath());
                return;
            }
            image = ImageIO.read(imgFile);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading image.");
        }
        repaint();
    }

    public void scaleImage(int width, int height) {
        if (image != null) {
            image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            int x = (getWidth() - image.getWidth(null)) / 2;
            int y = (getHeight() - image.getHeight(null)) / 2;
            g.drawImage(image, x, y, this);
        }
    }
}
