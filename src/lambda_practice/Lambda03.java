package lambda_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda03 {

    public static void main(String[] args) {

        Apartman daire1=new Apartman("dogu",3,4000);
        Apartman daire2=new Apartman("bati",2,2500);
        Apartman daire3=new Apartman("guney",1,3500);
        Apartman daire4=new Apartman("dogu",5,3000);

        List<Apartman> kiralikDaireler=new ArrayList<>(Arrays.asList(daire1,daire2,daire3,daire4));
        doguKiraSırasi(kiralikDaireler);
        System.out.println("katSayisi2denCokDairelerinKiralari(kiralikDaireler) = " + katSayisi2denCokDairelerinKiralari(kiralikDaireler));
        kira3000cokDaireninKatSayisiEnAzOlan(kiralikDaireler); //Optional[Apartman{cephe='guney', katSayisi=1, kira=3500}]

    }

    //Task 1: Doğu cephesindeki kiralık daireleri kiralarına göre sıralayınız.
    public static void doguKiraSırasi(List<Apartman> kiralikDaireler){
        kiralikDaireler.
                stream().
                filter(t->t.getCephe().equalsIgnoreCase("dogu")). //cephesi dogu olan daireleri filtreledik
                sorted(Comparator.comparing(Apartman::getKira)).forEach(System.out::println);
    }
    //Task 2: Kat sayısı 2 den çok olan dairelerin kliralarını listeleyin
    public static List<Integer> katSayisi2denCokDairelerinKiralari(List<Apartman> kiralikDaireler){ //list kiralar integer olacağından dta type Integer
        return kiralikDaireler.
                stream().
                filter(t->t.getKatSayisi()>2). //kat sayısı 2'den çok olan daireler var
                map(t->t.getKira()).
                collect(Collectors.toList());
    }
    //Task 3: kirası 3000den cok olan daireleri kat sayısı en az olanı yazdırın
    public static void kira3000cokDaireninKatSayisiEnAzOlan(List<Apartman> kiralikDaireler){
        System.out.println(kiralikDaireler.
                stream().
                filter(t->t.getKira()>3000).
                sorted(Comparator.comparing(Apartman::getKatSayisi)).
                findFirst());
    }


}
