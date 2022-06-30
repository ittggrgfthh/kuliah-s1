package src.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
// import java.awt.Font;
// import java.awt.Color;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import src.AppConfig;
import src.service.TableTransactionService;
import src.service.TransactionServiceImpl;
import src.util.ButtonUtil;
import src.util.ExitUtil;
import src.util.FieldUtil;
// import src.util.LabelUtil;

public class FrameJual extends JFrame {
    private JLabel transactionIdLabel = new JLabel("ID Transaksi"),
            idItemLabel = new JLabel("ID Barang"),
            nameItemLabel = new JLabel("Nama Barang"),
            priceItemLabel = new JLabel("Harga Barang"),
            amountItemLabel = new JLabel("Jumlah Barang"),
            totalLabel = new JLabel("Total"),
            payLabel = new JLabel("Bayar"),
            restLabel = new JLabel("Kembalian");

    private JTextField transactionIdField = new JTextField(),
            idItemField = new JTextField(),
            nameItemField = new JTextField(),
            priceItemField = new JTextField(),
            amountItemField = new JTextField(),
            totalField = new JTextField(),
            payField = new JTextField(),
            restField = new JTextField();

    private JButton sellingButton = new JButton("Jual"),
            deleteButton = new JButton("Hapus"),
            searchButton = new JButton("Cari"),
            exitButton = new JButton("Keluar");

    public FrameJual() {
        Map<String, JLabel> labelMap = new LinkedHashMap<>();
        labelMap.put("transactionId", transactionIdLabel);
        labelMap.put("idItem", idItemLabel);
        labelMap.put("nameItem", nameItemLabel);
        labelMap.put("priceItem", priceItemLabel);
        labelMap.put("amountItem", amountItemLabel);
        labelMap.put("total", totalLabel);
        labelMap.put("pay", payLabel);
        labelMap.put("rest", restLabel);
        // LabelUtil labelUtil = new LabelUtil(labelMap);

        Map<String, JTextField> fieldMap = new LinkedHashMap<>();
        fieldMap.put("transactionId", transactionIdField);
        fieldMap.put("idItem", idItemField);
        fieldMap.put("nameItem", nameItemField);
        fieldMap.put("priceItem", priceItemField);
        fieldMap.put("amountItem", amountItemField);
        fieldMap.put("total", totalField);
        fieldMap.put("pay", payField);
        fieldMap.put("rest", restField);
        FieldUtil fieldUtil = new FieldUtil(fieldMap);

        Map<String, JButton> buttonMap = new LinkedHashMap<>();
        buttonMap.put("selling", sellingButton);
        buttonMap.put("delete", deleteButton);
        buttonMap.put("search", searchButton);
        buttonMap.put("exit", exitButton);
        ButtonUtil buttonUtil = new ButtonUtil(buttonMap);

        setPreferredSize(new Dimension(971, 750));
        setTitle(AppConfig.PROGRAM_TITLE[3]);

        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        new BorderLayout();
        JDesktopPane desktopPane = new JDesktopPane();
        add(desktopPane, BorderLayout.CENTER);

        transactionIdLabel.setBounds(75, 48, 136, 44);
        idItemLabel.setBounds(75, 92, 133, 44);
        amountItemLabel.setBounds(548, 47, 200, 44);
        payLabel.setBounds(548, 91, 74, 44);
        restLabel.setBounds(548, 135, 118, 44);
        totalLabel.setBounds(548, 179, 67, 44);

        // mengatur letak objek textField pada container
        transactionIdField.setBounds(240, 54, 195, 31);
        idItemField.setBounds(240, 98, 196, 31);
        nameItemField.setBounds(75, 141, 205, 31);
        priceItemField.setBounds(298, 141, 140, 31);
        amountItemField.setBounds(719, 54, 190, 31);
        payField.setBounds(719, 98, 190, 31);
        restField.setBounds(719, 142, 190, 31);
        totalField.setBounds(719, 185, 190, 31);

        // mengatur aligment text
        priceItemField.setHorizontalAlignment(JTextField.RIGHT);
        amountItemField.setHorizontalAlignment(JTextField.RIGHT);
        payField.setHorizontalAlignment(JTextField.RIGHT);
        restField.setHorizontalAlignment(JTextField.RIGHT);
        totalField.setHorizontalAlignment(JTextField.RIGHT);

        // mengatur letak objek button pada container
        sellingButton.setBounds(85, 197, 120, 46);
        deleteButton.setBounds(368, 197, 120, 46);
        searchButton.setBounds(229, 197, 120, 46);
        exitButton.setBounds(786, 617, 120, 46);

        // mengatur button enable
        fieldUtil.setEnabled(0, 1, 0, 0, 1, 0, 1, 0);
        deleteButton.setEnabled(false);

        // Set Background Color Button
        sellingButton.setBackground(AppConfig.setColor.BLUE);
        searchButton.setBackground(AppConfig.setColor.PURPLE);
        deleteButton.setBackground(AppConfig.setColor.RED);
        exitButton.setBackground(AppConfig.setColor.BLACK);

        // Set Font Color Button
        sellingButton.setForeground(AppConfig.setColor.BLACK);
        searchButton.setForeground(AppConfig.setColor.WHITE);
        deleteButton.setForeground(AppConfig.setColor.BLACK);
        exitButton.setForeground(AppConfig.setColor.WHITE);

        // Set Font Color Label
        transactionIdLabel.setForeground(AppConfig.setColor.WHITE);
        idItemLabel.setForeground(AppConfig.setColor.WHITE);
        amountItemLabel.setForeground(AppConfig.setColor.WHITE);
        payLabel.setForeground(AppConfig.setColor.WHITE);
        restLabel.setForeground(AppConfig.setColor.WHITE);
        totalLabel.setForeground(AppConfig.setColor.WHITE);

        // Set Font Variant Label
        transactionIdLabel.setFont(AppConfig.setFont.SMALL_ARIAL);
        idItemLabel.setFont(AppConfig.setFont.SMALL_ARIAL);
        amountItemLabel.setFont(AppConfig.setFont.SMALL_ARIAL);
        payLabel.setFont(AppConfig.setFont.SMALL_ARIAL);
        restLabel.setFont(AppConfig.setFont.SMALL_ARIAL);
        totalLabel.setFont(AppConfig.setFont.SMALL_ARIAL);

        // mengatur letak objek table pada container
        String[] header = { "Id Barang", "Nama", "Harga", "Jumlah", "Total" };

        DefaultTableModel tableModel = new DefaultTableModel(null, header);
        JTable table = new JTable();
        table.setBackground(AppConfig.setColor.LIGHT_BLUE);
        table.setModel(tableModel);
        table.setEnabled(true);

        JScrollPane scrollPaneTable = new JScrollPane();
        scrollPaneTable.getViewport().add(table);
        scrollPaneTable.setBounds(85, 273, 821, 324);

        TableTransactionService tableTransactionService = new TableTransactionService(this, tableModel);

        // mengatur listerner
        idItemField.addFocusListener(
                new TransactionServiceImpl(this, null, fieldUtil, buttonUtil, tableTransactionService));
        amountItemField.addFocusListener(
                new TransactionServiceImpl(this, null, fieldUtil, buttonUtil, tableTransactionService));
        payField.addFocusListener(
                new TransactionServiceImpl(this, null, fieldUtil, buttonUtil, tableTransactionService));

        sellingButton.addActionListener(
                new TransactionServiceImpl(this, sellingButton, fieldUtil, buttonUtil, tableTransactionService));
        deleteButton.addActionListener(
                new TransactionServiceImpl(this, deleteButton, fieldUtil, buttonUtil, tableTransactionService));
        searchButton.addActionListener(
                new TransactionServiceImpl(this, searchButton, fieldUtil, buttonUtil, tableTransactionService));
        exitButton.addActionListener(new ExitUtil(this));

        // menambahkan seluruh objek kedalam desktopPane
        desktopPane.add(scrollPaneTable);

        for (JLabel label : labelMap.values()) {
            desktopPane.add(label);
        }
        for (JTextField textField : fieldMap.values()) {
            desktopPane.add(textField);
        }
        for (JButton button : buttonMap.values()) {
            desktopPane.add(button);
        }

        // menambahkan objek desktopPane ke container frame
        getContentPane().add(desktopPane);

        getContentPane().add(desktopPane).setBackground(AppConfig.setColor.DARK_GREEN);

        // menampilkan frame ke layar monitor
        pack();
        setLocationRelativeTo(null);

        TransactionServiceImpl transactionServiceImpl = new TransactionServiceImpl(this, null, fieldUtil, buttonUtil,
                tableTransactionService);
        transactionServiceImpl.setTransactionId();
    }

    public static void main(String[] args) {
        new FrameJual().setVisible(true);
    }

}
