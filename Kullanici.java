
import java.util.Scanner;



public class Kullanici {

    private String ad;
    private String kategori;
    private double fiyat;
    private int begeni;
    private static double toplam=0;
    public Kullanici(){
        this.ad="";
        this.kategori="";
        this.fiyat=0;
        this.begeni=0;

    }

    public Kullanici(String ad, String kategori,double fiyat,int begeni) {
        this.ad = ad;
        this.kategori = kategori;
        this.fiyat=fiyat;
        this.begeni=begeni;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getAd() {
        return ad;
    }

    public String getKategori() {
        return kategori;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    public void setBegeni(int begeni) {
        this.begeni = begeni;
    }

    public int getBegeni() {
        return begeni;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void ayir(String kategori, Kullanici dizi[]) {
        int sayac = 0;
        int gecici=dizi[0].getBegeni();
        int gecici2=dizi[0].getBegeni();
        String geciciAd=dizi[0].getAd();
        String geciciAd2=dizi[0].getAd();
        for (int i = 0; i < dizi.length; i++) {
            if (dizi[i].getKategori().equalsIgnoreCase(kategori)) {
                if (dizi[i].getAd().equalsIgnoreCase("")){
                    System.out.println("");
                }
                else
                System.out.println(dizi[i].getAd());
                if (dizi[i].getBegeni()>gecici){
                    gecici=dizi[i].getBegeni();
                    geciciAd=dizi[i].getAd();
                }
                if (dizi[i].getBegeni()<gecici2){
                    gecici2=dizi[i].getBegeni();
                    geciciAd2=dizi[i].getAd();
                }


            }
        }
        System.out.println(kategori + " oyunlari siralandi.");
        System.out.println("Bu kategoride en cok onerilen oyun:"+geciciAd);
        System.out.println("Bu kategoride en az onerilen oyun:"+geciciAd2);




    }

    public void oyunSec(String kategori,Kullanici liste[]) {
        System.out.println("Secmek istediginiz oyun?(SAYIYLA)");
        for (int i = 0; i < liste.length; i++) {
            if (liste[i].getKategori().equalsIgnoreCase(kategori)){
                System.out.println((i + 1) + ".oyun:" + liste[i].getAd());

            }

        }
        Scanner klavye = new Scanner(System.in);
        int secilen = klavye.nextInt();
        if (!liste[secilen-1].getKategori().equalsIgnoreCase(kategori)){
            do {
                System.out.println("Oyun aradiginiz kategoriye ait degildir.");
                secilen = klavye.nextInt();
            }while (!liste[secilen-1].getKategori().equalsIgnoreCase(kategori));
        }
        String secim;
        String secilenOyunAd = liste[secilen - 1].getAd();
        double secilenFiyat=liste[secilen-1].getFiyat();
        System.out.println("Secilen oyun:" + secilenOyunAd+"\n Secilen oyunun fiyati:"+secilenFiyat);
        System.out.print("Indirim yapmak ister misiniz? Yapmak için E yapmamak için herhangi bir tus:");
        secim=klavye.next();
        if (secim.equalsIgnoreCase("E")){
            indirimYap(secilenFiyat);
        }
        else {
            System.out.println("Indirim yapmamayi sectiniz.");
            toplam+=secilenFiyat;
        }
    }

    public void indirimYap(double secilenFiyat){
        Scanner klavye=new Scanner(System.in);
        System.out.print("Yapilacak indirim yuzdesini giriniz(%50 veya %25):");
        int yuzde=klavye.nextInt();
        if (yuzde==50 || yuzde==25){
        double yeniFiyat=secilenFiyat-secilenFiyat*yuzde/100;
        System.out.println("indirimli fiyatiniz:"+yeniFiyat);
            toplam+=yeniFiyat;
            System.out.println("Toplam fiyatiniz:"+toplam);

    }
        else if (yuzde==0){
            System.out.println("Indirim kuponunuz bulunmadıgından indirim yapilamadı fiyat:"+secilenFiyat);
            toplam+=secilenFiyat;
            System.out.println("Toplam fiyatiniz:"+toplam);
        }

        else {
            do {
                System.out.print("Hatali giris lutfen tekrar deneyiniz:");
                yuzde=klavye.nextInt();
            }
            while (yuzde!=50 && yuzde!=25 && yuzde!=0);
            double yeniFiyat=secilenFiyat-secilenFiyat*yuzde/100;
            System.out.println("indirimli fiyatiniz:"+yeniFiyat);
            toplam+=yeniFiyat;
            System.out.println("Toplam fiyatiniz:"+toplam);

            }
        }






}


        class Yonetici extends Kullanici {
            Scanner tara = new Scanner(System.in);
            private static int sinir=34;
            public Yonetici(String ad, String kategori, double fiyat, int begeni) {
                super(ad, kategori, fiyat, begeni);

            }

            public Yonetici() {
                super();
            }

            @Override //Kullanıcı sınıfından override edilmiş metodlar
            public void ayir(String kategori, Kullanici[] dizi) {
                super.ayir(kategori, dizi);
            }

            @Override
            public void indirimYap(double secilenFiyat) {
                super.indirimYap(secilenFiyat);
            }

            @Override
            public void oyunSec(String kategori, Kullanici[] liste) {
                super.oyunSec(kategori, liste);
            }

            @Override
            public void setKategori(String kategori) {
                super.setKategori(kategori);
            }

            @Override
            public void setAd(String ad) {
                super.setAd(ad);
            }

            @Override
            public void setBegeni(int begeni) {
                super.setBegeni(begeni);
            }

            @Override
            public String getAd() {
                return super.getAd();
            }

            @Override
            public String getKategori() {
                return super.getKategori();
            }

            @Override
            public double getFiyat() {
                return super.getFiyat();
            }

            @Override
            public int getBegeni() {
                return super.getBegeni();
            }

            @Override
            public void setFiyat(double fiyat) {
                super.setFiyat(fiyat);
            }

            public static void oyunEkle(Kullanici[] dizi) { /*Yöneticinin kullanabileceği metodlar. Static oldugundan
                                                         nesneden bağımsızdır. Sınıf ismiyle çağırılabilir.*/

                Scanner tara = new Scanner(System.in);
                System.out.print("Eklemek istediginiz oyunun adini giriniz:");
                String oyunAd = tara.nextLine();
                dizi[sinir + 1].setAd(oyunAd);
                System.out.print("Kategori eklemesi yapiniz:");
                String oyunKategori = tara.nextLine();
                dizi[sinir + 1].setKategori(oyunKategori);
                System.out.print("Oyunun fiyatini giriniz:");
                double oyunFiyat = tara.nextDouble();
                dizi[sinir + 1].setFiyat(oyunFiyat);
                System.out.println("Oyunun begeni sayisini giriniz:");
                int oyunBegeni = tara.nextInt();
                dizi[sinir + 1].setBegeni(oyunBegeni);
                System.out.println("Oyununuz sisteme basari ile eklenmistir.");
                System.out.println("Oyun adi:" + oyunAd + "\nOyun kategori:" + oyunKategori + "\nOyun Fiyati:" + oyunFiyat);
                System.out.println("Oyunun aldigi begeni:" + oyunBegeni);
                sinir++;

            }

            public static void oyunSil(Kullanici[] dizi) {
                Scanner tara = new Scanner(System.in);
                System.out.print("Silinecek oyunun numarasını giriniz");
                for (int i = 0; i < dizi.length; i++) {
                    if (dizi[i].getAd().equalsIgnoreCase("")) {
                        System.out.print("");
                    } else
                        System.out.println(i + 1 + ".Oyun:" + dizi[i].getAd());
                }
                int silinecekno = tara.nextInt();
                if (silinecekno > dizi.length || silinecekno <= 0 || dizi[silinecekno - 1].getAd().equalsIgnoreCase("")) {
                    do {
                        System.out.println("Hicbir oyun bu numara ile eslesmemektedir.");
                        silinecekno = tara.nextInt();
                    }
                    while (silinecekno > dizi.length || dizi[silinecekno - 1].getAd().equalsIgnoreCase(""));
                }
                System.out.println("Oyununuz basari ile silindi.Yeni oyun listeniz");
                for (int i = silinecekno - 1; i < dizi.length - 1; i++) {
                    dizi[i] = dizi[i + 1];
                }
                for (int m = 0; m < dizi.length; m++) {
                    if (dizi[m].getAd().equalsIgnoreCase("")) {
                        System.out.print("");
                    } else {
                        System.out.println("Oyun adi:" + dizi[m].getAd() + "\nOyun kategori:" + dizi[m].getKategori());
                        System.out.println("Oyun Fiyati:" + dizi[m].getFiyat() + "\nOyun Begenisi:" + dizi[m].getBegeni() + "\n");
                    }
                }
            }


            public static void bilgiDegis(Kullanici[] dizi) {
                String cevap;
                Scanner tara = new Scanner(System.in);
                for (int i = 0; i < dizi.length; i++) {
                    if (dizi[i].getAd().equalsIgnoreCase("")) {
                        System.out.print("");
                    } else
                        System.out.println(i + 1 + ".Oyun:" + dizi[i].getAd());
                }
                System.out.print("Degistirilmek istenen bilgiyi giriniz:\nFiyat\nKategori\nAd\nBegeni\nCikis ");
                cevap = tara.next();

                if (cevap.equalsIgnoreCase("Fiyat")) {
                    System.out.print("Fiyatini degistirmek istediginiz oyunun no'sunu giriniz");
                    int oyunNo = tara.nextInt();
                    if (oyunNo > dizi.length || oyunNo <= 0 || dizi[oyunNo - 1].getAd().equalsIgnoreCase("")) {
                        do {
                            System.out.println("Hicbir oyun bu numara ile eslesmemektedir.");
                            oyunNo = tara.nextInt();
                        }
                        while (oyunNo > dizi.length|| oyunNo <= 0 || dizi[oyunNo - 1].getAd().equalsIgnoreCase(""));
                    } else {
                        System.out.print("Oyunun yeni fiyatini giriniz:");
                        double yeniFiyat = tara.nextDouble();
                        dizi[oyunNo - 1].setFiyat(yeniFiyat);
                        System.out.print("Oyunun fiyati degistirildi degistirilen oyunun adi:" + dizi[oyunNo - 1].getAd() + "\nYeni fiyati:");
                        System.out.println(dizi[oyunNo - 1].getFiyat());
                    }
                }

                else if (cevap.equalsIgnoreCase("Kategori")) {
                    System.out.print("Kategori degismek istediginiz oyunun no sunu giriniz:");
                    int oyunNo = tara.nextInt();
                    if (oyunNo > dizi.length || oyunNo <= 0 || dizi[oyunNo - 1].getAd().equalsIgnoreCase("")) {
                        do {
                            System.out.println("Hicbir oyun bu numara ile eslesmemektedir.");
                            oyunNo = tara.nextInt();
                        }
                        while (oyunNo > dizi.length|| oyunNo <= 0 || dizi[oyunNo - 1].getAd().equalsIgnoreCase(""));
                    }
                    else {
                        System.out.print("Oyunun kategorisini giriniz:");
                        String yeniKat=tara.next();
                        dizi[oyunNo-1].setKategori(yeniKat);
                        System.out.print("Oyunun kategorisi degistirildi. degistirilen oyunun adi:"+dizi[oyunNo-1].getAd()+"\nYeni Kategori");
                        System.out.println(dizi[oyunNo-1].getKategori());
                    }
                }

                else if (cevap.equalsIgnoreCase("Ad")){
                    System.out.print("Adini degismek istediginiz oyunun no sunu giriniz:");
                    int oyunNo = tara.nextInt();
                    if (oyunNo > dizi.length || oyunNo <= 0 || dizi[oyunNo - 1].getAd().equalsIgnoreCase("")) {
                        do {
                            System.out.println("Hicbir oyun bu numara ile eslesmemektedir.");
                            oyunNo = tara.nextInt();
                        }
                        while (oyunNo > dizi.length|| oyunNo <= 0 || dizi[oyunNo - 1].getAd().equalsIgnoreCase(""));
                    }

                    else {
                        System.out.print("Oyunun adini giriniz:");
                        String yeniAd=tara.next();
                        dizi[oyunNo-1].setKategori(yeniAd);
                        System.out.print("Oyunun adi degistirildi. degistirilen oyunun adi:"+dizi[oyunNo-1].getAd()+"\nYeni ad:");
                        System.out.println(dizi[oyunNo-1].getAd());
                    }
                }

                else if (cevap.equalsIgnoreCase("Begeni")){
                    System.out.print("Begeni sayisini degismek istediginiz oyunun no sunu giriniz:");
                    int oyunNo = tara.nextInt();
                    if (oyunNo > dizi.length || oyunNo <= 0 || dizi[oyunNo - 1].getAd().equalsIgnoreCase("")) {
                        do {
                            System.out.println("Hicbir oyun bu numara ile eslesmemektedir.");
                            oyunNo = tara.nextInt();
                        }
                        while (oyunNo > dizi.length|| oyunNo <= 0 || dizi[oyunNo - 1].getAd().equalsIgnoreCase(""));
                    }

                    else {
                        System.out.print("Oyunun yeni begeni sayisini giriniz:");
                        String yeniBeg=tara.next();
                        dizi[oyunNo-1].setKategori(yeniBeg);
                        System.out.print("Oyunun Begenisi degistirildi. degistirilen oyunun adi:"+dizi[oyunNo-1].getAd()+"\nYeni begeni:");
                        System.out.println(dizi[oyunNo-1].getBegeni());
                    }

                }

                else
                    System.out.println("CIKIS YAPILIYOR");


            }

        }




  class Calistir {
      public static void main(String[] args) { //Çalıştırma fonksiyonu
          int diziUz=1000;
          Kullanici[] oyun = new Kullanici[diziUz]; //Bu bölümde 35 adet oyun tanımlanmış geri kalan alanlar boş bırakılmıştır.
          Kullanici[] kutuphane=new Kullanici[diziUz];
          oyun[0] = new Kullanici("GTFO", "Aksiyon", 135.60, 29665);
          oyun[1] = new Kullanici("Baldur's Gate", "Aksiyon", 50, 1436);
          oyun[2] = new Kullanici("Propnight", "Aksiyon", 32, 2206);
          oyun[3] = new Kullanici("Ready Or Not", "Aksiyon", 99, 2001);
          oyun[4] = new Kullanici("Chorus", "Aksiyon", 61, 1066);
          oyun[5] = new Kullanici("Sands of salzaar", "Rol Yapma", 15, 13584);
          oyun[6] = new Kullanici("Wizardry:The five ordeals", "Rol Yapma", 45, 469);
          oyun[7] = new Kullanici("Ruined King", "Rol yapma", 100, 5593);
          oyun[8] = new Kullanici("Wartales", "Rol yapma", 159, 2884);
          oyun[9] = new Kullanici("New world", "Rol yapma", 109, 145563);
          oyun[10] = new Kullanici("ICARUS", "Macera", 50, 8803);
          oyun[11] = new Kullanici("Pray for the gods", "Macera", 42.50, 3258);
          oyun[12] = new Kullanici("Against", "Macera", 25.60, 2671);
          oyun[13] = new Kullanici("After The Fall", "Macera", 54.90, 1568);
          oyun[14] = new Kullanici("Shadow Tactics", "Macera", 40, 2733);
          oyun[15] = new Kullanici("Ultimate Admiral", "Simulasyon", 57, 2956);
          oyun[16] = new Kullanici("Farming simulator", "Simulasyon", 269, 13822);
          oyun[17] = new Kullanici("Train simulator", "Simulasyon", 50, 15175);
          oyun[18] = new Kullanici("Heavenly Bodies", "Simulasyon", 32, 3524);
          oyun[19] = new Kullanici("Bbq simulator", "Simulasyon", 3.57, 450);
          oyun[20] = new Kullanici("Christmas Massacre", "Korku", 13.95, 2453);
          oyun[21] = new Kullanici("Poppy Playtime", "Korku", 10.50, 9941);
          oyun[22] = new Kullanici("Happy's Humble Burger Farm", "Korku", 32, 3360);
          oyun[23] = new Kullanici("Forewarned", "Korku", 22, 1578);
          oyun[24] = new Kullanici("Phasmaphobia", "Korku", 23, 359267);
          oyun[25] = new Kullanici("Thunder Tier One", "Strateji", 99, 2036);
          oyun[26] = new Kullanici("Noble Fates", "Strateji", 32, 1981);
          oyun[27] = new Kullanici("Age Of Empires", "Strateji", 299, 22199);
          oyun[28] = new Kullanici("Gloomhaven", "Strateji", 57, 6733);
          oyun[29] = new Kullanici("Age of Darkness", "Strateji", 49.50, 2348);
          oyun[30] = new Kullanici("Forza Horizon 5", "Spor", 299, 42214);
          oyun[31] = new Kullanici("Fifa 22", "Spor", 419, 20752);
          oyun[32] = new Kullanici("Gp bikes", "Spor", 40, 1957);
          oyun[33] = new Kullanici("Cricket 22", "Spor", 329, 2468);
          oyun[34] = new Kullanici("Scooter Flow", "Spor", 18.5, 1273);
         for (int i=35;i<diziUz;i++){
             oyun[i]=new Kullanici();
         }


          Scanner klavye = new Scanner(System.in);
          System.out.print("Kullanici adinizi ve parolanizi giriniz.\nKullanici adi:");
          String kullaniciAdi = klavye.next();
          System.out.print("Parola:");
          String parola = klavye.next();

          if (kullaniciAdi.equals("Yonetici") && parola.equals("336456")) {  /*Giriş yapan kişinin yönetici olup olmadığının
                                                                               kontrolü*/
              int secimNo;
              String cevap;
              do {

                  System.out.println("Yonetici sistemine hosgeldiniz lutfen yapmak istediginiz islemi seciniz.");
                  System.out.println("1-Oyun ekle\n2-Oyun Sil\n3-Bilgi degis\n4-Oyun bak");
                  secimNo = klavye.nextInt();
                  switch (secimNo) {
                      case 1: {
                          Yonetici.oyunEkle(oyun);
                          break;
                      }

                      case 2: {
                          Yonetici.oyunSil(oyun);
                          break;
                      }

                      case 3: {
                          Yonetici.bilgiDegis((oyun));
                          break;
                      }

                      case 4: {
                          System.out.print("Aradiginiz kategoriyi giriniz:");
                          String kategori = klavye.next();
                          Yonetici yonetici = new Yonetici();
                          yonetici.ayir(kategori, oyun);
                          yonetici.oyunSec(kategori,oyun);
                          break;
                      }

                      default: {
                          System.out.println("CIKIS YAPILIYOR.");
                          break;
                      }
                  }
                  System.out.print("Islem sona erdi. Tekrar baska bir islem yapmak istermisiniz Tekrar için E ye basınız:");
                  cevap = klavye.next();
              }
              while (cevap.equalsIgnoreCase("E"));

          }
          else {
              String cevap;
              do {


                  System.out.print("Oyun sistemine hosgeldiniz oyun bulmak için kategoriyi giriniz:");
                  String kategori = klavye.next();
                  Kullanici kullanici = new Kullanici(); /*Kullanıcı sınıfındaki fonksiyonlar static değil bu yüzden nesne
                                                           oluşturmak gerekli*/
                  kullanici.ayir(kategori, oyun);
                  kullanici.oyunSec(kategori, oyun);
                  System.out.print("Islem sona erdi.Tekrar baska bir islem yapmak istermisiniz Tekrar için E ye basınız:");
                  cevap = klavye.next();
              }
              while (cevap.equalsIgnoreCase("E"));

          }

      }
  }