#include <iostream.h>
#include <conio.h>
#include <stdio.h>

void main (){
    int n, k;
    cout << "Masukkan sebuah angka : "; cin >> k;

    for (n = k; n >= 1; n--){
        cout << "angka = " << n << endl;
    }
    getch();
}