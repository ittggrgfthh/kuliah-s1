package src.view;

import java.awt.Dimension;
import java.util.LinkedHashMap;
import java.util.Map;
// import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import src.AppConfig;
import src.service.LoginServiceImpl;
import src.util.ButtonUtil;
import src.util.ExitUtil;
import src.util.FieldUtil;

public class FrameLogin extends JFrame {
    private JLabel nipLabel = new JLabel("NIP"),
            passwordLabel = new JLabel("Password");

    private JTextField nipField = new JTextField(),
            passwordField = new JPasswordField();

    private JButton loginButton = new JButton("Login"),
            exitButton = new JButton("Cancel");

    public FrameLogin() {

        Map<String, JTextField> fieldMap = new LinkedHashMap<>();
        fieldMap.put("nip", nipField);
        fieldMap.put("password", passwordField);
        FieldUtil fieldUtil = new FieldUtil(fieldMap);

        Map<String, JButton> buttonMap = new LinkedHashMap<>();
        buttonMap.put("login", loginButton);
        buttonMap.put("exit", exitButton);
        ButtonUtil buttonUtil = new ButtonUtil(buttonMap);

        setPreferredSize(new Dimension(400, 230));
        setTitle("LOGIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JDesktopPane desktopPane = new JDesktopPane();

        /* Mengatur letak objek Label Di container */
        nipLabel.setBounds(19, 30, 37, 29);
        passwordLabel.setBounds(19, 66, 84, 29);

        /* Mengatur letak objek Text Di Container */
        nipField.setBounds(134, 31, 97, 31);
        passwordField.setBounds(134, 68, 166, 27);

        nipField.setToolTipText("Isi Nip dengan Angka !");

        /* Mengatur letak objek Button di Container */
        loginButton.setBounds(192, 122, 82, 39);
        exitButton.setBounds(285, 122, 82, 39);
        exitButton.setToolTipText("Menutup Program");

        // set font
        nipLabel.setForeground(AppConfig.setColor.WHITE);
        passwordLabel.setForeground(AppConfig.setColor.WHITE);

        // Mengatur objek untuk dapat berinteraksi
        nipField.addFocusListener(new LoginServiceImpl(this, fieldUtil, buttonUtil));
        loginButton.addActionListener(new LoginServiceImpl(this, fieldUtil, buttonUtil));
        exitButton.addActionListener(new ExitUtil(this));

        // Meletakkan seluruh kontrol pada objek panel */
        desktopPane.add(nipLabel);
        desktopPane.add(nipField);
        desktopPane.add(passwordLabel);
        desktopPane.add(passwordField);
        desktopPane.add(loginButton);
        desktopPane.add(exitButton);

        /* Menambahkan objek panel (pPgr) ke container frame */
        getContentPane().add(desktopPane).setBackground(AppConfig.setColor.DARK_GREEN);

        /* Menampilkan frame ke layar monitor */
        pack();
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        new FrameLogin().setVisible(true);
    }

}
