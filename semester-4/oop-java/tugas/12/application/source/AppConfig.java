package src;

import java.awt.Color;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

// import javax.swing.plaf.ColorUIResource;

import src.entity.Pegawai;
import src.entity.Transaction;

public class AppConfig {

    public static Properties properties;

    public static Properties configProp(String appProp) {
        Properties properties = new Properties();
        try {
            InputStream inputStream = new FileInputStream(appProp);
            // load a properties file from class path, inside static method
            properties.load(inputStream);
            return properties;
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File " + appProp + " tidak ditemukan.");
            return properties;
        } catch (IOException ioException) {
            System.err.println("File " + appProp + " tidak bisa di load.");
            return properties;
        }
    }

    public class setColor {
        public static final Color BLACK = new Color(0, 0, 0);
        public static final Color BLUE = new Color(45, 58, 247);
        public static final Color RED = new Color(255, 0, 0);
        public static final Color YELLOW = new Color(250, 250, 0);
        public static final Color PURPLE = new Color(225, 0, 250);
        public static final Color WHITE = new Color(255, 255, 255);
        public static final Color DARK_GREEN = new Color(4, 69, 66);
        public static final Color LIGHT_BLUE = new Color(190, 217, 250);
        public static final Color LIGHT_GREEN = new Color(174, 242, 197);
    }

    public class setFont {
        public static final Font TIMES_ROMAN = new Font("TimesRoman", Font.PLAIN, 16);
        public static final Font BIG_ARIAL = new Font("Arial", Font.BOLD, 26);
        public static final Font SMALL_ARIAL = new Font("Arial", Font.BOLD, 20);
    }

    public static String NIM;
    public static String FULLNAME_AUTHOR;
    public static String AUTHOR;

    public static String[] PROGRAM_TITLE = {
            "Program Pegawai",
            "Program Barang",
            "Menu Penjualan",
            "Transaksi Penjualan",
            "Cetak Laporan" };

    public static Pegawai pegawai;
    public static List<Transaction> listTransaction = new ArrayList<>();

}
