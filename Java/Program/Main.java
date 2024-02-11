package Program;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void create(ArrayList<DPR> list, Scanner scanner) {
        System.out.println("Silahkan input id anggota: ");
        int id = 0;
        id = scanner.nextInt();
        scanner.nextLine();  // Mengabaikan newline di akhir input sebelumnya

        System.out.println("Silahkan input nama anggota: ");
        String name = scanner.nextLine();

        System.out.println("Silahkan input bidang anggota: ");
        String bidang = scanner.nextLine();

        System.out.println("Silahkan input partai anggota: ");
        String partai = scanner.nextLine();

        DPR temp = new DPR();
        temp.setID(id);  // Mengatur ID anggota dengan ID baru
        temp.setName(name);  // Mengatur nama anggota dengan nama baru
        temp.setBidang(bidang);  // Mengatur bidang anggota dengan bidang baru
        temp.setPartai(partai);  // Mengatur partai anggota dengan partai baru

        list.add(temp);  // Menambahkan anggota baru ke list

        System.out.println("Data berhasil diinput!");
    }

    public static void read(ArrayList<DPR> anggota) {
        int maxId = 0, maxNama = 0, maxBidang = 0, maxPartai = 0;
    
        // Menghitung panjang string terpanjang untuk setiap kolom
        // Menghitung panjang string terpanjang untuk setiap kolom
        for (DPR dpr : anggota) {
            maxId = Math.max(maxId, Math.max(Integer.toString(dpr.getID()).length(), "ID".length()));
            maxNama = Math.max(maxNama, Math.max(dpr.getName().length(), "Nama".length()));
            maxBidang = Math.max(maxBidang, Math.max(dpr.getBidang().length(), "Bidang".length()));
            maxPartai = Math.max(maxPartai, Math.max(dpr.getPartai().length(), "Partai".length()));
        }

        // Membuat format string dengan lebar kolom yang sesuai
        String formatStr = "| %-" + maxId + "s | %-" + maxNama + "s | %-" + maxBidang + "s | %-" + maxPartai + "s |";
    
        // Mencetak header tabel
        System.out.println(new String(new char[maxId + maxNama + maxBidang + maxPartai + 13]).replace("\0", "-"));
        System.out.printf(formatStr + "\n", "ID", "Nama", "Bidang", "Partai");
        System.out.println(new String(new char[maxId + maxNama + maxBidang + maxPartai + 13]).replace("\0", "-"));
    
        // Mencetak baris tabel
        for (DPR dpr : anggota) {
            System.out.printf(formatStr + "\n", dpr.getID(), dpr.getName(), dpr.getBidang(), dpr.getPartai());
        }
    
        System.out.println(new String(new char[maxId + maxNama + maxBidang + maxPartai + 13]).replace("\0", "-"));
    }

    public static void update(ArrayList<DPR> anggota, Scanner scanner) {
        // Meminta ID anggota yang ingin diperbarui
        System.out.println("Masukkan ID anggota yang ingin diperbarui: ");
        int id = 0;
        id = scanner.nextInt();
        scanner.nextLine();
        int cekID = 0;
    
        // Mencari anggota dengan ID yang dimasukkan
        for (DPR dpr : anggota) {
            if (dpr.getID() == id) {
                // Menampilkan data lama
                System.out.println("Data lama:");
                System.out.println("Nama: " + dpr.getName());
                System.out.println("Bidang: " + dpr.getBidang());
                System.out.println("Partai: " + dpr.getPartai());
                System.out.println("\n");
                
                // Meminta data baru dan memperbarui data anggota
                System.out.println("Masukkan nama baru: ");
                dpr.setName(scanner.nextLine());
                System.out.println("Masukkan bidang baru: ");
                dpr.setBidang(scanner.nextLine());
                System.out.println("Masukkan partai baru: ");
                dpr.setPartai(scanner.nextLine());
                
                cekID = 1;
            }
        }
    
        // Menampilkan pesan berdasarkan apakah ID ditemukan atau tidak
        if (cekID == 0) {
            System.out.println("ID tidak ditemukan!");
        } else {
            System.out.println("Data berhasil diperbarui");
        }
    }

    public static void delete(ArrayList<DPR> anggota, Scanner scanner) {        
        // Meminta ID anggota yang ingin dihapus
        System.out.println("Masukkan ID anggota yang ingin dihapus: ");
        int id = 0;
        id = scanner.nextInt();
        DPR toRemove = null;
    
        // Mencari anggota dengan ID yang dimasukkan
        for (DPR dpr : anggota) {
            if (dpr.getID() == id) {
                toRemove = dpr;
            }
        }
    
        // Menghapus anggota dari daftar jika ditemukan
        if (toRemove != null) {
            anggota.remove(toRemove);
            System.out.println("Data berhasil dihapus");
        } else {
            System.out.println("ID tidak ditemukan!");
        }
    }
    
    public static void main(String[] args) {
        int query = 0;
        
        Scanner scanner = new Scanner(System.in);

        ArrayList<DPR> list = new ArrayList<DPR>();
        
        do {
            System.out.println("---------------------------");
            System.out.println("|        LIST QUERY       |");
            System.out.println("---------------------------");
            System.out.println("|1. Create Data           |");
            System.out.println("|2. Read Data             |");
            System.out.println("|3. Update Data           |");
            System.out.println("|4. Delete Data           |");
            System.out.println("|5. Finish                |");
            System.out.println("---------------------------");

            System.out.println("Pilih Action!");
            query = scanner.nextInt();
            
            switch(query) {
                case 1:  // Case 1 untuk operasi create data
                    create(list, scanner);
                    break;
                case 2:
                    read(list);
                    break;
                case 3:
                    update(list, scanner);
                    break;
                case 4:
                    delete(list, scanner);
                    break;
            }
        } while (query != 5);
        
        scanner.close();
    }
    
}
