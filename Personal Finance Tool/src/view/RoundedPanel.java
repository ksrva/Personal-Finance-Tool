/*
 * Design class used instead of JPanel for round panels 
 */



package view;

import javax.swing.*;
import java.awt.*;

//Code for rounded panel was referenced from : https://www.youtube.com/watch?v=4PRqBDDixWE
public class RoundedPanel extends JPanel {
    private int cornerRadius;

    public RoundedPanel(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        setOpaque(false); // Make the panel transparent
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw rounded rectangle with the specified corner radius
        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, width - 1, height - 1, cornerRadius, cornerRadius);

        g2d.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 200); // Adjust the size as needed
    }

}