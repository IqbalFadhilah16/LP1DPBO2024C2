# Mengimpor kelas DPR
from DPR import DPR

# Membuat list kosong untuk menyimpan data anggota DPR
anggota = []

# Variabel untuk mengecek apakah ID ditemukan atau tidak
cekID = ""

# Fungsi untuk menambahkan data anggota DPR
def create():
    # Meminta input dari pengguna
    id = int(input("ID : "))
    name = str(input("Nama : "))
    bidang = str(input("Bidang : "))
    partai = str(input("Partai : "))

    # Menambahkan data anggota DPR ke list
    anggota.append(DPR(id, name, bidang, partai))

    print("Data berhasil ditambahkan!")

# Fungsi untuk menampilkan data anggota DPR
def read():
    # Menghitung panjang string terpanjang untuk setiap kolom
    max_id = max([len(str(DPR.get_id())) for DPR in anggota] + [len("ID")])
    max_nama = max([len(DPR.get_name()) for DPR in anggota] + [len("Nama")])
    max_bidang = max([len(DPR.get_bidang()) for DPR in anggota] + [len("Bidang")])
    max_partai = max([len(DPR.get_partai()) for DPR in anggota] + [len("Partai")])

    # Membuat format string dengan lebar kolom yang sesuai
    format_str = "| {:{}} | {:{}} | {:{}} | {:{}} |"

    # Mencetak header tabel
    print("-" * (max_id + max_nama + max_bidang + max_partai + 13))  # 13 adalah jumlah karakter tambahan '|', ' ', dan '-'
    print(format_str.format("ID", max_id, "Nama", max_nama, "Bidang", max_bidang, "Partai", max_partai))
    print("-" * (max_id + max_nama + max_bidang + max_partai + 13))  # 13 adalah jumlah karakter tambahan '|', ' ', dan '-'

    # Mencetak baris tabel
    for DPR in anggota:
        print(format_str.format(DPR.get_id(), max_id, DPR.get_name(), max_nama, DPR.get_bidang(), max_bidang, DPR.get_partai(), max_partai))

    print("-" * (max_id + max_nama + max_bidang + max_partai + 13))  # 13 adalah jumlah karakter tambahan '|', ' ', dan '-'

# Fungsi untuk memperbarui data anggota DPR
def update():
    # Meminta ID anggota yang ingin diperbarui
    id = int(input("Masukkan ID anggota yang ingin diperbarui: "))
    cekID = 0

    # Mencari anggota dengan ID yang dimasukkan
    for DPR in anggota:
        if DPR.get_id() == id:
            # Menampilkan data lama
            print("Data lama:")
            print("Nama:", DPR.get_name())
            print("Bidang:", DPR.get_bidang())
            print("Partai:", DPR.get_partai())
            print("\n")
            
            # Meminta data baru dan memperbarui data anggota
            DPR.set_name(input("Masukkan nama baru: "))
            DPR.set_bidang(input("Masukkan bidang baru: "))
            DPR.set_partai(input("Masukkan partai baru: "))
            
            cekID = 1

    # Menampilkan pesan berdasarkan apakah ID ditemukan atau tidak
    if cekID == 0:
        print("ID tidak ditemukan!")
    elif cekID == 1:
        print("Data berhasil diperbarui")

# Fungsi untuk menghapus data anggota DPR
def delete():
    # Meminta ID anggota yang ingin dihapus
    id = int(input("Masukkan ID anggota yang ingin dihapus: "))
    cekID = 0

    # Mencari anggota dengan ID yang dimasukkan dan menghapusnya
    for i, DPR in enumerate(anggota):
        if DPR.get_id() == id:
            del anggota[i]
            cekID = 1

    # Menampilkan pesan berdasarkan apakah ID ditemukan atau tidak
    if cekID == 0:
        print("ID tidak ditemukan!")
    elif cekID == 1:
        print("Data berhasil dihapus!")

# Loop utama program
query = 0
while query != 5:
    # Menampilkan menu
    print ("---------------------------")
    print ("|        LIST QUERY       |")
    print ("---------------------------")
    print ("|1. Create Data           |")
    print ("|2. Read Data             |")
    print ("|3. Update Data           |")
    print ("|4. Delete Data           |")
    print ("|5. Finish                |")
    print ("---------------------------")

    # Meminta pengguna memilih aksi
    print("Pilih Action!")
    query = int(input())
    if query == 1:
        create()
    elif query == 2:
        read()
    elif query == 3:
        update()
    elif query == 4:
        delete()
