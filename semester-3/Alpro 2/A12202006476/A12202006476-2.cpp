#include <iostream.h>
#include <conio.h>

struct smhs{
	char nim[5], nama[15];
	float nilai;
} mahasiswa;

void main(){
	clrscr();
	//input data.........................
	cout << "\nIsi Data Mahasiswa : \n";
	cout << "Masukan NIM    = "; cin >> mahasiswa.nim;
	cout << "Masukan Nama   = "; cin >> mahasiswa.nama;
	cout << "Masukan Nilai  = "; cin >> mahasiswa.nilai;

	//cetak data.........................
	cout << "\n\nCetak Data yang sudah diisikan : \n";
	cout << "NIM              = " << mahasiswa.nim << endl;
	cout << "Nama             = " << mahasiswa.nama << endl;
	cout << "Nilai            = " << mahasiswa.nilai << endl << endl;

	getch();
}