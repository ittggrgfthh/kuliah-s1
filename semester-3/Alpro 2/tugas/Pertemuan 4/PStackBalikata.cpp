// header file.......................
#include <iostream.h> // cin, cout
#include <conio.h> // getch(), clrscr()
#include <stdio.h>
#include <string.h>

#define maxkal 200

// deklarasi struct..................
struct tumpukan
{
    char isi[maxkal];
    int atas;
} tumkal;

// fungsi push................................
void push(char x) {
    if(tumkal.atas == maxkal) {
        cout << "\nTumpukan Sudah Penuh !";
        getch();
    } else {
        tumkal.atas = tumkal.atas + 1;
        tumkal.isi[tumkal.atas] = x;
    }
}

// fungsi pop................................
char pop() {
    char hasil;
    if(tumkal.atas == 0) {
        cout << "\nTumpukan sudah kosong !";
        hasil = ' ';
    } else {
        hasil = tumkal.isi[tumkal.atas];
        tumkal.atas = tumkal.atas - 1;
    }
    return hasil;
}

// program utama.............................
void main() {
    int i;
    char kalimat[maxkal];

    clrscr();
    tumkal.atas = 0;

    cout << "Aplikasi stack untuk membalik kalimat\n";
    cout << "-----------------------------------------\n\n";

    // Inputkan kalimat yang akan dibalik.........................
    cout << "Masukkan sembarang kalimat : "; gets(kalimat);

    clrscr();
    cout<<"\nKalimat Awal : " << kalimat;

    // proses awal balik kalimat.................................
    for(i = 0; i < strlen(kalimat); i++) {
        push(kalimat[i]);
    }

    cout << "\n\nKalimat setelah di balik : ";

    for(i = 0; i < strlen(kalimat); i++) {
        cout << "" << pop();
    }
    getch();
}