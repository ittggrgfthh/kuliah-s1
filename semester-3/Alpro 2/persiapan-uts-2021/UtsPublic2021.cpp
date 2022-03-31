#include <conio.h>
#include <stdio.h>
#include <iostream.h>
#include <iomanip.h>
#include <string>

int const n=5;
int jml;

struct spdam{
    char nopelanggan[6], golongan;
    string nama;
    int gajiPokok, tunjangan, gajiKotor, potongan, gajiBersih;
} datatagihan[n];

void tukar (int a, int b){
spdam temp;
temp = datatagihan[b];
datatagihan[b] = datatagihan[a];
datatagihan[a] = temp;
}

void bubbleSort(){
    for (int i=1;i<jml;i++) {
        for (int j=0;j<jml-1;j++) {
            if(datatagihan[j].golongan>datatagihan[j+1].golongan)
                tukar(j,j+1);
        }
    }
}

//proses penghitungan gaji pokok dan tunjangan
void gajiTunjangan(){
    switch(datatagihan[jml].golongan) {
        case '1':
            datatagihan[jml].gajiPokok = 1000000;
            datatagihan[jml].tunjangan = 0.25 * datatagihan[jml].gajiPokok;
            break;
        case '2':
            datatagihan[jml].gajiPokok = 2000000;
            datatagihan[jml].tunjangan = 0.5 * datatagihan[jml].gajiPokok;
            break;
        case '3':
            datatagihan[jml].gajiPokok = 3000000;
            datatagihan[jml].tunjangan = 0.5 * datatagihan[jml].gajiPokok;
            break;
        }
}

//proses penghitungan gaji kotor
void prosesGajiKotor(){
    datatagihan[jml].gajiKotor = datatagihan[jml].gajiPokok + datatagihan[jml].tunjangan;
}

//proses penghitungan Gaji bersih
void prosesGajiBersih(){
    datatagihan[jml].gajiBersih = datatagihan[jml].gajiKotor - datatagihan[jml].potongan;
}

void main(){
    // input data pelanggan
    //tampilkan data awal
    jml=0;

    while (jml<n) {
        clrscr();
        cout << "==Program Buble Sort==" << endl;
        cout << "\n\nMasukkan data index [" << jml <<"] :\n";
        cout << "No Pelanggan : "; cin >> datatagihan[jml].nopelanggan;
        cout << "Nama         : "; cin >> datatagihan[jml].nama;
        cout << "Golongan     : "; cin >> datatagihan[jml].golongan;

        gajiTunjangan();

        cout << "Gaji Pokok   : " << datatagihan[jml].gajiPokok << endl;
        cout << "Tunjangan    : " << datatagihan[jml].tunjangan << endl;

        prosesGajiKotor();

        cout << "Gaji Kotor   : " << datatagihan[jml].gajiKotor << endl;
        cout << "Potongan     : "; cin >> datatagihan[jml].potongan; 
        cout << endl;

        prosesGajiBersih();

        cout << "Gaji Bersih : " << datatagihan[jml].gajiBersih << endl;

        // keterangan tipe otomatis muncul setelah mengisi tipe
        jml++;
        cout << "\n Tambah Data Lagi [y/t] :";
        char lagi = getche();
    
        if(strchr("Tt",lagi) !=NULL)
            break;
    }

    //tampilkan data
    clrscr();
    cout <<"\nData Awal :"<<endl;
    //tampilkamn data setelah diurutkan
    cout <<"\n\nData sebelum di sort :"<<endl;
    cout<<"------------------------------------------------------------------------"<<endl;
    cout<<"No   NIP   Nama    Gol    Gaji Kotor  Potongan  Gaji_Bersih "<<endl;
    cout<<"------------------------------------------------------------------------"<<endl;

    for (int i=0; i<jml; i++) {
        cout << setiosflags(ios::left) << setw(4) << (i+1);
        cout << setiosflags(ios::left) << setw(6) << (datatagihan[i].nopelanggan);
        cout << setiosflags(ios::left) << setw(10) << (datatagihan[i].nama);
        cout << setiosflags(ios::left) << setw(7) << (datatagihan[i].golongan);
        cout << setiosflags(ios::left) << setw(12) << (datatagihan[i].gajiKotor);
        cout << setiosflags(ios::left) << setw(10) << (datatagihan[i].potongan);
        cout << setiosflags(ios::left) << setw(11) << (datatagihan[i].gajiBersih);
        cout <<endl;
    }

    //proses pengurutan data
    bubbleSort();
    //tampilkamn data setelah diurutkan
    cout <<"\n\nData setelah di sort :"<<endl;
    cout<<"------------------------------------------------------------------------"<<endl;
    cout<<"No   NIP   Nama    Gol    Gaji Kotor  Potongan  Gaji_Bersih "<<endl;
    cout<<"------------------------------------------------------------------------"<<endl;

    for (int a=0; a<jml;a++) {
        cout << setiosflags(ios::left) << setw(4) << (a+1);
        cout << setiosflags(ios::left) << setw(6) << (datatagihan[a].nopelanggan);
        cout << setiosflags(ios::left) << setw(10) << (datatagihan[a].nama);
        cout << setiosflags(ios::left) << setw(7) << (datatagihan[a].golongan);
        cout << setiosflags(ios::left) << setw(12) << (datatagihan[a].gajiKotor);
        cout << setiosflags(ios::left) << setw(10) << (datatagihan[a].potongan);
        cout << setiosflags(ios::left) << setw(11) << (datatagihan[a].gajiBersih);
        cout <<endl;
    }
    cout << "\n\nSorting Selesai";
    getch();
}