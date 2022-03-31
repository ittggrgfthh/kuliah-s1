#include <iostream.h>
#include <stdio.h>
#include <conio.h>

void main(){
    // deklarasi variabel
    // A[4] 	= array A berjumlah 4 data
    // index[4]	= digunakan untuk mencatat index pada array A, daya tampung  disamakan
    // untuk antisipasi data dicari adalah semua data
    // variabel i	= counter proses perulangan
    // variabel j	= sebagai counter utk menghitung jml data yang ditemukan
   
    int A[4];
    int index[4],i,j,k;

    // proses pengimputan data
    for (i=0;i<4;i++){
        cout << "Data Ke - " << (i + 1) << ": "; cin >> A[i];
    }

    // memasukkan data yang akan dicari ke dalam K
    cout << "Masukkan data yang akan dicari : "; cin >> k;

    //proses pencarian data
    j=0;
    for (i=0; i<4;i++)
    {
        if (A[i] == k){
            index[j] = i;
            j++;
        }
    }
    //jika data ditemukan dalam array
    if (j>0){
        cout << "Data " << k << " yang dicari ada " << j << " buah\n";
        cout << "Data tersebut terdapat dalam index ke : ";
     
        for (i=0;i<j;i++){
            cout << index[i] << " ";
        }
    }
    // jika tidak ditemukan
    else{
        cout << "data tidak ditemukan dalam array \n";
    }
    
    getch();
}