package com.example.employeemanagementsystem;

import javax.swing.*;
import java.awt.*;

public class HeaderPanel extends JPanel {

    public HeaderPanel(String title) {

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1000, 100));
        setBackground(new Color(100, 125, 235));

        JLabel imageLabel = new JLabel("👥");
        imageLabel.setForeground(Color.WHITE);
        imageLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 34));

        imageLabel.setBorder(
                BorderFactory.createEmptyBorder(
                        10, 20, 10, 10
                )
        );

        JLabel titleLabel =
                new JLabel(title, SwingConstants.CENTER);

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 26)
        );

        titleLabel.setForeground(Color.WHITE);

        add(imageLabel, BorderLayout.WEST);
        add(titleLabel, BorderLayout.CENTER);
    }
}


