#include <iostream.h>
#include <conio.h>
#include <stdio.h>

struct Node{
    int notest, nilai;
    char nama[20];
    Node *next, *bantu;
};

Node *head = NULL;
Node *tail = NULL;
Node *baru;

int lEmpty(){
    if (head == NULL)
        return 1;
    else
        return 0;
}
void tambahDepan(){
    baru = new Node;
    baru->next = NULL;
    // masukkan data.............................
    clrscr();
    cout << "Isikan Data Simpul Baru\n";
    cout << "==========================================\n";

    cout << "No Test   : "; cin >>baru->notest;
    cout << "Nama      : "; gets(baru->nama);
    cout << "Nilai     : "; cin >> baru->nilai;
    cout << endl;

    if (lEmpty() == 1){
        head = tail = baru;
        tail->next = NULL;
    }
    else{
        baru->next = head;
        head = baru;
    }
    cout << "Data masuk\n";
}

void tambahBelakang(){
    Node *next, *bantu;
    baru = new Node;
    baru->next = NULL;
    // masukkan data.............................
    clrscr();
    cout << "Isikan Data Simpul Baru\n";
    cout << "==========================================\n";

    cout << "No Test   : "; cin >>baru->notest;
    cout << "Nama      : "; gets(baru->nama);
    cout << "Nilai     : "; cin >> baru->nilai;
    cout << endl;

    if(lEmpty() == 1){
        head=baru;
    }
    else{
        bantu=head;
        while(bantu->next != NULL){
	        bantu=bantu->next;
        }
        bantu->next = baru;
    }
    cout << "Data masuk\n";
}

void hapusDepan(){
    Node *hapus, *tail;
    hapus = head;
    int d;

    // jika kosong.........
    if (lEmpty() == 0){
        // jika node lebih dari 1......
        if (head != tail){
            hapus = head;
            d = hapus->notest;
            head = head->next;
            delete hapus;
        }
        else{
            // jika node hanya 1.......
            d = tail->notest;
            head = tail = NULL;
        }
        cout << "terhapus";
    }
    else
        cout << "Masih kosong\n";
}

void hapusBelakang(){
Node *hapus, *tail;
    hapus = head;
    int d;

    // jika kosong.........
    if (lEmpty() == 0){
        // jika node lebih dari 1......
        if (head->next != NULL){
            tail = head;
            while(tail->next->next!=NULL){	  
                tail = tail->next;  // geser bantu 		
            }
            hapus = tail->next;
            d = hapus->notest;
            tail->next = NULL;
            delete hapus;

        }
        else{
            // jika node hanya 1.......
            d = tail->notest;
            head = tail = NULL;
        }
        cout << "terhapus";
    }
    else
        cout << "Masih kosong\n";
}

void printNode(){
    Node *bantu;
    bantu = head;
    if (lEmpty() == 0){
        clrscr();
        cout << "\nIsi Linked List\n";
        cout << "==============================\n";
        while (bantu != NULL){
            cout << "No test   : " << bantu->notest;
            cout << ", Nama    : " << bantu->nama;
            cout << ", Nilai   : " << bantu->nilai << endl;
            bantu = bantu->next;
        }
    }
    else
        cout << "Data Kosong";
        getch();
}

// program utama.............................
void main(){
    int pilih;
    do{
        // Tampilan Menu...........................
        clrscr();
        cout << "--------------------------------------\n"
             << "Menu Pilihan (SLLNC) \n"
             << "--------------------------------------\n"
             << " [1] Tambah Depan \n"
             << " [2] Tambah Belakang \n"
             << " [3] Hapus Depan \n"
             << " [4] Hapus Belakang \n"
             << " [5] Cetak Linked List \n"
             << " [6] Keluar \n\n"
             << "--------------------------------------\n"
             << "Masukkan pilihan : "; cin >> pilih;
        switch (pilih){
            case 1:
                tambahDepan();
                break;
            case 2:
                tambahBelakang();
                break;
            case 3:
                hapusDepan();
                break;
            case 4:
                hapusBelakang();
                break;
            case 5:
                printNode();
                break;
            default:
                cout << "Pilihan tidak tersedia ! ";
                break;
        }
    } while (pilih != 6);
}