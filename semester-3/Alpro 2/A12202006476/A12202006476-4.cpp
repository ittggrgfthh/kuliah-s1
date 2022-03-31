#include <iostream.h>
#include <conio.h>
#include <stdio.h>

struct smhs{
	char nim[5], nama[15];
	float nilai;
} mahasiswa[5];

int a = 0; //counter data

void main(){
	clrscr();
	for(int i = 0; i < 5; i++){
		//input data....................
		cout << "\nIsi Data Mahasiswa : \n";
		cout << "Masukan NIM    = "; gets(mahasiswa[i].nim);
		cout << "Masukan Nama   = "; gets(mahasiswa[i].nama);
		cout << "Masukan NIlai  = "; cin >> mahasiswa[i].nilai;
	}
	
	//cetak data........................
	clrscr();
	cout << "\n\nCetak Data yang sudah diisikan : \n\n";
	cout << "No    NIM              Nama    Nilai   Nilaihuruf\n";
	cout << "======================================================\n";

	for(int a = 0; a < 5; a++){
		cout << " " << a;
		cout << "\t" << mahasiswa[a].nim;
		cout << "\t" << mahasiswa[a].nama;
		cout << "\t" << mahasiswa[a].nilai;

		//proses penghitungan nilai.........
		if (mahasiswa[a].nilai >= 80)
			cout << "\t" << "A";
		else if (mahasiswa[a].nilai >= 60)
			cout << "\t" << "B";
		else{
			cout << "\t" << "C";
		}
		cout << endl;
	}
	getch();

}