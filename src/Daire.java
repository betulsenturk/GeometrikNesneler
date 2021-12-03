// Daire classı icin GeometrikNesne classını extend ediyoruz
public class Daire extends GeometrikNesne{

    // Bu class icin gerekli degiskenimizi olusturduk
    private double yaricap;

    // Parametresiz constructor metot
    public Daire(){
        super();        // GeometrikNesne classındaki bilgileri de aliyoruz
        yaricap = 1.0;
    }

    // Etiket, tarih ve yaricap degiskenlerini parametre olarak alan constructor metot
    public Daire(String etiket, Date tarih, double yaricap)
    {
        super(etiket, tarih);    // GeometrikNesne classındaki bilgileri aliyoruz
        this.yaricap = yaricap;  // Parametre olarak gelen yaricapi bu classtaki degiskene atiyoruz
    }

    // Copy constructor
    public Daire(Daire originalObject){
        super(originalObject);   // GeometrikNesne classından aldiklarimizi da kopyaliyoruz
        yaricap = originalObject.yaricap;
    }

    // Get ve Set metotlari
    public double getYaricap() {
        return yaricap;
    }

    public void setYaricap(double yaricap) {
        this.yaricap = yaricap;
    }

    // toString metodu
    public String toString(){
        return super.toString() + "\nYaricap: " + getYaricap();
    }

    // GeoemtrikNesne classindaki abstract metotlari override ediyoruz
    @Override
    public double alanHesapla() {
        return (Math.PI * getYaricap() * getYaricap());
    }

    @Override
    public double cevreHesapla() {
        return (2 * Math.PI * getYaricap());
    }

    @Override
    public int compareTo(Object o) {
        Daire other = (Daire) o;

        if (yaricap > other.yaricap){
            return 1;
        }
        else if (yaricap < other.yaricap){
            return -1;
        }
        else
            return 0;
    }
}
