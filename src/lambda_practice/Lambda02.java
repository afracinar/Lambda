package lambda_practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda02 {
    public static void main(String[] args) {

        List<String> list=new ArrayList<>();
        list.add("Elma");
        list.add("portakal");
        list.add("uzum");
        list.add("cilek");
        list.add("greyfurt");
        list.add("nar");
        list.add("mandalina");
        list.add("armut");
        list.add("elma");
        list.add("keciboynuzu");
        list.add("Ayva");

        System.out.println(ilkHarfBykGerisiKckList(list));
        System.out.println();
        System.out.println(ecIleBaslayanList(list));
        System.out.println();
        yildizliYaz(list);
        System.out.println();
        System.out.println(icindeEOlanlar(list));
        System.out.println();
        lHarfiSil(list);
        System.out.println();
        ikinciHarfeGöreSiralaİlkBeşElCharSayisi(list);

    }
    //S1: list elemanlarını ilk harf buyuk gerisi kucuk sekılde listeleyelim
    public static List<String> ilkHarfBykGerisiKckList(List<String> l){
        return
        l.stream().
                map(t->t.substring(0,1).toUpperCase()+t.substring(1).toLowerCase()).collect(Collectors.toList());
    }

    // S2: ilk harfi e ve ya c olanlari listeleyelim
    public static List<String> ecIleBaslayanList(List<String> liste){
        return liste.stream().
                filter(t->t.toLowerCase().startsWith("e") || t.toLowerCase().startsWith("c")).
                collect(Collectors.toList());
    }
   //Task 3:tüm stringlerin başına ve sonuna * ekleyerek yazalım
    public static void yildizliYaz(List<String> liste){
        liste.
                stream().
                map(t->"*"+t+"*").
                forEach(Utils::yazString);
    }

    //Task 4: icinde e olanlardan yeni bir list olusturunuz
    public static List<String> icindeEOlanlar(List<String> liste){
        return liste.
                stream().
                filter(t->t.toLowerCase().contains("e")).
                collect(Collectors.toList());
    }
    //S5: tum 'l' leri silelim yazdiralim
    public static void lHarfiSil(List<String> liste){
        liste.stream().
                map(t->t.toLowerCase().replace("l","")).
                forEach(Utils::yazString);
    }
    //S6: List elemanarını 2.harfe gore sıralayıp ilk 5 elemandan char sayısı en buyuk elemanı print
    public static void ikinciHarfeGöreSiralaİlkBeşElCharSayisi(List<String> liste){
        System.out.println(liste.
                stream().  //akışı sağladık
                sorted(Comparator.comparing(t->t.charAt(1))). //2.harfe göre sıralama yaptık
                limit(5). //sıralamadaki ilk 5 elemanı aldık
                sorted(Comparator.comparing(String::length).reversed()). //ilk 5 elemanı tekrar sıralamaya tabi tuttuk ve ters çevirdik
                findFirst());  //akıştaki ilk elemanı bize getirir
    }
}
