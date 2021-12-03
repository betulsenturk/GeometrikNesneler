# GeometrikNesneler

## Genel Problem Tanımı: 
Dosyadan okunan veriler kullanılarak geometrik nesnelere ilişkin bir sınıf hiyerarşisi oluşturulması,
soyut sınıf yazımı, çok-biçimlilik (polymorphism) gerçekleştirimi ve "polymorphic" işleyişin örneklenmesi,
bir arayüzün (Comparable interface) gerçekleştirilmesi, dizi tanımı ve kullanımı gibi konuların ele alınması hedeflenmektedir.

#### --Gereksinimler--
##### Geometrik Nesne Sınıfı:
* Geometrik nesneleri genel olarak temsil eden ve soyut (abstract) bir sınıf olan "GeometrikNesne" 
sınıfı yazılacaktır.
* Bu sınıf nesneye verilen etiketi ("Daire 1" gibi bir isim) tutmak için String tipinde "etiket" değişkeni 
ile şeklin oluşturulma tarihini tutmak için Date sınıfı tipinde tarih değişkenlerine sahiptir.
* Bu sınıfta soyut (abstract) metotlar olan "double alanHesapla()", "double cevreHesapla()" ve 
"int compareTo(Object o)" metotlarının imzaları vardır.

##### Daire Sınıfı:
* GeometrikNesne sınıfından kalıtım ile türetilen Daire sınıfı yazılacaktır.
* Bu sınıf double tipinde yaricap değişkenine sahiptir.
* Parametresiz yapıcı (constructor) metot, yaricap değerine 1.0 atamaktadır.
* Üst sınıftaki soyut metotların gerçekleştirimleri yapılmalıdır. Daire alanı için PI * r * r, çevresi için 
2 * PI * r formülleri kullanılabilir. CompareTo metodu şu şekilde gerçekleştirilecektir: eğer metodun 
üzerinde çağrıldığı daire nesnesinin yarıçapı parametrede verilen daire nesnesinin yarıçapından 
büyük ise 1, eğer metodun üzerinde çağrıldığı daire nesnesinin yarıçapı parametrede verilen daire 
nesnesinin yarıçapından küçük ise -1 ve eşitlik durumunda 0 döndürülecektir

##### Dikdörtgen Sınıfı:
* GeometrikNesne sınıfından kalıtım ile türetilen Dikdortgen sınıfı yazılacaktır.
* Bu sınıf double tipinde en ve boy değişkenlerine sahiptir. 
* Parametresiz yapıcı (constructor) metot, en ve boy değerlerine 1.0 atamaktadır.
*  Üst sınıftaki soyut metotların gerçekleştirimleri yapılmalıdır. Dikdortgen alanı için en * boy, çevresi 
için 2 * (en + boy) formülleri kullanılabilir. CompareTo metodu şu şekilde gerçekleştirilecektir: eğer 
metodun üzerinde çağrıldığı dikdörtgen nesnesinin alanı parametrede verilen dikdörtgen 
nesnesinin alanından büyük ise 1, eğer metodun üzerinde çağrıldığı dikdörtgen nesnesinin alanı 
parametrede verilen dikdörtgen nesnesinin alanından küçük ise -1 ve eşitlik durumunda 0 
döndürülecektir.

##### Silindir Sınıfı:
* GeometrikNesne sınıfından kalıtım ile türetilen Silindir sınıfı yazılacaktır.
* Bu sınıf double tipinde yaricap ve uzunluk değişkenlerine sahiptir. 
* Parametresiz yapıcı (constructor) metot, yaricap ve uzunluk değerlerine 1.0 atamaktadır.
* Bu sınıfa özel olarak "hacimHesapla" metodu yazılacaktır. Hacim hesaplama için PI * yaricap * 
yaricap * uzunluk formülü kullanılabilir.
* Üst sınıftaki soyut metotların gerçekleştirimleri yapılmalıdır. Silindir alanı için 2 * yaricap * PI * 
(yaricap + uzunluk), silindir çevresi için (2 * 2 * yaricap * PI) + (2 * uzunluk) formülleri kullanılabilir.
CompareTo metodu şu şekilde gerçekleştirilecektir: eğer metodun üzerinde çağrıldığı silindir 
nesnesinin hacmi parametrede verilen silindir nesnesinin hacminden büyük ise 1, eğer metodun 
üzerinde çağrıldığı silindir nesnesinin hacmi parametrede verilen silindir nesnesinin hacminden
küçük ise -1 ve eşitlik durumunda 0 döndürülecektir.

##### Deneme Sınıfı:
* Deneme sınıfı içinde main metot yazarak aşağıda belirtilenleri yapınız.
* Aşağıda verilen input.txt dosyasını okuyarak oluşturacağınız nesneleri GeometrikNesne tipinde 
tanımlı olan bir dizi içine sırası ile yerleştiriniz.

