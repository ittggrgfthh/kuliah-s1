//NIM			: A12.2020.06492
//Nama		: Andreas Marcelino Andriawan
//Kelompok	: A12.6306

#include <conio.h>
#include <stdio.h>
#include <iostream.h>
#include <iomanip.h>
#include <string>

#define nilaiSetw 7


int const n=5;
int cntnr;

struct sPelanggan{
    char noPelanggan[5], golongan;
    string nama;
    int gajiPokok, tunjangan, gajiKotor, potongan, gajiBersih;
} dataPelanggan[n];

void tukar (int a, int b){
sPelanggan temp;
temp = dataPelanggan[b];
dataPelanggan[b] = dataPelanggan[a];
dataPelanggan[a] = temp;
}

void bubbleSort(){
    for (int i = 1; i < cntnr; i++) {
        for (int j = 0; j < cntnr - 1; j++) {
            if(dataPelanggan[j].golongan > dataPelanggan[j+1].golongan)
                tukar(j, j + 1);
        }
    }
}

//proses penghitungan gaji pokok dan tunjangan
void gajiTunjangan(){
    switch(dataPelanggan[cntnr].golongan) {
        case '1':
            dataPelanggan[cntnr].gajiPokok = 1000000;
            dataPelanggan[cntnr].tunjangan = 0.25 * dataPelanggan[cntnr].gajiPokok;
            break;
        case '2':
            dataPelanggan[cntnr].gajiPokok = 2000000;
            dataPelanggan[cntnr].tunjangan = 0.5 * dataPelanggan[cntnr].gajiPokok;
            break;
        case '3':
            dataPelanggan[cntnr].gajiPokok = 3000000;
            dataPelanggan[cntnr].tunjangan = 0.5 * dataPelanggan[cntnr].gajiPokok;
            break;
        }
}

//proses penghitungan gaji kotor
void prosesGajiKotor(){
    dataPelanggan[cntnr].gajiKotor = dataPelanggan[cntnr].gajiPokok + dataPelanggan[cntnr].tunjangan;
}

//proses penghitungan Gaji bersih
void prosesGajiBersih(){
    dataPelanggan[cntnr].gajiBersih = dataPelanggan[cntnr].gajiKotor - dataPelanggan[cntnr].potongan;
}

void judul(){
    // cout<<"----------------------------------------------------------------------"<<endl;
    // cout<<"No   NIP  Nama    Gol    Gaji Kotor Potongan Gaji_Bersih "<<endl;
    cout << setiosflags(ios::left) << setw(11-nilaiSetw) << "No";
    cout << setw(nilaiSetw) << "NIP";
    cout << setw(5+nilaiSetw) << "Nama";
    cout << setw(3+nilaiSetw) << "Gol";
    cout << setw(11+nilaiSetw) << "Gaji Kotor";
    cout << setw(9+nilaiSetw) << "Potongan";
    cout << setw(12+nilaiSetw) << "Gaji_Bersih";
    cout << endl;
    // cout<<"----------------------------------------------------------------------"<<endl;
}

void data(){
    for (int i=0; i<cntnr; i++) {
        cout << setw(11-nilaiSetw) << (i+1);
        cout << setw(nilaiSetw) << (dataPelanggan[i].noPelanggan);
        cout << setw(6+nilaiSetw) << (dataPelanggan[i].nama);
        cout << setw(3+nilaiSetw) << (dataPelanggan[i].golongan);
        cout << setw(11+nilaiSetw) << (dataPelanggan[i].gajiKotor);
        cout << setw(9+nilaiSetw) << (dataPelanggan[i].potongan);
        cout << setw(12+nilaiSetw) << (dataPelanggan[i].gajiBersih);
        cout <<endl;
    }
}

void main(){
    // input data pelanggan
    //tampilkan data awal
    cntnr=0;

    while (cntnr<n) {
        clrscr();
        cout << "==Program Buble Sort==" << endl;
        cout << "\n\nMasukkan data index [" << cntnr <<"] :\n";
        cout << "No Pelanggan : "; gets (dataPelanggan[cntnr].noPelanggan);
        cout << "Nama         : "; cin >> dataPelanggan[cntnr].nama;
        cout << "Golongan     : "; cin >> dataPelanggan[cntnr].golongan;

        gajiTunjangan();

        cout << "Gaji Pokok   : " << dataPelanggan[cntnr].gajiPokok << endl;
        cout << "Tunjangan    : " << dataPelanggan[cntnr].tunjangan << endl;

        prosesGajiKotor();

        cout << "Gaji Kotor   : " << dataPelanggan[cntnr].gajiKotor << endl;
        cout << "Potongan     : "; cin >> dataPelanggan[cntnr].potongan; 

        prosesGajiBersih();

        cout << "Gaji Bersih : " << dataPelanggan[cntnr].gajiBersih << endl;

        // keterangan tipe otomatis muncul setelah mengisi tipe
        cntnr++;
        cout << "\n Tambah Data Lagi [y/t] :";
        char lagi = getche();
    
        if(strchr("Tt",lagi) != NULL)
            break;
    }

    //tampilkan data
    clrscr();
    cout <<"\nData Awal :"<<endl;
    //tampilkamn data setelah diurutkan
    cout <<"\n\nData sebelum di sort :"<<endl;
    judul();
    data();
    //proses pengurutan data
    bubbleSort();
    //tampilkamn data setelah diurutkan
    cout <<"\n\nData setelah di sort :"<<endl;
    judul();
    data();
    cout << "\n\nSorting Selesai";
    getch();
}