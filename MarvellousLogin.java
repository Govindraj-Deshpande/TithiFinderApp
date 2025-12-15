package frontend;

import java.awt.*;
import java.awt.event.*;

public class MarvellousLogin extends Frame implements ActionListener {
    TextField txtUser;
    Button btnLogin;
    Label lblWelcome;

    public MarvellousLogin() {
        setTitle("Marvellous Login");
        setSize(400, 200);
        setLayout(null);
        setBackground(new Color(51, 0, 102));

        lblWelcome = new Label("Enter your name:");
        lblWelcome.setBounds(80, 60, 150, 30);
        lblWelcome.setForeground(Color.white);
        add(lblWelcome);

        txtUser = new TextField();
        txtUser.setBounds(220, 60, 100, 30);
        add(txtUser);

        btnLogin = new Button("Login");
        btnLogin.setBounds(150, 110, 100, 30);
        btnLogin.addActionListener(this);
        add(btnLogin);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String user = txtUser.getText().trim();
        if (!user.equals("")) {
            this.dispose();
            new TithiFinderFrame();
        }
    }

    public static void main(String[] args) {
        new MarvellousLogin();
    }
}
