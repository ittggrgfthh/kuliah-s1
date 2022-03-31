#include <iostream.h>
#include <conio.h>

struct smhs{
	char nim[5], nama[15];
	float nilai;
} mahasiswa[5];

void main(){
	clrscr();
	for(int i = 0; i < 5; i++){
		//input data....................
		cout << "\nIsi Data Mahasiswa : \n";
		cout << "Masukan NIM    = "; cin >> mahasiswa[i].nim;
		cout << "Masukan Nama   = "; cin >> mahasiswa[i].nama;
		cout << "Masukan NIlai  = "; cin >> mahasiswa[i].nilai;
	}

	//cetak data.......................
	clrscr();
	cout << "\n\nCetak Data yang sudah diisikan : \n\n";
	cout << "No    NIM              Nama      Nilai\n";
	cout << "======================================\n";

	for(int a = 0; a < 5; a++){
		cout << " " << a;
		cout << "\t" << mahasiswa[a].nim;
		cout << "\t" << mahasiswa[a].nama;
		cout << "\t" << mahasiswa[a].nilai;
		cout << endl;
	}
	getch();

}