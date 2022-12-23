import lambda_practice.Lambda01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

// *********************** anyMatch() *** allMatch() **** noneMatch() ************************

//anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
//allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
//noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

public class Lambda03 {

    public static void main(String[] args) {

        List<String> menu = new ArrayList<>(Arrays.asList("trileçe","havucDilim","güvec","kokorec","küşleme","arabAşı","waffle","künefe","güvec"));

        alfaBuyukTekrarsız(menu); //ARABAŞI GÜVEC HAVUCDİLİM KOKOREC KÜNEFE KÜŞLEME TRİLEÇE WAFFLE
        System.out.println("\n**************");
        charSayisiTers(menu); //10 7 6 5
        System.out.println("\n**************");
        charSayisiKucukBuyuk(menu); //güvec güvec waffle künefe trileçe kokorec küşleme arabAşı havucDilim
        System.out.println("\n**************");
        harfSayisidenAzKontrol(menu); //list elemanları 7 harften büyük
        System.out.println();
        wIleBaslayanElKontrol(menu); //w ile yemek icat ettik
        System.out.println();
        xIleBitenElKontrol(menu); //x ile yemek ismi biter mi hiç
        System.out.println();
        krktrSayisiEnBuyukEl(menu); //[havucDilim]
        System.out.println();
        ilkElHaricSonHarfSiraliPrint(menu); //kokorec güvec trileçe küşleme waffle künefe havucDilim arabAşı


    }
    // Task -1 : List elemanlarini alafabetik,buyuk harf ve  tekrarsiz print ediniz.
    public static void alfaBuyukTekrarsız(List<String> yemek){
        yemek.
                stream().
                map(String::toUpperCase). //büyük harf olmasını sağladık
                sorted(). //alfabetik olarak sıraladık-national order
                distinct(). //elemanları tekrarsız hale getirdik
                forEach(t-> System.out.print(t+" ")); //print
    }
                //                    map               sorted             distinct      foreach
    // Task -2 : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void charSayisiTers(List<String> ikram){
        ikram.
                stream(). //akışa alındı
                map(String::length). //akışı update ettik,güncelledik.kelimelerin uzunluğuna göre
                sorted(Comparator.reverseOrder()). //tersten sıraladık
                distinct(). //tekrarsız hale getirdik
                forEach(t-> System.out.print(t+" "));
    }

    // Task-3 : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    public static void charSayisiKucukBuyuk(List<String> ikram){
        ikram.
                stream(). //akış geldi
                sorted(Comparator.comparing(String::length)). // String ifadeleri değiştirmeden char sayısına göre küçükten büyüğe sıraladık
                forEach(t-> System.out.print(t+" ")); //print
    }

    // Task-4 : List elemalarinin hepsinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void harfSayisidenAzKontrol(List<String> ikram){
        System.out.print(ikram.
                stream().
                allMatch(t->t.length()<=7) ? "list elemanları 7 ve daha az harften oluşuyor" : "list elemanları 7 harften büyük");
    }
    // Task-5 : List elelmanlarinin hepsinin "w" ile baslamasını noneMatch() ile kontrol ediniz.
    public static void wIleBaslayanElKontrol(List<String> ikram){
        System.out.println(ikram.
                stream().
                noneMatch(t->t.startsWith("w")) ?  "w ile başlayan yemek ismi mi olur" : "w ile yemek icat ettik"); //noneMatch true/false göndürür
    }

    //Task 6: List elemanlarının "x" ile biten en az bir elemanı var mı kontrol ediniz
    public static void xIleBitenElKontrol(List<String> ikram){
        System.out.println(ikram.
                stream().
                anyMatch(t -> t.endsWith("x")) ? "maşallah" : "x ile yemek ismi biter mi hiç");
    }

    //Task 7: Karakter sayısı en büyük elemanı yazdırınız.
    public static void krktrSayisiEnBuyukEl(List<String> ikram){
        Stream<String> sonIsim = ikram.
                stream().
                sorted(Comparator.comparing(t->t.toString().length()).
                        reversed()). //karakter sayısına göre tersten sıralandı
                limit(1); //limit methodu kullanılarak sadece ilk elemanı çağırıldı
        //limit()  methodunun dönen değeri Stream<Sring> yapıdadır
        System.out.println(Arrays.toString(sonIsim.toArray()));
                 //sonIsim.toArray() --> stream olan akış array'e çevrildi
        //Arrays.toString(sonIsim.toArray()) --> Array'i string yapıya çeviriyor
    }
    // Task-8 : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void ilkElHaricSonHarfSiraliPrint(List<String> ikram){
        ikram.
                stream(). //akış sağlandı
                sorted(Comparator.comparing(t->t.charAt(t.length()-1))). //son harfine göre alfabetik sıralandı
                skip(1). //akıştaki ilk eleman hariç tutuldu
                forEach(t-> System.out.print(t+" ")); //print
    }
}