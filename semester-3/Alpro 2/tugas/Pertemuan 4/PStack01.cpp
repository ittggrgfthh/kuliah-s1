// header file.......................
#include <iostream.h>
#include <conio.h>
#include <stdio.h>

#define maxstack 4

// deklarasi struct..................
struct STACK {
    int top;
    int data[maxstack+1];
} tumpukan;

int isidata;



// fungsi untuk menambahkan data pada stack..............
void push() {
    cout << "\nMasukkan data : ";
    cin >> isidata;

    tumpukan.top++;
    tumpukan.data[tumpukan.top] = isidata;
}

// fungsi untuk mengambil data pada stack................
void pop() {
    cout << "Data yang terambil : " << tumpukan.data[tumpukan.top] << endl;
    tumpukan.data[tumpukan.top] = 0;
    tumpukan.top--;
    getch();
}

// fungsi untuk mencetak data pada stack................
void print() {
    cout << "\nData yang terdapat dalam stack : \n";
    cout << "----------------------------------\n\n";
    for(int i = 4; i >= 0; i--) {
        if(tumpukan.data[i] > 0) {
            cout << "\t|| " << tumpukan.data[i] << " ||\n";
        } 
        else {
            cout << "\t||   ||\n";
        }
    }
    cout << "\t||===||\n";
    getch();
}

// fungsi untuk membersihkan data dalam stack.............
void clear() {
    tumpukan.top = -1;
    for(int a = 0; a <= maxstack; a++) {
        tumpukan.data[a] = 0;
    }
    cout << "Data sudah dibersihkan.";
    getch();
}

// fungsi utama
void main() {
    clear();
    int pilihan;

    do {
        clrscr();
        cout << "PROGRAM STACK" << endl;
        cout << "===========================" << endl;
        cout << "Pilihan Menu : " << endl;
        cout << "1. Push stack" << endl;
        cout << "2. Pop stack" << endl;
        cout << "3. Print stack" << endl;
        cout << "4. Clear stack" << endl;
        cout << "5. Exit" << endl << endl;

        cout << "Menu pilihan Anda : "; cin >> pilihan;

        switch (pilihan) {
            case 1:
                push();
                break;
            case 2:
                pop();
                break;
            case 3:
                print();
                break;
            case 4:
                clear();
                break;
            default:
                break;
        }
    } while (pilihan < 5);
    
}