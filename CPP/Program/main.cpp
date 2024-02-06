#include <bits/stdc++.h>
#include "DPR.cpp"

using namespace std;

int main() {
    DPR temp;
    list<DPR> llist;

    int i = 0, cariID = 0, cekID = 0, query = 0; 
    int id = 0;
    string nama, bidang, partai;
    
    do {
        cout << "---------------------------" << '\n';
        cout << "|        LIST QUERY       |" << '\n';
        cout << "---------------------------" << '\n';
        cout << "1. Create Data" << '\n';
        cout << "2. Read Data" << '\n';
        cout << "3. Update Data" << '\n';
        cout << "4. Delete Data" << '\n';
        cout << "5. Finish" << '\n';
        cout << "---------------------------" << '\n';

        cout << "Pilih Action!" << '\n';
        cin >> query;

        switch(query) {  
            case 1:  // Case 1 untuk operasi create data
                cout << "Silahkan input id anggota: ";  
                cin >> id;  // Menerima input ID dari pengguna
                cin.ignore();  // Mengabaikan newline di akhir input sebelumnya
                            
                cout << "Silahkan input nama anggota: ";  
                getline(cin, nama);  // Menerima input nama dari pengguna
                            
                cout << "Silahkan input bidang anggota: ";  
                getline(cin, bidang);  // Menerima input bidang dari pengguna
                            
                cout << "Silahkan input partai anggota: ";  
                getline(cin, partai);  // Menerima input partai dari pengguna

                temp.set_id(id);  // Mengatur ID anggota dengan ID baru
                temp.set_nama(nama);  // Mengatur nama anggota dengan nama baru
                temp.set_bidang(bidang);  // Mengatur bidang anggota dengan bidang baru
                temp.set_partai(partai);  // Mengatur partai anggota dengan partai baru

                llist.push_back(temp);  // Menambahkan anggota baru ke list

                cout << "Data berhasil diinput!" << '\n';  // Mencetak pesan bahwa data berhasil diinput
            break;

            case 2:  // Case 2 untuk operasi read data
                cout << "--------------------------" << '\n'; 
                cout << "|       LIST ANGGOTA     |" << '\n'; 
                cout << "--------------------------" << '\n';  

                // Melakukan iterasi melalui list anggota
                for (list<DPR>::iterator it = llist.begin(); it != llist.end(); it++) {
                    cout << "ID : " << it->get_id() << '\n';  // Mencetak ID anggota
                    cout << "Nama : " << it->get_nama() << '\n';  // Mencetak nama anggota
                    cout << "Bidang : " << it->get_bidang() << '\n';  // Mencetak bidang anggota
                    cout << "Partai : " << it->get_partai() << '\n';  // Mencetak partai anggota
                            
                    i++;  // Menambahkan counter
                }
                cout << "--------------------------" << '\n' << '\n'; 
            break;

            case 3:  // Case 3 untuk operasi update data
                cout << "Masukkan ID anggota yang ingin diperbarui: ";  
                cin >> id;  // Menerima input ID dari pengguna
                cekID = 0;  // Mengatur variabel penanda bahwa ID belum ditemukan
                cin.ignore();  // Mengabaikan newline di akhir input sebelumnya

                // Melakukan iterasi melalui list anggota
                for (list<DPR>::iterator it = llist.begin(); it != llist.end(); it++) {
                    if (it->get_id() == id) {  // Jika ID anggota sama dengan ID yang dimasukkan pengguna
                        cout << "Masukkan nama baru: ";  
                        getline(cin, nama);  // Menerima input nama dari pengguna
                        it->set_nama(nama);  // Mengatur nama anggota dengan nama baru

                        cout << "Masukkan bidang baru: ";  
                        getline(cin, bidang);  // Menerima input bidang dari pengguna
                        it->set_bidang(bidang);  // Mengatur bidang anggota dengan bidang baru

                        cout << "Masukkan partai baru: ";  
                        getline(cin, partai);  // Menerima input partai dari pengguna
                        it->set_partai(partai);  // Mengatur partai anggota dengan partai baru

                        cekID = 1;  // Mengatur variabel penanda bahwa ID telah ditemukan
                    }
                }

                if(cekID == 0) {  // Jika ID tidak ditemukan
                    cout << "Id tidak ada!" << '\n';  // Mencetak pesan bahwa ID tidak ditemukan
                } else {  // Jika ID ditemukan
                    cout << "Data berhasil diperbarui!" << '\n';  // Mencetak pesan bahwa data berhasil diperbarui
                }

            break;

            case 4:  // Case 4 untuk operasi delete data
                cout << "Masukkan ID anggota yang ingin dihapus: ";  // Meminta ID anggota dari pengguna
                cin >> id;  // Menerima input ID dari pengguna
                cekID = 0;  // Mengatur variabel penanda bahwa ID belum ditemukan

                // Melakukan iterasi melalui list anggota
                for (list<DPR>::iterator it = llist.begin(); it != llist.end(); ) {
                    if (it->get_id() == id) {  // Jika ID anggota sama dengan ID yang dimasukkan pengguna
                        it = llist.erase(it);  // Menghapus anggota dari list
                        cekID = 1;  // Mengatur variabel penanda bahwa ID telah ditemukan
                    } else {
                        ++it;  // Jika ID anggota tidak sama dengan ID yang dimasukkan pengguna, lanjutkan ke anggota berikutnya
                    }
                }

                if(cekID == 0) {  // Jika ID tidak ditemukan
                    cout << "Id tidak ada!" << '\n';  // Mencetak pesan bahwa ID tidak ditemukan
                } else {  // Jika ID ditemukan
                    cout << "Data berhasil dihapus!" << '\n';  // Mencetak pesan bahwa data berhasil dihapus
                }
            break;
        }
    } while (query != 5);

    return 0;
}

