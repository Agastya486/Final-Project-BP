import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class index{
        //Methods start

        public static void urutPenjualan(String[] namaMenu, int[] jumlahTerjual, String[] waktuPenjualan) {
                String[] sortedNamaMenu = namaMenu.clone();
                int[] sortedJumlahTerjual = jumlahTerjual.clone();
                String[] sortedWaktuPenjualan = waktuPenjualan.clone();
                
                for (int i = 0; i < sortedJumlahTerjual.length - 1; i++) {
                        int maxIndex = i;

                        for (int j = i + 1; j < sortedJumlahTerjual.length; j++) {
                                if (sortedJumlahTerjual[j] > sortedJumlahTerjual[maxIndex]) {
                                maxIndex = j;
                                }
                        }

                        if (maxIndex != i) {
                                int tempJumlah = sortedJumlahTerjual[i];
                                sortedJumlahTerjual[i] = sortedJumlahTerjual[maxIndex];
                                sortedJumlahTerjual[maxIndex] = tempJumlah;

                                String tempNama = sortedNamaMenu[i];
                                sortedNamaMenu[i] = sortedNamaMenu[maxIndex];
                                sortedNamaMenu[maxIndex] = tempNama;

                                String tempWaktuPenjualan = sortedWaktuPenjualan[i];
                                sortedWaktuPenjualan[i] = sortedWaktuPenjualan[maxIndex];
                                sortedWaktuPenjualan[maxIndex] = tempWaktuPenjualan;
                        }
                }

                for (int i = 0; i < 5; i++) {
                        System.out.println((i + 1) + ". " + sortedNamaMenu[i] + " - " + sortedJumlahTerjual[i] + " buah terjual" + " - " + sortedWaktuPenjualan[i]);
                }
                System.out.println("");
        }

        public static float hitungBarang(String namaMenu, int harga, String[] menuTotal, int[] hargaMenuTotal, int[] jumlahTerjualTotal, Scanner sc, int pilihKasir, int[] jumlahTerjual, float grandTotal, String[] waktuPenjualan){
                System.out.print("Masukkan jumlah : ");
                int jumlah = sc.nextInt();
                jumlahTerjual[pilihKasir - 1] += jumlah;

                menuTotal[pilihKasir - 1] = namaMenu;
                hargaMenuTotal[pilihKasir - 1] = harga;
                jumlahTerjualTotal[pilihKasir - 1] = jumlahTerjual[pilihKasir - 1];

                float total = harga * jumlah;
                grandTotal += total;
                System.out.println("");

                System.out.println("->Anda membeli " + namaMenu + " dengan jumlah sebanyak " + jumlah + "!");
                System.out.println("->Total nya adalah " + total);
                System.out.println("");

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                waktuPenjualan[pilihKasir - 1] = LocalDateTime.now().format(formatter);  // Menyimpan waktu pembelian
                return grandTotal;
        }
        
        public static void urutHuruf(String[] namaMenu, int[] hargaMenu){
                for (int i = 0; i < namaMenu.length - 1; i++) {
                        int minIndex = i;
                        for (int j = i + 1; j < namaMenu.length; j++) {
                                if (namaMenu[j].compareToIgnoreCase(namaMenu[minIndex]) < 0) {
                                minIndex = j;
                                }
                        }
                        if (minIndex != i) {
                                String tempNama = namaMenu[i];
                                namaMenu[i] = namaMenu[minIndex];
                                namaMenu[minIndex] = tempNama;

                                int tempHarga = hargaMenu[i];
                                hargaMenu[i] = hargaMenu[minIndex];
                                hargaMenu[minIndex] = tempHarga;
                        }
                }

                for(int i = 0; i < namaMenu.length; i++){
                        System.out.println(i+1 + ". " + namaMenu[i] + " [" + hargaMenu[i] + "]");
                }
                System.out.println("");
        }
        
        //Methods end

        //Dashboard users
        public static void main(String[] args){
                int pilihDashboard = 0, pilihKasir = 0, pilihMenu = 0, jumlahBeli = 0, item = 0, counter = 1,
                pilihAdmin = 0, jumlahTambahMenu = 0, gantiHarga = 0, index = -1,
                ubahMenu2 = 0, hargaMenuBaru = 0;
                float total = 0, grandTotal = 0, totalPemasukan = 0;

                Scanner sc = new Scanner(System.in);

                String[] namaMenu = {
                        "Green Bean Robusta Arjuno", "Green Bean Robusta Welirang", 
                        "Green Bean Arabika Arjuno", "Green Bean Arabika Welirang",
                        "Roasted Bean Arabika Arjuno", "Roasted Bean Arabika Welirang",
                        "Bubuk Medium Spesial", "Bubuk Medium To Dark"
                        };
                int[] hargaMenu = {65000,65000,120000,110000,165000,160000,60000,50000};
                int[] jumlahTerjual = new int[hargaMenu.length];

                String[] menuTotal = new String[100];
                int[] hargaMenuTotal = new int[100];
                int[] jumlahTerjualTotal = new int[100];
                String[] waktuPenjualan = new String[namaMenu.length];

                do {
                        System.out.println("=== Bold Beans Coffee Dashboard === \n1.Kasir \n2.Admin \n3.Owner \n4.Selesai");
                        System.out.print("Pilihan anda : ");
                        pilihDashboard = sc.nextInt();
                        System.out.println("");

                        switch(pilihDashboard){
                                case 1:
                                        do{
                                                System.out.println("=== Menu Kasir Bold Beans Coffee ===");
                                                urutHuruf(namaMenu, hargaMenu);
                                                System.out.println("");

                                                System.out.println("[Klik angka selain di menu untuk keluar]");
                                                System.out.print("Pilihan anda : ");
                                                pilihKasir = sc.nextInt();
                                                System.out.println("");                                                

                                                if(pilihKasir > namaMenu.length){
                                                        System.out.println("=== Daftar Belanja Bold Beans Coffee ===");
                                                        for(int i = 0; i < menuTotal.length;i++){
                                                                if (menuTotal[i] != null) {
                                                                        System.out.println( counter + ". " + menuTotal[i] + " " + hargaMenuTotal[i] + " " + jumlahTerjual[i] + " buah");
                                                                        counter++;

                                                                        menuTotal[i] = null;
                                                                        hargaMenuTotal[i] = 0;
                                                                        jumlahTerjualTotal[i] = 0;
                                                                        
                                                                }
                                                        }
                                                        System.out.println("===============================================");
                                                        System.out.println("->Grand totalnya adalah " + grandTotal + "\n");
                                                        counter = 1;
                                                        grandTotal = 0;
                                                        break;
                                                }
                                                if(pilihKasir >= 1 && pilihKasir <= namaMenu.length){
                                                        grandTotal = hitungBarang(namaMenu[pilihKasir - 1], hargaMenu[pilihKasir - 1], menuTotal, hargaMenuTotal, jumlahTerjualTotal ,sc, pilihKasir, jumlahTerjual, grandTotal, waktuPenjualan);
                                                        totalPemasukan += grandTotal;
                                                }


                                        }while(pilihKasir <= namaMenu.length);
                                break;
                                
                                case 2:
                                        do{
                                                System.out.println("=== Menu Admin Bold Beans Coffee === \n1.Tampilkan Menu \n2.Tambah Menu \n3.Ubah Menu \n4.Hapus Menu \n5.Selesai");
                                                System.out.print("Pilihan anda : ");
                                                pilihAdmin = sc.nextInt();
                                                System.out.println("");

                                                switch(pilihAdmin){
                                                        case 1:
                                                                urutHuruf(namaMenu, hargaMenu);
                                                        break;

                                                        case 2:
                                                                if(namaMenu.length == 100){
                                                                        System.out.println("Maaf, menu sudah mencapai batas, yaitu 100. Mohon menghapus beberapa menu terlebih dahulu");

                                                                }
                                                                else if(namaMenu.length < 100){
                                                                        System.out.println("Jumlah menu yang ingin ditambah? (Maksimal menu adalah 100. Menu yang sudah ada [" + namaMenu.length + "/" +"100])");
                                                                        System.out.print(": ");
                                                                        jumlahTambahMenu = sc.nextInt();
                                                                        System.out.println("");

                                                                        if(jumlahTambahMenu >= 100){
                                                                                System.out.println("Maaf, menu tidak dapat melebihi 100");
                                                                                System.out.println("");
                                                                        }
                                                                        else if (jumlahTambahMenu < 100){
                                                                                String[] tempNamaMenu = new String[namaMenu.length + jumlahTambahMenu];
                                                                                int[] tempHargaMenu = new int[hargaMenu.length + jumlahTambahMenu];

                                                                                for(int i = 0; i <= namaMenu.length - 1; i++){
                                                                                        tempNamaMenu[i] = namaMenu[i];
                                                                                        tempHargaMenu[i] = hargaMenu[i];
                                                                                }

                                                                                for(int i = namaMenu.length; i <= tempNamaMenu.length - 1; i++){
                                                                                        System.out.print("Masukkan nama: ");
                                                                                        sc.nextLine();
                                                                                        tempNamaMenu[i] = sc.nextLine();
                                                                                        
                                                                                        System.out.print("Masukkan harga : ");
                                                                                        tempHargaMenu[i] = sc.nextInt();

                                                                                }

                                                                                namaMenu = tempNamaMenu;
                                                                                hargaMenu = tempHargaMenu;

                                                                                System.out.println("");
                                                                        }
                                                                }
                                                        break;

                                                        case 3:
                                                                urutHuruf(namaMenu, hargaMenu);

                                                                sc.nextLine();
                                                                System.out.print("Menu yang ingin diubah (ketik nama menu): ");
                                                                String ubahMenu = sc.nextLine();
                                                                
                                                                for(int i = 0;i < namaMenu.length;i++){
                                                                        if(namaMenu[i].equalsIgnoreCase(ubahMenu)){
                                                                                index = i;
                                                                                break;
                                                                        }
                                                                }

                                                                if (index == -1) {
                                                                        System.out.println("Menu tidak ditemukan \n");
                                                                } else {
                                                                        System.out.println("Apa yang ingin diubah? \n1.Nama \n2.Harga");
                                                                        System.out.print(": ");
                                                                        ubahMenu2 = sc.nextInt();

                                                                        switch(ubahMenu2){
                                                                                case 1:
                                                                                        System.out.print("Masukkan nama baru untuk menu: ");
                                                                                        sc.nextLine();
                                                                                        String namaMenuBaru = sc.nextLine();
                                                                                        namaMenu[index] = namaMenuBaru;
                                                                                        System.out.println("Menu berhasil diubah. \n");
                                                                                break;

                                                                                case 2:
                                                                                        System.out.print("Masukkan harga baru untuk menu: ");
                                                                                        hargaMenuBaru = sc.nextInt();
                                                                                        hargaMenu[index] = hargaMenuBaru;
                                                                                        System.out.println("Menu berhasil diubah. \n");
                                                                                break;
                                                                                        
                                                                        }
                                                                }

                                                        break;

                                                        case 4:
                                                                urutHuruf(namaMenu, hargaMenu);
                                                                System.out.print("Menu yang ingin dihapus(ketik nama menu): ");
                                                                sc.nextLine();
                                                                String hapusMenu = sc.nextLine();

                                                                for (int i = 0; i < namaMenu.length; i++) {
                                                                        if (namaMenu[i].equalsIgnoreCase(hapusMenu)) {
                                                                        index = i;
                                                                        break;
                                                                        }
                                                                }

                                                                if (index != -1) {
                                                                        //hapus menunya dan sinkronkan
                                                                        for (int i = index; i < namaMenu.length - 1; i++) {
                                                                        namaMenu[i] = namaMenu[i + 1];
                                                                        }

                                                                        for (int i = index; i < hargaMenu.length - 1; i++) {
                                                                                hargaMenu[i] = hargaMenu[i + 1];
                                                                        }

                                                                        for (int i = index; i < jumlahTerjual.length - 1; i++) {
                                                                                jumlahTerjual[i] = jumlahTerjual[i + 1];
                                                                        }
                                                                        jumlahTerjual = java.util.Arrays.copyOf(jumlahTerjual, jumlahTerjual.length - 1);                                                         
                                                                        namaMenu = java.util.Arrays.copyOf(namaMenu, namaMenu.length - 1);
                                                                        hargaMenu = java.util.Arrays.copyOf(hargaMenu, hargaMenu.length - 1);


                                                                        System.out.println("Menu '" + hapusMenu + "' berhasil dihapus. \n");
                                                                } else {
                                                                        System.out.println("Menu tidak ditemukan.");
                                                                }
                                                        break;

                                                        case 5:
                                                                System.out.println("Keluar.....");
                                                        break;

                                                        default:
                                                                System.out.println("Maaf, pilihan tidak tersedia");                                                             

                                                }
                                        }while(pilihAdmin != 5);
                                break;

                                case 3:
                                        System.out.println("=== Menu Owner Bold Beans Coffee === \n");
                                        System.out.println("Total penjualan : " + totalPemasukan);
                                        
                                        System.out.println("");

                                        urutPenjualan(namaMenu, jumlahTerjual, waktuPenjualan);
                        }
                } while (pilihDashboard != 4);
                    
        }

}