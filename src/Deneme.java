//---------------------------------------------------------------------------------------------------------------------
// Gerekli seyleri import ediyoruz
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Deneme {
    public static void main(String[] args)
    {
//---------------------------------------------------------------------------------------------------------------------
        // Dosya okumak icin gerekli islemleri ayarliyoruz
        Scanner fileIn = null;
        try
        {
            fileIn = new Scanner(new FileInputStream("input.txt"));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Dosya bulunamadi.");
            System.exit(0);
        }
//---------------------------------------------------------------------------------------------------------------------
        // GeometrikNesne tipinde bir dizi olusturuyoruz
        GeometrikNesne[] nesneler = new GeometrikNesne[50];

        int i = 0;               // Dosyadan okuyarak olusturdugumuz nesneleri diziye ekleyebilmek icin olusturduk

        int daireSay = 0;        // Ileride kullanmak icin daire,
        int dikdortgenSay = 0;   // dikdortgen ve
        int silindirSay = 0;     // silindir sayilarini saydirmak uzere baslangicta sifir atiyoruz

        double cevreToplam = 0;  // Ileride kullanmak icin cevre,
        double alanToplam = 0;   // alan ve
        double hacimToplam = 0;  // hacim toplamlarini hesaplatmak uzere baslangicta sifir atadik

        double minCevre = Integer.MAX_VALUE;   // Minimum cevre,
        double minAlan = Integer.MAX_VALUE;    // alan ve
        double minHacim = Integer.MAX_VALUE;   // hacim icin baslangicta buyuk deger atadik

        double maxCevre = 0;   // Maximum cevre,
        double maxAlan = 0;    // alan ve
        double maxHacim = 0;   // hacim icin baslangicta kucuk deger atadik

        // Sonradan kopyasini olusturmak icin son daire, dikdortgen ve silindiri aliyoruz
        Daire sonDaire = new Daire();
        Dikdortgen sonDikdortgen = new Dikdortgen();
        Silindir sonSilindir = new Silindir();
//---------------------------------------------------------------------------------------------------------------------
        // Dosyada okunacak veri kalmayana kadar devam eden while dongusu
        while (fileIn.hasNextLine())
        {
            // Satirlarin basindaki geometrik nesnelerin tipini okuyoruz
            String sekil = fileIn.next();
//---------------------------------------------------------------------------------------------------------------------
            // Okudugumuz sekil daire ise,
            if (sekil.equals("daire"))
            {
                // Satirin devami okuyarak gerekli bilgileri gerekli degiskenlere atiyoruz
                String etiket = fileIn.next();
                double yaricap = fileIn.nextDouble();
                fileIn.next();   // Date in basladigi kismi belli eden "date" kelimesini okutuyoruz
                Date tarih = new Date(fileIn.nextInt(), fileIn.nextInt(), fileIn.nextInt());

                // Okudugumuz nesneyi olusturuyoruz
                GeometrikNesne nesne = new Daire(etiket, tarih, yaricap);

                // Olusturdugumuz nesneyi nesneleri tuttugumuz diziye ekliyoruz
                nesneler[i] = nesne;

                // Son daireye olusturdugumuz nesneyi atiyoruz
                sonDaire = (Daire) nesne;

                daireSay ++;  // Daire sayisini bir artiriyoruz

                // Toplamlarini almak icin cevre ve alanlari hesaplatiyoruz
                double cevre = nesne.cevreHesapla();
                double alan = nesne.alanHesapla();

                // Hesaplattigimiz cevre ve alani toplamlara ekliyoruz
                cevreToplam += cevre;
                alanToplam += alan;

                // Min ve max degerler icin gerekli kosullarda atamalari yapiyoruz
                if (cevre < minCevre) minCevre = cevre;
                if (cevre > maxCevre) maxCevre = cevre;
                if (alan < minAlan) minAlan = alan;
                if (alan > maxAlan) maxAlan = alan;
            }
//---------------------------------------------------------------------------------------------------------------------
            // Okudugumuz sekil dikdortgen ise,
            else if (sekil.equals("dikdortgen"))
            {
                // Satirin devami okuyarak gerekli bilgileri gerekli degiskenlere atiyoruz
                String etiket = fileIn.next();
                double en = fileIn.nextDouble();
                double boy = fileIn.nextDouble();
                fileIn.next();   // Date in basladigi kismi belli eden "date" kelimesini okutuyoruz
                Date tarih = new Date(fileIn.nextInt(), fileIn.nextInt(), fileIn.nextInt());

                // Okudugumuz nesneyi olusturuyoruz
                GeometrikNesne nesne = new Dikdortgen(etiket, tarih, en, boy);

                // Olusturdugumuz nesneyi nesneleri tuttugumuz diziye ekliyoruz
                nesneler[i] = nesne;

                // Son dikdortgene olusturdugumuz nesneyi atiyoruz
                sonDikdortgen = (Dikdortgen) nesne;

                dikdortgenSay ++;   // Dikdortgen sayisini bir artiriyoruz

                // Toplamlarini almak icin cevre ve alani hesaplatiyoruz
                double cevre = nesne.cevreHesapla();
                double alan = nesne.alanHesapla();

                // Hesaplattigimiz cevre ve alani toplamlara ekliyoruz
                cevreToplam += cevre;
                alanToplam += alan;

                // Min ve max degerler icin gerekli kosullarda atamalari yapiyoruz
                if (cevre < minCevre) minCevre = cevre;
                if (cevre > maxCevre) maxCevre = cevre;
                if (alan < minAlan) minAlan = alan;
                if (alan > maxAlan) maxAlan = alan;
            }
//---------------------------------------------------------------------------------------------------------------------
            else   // Okudugumuz sekil silindir ise,
            {
                // Satirin devami okuyarak gerekli bilgileri gerekli degiskenlere atiyoruz
                String etiket = fileIn.next();
                double yaricap = fileIn.nextDouble();
                double uzunluk = fileIn.nextDouble();
                fileIn.next();   // Date in basladigi kismi belli eden "date" kelimesini okutuyoruz
                Date tarih = new Date(fileIn.nextInt(), fileIn.nextInt(), fileIn.nextInt());

                // Okudugumuz nesneyi olusturuyoruz
                GeometrikNesne nesne = new Silindir(etiket, tarih, yaricap, uzunluk);

                // Olusturdugumuz nesneyi nesneleri tuttugumuz diziye ekliyoruz
                nesneler[i] = nesne;

                // Son silindire olusturdugumuz nesneyi atiyoruz
                sonSilindir = (Silindir) nesne;

                silindirSay ++;   // Silindir sayisini bir artiriyoruz

                // Toplamlarini almak icin cevre, alan ve hacimi hesaplatiyoruz
                double cevre = nesne.cevreHesapla();
                double alan = nesne.alanHesapla();
                double hacim = ((Silindir) nesne).hacimHesapla();

                // Hesaplattigimiz cevre, alan ve hacmi toplamlara ekliyoruz
                cevreToplam += cevre;
                alanToplam += alan;
                hacimToplam += hacim;

                // Min ve max degerler icin gerekli kosullarda atamalari yapiyoruz
                if (cevre < minCevre) minCevre = cevre;
                if (cevre > maxCevre) maxCevre = cevre;
                if (alan < minAlan) minAlan = alan;
                if (alan > maxAlan) maxAlan = alan;
                if (hacim < minHacim) minHacim = hacim;
                if (hacim > maxHacim) maxHacim = hacim;
            }
            i++;  // Nesneler dizisine nesnelerimizi sirayla ekleyebilmek icin her donuste i yi bir artiriyoruz
        }
//---------------------------------------------------------------------------------------------------------------------
        // Son daire, dikdortgen ve silindirin kopyalarini olusturuyoruz
        Daire copyDaire = new Daire(sonDaire);
        Dikdortgen copyDikdortgen = new Dikdortgen(sonDikdortgen);
        Silindir copySilindir = new Silindir(sonSilindir);

        // Olusturdugumuz kopyalari da diziye ekliyoruz
        nesneler[i] = copyDaire;
        nesneler[i+1] = copyDikdortgen;
        nesneler[i+2] = copySilindir;

        // Kopyalarin cevre, alan ve hacimlerini de toplamlara ekliyoruz
        cevreToplam += copyDaire.cevreHesapla() + copyDikdortgen.cevreHesapla() + copySilindir.cevreHesapla();
        alanToplam += copyDaire.alanHesapla() + copyDikdortgen.alanHesapla() + copySilindir.alanHesapla();
        hacimToplam += copySilindir.hacimHesapla();

        // Kopyları da daire, dikdortgen ve silidir sayisina ekliyoruz
        daireSay++;
        dikdortgenSay++;
        silindirSay++;
//---------------------------------------------------------------------------------------------------------------------
        // polymorphicYazdir metodu ile dizideki nesneleri yazdiriyoruz
        for (int j=0; j<(i+3); j++){
            polymorphicYadir(nesneler[j]);
            System.out.println("\n****************************************");
        }
//---------------------------------------------------------------------------------------------------------------------
        // Karsilastirirken kolay ulasabilmek icin dairelere, dikdortgenlere ve silindirlere ozel diziler olusturduk
        Daire[] daireler = new Daire[daireSay];
        Dikdortgen[] dikdortgenler = new Dikdortgen[dikdortgenSay];
        Silindir[] silindirler = new Silindir[silindirSay];

        // Verileri dizilere sirayla ekleyebilmek icin olusturdugumuz degiskenler
        int a=0;
        int b=0;
        int c=0;

        // Nesneler dizisinin elemanlarini sirasiyla dolasiyoruz
        for (int j=0; j<(i+3); j++){
            // Nesne daire ise,
            if (nesneler[j] instanceof Daire){
                daireler[a] = (Daire)nesneler[j];
                a++;
            }
            // Nesne dikdortgen ise,
            else if (nesneler[j] instanceof Dikdortgen){
                dikdortgenler[b] = (Dikdortgen) nesneler[j];
                b++;
            }
            // Nesne silindir ise,
            else {
                silindirler[c] = (Silindir)nesneler[j];
                c++;
            }
        }
//---------------------------------------------------------------------------------------------------------------------
        System.out.println("compareTo ile karsilastirma sonuclari:");
        System.out.println("DAIRELER:");
        // Ilk ve son daire ile Son ve Sondan onceki daireyi karsılastiriyoruz
        karsilastir(daireler[0], daireler[daireSay-1]);
        karsilastir(daireler[daireSay-1], daireler[daireSay-2]);

        System.out.println();
        System.out.println("DIKDORTGENLER:");
        // Ilk ve son dikdortgen ile Son ve Sondan onceki dikdortgeni karsılastiriyoruz
        karsilastir(dikdortgenler[0], dikdortgenler[dikdortgenSay-1]);
        karsilastir(dikdortgenler[dikdortgenSay-1], dikdortgenler[dikdortgenSay-2]);

        System.out.println();
        System.out.println("SILINDIRLER:");
        // Ilk ve son silindir ile Son ve Sondan onceki silindiri karsılastiriyoruz
        karsilastir(silindirler[0], silindirler[silindirSay-1]);
        karsilastir(silindirler[silindirSay-1], silindirler[silindirSay-2]);
//---------------------------------------------------------------------------------------------------------------------
        // Ortalama cevre, alan ve hacimi ve Min-Max cevre, alan ve hacimi tutacagimiz listeyi olusturuduk
        double[] liste = new double[9];
        System.out.println("************************************************************************");
        System.out.println("Ortalama cevre, alan ve hacim ve Min-Max cevre, alan ve hacim:");
        // Listenin elemanlarini sirasiyla ekliyoruz
        liste[0] = cevreToplam/(daireSay + dikdortgenSay + silindirSay);  // Ortalama cevre
        liste[1] = alanToplam/(daireSay + dikdortgenSay + silindirSay);   // Ortalama alan
        liste[2] = hacimToplam/silindirSay;                               // Ortalama hacim
        liste[3] = minCevre;   // Minimum cevre degeri
        liste[4] = maxCevre;   // Maximum cevre degeri
        liste[5] = minAlan;    // Minimum alan degeri
        liste[6] = maxAlan;    // Maximum alan degeri
        liste[7] = minHacim;   // Minimum hacim degeri
        liste[8] = maxHacim;   // Maximum hacim degeri

        // Olusturdugumuz listedeki elemanlari sirasiyla yazdiriyoruz
        for (double eleman:liste) System.out.printf("%.2f  ", eleman);
    }
//---------------------------------------------------------------------------------------------------------------------
    // Static polymorphicYazdir metodu
    public static void polymorphicYadir(GeometrikNesne n)
    {
        // Nesne bilgilerini + cevre ve alan bilgilerini yazdiriyoruz
        System.out.println(n);
        System.out.printf("Cevre: %.2f\nAlan: %.2f", n.cevreHesapla(), n.alanHesapla());

        // Nesnemiz silindirse hacim de ekliyoruz
        if (n instanceof Silindir)
            System.out.printf("\nHacim: %.2f", ((Silindir) n).hacimHesapla());
    }
//---------------------------------------------------------------------------------------------------------------------
    // Static karsilastir metodu
    public static void karsilastir(GeometrikNesne n1, GeometrikNesne n2){
        System.out.println(n1.compareTo(n2));
    }
}
//---------------------------------------------------------------------------------------------------------------------