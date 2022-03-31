import java.util.Scanner;

public class Latihan04c {
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        String nama, Prodi;
        int nilai;
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Data Tes");
            System.out.println("==========================");
            System.out.print("Nama     : ");
            nama = input.nextLine();
            System.out.print("Prodi    : ");
            Prodi = input.nextLine();
            System.out.print("Nilai    : ");
            nilai = input.nextInt();

            if (nilai > 80 && nilai <= 100) {
                System.out.println("\nNilai Huruf A");
            } else if (nilai > 65 && nilai <= 80) {
                System.out.println("\nNilai Huruf B");
            } else if (nilai > 50 && nilai <= 65) {
                System.out.println("\nNilai Huruf C");
            } else if (nilai > 40 && nilai <= 50) {
                System.out.println("\nNilai Huruf D");
            } else if (nilai <= 40) {
                System.out.println("\nNilai Huruf E");
            }
        }
    }
}
