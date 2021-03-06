#include <iostream.h>
#include <conio.h>

void main(){
	const int data[10] = {1,2,3,4,5,6,7,8,9,10};
	int cari, i;

	//menampilkan data
	cout << "\n\nDeretan Bilangan = ";

	for (i = 0; i < 10; i++){
		cout << data[i] << " ";
	}

	cout << "\nMasukan data yang dicari : "; cin >> cari;
	
	int awal = 0, akhir = 10, tengah;
	while (awal <= akhir){
		tengah = (awal + akhir) / 2;

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
		cout << "Data ditemukan, Ke - " << (tengah + 1) << endl;
	}
	else{
		cout << "Target tidak ditemukan " << endl;
	}
	getch();
}