import java.util.Scanner;

class Barang{
    String nama;
    String jenis;
    int jumlah;
    int harga;

    public void inputBarang(){
        Scanner input = new Scanner(System.in);
        System.out.print("masukkan nama barang = ");
        nama = input.nextLine();
        System.out.print("masukkan jenis barang = ");
        jenis = input.nextLine();
        System.out.print("masukkan jumlah barang = ");
        jumlah = input.nextInt();
        System.out.print("masukkan harga barang = ");
        harga = input.nextInt();
    }

    public void getBarang(String a,String b,int c,int d){
        nama = a;
        jenis = b;
        jumlah = c;
        harga = d;
    }

    // Barang(String a,String b,int c,int d){
    //     nama = a;
    //     jenis = b;
    //     jumlah = c;
    //     harga = d;
    // }

    public void cetakBarang(int id){
        System.out.println(id +"\t"+ nama+"\t\t"+jenis+"\t\t"+jumlah+"\t"+harga);
    }
}

public class test {
    public static void entryData(Barang[] a){
        Scanner input = new Scanner(System.in);
        
        System.out.print("berapa banyak data barang yang ingin anda masukkan? ");
        int n = input.nextInt();
        
        a = new Barang[n];
        
        for(int x=0;x<n;x++){
            a[x] = new Barang();
            System.out.println("Masukkan data Barang ke-"+(x+1)+" : ");
            a[x].inputBarang();
            System.out.println("-----------------------------");
        }
        System.out.println("banyak nya data = "+a.length);
        simpleCetakData(a);
        backMenu(a, "data berhasil di masukkan.");
    }

    public static void entryDataAutomatic(Barang[] a){
        int n = 10;
        a = new Barang[n];
        for(int x=0;x<n;x++){
            a[x] = new Barang();
        }
        a[0].getBarang("Xiaomi note 8", "phone", 3, 1600000);
        a[1].getBarang("Xiaomi note 9", "phone", 5, 1700000);
        a[2].getBarang("Xiaomi note 10", "phone", 12, 2000000);
        a[3].getBarang("Xiaomi note 11", "phone", 10, 2900000);
        a[4].getBarang("Iphone X", "phone", 20, 3000000);
        a[5].getBarang("Iphone XR", "phone", 20, 3500000);
        a[6].getBarang("Asus ROG 14", "laptop", 15, 20000000);
        a[7].getBarang("Asus ROG 15", "laptop", 10, 22000000);
        a[8].getBarang("Logitech GPROX", "headset", 30, 1600000);
        a[9].getBarang("Logitech G933", "headset", 10, 1500000);
        simpleCetakData(a);
        backMenu(a, "data berhasil dimasukkan.");
    }


    public static void cetakData(Barang[] obj){
        if(obj.length<1){
            backMenu(obj, "data tidak ditemukan, masukkan data terlebih dahulu! .");
        }
        else{  
            simpleCetakData(obj);
            backMenu(obj, "data berhasil di tampilkan.");
        }
    }

    public static void simpleCetakData(Barang[] obj){
        System.out.println("__________________________________________________");
        System.out.println("id \t\t nama \t\t jenis \t\t jumlah \t harga ");
        for(int x=0;x<obj.length;x++){
            obj[x].cetakBarang(x+1);
        }  
        System.out.println("__________________________________________________");
    }

    public static void hapusData(Barang[] a){
        Scanner input = new Scanner(System.in);
        simpleCetakData(a);
        System.out.print("masukkan posisi data yang ingin di hapus = ");
        int x = input.nextInt();
        String nama_barang = a[x-1].nama;
        for (int i = x-1; i <= a.length - 2; i++) {
            a[i] = a[i + 1];
        }
        Barang[] y_new = initiateNewArrayRemoveBy1Length(a);
        simpleCetakData(y_new);
        backMenu(y_new, "data pada posisi ke "+x+"("+nama_barang+") berhasil di hapus."); 
    }

    public static void tambahData(Barang[] a){
        Scanner input = new Scanner(System.in);
        simpleCetakData(a);
        System.out.println("1. tambah data di depan.");
        System.out.println("2. tambah data di posisi yang di inginkan.");
        System.out.println("3. tambah data di belakang.");
        System.out.print("pilihan = ");
        int x = input.nextInt();
        switch(x){
            case(1):
                Barang test = new Barang();
                test.inputBarang();
                Barang[] a_new = initiateNewArrayAddedBy1Length(a);
                for(int y = a.length-1;y>=0;y--){
                    a_new[y+1] = a_new[y];
                }
                a_new[0] = test;
                backMenu(a_new, "data berhasil ditambah. ");
                break;
            case(2):
                Barang test2 = new Barang();
                test2.inputBarang();
                System.out.print("masukkan posisi data (1 sampai "+a.length+") yang akan di tambah = ");
                int b = input.nextInt();
                if(b<1||b>a.length){
                    backMenu(a, "gagal.");
                    break;
                }
                Barang[] a_new2 = initiateNewArrayAddedBy1Length(a);
                for(int y=a.length-1;y>=b-1;y--){
                    a_new2[y+1] = a_new2[y];
                }
                a_new2[b-1] = test2;
                backMenu(a_new2, "data berhasil ditambah. ");
                break;
            case(3):
                Barang test3 = new Barang();
                test3.inputBarang();
                Barang[] a_new3 = initiateNewArrayAddedBy1Length(a);
                a_new3[a.length] = test3;
                backMenu(a_new3, "data berhasil ditambah. ");
                break;
            default:
                backMenu(a, "input salah.");
                break;
        }
    }

    public static void sortData(Barang[] a){
        Scanner input = new Scanner(System.in);
        System.out.println("sorting berdasarkan : ");
        System.out.println("1. nama ");
        System.out.println("2. jenis ");
        System.out.println("3. jumlah ");
        System.out.println("4. harga ");
        System.out.print("pilih =  ");
        int x = input.nextInt();
        switch(x){
            case(1):
                sortFilter(a, "nama");
                break;
            case(2):
                sortFilter(a, "jenis");
                break;
            case(3):
                sortFilter(a, "jumlah");
                break;
            case(4):
                sortFilter(a, "harga");
                break;
            default:
                backMenu(a, "salah input, coba lagi.");
                break;
        }
    }

    public static Barang[] initiateNewArrayAddedBy1Length(Barang[] a){
        Barang[] new_obj = new Barang[a.length+1];
        for(int x = 0;x<new_obj.length-1;x++){
            new_obj[x] = a[x];
        }
        return new_obj;
    }

    public static Barang[] initiateNewArrayRemoveBy1Length(Barang[] a){
        Barang[] new_obj = new Barang[a.length-1];
        for(int x = 0;x<new_obj.length;x++){
            new_obj[x] = a[x];
        }
        return new_obj;
    }

    public static void menu(Barang[] a){
        Scanner input = new Scanner(System.in);
        System.out.println("____________________________");
        System.out.println("1. masukkan data barang (manual) .");
        System.out.println("2. masukkan data barang (automatis) .");
        System.out.println("3. tampilkan data barang.");
        System.out.println("4. tambah data barang.");
        System.out.println("5. cari data barang.");
        System.out.println("6. edit data barang.");
        System.out.println("7. hapus data barang.");
        System.out.println("8. sorting/urutkan data barang.");
        System.out.println("9. exit program.");
        System.out.println("____________________________");
        System.out.print("masukkan pilihan = ");
        int c = input.nextInt();
        switch(c){
            case(1):
                entryData(a);
                break;
            case(2):
                entryDataAutomatic(a);
                break;
            case(3):
                cetakData(a);
                break;
            case(4):
                tambahData(a);
                break;
            case(5):
                cariData(a);
                break;
            case(6):
                editData(a);
                break;
            case(7):
                hapusData(a);
                break;
            case(8):
                sortData(a);
                break;
            default:
                break;
        }
    }

    public static void cariData(Barang[] a){
        Scanner input = new Scanner(System.in);
        simpleCetakData(a);
        System.out.println("cari data barang berdasarkan : ");
        System.out.println("1. nama");
        System.out.println("2. jenis");
        System.out.println("3. jumlah");
        System.out.println("4. harga");
        System.out.print("pilih = ");
        int x = input.nextInt();
        switch(x){
            case(1):
                searchFilter(a, "nama");
                break;
            case(2):
                searchFilter(a, "jenis");
                break;
            case(3):
                searchFilter(a, "jumlah");
                break;
            case(4):
                searchFilter(a, "harga");
                break;
            default:
                backMenu(a, "input salah.");
                break;
        }
    }

    public static void editData(Barang[] a){
        Scanner input = new Scanner(System.in);
        simpleCetakData(a);
        System.out.print("pilih urutan data yang akan di edit = ");
        int x = input.nextInt();
        if(x<1||x>a.length){
            backMenu(a, "input salah , ulang kembali.");
        }
        Barang temp = new Barang();
        temp.inputBarang();
        a[x-1] = temp;
        backMenu(a, "data di urutan "+x+" berhasil di edit.");
    }

    public static void sortFilter(Barang[] a,String b){
        Barang temp = new Barang();
        for(int j = 0; j <= a.length-1 - 1; j++){
            for(int i = 0; i <= a.length-1- 1 - j; i++){
                switch(b){
                    case("nama"):
                        if(a[i].nama.compareTo(a[i+1].nama) > 0){
                            temp = a[i];
                            a[i] = a[i+1];
                            a[i+1] = temp;
                        }
                        break;
                    case("jenis"):
                        if(a[i].jenis.compareTo(a[i+1].jenis) > 0){
                            temp = a[i];
                            a[i] = a[i+1];
                            a[i+1] = temp;
                        }
                        break;
                    case("jumlah"):
                        if(a[i].jumlah > a[i+1].jumlah){
                            temp = a[i];
                            a[i] = a[i+1];
                            a[i+1] = temp;
                        }
                        break;
                    case("harga"):
                        if(a[i].harga > a[i+1].harga){
                            temp = a[i];
                            a[i] = a[i+1];
                            a[i+1] = temp;
                        }
                        break;
                    
                }
            }
        }
        simpleCetakData(a);
        backMenu(a, "data berhasil di sorting");
    }

    public static void searchFilter(Barang[] a,String b){
        Scanner input = new Scanner(System.in);
        simpleCetakData(a);
        System.out.print("masukkan kata kunci yang dicari = ");
        String katakunci = input.nextLine();
        boolean found = false;
        int found_location = -1;
        int i = 0;
        while(i<a.length && found==false){
            if(b=="nama"){
                if(katakunci.equals(a[i].nama)){
                    found=true;
                    found_location=i;
                    backMenu(a, "data ditemukan di urutan "+found_location+1+".");
                    break;
                }
            }
            else if(b=="jenis"){
                if(katakunci.equals(a[i].jenis)){
                    found=true;
                    found_location=i;
                    backMenu(a, "data ditemukan di urutan "+found_location+1+".");
                    break;
                }
            }
            else if(b=="jumlah"){
                if(katakunci.equals(String.valueOf(a[i].jumlah))){
                    found=true;
                    found_location=i;
                    backMenu(a, "data ditemukan di urutan "+found_location+1+".");
                    break;
                }
            }
            else{
                if(katakunci.equals(String.valueOf(a[i].harga))){
                    found=true;
                    found_location=i;
                    backMenu(a, "data ditemukan di urutan "+found_location+1+".");
                    break;
                }
            }

            i++;
        }
        backMenu(a, "data tidak ditemukan");
    }



    public static void backMenu(Barang[] a,String b){
        System.out.println(b);
        System.out.println("1.kembali ke menu utama.");
        System.out.println("2.exit program.");
        System.out.print("pilih = ");
        Scanner input = new Scanner(System.in);
        int z = input.nextInt();
        switch(z){
            case(1):
                menu(a);
                break;
            default:
                break;
        }
    }

    public static void main(String[] args){

        Barang[] a = new Barang[0];
        menu(a);

    }
}
