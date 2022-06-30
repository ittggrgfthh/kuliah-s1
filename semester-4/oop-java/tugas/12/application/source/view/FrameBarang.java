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

import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import src.AppConfig;

import src.service.BarangServiceImpl;
import src.service.TableBarangService;

import src.util.ButtonUtil;
import src.util.ExitUtil;
import src.util.FieldUtil;
import src.util.LabelUtil;

public class FrameBarang extends JFrame {
    // @SuppressWarnings("unused")
    // private JPanel panelBarang = new JPanel();

    private JLabel idLabel = new JLabel("ID"),
            nameLabel = new JLabel("Nama"),
            sellingPriceLabel = new JLabel("Harga Jual"),
            purchasePriceLabel = new JLabel("Harga Beli"),
            amountLabel = new JLabel("Jumlah");

    private JTextField idField = new JTextField(),
            nameField = new JTextField(),
            sellingPriceField = new JTextField(),
            purchasePriceField = new JTextField(),
            amountField = new JTextField();

    private JButton addButton = new JButton("Tambah"),
            searchButton = new JButton("Pilih"),
            updateButton = new JButton("Edit"),
            deleteButton = new JButton("Hapus"),
            exitButton = new JButton("Keluar");

    public FrameBarang() {
        Map<String, JLabel> labelMap = new LinkedHashMap<>();
        labelMap.put("id", idLabel);
        labelMap.put("name", nameLabel);
        labelMap.put("sellingPrice", sellingPriceLabel);
        labelMap.put("purchasePrice", purchasePriceLabel);
        labelMap.put("amount", amountLabel);
        LabelUtil labelUtil = new LabelUtil(labelMap);
        for (JLabel label : labelUtil.list) {
            label.setForeground(AppConfig.setColor.WHITE);
            label.setFont(AppConfig.setFont.SMALL_ARIAL);
        }

        Map<String, JTextField> fieldMap = new LinkedHashMap<>();
        fieldMap.put("id", idField);
        fieldMap.put("name", nameField);
        fieldMap.put("sellingPrice", sellingPriceField);
        fieldMap.put("purchasePrice", purchasePriceField);
        fieldMap.put("amount", amountField);
        FieldUtil fieldUtil = new FieldUtil(fieldMap);

        Map<String, JButton> buttonMap = new LinkedHashMap<>();
        buttonMap.put("add", addButton);
        buttonMap.put("search", searchButton);
        buttonMap.put("update", updateButton);
        buttonMap.put("delete", deleteButton);
        buttonMap.put("exit", exitButton);
        ButtonUtil buttonUtil = new ButtonUtil(buttonMap);

        setPreferredSize(new Dimension(971, 750));
        setTitle(AppConfig.PROGRAM_TITLE[1]);

        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JDesktopPane desktopPane = new JDesktopPane();

        /* Mengatur letak objek Label Di Container */
        idLabel.setBounds(75, 48, 54, 44);
        nameLabel.setBounds(75, 92, 75, 44);
        sellingPriceLabel.setBounds(548, 47, 121, 44);
        purchasePriceLabel.setBounds(548, 91, 121, 44);
        amountLabel.setBounds(548, 135, 100, 44);

        /* Mengatur letak objek Text Di Container */
        idField.setBounds(243, 55, 140, 31);
        nameField.setBounds(243, 99, 273, 31);
        sellingPriceField.setBounds(716, 54, 190, 31);
        purchasePriceField.setBounds(716, 98, 190, 31);
        amountField.setBounds(716, 142, 190, 31);

        /* Mengatur letak objek Button Di Container */
        addButton.setBounds(85, 197, 120, 46);
        searchButton.setBounds(229, 197, 120, 46);
        updateButton.setBounds(368, 197, 120, 46);
        deleteButton.setBounds(503, 197, 120, 46);
        exitButton.setBounds(786, 617, 120, 46);

        idField.setToolTipText("Isi Kode dengan Angka!");

        // membuat tabel.......................................
        String[] header = { "Kode", "Nama", "Harga Jual", "Harga Beli", "Jumlah" };
        DefaultTableModel tableModel = new DefaultTableModel(null, header);
        JTable tabel = new JTable();
        tabel.setModel(tableModel);
        tabel.setBackground(AppConfig.setColor.LIGHT_BLUE);
        tabel.setEnabled(false);

        JScrollPane scrollPaneTable = new JScrollPane();
        scrollPaneTable.getViewport().add(tabel);

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
        TableBarangService tableBarangService = new TableBarangService(this, tableModel);
        addButton.addActionListener(new BarangServiceImpl(this, addButton, fieldUtil, buttonUtil, tableBarangService));
        searchButton.addActionListener(
                new BarangServiceImpl(this, searchButton, fieldUtil, buttonUtil, tableBarangService));
        updateButton.addActionListener(
                new BarangServiceImpl(this, updateButton, fieldUtil, buttonUtil, tableBarangService));
        deleteButton.addActionListener(
                new BarangServiceImpl(this, deleteButton, fieldUtil, buttonUtil, tableBarangService));
        exitButton.addActionListener(new ExitUtil(this));

        idField.addActionListener(new BarangServiceImpl(this, null, fieldUtil, buttonUtil, tableBarangService));
        nameField.addActionListener(new BarangServiceImpl(this, null, fieldUtil, buttonUtil, tableBarangService));
        sellingPriceField
                .addActionListener(new BarangServiceImpl(this, null, fieldUtil, buttonUtil, tableBarangService));
        purchasePriceField
                .addActionListener(new BarangServiceImpl(this, null, fieldUtil, buttonUtil, tableBarangService));
        amountField.addActionListener(new BarangServiceImpl(this, null, fieldUtil, buttonUtil, tableBarangService));

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
        scrollPaneTable.setBounds(85, 273, 821, 324);

        getContentPane().add(desktopPane).setBackground(AppConfig.setColor.DARK_GREEN);

        pack();
        setLocationRelativeTo(null);
        tableBarangService.updateDataTable();
        fieldUtil.setBlank();
        fieldUtil.setEnabled(false);
    }

    public static void main(String[] args) {
        new FrameBarang().setVisible(true);
    }
}