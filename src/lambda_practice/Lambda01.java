package lambda_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//map():stream den gelen elemanları baska ttıplere donusturmek veya uzerlerınde
//ıslem yapmak ıcın (update) kullanılır
//distinct() => Bu method tekrarlı elemanları sadece bir kere akısa sokar.
// Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
// Sıralı akışlar için, farklı elemanın seçimi sabittir
// (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
// Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder.
//terminal  method akışı sonlandıran method demektir.
//sorted() methodu national order'a göre sıralar-küçükten büyüğe,alfabetik sıraya göre
//sorted(Comparator.reverseOrder()) methodu natural order'ın tersi şekilde sıralar
//List olarak döndürebilmek için return type'ı list yapmamız gerekiyor --Task 11 örneği
/*
reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
kullanımı yaygındır pratiktir.
Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.

*/

public class Lambda01 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(-5, -8, -2, -12, 0, 1, 12, 5, 5, 6, 9, 15, 8));
        hepsiniYazdir(list); //-5 -8 -2 -12 0 1 12 5 5 6 9 15 8
        System.out.println("\n*************");
        negatifYaz(list); //-5 -8 -2 -12
        System.out.println("\n**************");
        pozitifYaz(list); //1 12 5 5 6 9 15 8
        System.out.println("\n***************");
        ciftYaz(list); //-8 -2 -12 0 12 6 8
        System.out.println("\n**************");
        pozveCift(list); //12 6 8
        System.out.println("\n*************");
        pozVeyaCift(list); //-8 -2 -12 0 1 12 5 5 6 9 15 8
        System.out.println("\n*************");
        elemanKareleri(list); //25 64 4 144 0 1 144 25 25 36 81 225 64
        System.out.println("\n*************");
        ciftKupYazdır(list); //-512 -8 -1728 0 1728 216 512
        System.out.println("\n*************");
        kareTekrarsiz(list); //25 64 4 144 0 1 36 81 225
        System.out.println("\n*************");
        elemanlarıSirala(list); //-12 -8 -5 -2 0 1 5 5 6 8 9 12 15
        System.out.println("\n*************");
        tersSirala(list); //15 12 9 8 6 5 5 1 0 -2 -5 -8 -12
        System.out.println("\n*************");
        System.out.println("pozKup5List(list) = " + pozKup5List(list)); //pozKup5List(list) = [125, 125, 3375]
        System.out.println("\n*************");
        pozKup5List2(list); //[125, 125, 3375]
        System.out.println("\n*************");
        System.out.println(pozKareSon5DegilList(list)); //[1, 144, 36, 81, 64]
        System.out.println("\n*************");
        System.out.println(elemanToplam(list)); //34
        System.out.println("\n*************");
        System.out.println(elemanToplamReferance(list)); //34
        System.out.println("\n*************");
        pozElToplam(list); //61


    }

    //Task 1: Listi aralarında boşluk bırakarak yazdıran methodu oluşturunuz
    public static void hepsiniYazdir(List<Integer> l) {

        l.stream().forEach(t -> System.out.print(t + " ")); //lambda expression
    }

    //Task 2: sadece negatif olanlari yazdir
    public static void negatifYaz(List<Integer> l) {
        l.stream().filter(t -> t < 0).forEach(t -> System.out.print(t + " "));
    }

    //Task 3:Pozitif olanlardan yeni bir list oluşturun
    public static void pozitifYaz(List<Integer> l) {
        l.stream().filter(t -> t > 0).forEach(t -> System.out.print(t + " "));
    }

    //Task 4: çiftleri yazan methodu yazınız
    public static void ciftYaz(List<Integer> l) {
        l.stream().filter(t -> t % 2 == 0).forEach(t -> System.out.print(t + " "));
    }

    //Task 5:pozitif ve çift olanlar
    public static void pozveCift(List<Integer> l) {
        l.stream().filter(t -> t > 0 && t % 2 == 0).forEach(t -> System.out.print(t + " "));
    }

    //Task 6:pozitif veya çift olanları yazdırınız
    public static void pozVeyaCift(List<Integer> l) {
        l.stream().filter(t -> t > 0 || t % 2 == 0).forEach(t -> System.out.print(t + " "));
    }

    //Task 7:Listin elemanların karelerini aynı satırda boşluk bırakarak yazdırınız
    public static void elemanKareleri(List<Integer> l) {
        l.stream().map(t -> t * t).forEach(t -> System.out.print(t + " ")); //25 64 4 144 0 1 144 25 25 36 81 225 64
    }

    //Task 8:Listin çift elemanlarının küplerini aynı satırda bir boşluk bırakarak yazdırın
    public static void ciftKupYazdır(List<Integer> l) {
        l.stream().filter(t -> t % 2 == 0).map(t -> t * t * t).forEach(t -> System.out.print(t + " "));
    }

    //Task 9:Listin elemanların karelerini tekrarsız yazdıralm.
    public static void kareTekrarsiz(List<Integer> l) {
        l.stream().map(t -> t * t).distinct().forEach(t -> System.out.print(t + " "));  //distinct methodu akıştan gelen birden fazla aynı sayıları tekrarsız yazdırır
    }

    //Task 9: listin elemanlarini kucukten buyuge siralayalim
    public static void elemanlarıSirala(List<Integer> l) {
        l.stream().sorted().forEach(t -> System.out.print(t + " "));
    }

    //Task 10:Listin elemanlarını büyükten küüçüğe doğru sıralayınız
    public static void tersSirala(List<Integer> l) {
        l.stream().sorted(Comparator.reverseOrder()).forEach(t -> System.out.print(t + " "));
    }

    // S11: list pozitif elemanlari icin kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim
    public static List<Integer> pozKup5List(List<Integer> l) {
        return l.stream().filter(t -> t > 0).map(t -> t * t * t).filter(t -> t % 10 == 5).collect(Collectors.toList());

    }

    public static void pozKup5List2(List<Integer> l) {
        List<Integer> yeniList = l.stream().filter(t -> t > 0).map(t -> t * t * t).filter(t -> t % 10 == 5).collect(Collectors.toList());
        System.out.println(yeniList);
    }
    //S12: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim
    public static List<Integer> pozKareSon5DegilList(List<Integer> l){
        List<Integer> list = l.stream().filter(t->t>0).map(t->t*t).filter(t->t%10!=5).collect(Collectors.toList());
        return list;
    }
    //Task 13:List elemanlarının toplamını yazdırınız
    public static int elemanToplam(List<Integer> l){
       int i = l.stream().reduce(0,(a,b)->a+b);
       return i;
    }

    public static int elemanToplamReferance(List<Integer> l){
        int i = l.stream().reduce(0,Integer::sum);
        return i;
    }
    //S14 : Listin pozitif elemanları toplamını bulalım
    public static void pozElToplam(List<Integer> l){
        System.out.println(l.stream().filter(t -> t > 0).reduce(0, Integer::sum));

    }
}
