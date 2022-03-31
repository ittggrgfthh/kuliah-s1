// 1. a. Pointer adalah variabel yang dapat menyimpan alamat memori valuenya.
//    b. 
int a = 10; 
int *b = &a;

// 2. di wa

// 3. 
void tambah_tengah(){
    int sisip;
    cout << "Masukan Posisi Sisip Anda : "; cin >> sisip;
    bantu = head; // bantu diletakan di head dulu   
    for(int i=1;i<sisip-1;i++){
        bantu=bantu->next; // menggeser hingga didapat data cari
    }
    buat_baru();
    bantu2 = bantu->next; // menghubungkan ke node setelah yang dicari
    bantu->next = baru;
    baru->prev = bantu;
    baru->next = bantu2; // menghubungkan node baru
    bantu2->prev = baru;
    tampil();
}

// 4.
void hapusbelakang(){
	Node *temp;
	temp = tail;
	// cek apakah kosong, 1 node, atau bbrp node.......
	if (head == NULL){
		cout << "\nLinked List Kosong ! [Enter] ";
		getch();
	}
	else{
		//jika ada sebuah node.........................
		if(head == tail){
			head = NULL;
			tail = NULL;
		}
		else{
			//jika node lebih dari 1...................
			tail = tail->prev;
			tail->next = head;
			head->prev = tail;
		}
		delete temp;
		current = head;
	}		
}

// 5.
Void tambahDepan(int databaru)
{
    TNode *baru,*assist;
    baru = new TNode;
    baru->data = databaru;
    baru->next = baru;

    if(isEmpty()==1){
        head = baru;
        head->next = head;
    }
    else{
        assist = head;
        while(assist->next != head){
            assist = assist->next;
        }
    baru->next = head;
    head = baru;
    assist->next = head;
    }
cout<< ”Data Masuk”;
}