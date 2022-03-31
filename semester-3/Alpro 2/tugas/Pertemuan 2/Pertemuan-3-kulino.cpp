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
        printf(" Data Ke-%d:", i+1);
        scanf("%d", &A[i]);
    }

    // memasukkan data yang akan dicari ke dalam K
    printf("Masukkan data yang akan dicari :");
    scanf ("%d",&k);

    //proses pencarian data
    j=0;
    for (i=0; i<4;i++)
    {
        if (A[i]==k){
            index [j]=i;
            j++;
        }
    }
    //jika data ditemukan dalam array
    if (j>0){
        printf("Data %d yang dicari ada %d buah\n",k,j);
        printf("Data tersebut terdapat dalam index ke : ");
     
        for (i=0;i<j;i++){
            printf(" %d ", index[i]);
        }
        printf("\n");
    }
    // jika tidak ditemukan
    else{
        printf ("data tidak ditemukan dalam array \n");
    }
    
    getch();
}