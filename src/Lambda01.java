import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {

    public static void main(String[] args) {

        /*
      1)  Lambda --> mathod create  etme değil mevcut method'ları (library) secip kullanmaktır...
          Lambda'lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
      2) "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
          "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur(Java-Pyton)
      3)  "Functional Programming" hiz, code kisaligi, code okunabilirligi
          ve hatasiz code yazma acilarindan cok faydalidir.Hazır kodları vardır onlar kullanılır
  *** 4)  Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.
          Çünkü map'ler homojen değillerdşr 2 farklı data type ile kullanılabilir
      5)  Lambda fonksiyonları class'tan bağımsızdır
      6)  Elimizde array,collection varsa hiç düşünmeden Lambda kullanmalıyız
      NOTE:İmkan varsa methıd referance yapmak lazım

      * Yazili Olmayan Kural *
* Lambda kullanirken mumkun mertebe "lambda expression"dan kacinilmasi önerilir.
* Eger mumkunse "method referance" kullanilmasi tavsiye edilir.

*/

      List<Integer> sayi = new ArrayList<>(Arrays.asList(34,22,16,11,35,20,63,21,65,44,66,64,81,38,15)); //array'i arrayliste çevirmek için asList kullandık

          printElStructured(sayi); //34 22 16 11 35 20 63 21 65 44 66 64 81 38 15
        System.out.println("\n***********");
          printElFunctional(sayi); //34 22 16 11 35 20 63 21 65 44 66 64 81 38 15
        System.out.println("\n***********");
          printElFunctional1(sayi); //342216113520632165446664813815 -->kullanışsız
        System.out.println("\n***********");
          printElFunctional2(sayi); //34 22 16 11 35 20 63 21 65 44 66 64 81 38 15
        System.out.println("\n***********");
          printCiftElFunctional(sayi); //34 22 16 20 44 66 64 38
        System.out.println("\n***********");
          printCiftElStructured(sayi); //34 22 16 20 44 66 64 38
        System.out.println("\n***********");
          printCift34KucukFunctional(sayi); //22 16 20
        System.out.println("\n***********");
          printCift34BuyukFunctional(sayi); //34 22 16 35 20 63 65 44 66 64 81 38


    }
    //TASK  : "Structured Programming"(core java ile) kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.
    public static void printElStructured(List<Integer> sayi){
        for (Integer w : sayi){
            System.out.print(w+" ");
        }
    }
    //TASK  : "functional Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.
    public static void printElFunctional(List<Integer> sayi){
        sayi.
                stream(). //stream() methodu ile streamAPI-lambda kullanacağımızı söylüyoruz.
                forEach((w)-> System.out.print(w+" ")); //(Lambda expression--lambdaya nasıl çalışacağını söylüyoruz ama lambda ya ne yapmasını gerektiğini söylememiz lazım)
         // lambdayı foreach içine yazıyoruz.forEach() terminal operationdur,bitiştir
         //genelde expressionlardan kaçınılınır.method referance kullanılması tavsiye edilir
    }
    public static void printElFunctional1(List<Integer> sayi){
        sayi.
                stream().
                forEach(System.out::print); //System classına gir.out değişkenini bul.ordan print methodunu kullandık
                                            // method referance--ne yapmak istediğimizi söylüyoruz
    }
    //--->kendimiz bir method oluşturalım ve bunu çağıralım
    public static void yazdir(int a){
        System.out.print(a+" ");
    }
    public static void yazdir(String a){
        System.out.print(a+" ");
    }

    public static void printElFunctional2(List<Integer> sayi){
        sayi.
                stream().
                forEach(Lambda01::yazdir); //method referance--ne yapmak istediğimizi söylüyoruz.forEach terminal operatörüdür.akışı durdurur,sonuçlandırır

    }
    //TASK  : functional Programming ile list elemanlarinin  cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftElFunctional(List<Integer> sayi){
        sayi.
                stream().
                filter(t -> t %2 ==0). //lambda expression   if yerine filter() methodunu kullanmış olduk.çift'leri istediği için filtreledik
                forEach(Lambda01::yazdir); //terminal method,akışı durdurur,sonuçlandırır
    }
    //yukarıdaki task'i filter() kısmını method referance ile yapalım
    public static boolean ciftBul(int a){
        return a%2==0;

    }
    public static void printCiftElFunctional1(List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul). //method referance
                forEach(Lambda01::yazdir);
    }


    //TASK  : Structural Programming ile list elemanlarinin  cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftElStructured(List<Integer> sayi){
        for (Integer w :sayi){
            if (w%2==0){
                System.out.print(w+" ");
            }
        }
    }
    //TASK :functional Programming ile list elemanlarinin 34 den kucuk cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCift34KucukFunctional(List<Integer> sayi){
        sayi.
                stream().
                filter(t->t%2==0 && t<34).forEach(Lambda01::yazdir); //2 koşul olduğundan 2 tane filter methodu arka arkaya da kullanılabilir
    }
    //Task : functional Programming ile list elemanlarinin 34 den buyk veya cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCift34BuyukFunctional(List<Integer> sayi){
        sayi.
                stream(). //stream ile akışa aldık
                filter(t->t>34 || t%2==0). //burada veya dediği için ayrı ayrı filter yapamayız
                forEach(Lambda01::yazdir);
    }

}
