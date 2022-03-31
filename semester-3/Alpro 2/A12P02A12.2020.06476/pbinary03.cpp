#include <iostream.h>
#include <conio.h>

void main(){
	const char data[6] = {'a','b','c','d','e','f'};
	char cari, i;

	//menampilkan data
	cout << "\n\nDeretan Bilangan = ";

	for (i = 0; i < 6; i++){
		cout << data[i] << " ";
	}

	cout << "\nMasukan data yang dicari : "; cin >> cari;
	
	int awal = 0, akhir = 6, tengah;
	while (awal <= akhir){
		tengah = (awal + akhir) / 2; //tengah = 3

		if (cari > data[tengah]){
			awal = tengah + 1;
		}
		else if (cari < data[tengah]){
			akhir = tengah - 1;
		}
		else{
			awal = akhir + 1;
		}
	}
	if (cari == data[tengah]){
		cout << "Data " << cari << " ditemukan index ke : " << (tengah) << endl;
	}
	else{
		cout << "Target tidak ditemukan " << endl;
	}
	getch();
}