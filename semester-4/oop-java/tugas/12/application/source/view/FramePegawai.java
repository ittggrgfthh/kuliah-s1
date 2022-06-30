package src.view;

// import java.awt.Color;
import java.awt.Dimension;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import javax.swing.JDesktopPane;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import javax.swing.table.DefaultTableModel;

import src.AppConfig;

import src.service.PegawaiServiceImpl;
import src.service.TablePegawaiService;

import src.util.ButtonUtil;
import src.util.ExitUtil;
import src.util.FieldUtil;
import src.util.LabelUtil;

public class FramePegawai extends JFrame {
    // @SuppressWarnings("unused")
    // private JPanel panelPegawai = new JPanel();

    private JLabel nipLabel = new JLabel("NIP"),
            nameLabel = new JLabel("Nama"),
            departmentLabel = new JLabel("Bagian"),
            genderLabel = new JLabel("Jenis Kelamin"),
            passwordLabel = new JLabel("Password");

    private JTextField nipField = new JTextField(),
            nameField = new JTextField(),
            departmentField = new JTextField(),
            genderField = new JTextField(),
            passwordField = new JTextField();

    private JButton addButton = new JButton("Tambah"),
            searchButton = new JButton("Pilih"),
            updateButton = new JButton("Edit"),
            deleteButton = new JButton("Hapus"),
            exitButton = new JButton("Keluar");

    public FramePegawai() {
        Map<String, JLabel> labelMap = new LinkedHashMap<>();
        labelMap.put("nip", nipLabel);
        labelMap.put("name", nameLabel);
        labelMap.put("department", departmentLabel);
        labelMap.put("gender", genderLabel);
        labelMap.put("password", passwordLabel);
        LabelUtil labelUtil = new LabelUtil(labelMap);
        for (JLabel label : labelUtil.list) {
            label.setForeground(AppConfig.setColor.WHITE);
            label.setFont(AppConfig.setFont.SMALL_ARIAL);
        }

        Map<String, JTextField> fieldMap = new LinkedHashMap<>();
        fieldMap.put("nip", nipField);
        fieldMap.put("name", nameField);
        fieldMap.put("department", departmentField);
        fieldMap.put("gender", genderField);
        fieldMap.put("password", passwordField);
        FieldUtil fieldUtil = new FieldUtil(fieldMap);

        Map<String, JButton> buttonMap = new LinkedHashMap<>();
        buttonMap.put("add", addButton);
        buttonMap.put("search", searchButton);
        buttonMap.put("update", updateButton);
        buttonMap.put("delete", deleteButton);
        buttonMap.put("exit", exitButton);
        ButtonUtil buttonUtil = new ButtonUtil(buttonMap);

        setPreferredSize(new Dimension(971, 750));
        setTitle(AppConfig.PROGRAM_TITLE[0]);

        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JDesktopPane desktopPane = new JDesktopPane();

        /* Mengatur letak objek Label Di Container */
        nipLabel.setBounds(75, 48, 54, 44);
        nameLabel.setBounds(75, 92, 75, 44);
        genderLabel.setBounds(75, 136, 149, 44);
        departmentLabel.setBounds(548, 47, 85, 44);
        passwordLabel.setBounds(548, 91, 113, 44);

        /* Mengatur letak objek Text Di Container */
        nipField.setBounds(243, 55, 140, 31);
        nameField.setBounds(243, 99, 273, 31);
        genderField.setBounds(243, 143, 190, 31);
        departmentField.setBounds(716, 54, 190, 31);
        passwordField.setBounds(716, 98, 190, 31);

        /* Mengatur letak objek Button Di Container */
        addButton.setBounds(85, 197, 120, 46);
        searchButton.setBounds(229, 197, 120, 46);
        updateButton.setBounds(368, 197, 120, 46);
        deleteButton.setBounds(503, 197, 120, 46);
        exitButton.setBounds(786, 617, 120, 46);

        nipField.setToolTipText("Isi Nip dengan Angka!");

        // membuat tabel.......................................
        String[] header = { "NIP", "Nama", "Bagian", "Jenis Kelamin", "Password" };
        DefaultTableModel tableModel = new DefaultTableModel(null, header);
        JTable tabel = new JTable();
        tabel.setModel(tableModel);
        tabel.setBackground(AppConfig.setColor.LIGHT_BLUE);
        tabel.setEnabled(false);

        JScrollPane scrollPaneTable = new JScrollPane();
        scrollPaneTable.getViewport().add(tabel);
        scrollPaneTable.setBounds(85, 273, 821, 324);

        exitButton.setToolTipText("Mengakhiri Program");

        // Set Background Color Button
        addButton.setBackground(AppConfig.setColor.BLUE);
        searchButton.setBackground(AppConfig.setColor.PURPLE);
        updateButton.setBackground(AppConfig.setColor.YELLOW);
        deleteButton.setBackground(AppConfig.setColor.RED);
        exitButton.setBackground(AppConfig.setColor.BLACK);

        // Set Font Color Button
        addButton.setForeground(AppConfig.setColor.WHITE);
        searchButton.setForeground(AppConfig.setColor.WHITE);
        updateButton.setForeground(AppConfig.setColor.BLACK);
        deleteButton.setForeground(AppConfig.setColor.BLACK);
        exitButton.setForeground(AppConfig.setColor.WHITE);

        /* Objek Button di Non Aktifkan dan di aktifkan */
        addButton.setEnabled(true);
        exitButton.setEnabled(true);

        // Mengatur objek untuk dapat berinteraksi
        TablePegawaiService tablePegawaiService = new TablePegawaiService(this, tableModel);
        addButton
                .addActionListener(new PegawaiServiceImpl(this, addButton, fieldUtil, buttonUtil, tablePegawaiService));
        searchButton.addActionListener(
                new PegawaiServiceImpl(this, searchButton, fieldUtil, buttonUtil, tablePegawaiService));
        updateButton.addActionListener(
                new PegawaiServiceImpl(this, updateButton, fieldUtil, buttonUtil, tablePegawaiService));
        deleteButton.addActionListener(
                new PegawaiServiceImpl(this, deleteButton, fieldUtil, buttonUtil, tablePegawaiService));
        exitButton.addActionListener(new ExitUtil(this));

        nipField.addActionListener(new PegawaiServiceImpl(this, null, fieldUtil, buttonUtil, tablePegawaiService));
        nameField.addActionListener(new PegawaiServiceImpl(this, null, fieldUtil, buttonUtil, tablePegawaiService));
        departmentField
                .addActionListener(new PegawaiServiceImpl(this, null, fieldUtil, buttonUtil, tablePegawaiService));
        genderField.addActionListener(new PegawaiServiceImpl(this, null, fieldUtil, buttonUtil, tablePegawaiService));
        passwordField.addActionListener(new PegawaiServiceImpl(this, null, fieldUtil, buttonUtil, tablePegawaiService));

        // Meletakkan seluruh kontrol pada objek panel */
        for (JLabel label : labelMap.values()) {
            desktopPane.add(label);
        }

        for (JTextField textField : fieldMap.values()) {
            desktopPane.add(textField);
        }

        for (JButton button : buttonMap.values()) {
            desktopPane.add(button);
        }

        desktopPane.add(scrollPaneTable);

        getContentPane().add(desktopPane).setBackground(AppConfig.setColor.DARK_GREEN);

        pack();
        setLocationRelativeTo(null);
        tablePegawaiService.updateDataTable();
        fieldUtil.setBlank();
        fieldUtil.setEnabled(false);
    }

    public static void main(String[] args) {
        new FramePegawai().setVisible(true);
    }
}