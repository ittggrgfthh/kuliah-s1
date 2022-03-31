import java.util.Scanner;

public class Latihan02j {
    public static void main(String[] args) {
        try (Scanner u_input = new Scanner(System.in)) {
            String nama;
            int nilai1, nilai2 = 0;
            float rata2;

            System.out.print("Nama        : ");
            nama = u_input.next();
            System.out.print("Nilai 1     : ");
            nilai1 = u_input.nextInt();
            System.out.print("Nilai 2     : ");
            nilai2 = u_input.nextInt();
            System.out.println("====================================");
            rata2 = (nilai1 + nilai2) / 2;
            System.out.println("Nama        : " + nama);
            System.out.println("Rata - rata : " + rata2);
        }
    }
}
