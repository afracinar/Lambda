package lambda_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda04 {

    public static void main(String[] args) {

        List<String> kelimeler = new ArrayList<>(Arrays.asList("bilgisayar","laptop","telefonn","televizyon","ayna","kamera","kart","monitor"));

        System.out.println(length3_7veyaAIleBiten(kelimeler)); //[laptop, ayna, kamera, kart]
        System.out.println();
        uzunlukVeIkinciHarfeGoreBenzrszSirala(kelimeler);
        System.out.println();
        System.out.println(length4ve8Haric(kelimeler)); //[bilgisayar, laptop, televizyon, kamera, monitor]
        System.out.println();
        sonHarfSiralaSon3Al(kelimeler); //[bilgisayar, monitor, kart]

    }
    //Task 1: uzunlugu 3 ile 7 arası olan veya a ile biten elemanlardan yeni bir liste olustur
    public static List<String> length3_7veyaAIleBiten(List<String> elemanlar){
       return elemanlar.
               stream().
               filter(t->(t.length()>3 && t.length()<7) || t.toLowerCase().endsWith("a")).
               collect(Collectors.toList());
    }
    //Task 2: list elemanlarını uzunluklarına ve ikinci harflerine göre benzersiz sıralayıp yazdırın
    public static void uzunlukVeIkinciHarfeGoreBenzrszSirala(List<String> elemanlar){
         elemanlar.
                stream().
                sorted(Comparator.comparing(String::length)).sorted(Comparator.comparing(t->t.substring(1,2))).distinct().forEach(t-> System.out.print(t+" "));
    }
    //Task 3: uzunlugu 4 ve 8 olanlar haric bir liste olusturunuz
    public static List<String> length4ve8Haric(List<String> elemanlar){
        return elemanlar.
                stream().
                filter(t->t.length()!=4 && t.length()!=8).
                collect(Collectors.toList());
    }

    //Task 4: List elemanlarını son harfe göre sıralayıp, son 3 elemanı yazdırın
    public static void sonHarfSiralaSon3Al(List<String> elemanlar){
        System.out.println(elemanlar.
               stream().
               sorted(Comparator.comparing(t->t.charAt(t.length()-1))).
                skip(elemanlar.size()-3).collect(Collectors.toList()));
    }
}
