#include <iostream>

void main(){

    int arrayNilai[10] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9 ,10};//error
    //data yang dimasukkan melebihi batas index array
    for(int a=0; a<10;a++)

    {

    cout << "Nilai array [" << a << "] =" << arrayNilai[a] << endl;

    }

    cout << endl;

    cin.get();

}