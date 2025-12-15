package frontend;

import backend.TithiDBManager;
import backend.TithiFinder;
import backend.TithiResult;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TithiFinderFrame extends JFrame {
    private JTextField nameField;
    private JDateChooser dateChooser;
    private JTextArea resultArea;

    public TithiFinderFrame() {
        setTitle("Tithi Birthday Finder");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(new JLabel("Your Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Date of Birth:"));
        dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("dd-MM-yyyy");
        panel.add(dateChooser);

        JButton findBtn = new JButton("Find My Tithi");
        panel.add(findBtn);

        resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        findBtn.addActionListener(e -> {
            String name = nameField.getText().trim();
            Date dob = dateChooser.getDate();

            if (name.isEmpty() || dob == null) {
                JOptionPane.showMessageDialog(this, "Please enter name and date.");
                return;
            }

            TithiFinder finder = new TithiFinder();
            TithiResult result = finder.findTithi(dob);

            String tithi = result.getTithiName();
            String day = result.getDay();

            if (tithi.equals("We only have data for December 2001") ||
                tithi.equals("Tithi data file not found.") ||
                tithi.equals("Error reading tithi data.") ||
                tithi.equals("No tithi data found for selected date.")) {
                resultArea.setText(tithi);
                return;
            }

            resultArea.setText("Hello " + name + "!\nYour Hindu tithi is: " + tithi +
                               "\nDay of birth: " + day);

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String dobStr = sdf.format(dob);

            // Call the updated method with 4 parameters (no tithiDate)
            TithiDBManager.insertTithiData(name, dobStr, tithi, day);
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TithiFinderFrame();
    }
}
