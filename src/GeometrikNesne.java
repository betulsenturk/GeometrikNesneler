// Geometrik nesneleri genel olarak temsil eden ve abstract bir sınıf olan GeometrikNesne classını oluşturduk
public abstract class GeometrikNesne implements Comparable {

    // Bu class icin gerekli olan degiskenlerimizi olusturduk
    private String etiket;
    private Date tarih;

    // Parametresiz constructor metot
    public GeometrikNesne()
    {
        tarih = new Date();
    }

    // Etiket ve tarih degiskenlerini parametre olarak alan constructor metot
    public GeometrikNesne(String etiket, Date tarih)
    {
        this.etiket = etiket;   // Bu class a ait olan degiskenlere
        this.tarih = tarih;     // parametre ile gelen degiskenleri atiyoruz
    }

    // Copy Constructor
    public GeometrikNesne(GeometrikNesne originalObject)
    {
        etiket = originalObject.etiket;
        tarih = new Date(originalObject.tarih);   // Privacy Leak engellenecek sekilde yaziyoruz
    }

    // Get ve Set metotlari (Tarih icin yine privacy leake dikkat ediyoryuz)
    public String getEtiket(){
        return etiket;
    }

    public Date getTarih(){
        return new Date(tarih);
    }

    public void setEtiket(String etiket) {
        this.etiket = etiket;
    }

    public void setTarih(Date tarih) {
        this.tarih = new Date(tarih);
    }

    // toString metodu
    public String toString(){
        return "Etiket: " + getEtiket() + " Tarih: " + getTarih();
    }

    // Abstract metotların imzaları
    public abstract double alanHesapla();
    public abstract double cevreHesapla();
    public abstract int compareTo(Object o);
}
