import java.util.Scanner;
import java.util.stream.IntStream;

public class Lambda05 {

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar (x dahil) tamsayilari toplayan bir program create ediniz.

    public static void main(String[] args) {

        System.out.println("toplam = " + topla(8)); //toplam = 36
        System.out.println("toplaCincix = " + toplaCincix(8)); //toplaCincix = 36
        System.out.println("ilkXCiftSayiyiTopla = " + ilkXCiftSayiyiTopla(5));
        System.out.println("toplaIlkXCift = " + toplaIlkXCift(8)); //toplaIlkXCift = 72
        System.out.println("toplaIlkXTek = " + toplaIlkXTek(3)); //toplaIlkXTek = 9
        ikininIlkXkuvveti(3);//2 4 8
        System.out.println();
        istelilenSayininIlkXKuvveti(3,2); //3 9
    }

    //Structured
    public static int topla(int x){
        int toplam =0;
        for (int i = 0; i <= x ; i++) {
            toplam=toplam+i;
        }
        return toplam;
    }

    //Functional
    public static int toplaCincix(int x){
       return IntStream.
               range(1,x+1). //range 2 parametreli kullanılır.ilk parametre dahil 2. parametre dahil değil demektir.bu sayılar akışa alındı
               sum(); //toplamlarını verir
    }
    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int toplaCift(int x){
        return IntStream.
                rangeClosed(1,x).  //
                filter(Lambda01::ciftBul).
                sum();
    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
    public static int ilkXCiftSayiyiTopla(int x){
        return IntStream.
                rangeClosed(1,x*2).
                filter(Lambda01::ciftBul).
                sum();
    }
    public static int toplaIlkXCift(int x){
       return IntStream. //int türünde akış olduğu için akışı int'e göre hazırla diyoruz
                iterate(2,t->t+2). //2 den  sonsuza kadar elemanları 2 arttırarak akışa alır 2-4-6-8-10-....
                limit(x). //akışı limitteki değer kadar sıraladık
               sum(); //akıştan gelen bütün değerleri toplar
    }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz
    public static int toplaIlkXTek(int x) {
        return IntStream.
                iterate(1, t -> t + 2). //1-3-5-7-9-11-13-15-
                        limit(x). //akışı limitteki değer kadar sıraladık
                        sum(); //akıştan gelen sayıları topladık
    }
    //TASK 05 --> 2'nin ilk pozitif x(1-2-3..) kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ikininIlkXkuvveti(int x){
         IntStream.
                 iterate(2,t->t*2). //iterasyon için şartımızı yazdık
                 limit(x). //sınırı belirledik
                 forEach(Lambda01::yazdir);
    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void istelilenSayininIlkXKuvveti(int istenilenSayi,int x){
        IntStream.
                iterate(istenilenSayi,t->t*istenilenSayi).
                limit(x).
                forEach(Lambda01::yazdir);
    }
    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.

    public static void istelilenSayininFaktoriyeli(int istenilenSayi,int x){
        IntStream.
                iterate(istenilenSayi,t->t*(istenilenSayi-1)).
                limit(x).
                forEach(Lambda01::yazdir);
    }
    public static void istenenSayiFaktoriyeli(int x){
        IntStream.rangeClosed(1,x).reduce(1,(t,u)->t*u);
    }
}