package frontend;

import java.awt.*;

public class MainFrame extends Frame {
    public MainFrame(String username) {
        setTitle("Welcome");
        setSize(400, 200);
        setLayout(null);
        setBackground(new Color(0, 102, 102));

        Label lbl = new Label("Hello " + username + "! Welcome to Tithi Finder App");
        lbl.setBounds(50, 80, 300, 30);
        lbl.setForeground(Color.white);
        add(lbl);

        setVisible(true);
    }

    public static void main(String[] args) {
        // For testing purposes, you can pass a sample username
        new MarvellousLogin(); // This opens login screen first
    }
}
