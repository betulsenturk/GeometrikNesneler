// Silindir classı icin GeometrikNesne classını extend ediyoruz
public class Silindir extends GeometrikNesne{

    // Bu class icin gerekli olan degiskenlerimizi olusturduk
    private double yaricap;
    private double uzunluk;

    // Parametresiz constructor metot
    public Silindir(){
        super();        // GeometrikNesne classındaki bilgileri de aliyoruz
        yaricap = 1.0;
        uzunluk = 1.0;
    }

    // Etiket, tarih, yaricap ve uzunluk degiskenlerini parametre olarak alan constructor metot
    public Silindir(String etiket, Date tarih, double yaricap, double uzunluk){
        super(etiket, tarih);     // GeometrikNesne classındaki bilgileri aliyoruz
        this.yaricap = yaricap;   // Parametre olarak gelen yaricapi bu classtaki degiskene atiyoruz
        this.uzunluk = uzunluk;   // Parametre olarak gelen uzunlugu bu classtaki degiskene atiyoruz
    }

    // Copy constructor
    public Silindir(Silindir originalObject){
        super(originalObject);            // GeometrikNesne classından aldiklarimizi da kopyaliyoruz
        yaricap = originalObject.yaricap;
        uzunluk = originalObject.uzunluk;
    }

    // Get ve Set metotlari
    public double getYaricap() {
        return yaricap;
    }

    public void setYaricap(double yaricap) {
        this.yaricap = yaricap;
    }

    public double getUzunluk() {
        return uzunluk;
    }

    public void setUzunluk(double uzunluk) {
        this.uzunluk = uzunluk;
    }

    // toString metodu
    public String toString() {
        return super.toString() + "\nYaricap: " + yaricap + " Uzunluk: " + uzunluk;
    }

    // Silindir clssina ozel olarak hacimHesapla metodu da ekliyoruz
    public double hacimHesapla(){
        return (Math.PI * getYaricap() * getYaricap() * getUzunluk());
    }

    // GeoemtrikNesne classindaki abstract metotlari override ediyoruz
    @Override
    public double alanHesapla() {
        return (2 * getYaricap() * Math.PI * (getYaricap() + getUzunluk()));
    }

    @Override
    public double cevreHesapla() {
        return ((2 * 2 * getYaricap() * Math.PI) + (2 * getUzunluk()));
    }

    @Override
    public int compareTo(Object o) {
        Silindir other = (Silindir) o;
        if (hacimHesapla() > other.hacimHesapla()){
            return 1;
        }
        else if (hacimHesapla() < other.hacimHesapla()){
            return -1;
        }
        else
            return 0;
    }
}
