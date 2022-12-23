import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {

    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(4,2,6,11,-5,7,3,15));
        ciftKarePrint(sayi); //16 4 36
        System.out.println("\n*******");
        tekKupBirFazlaPrint(sayi); //1332 -124 344 28 3376
        System.out.println("\n*******");
        maxElBul(sayi); //Optional[15]
        System.out.println("\n*******");
        ciftKareMaxPrint(sayi); //Optional[36]
        System.out.println("\n*******");
        elemanlarToplam(sayi); //toplam = 43
        System.out.println("\n*******");
        ciftElemanCarpım(sayi); //Optional[48]
        System.out.println("\n*******");
        minBul(sayi); //Optional[-5]
        System.out.println("\n*******");
        bestenBuyukTekKucuk(sayi); //Optional[7]
        System.out.println("\n*******");
        ciftKareSırala(sayi); //4 16 36


    }
    // Task-1 : Functional Programming ile listin cift elemanlarinin  karelerini ayni satirda aralarina bosluk bırakarak print ediniz
    public static void ciftKarePrint( List<Integer> sayi){
       sayi.
               stream().
               filter(Lambda01::ciftBul). //akıştaki çift sayıları filtreledik
               map(t-> t*t). //map methodu akışı değiştirir.sadece çift sayılar üzerinden işlem yapacağız.stream içerisindeki elemanları başka değerlere dçnüştürür (16,4,36)
               forEach(Lambda01::yazdir);
    }

    // Task-2 : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print ediniz
    public static void tekKupBirFazlaPrint(List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda02::tekBul). //filter(t->t%2 != 0). ==>Bu şekilde de olur
                map(t->(t*t*t)+1).
                forEach(Lambda01::yazdir);
    }
    public static boolean tekBul(int a){
         return a%2!=0;
    }                                            //filter            //map--akış değişiyor karekök ile işlem yapılıyor
    // Task-3 : Functional Programming ile listin cift elemanlarinin karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
     public static void ciftKarekokPrint(List<Integer> sayi){
            sayi.
                    stream().
                    filter(Lambda01::ciftBul).
                    map(Math::sqrt). //karekök bulmak için Math class'ından sqrt methodunu kullandık.double döndürüyor
                    forEach(t-> System.out.println(t+" ")); //lambda expression
     }
     //Task-4:List'in en büyük elemanını yazdırınız.
    public static void maxElBul(List<Integer> sayi){  //sonuç sadece bir tane değer döndürecekse reduce() methodu kullanaılır.
        Optional<Integer> maxSayi = sayi.
                stream().
                reduce(Math::max); //eğer result'ımız tek bir değer ise o zaman reduce() terminaal operatörü kullanılır
        //int değere null atayamayız.(INTERWİEVVV).nullpointerexception verir.böyle bir ihtimal varsa Java bizi "Optional" olarak yazmaya zorlar.
        System.out.println(maxSayi);
    }                   //filter         //map       //reduce--1 tane değer olduğu için
    // Task-5 : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void ciftKareMaxPrint(List<Integer> sayi){
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t -> t * t).
                reduce(Integer::max)); //Integer dersek kod daha hızlı çalışır.Math deseydik içinde bir sürü şey olduğu için yavaş çalışırdı
    }
                                         //topplam sadece 1 değer olduğu olduğu için reduce methodu kullanılır.
    // Task-6: List'teki tum elemanlarin toplamini yazdiriniz.Lambda Expression...
    public static void elemanlarToplam(List<Integer> sayi){
        int toplam = sayi.
                stream().
                reduce(0,(a,b)->a+b);
        System.out.println("toplam = " + toplam);

        /*
           * a ilk degerini her zaman atanan degerden (ilk parametre) alır,bu örnekte 0 oluyor,yoplama olduğu için etkisiz eleman
           * b degerini her zamana  stream()'dan akısdan alır (4,2,6,11,-5,7,3,15)yani ilk olarak 4 alır
           * a ilk degerinden sonraki her değeri action(işlem)'dan alır
*/
    }                                    //reduce
    //Task-7: List'teki çift elemanların çarpımını yazdırınız
    public static void ciftElemanCarpım(List<Integer> sayi){
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(Math::multiplyExact)); //method referance

        //2.YOLL---> reduce 2 parametreli şekilde yapımı
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(1, (a, b) -> a * b)); //lambda expression
    }
                                       //reduce
    // Task-8 : List'teki elemanlardan en kucugunu  print ediniz.
    //1.yol method referance
    public static void minBul(List<Integer> sayi){
        System.out.println(sayi.
                stream().
                reduce(Integer::min)); //Math::min
        //2.YOL--method referance
        System.out.println(sayi.
                stream().
                reduce(Lambda02::myMiracMin));
    }
    public static int myMiracMin(int a,int b){
        return a<b ? a : b;
    }
                      //filter      //reduce  //filter
    //Task-9: List'teki 5'ten büyük en küçük tek sayıyı print ediniz
    public static void bestenBuyukTekKucuk(List<Integer> sayi){
        System.out.println(sayi.
                stream().
                filter(a -> (a > 5) && (a % 2 == 1)).
                reduce(Lambda02::myMiracMin));
    }
                         //filter            //map        //reduce kullanılmaz çok değer verecek.sort
    // Task-10 : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
    public static void ciftKareSırala(List<Integer> sayi){
        sayi.
                stream(). //akışı başlattık
                filter(Lambda01::ciftBul). //çift sayıları alarak filtreleme yaptık
                map(t->t*t). //karelerini alarak akışı değiştirdik
                sorted(). //national order yapar yani akış içindeki sayıları alarak küçükten büyüğe doğru sıralar
                forEach(Lambda01::yazdir);
    }
}
