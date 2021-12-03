// Dikdortgen classı icin GeometrikNesne classını extend ediyoruz
public class Dikdortgen extends GeometrikNesne{

    // Bu class icin gerekli olan degiskenlerimizi olusturduk
    private double en;
    private double boy;

    // Parametresiz constructor metot
    public Dikdortgen(){
        super();     // GeometrikNesne classındaki bilgileri de aliyoruz
        en = 1.0;
        boy = 1.0;
    }

    // Etiket, tarih, en ve boy degiskenlerini parametre olarak alan constructor metot
    public Dikdortgen(String etiket, Date tarih, double en, double boy){
        super(etiket, tarih);   // GeometrikNesne classındaki bilgileri aliyoruz
        this.en = en;           // Parametre olarak gelen eni bu classtaki degiskene atiyoruz
        this.boy = boy;         // Parametre olarak gelen boyu bu classtaki degiskene atiyoruz
    }

    // Copy constructor
    public Dikdortgen(Dikdortgen originalObject){
        super(originalObject);    // GeometrikNesne classından aldiklarimizi da kopyaliyoruz
        en = originalObject.en;
        boy = originalObject.boy;
    }

    // Get ve Set metotlari
    public double getEn() {
        return en;
    }

    public void setEn(double en) {
        this.en = en;
    }

    public double getBoy() {
        return boy;
    }

    public void setBoy(double boy) {
        this.boy = boy;
    }

    // toString metodu
    public String toString(){
        return super.toString() + "\nEn: " + getEn() + " Boy: " + getBoy();
    }

    // GeoemtrikNesne classindaki abstract metotlari override ediyoruz
    @Override
    public double alanHesapla() {
        return (getEn() * getBoy());
    }

    @Override
    public double cevreHesapla() {
        return (2 * (getEn()+getBoy()));
    }

    @Override
    public int compareTo(Object o) {
        Dikdortgen other = (Dikdortgen) o;

        if (alanHesapla() > other.alanHesapla()){
            return 1;
        }
        else if (alanHesapla() < other.alanHesapla()){
            return -1;
        }
        else
            return 0;
    }
}
