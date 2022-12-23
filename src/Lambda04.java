import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {


        /*
         TASK :
           fields --> Universite (String)
           bolum (String)
           ogrcSayisi (int)
           notOrt (int)
           olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
           pojp class= classın field'leri olur access modifier'i private yaparız.parametreli ve parametresiz consturoctor'lar,toString ler

 */
        public static void main(String[] args) {

            Universite u01 = new Universite("bogazici","matematik",571,93);
            Universite u02 = new Universite("istanbul tk","matematik",600,81);
            Universite u03 = new Universite("istanbul","hukuk",1400,71);
            Universite u04 = new Universite("marmara","bilgisayar",1080,77);
            Universite u05 = new Universite("odtü","gemi mühendisliği",333,74);

            List<Universite> unv = new ArrayList<>(Arrays.asList(u01,u02,u03,u04,u05));

            System.out.println(notOrt74BuyukUnv(unv)); //false
            System.out.println();
            System.out.println(matBolumVarMi(unv)); //true
            System.out.println();
            System.out.println(ogrSayisiBuyukKucukSirala(unv)); //[Universite{univercity='istanbul', bolum='hukuk', ogrSayisi=1400, notOrt=71.0}, Universite{univercity='marmara', bolum='bilgisayar', ogrSayisi=1080, notOrt=77.0}, Universite{univercity='istanbul tk', bolum='matematik', ogrSayisi=600, notOrt=81.0}, Universite{univercity='bogazici', bolum='matematik', ogrSayisi=571, notOrt=93.0}, Universite{univercity='odtü', bolum='gemi mühendisliği', ogrSayisi=333, notOrt=74.0}]
            System.out.println();
            System.out.println("matBolumSayisi(unv) = " + matBolumSayisi(unv)); //2
            System.out.println();
            System.out.println("ogr550fazlaUniEnBykNotOrt(unv) = " + ogr550fazlaUniEnBykNotOrt(unv)); //ogr550fazlaUniEnBykNotOrt(unv) = OptionalInt[93]
            System.out.println();
            System.out.println("ogr1050AzUniEnKckNotOrt(unv) = " + ogr1050AzUniEnKckNotOrt(unv)); //ogr1050AzUniEnKckNotOrt(unv) = OptionalInt[74]
        }

    //Task 1--> Bütün üniversitelerin notOrt'larinin 74' den buyuk olduğunu kontrol eden pr create ediniz
        public static boolean notOrt74BuyukUnv(List<Universite> unv){
           return unv.
                   stream(). //akış sağlandı--universiteler u01,u02,u03,u04,u05
                   allMatch(t->t.getNotOrt()>74);  //allMatch methodu gelen akıştan tüm elemanları şarta tabi tutar.
                                                   // boolean return eder.tüm hepsi doğru ise true,bir tanesi bile yanlışsa false verir
        }

    //task 02-->universite'lerde herhangi birinde(anyMatch) "matematik" olup olmadigini  kontrol eden pr create ediniz.
    public static boolean matBolumVarMi(List<Universite> unv){
           return unv.
                   stream().
                   anyMatch(t->t.getBolum(). //akıştan gelen objelerin bölüm isimleri alındı
                           toLowerCase(). //bölüm isimlerindeki karakterelr küçük harfe çevrildi
                           contains("mat"));  //içinde "mat" kelimesi var mı kontrol edildi
                              //anyMatch'de bir tanesi bile şartı sağlarsa true verir.
    }

    //task 03-->universite'leri ogr sayilarina gore b->k siralayiniz.
    public static List<Universite> ogrSayisiBuyukKucukSirala(List<Universite> unv){
        return unv.
                stream(). //akış sağlandı
                sorted(Comparator.comparing(Universite::getOgrSayisi).reversed()). //üniler ogr sayısına göre tersten sıralandı
                 collect(Collectors.toList());  //stream yapıyı list yapısına çevirdik
    }

    //Task 4: Matematik bölümlerinin sayısını print ediniz
    public static int matBolumSayisi(List<Universite> unv){
            return (int) unv.  //count long döndüreceği için ve long int'ten büyük olduğundan long'u int'e döndürüyoruz yani daraltıyoruz
                    stream().  //akış sağlandı
                    filter(t->t.getBolum().contains("mat")). //mat bölümü olan unileri seçtik
                    count(); //seçilen üni sayısını aldık.count long döndürür.terminal operatörüdür
    }
                               //filtre             //map-not ort alıyoruz  //max
    //task 05-->Ogrenci sayilari 550'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.
    public static OptionalInt ogr550fazlaUniEnBykNotOrt(List<Universite> unv){
            return unv.
                    stream().
                    filter(t->t.getOgrSayisi()>550).
                    mapToInt(t-> (int) t.getNotOrt()). //burada akışı değiştirdik.artık nor ortalamalrıyla devam ediyoruz.mapToInt bu methoddan sonra java farklı methodları karşımıza çıkarıyor
                    max(); //max methodu mapToInt ile ortaya çıktı.max akıştan gelen en büyük sayıyı getirir
    }
    //task 06-->Ogrenci sayilari 1050'dan az olan universite'lerin en kucuk notOrt'unu bulun
    public static OptionalInt ogr1050AzUniEnKckNotOrt(List<Universite> unv) {
        return unv.
                stream().
                filter(t -> t.getOgrSayisi() < 1050).
                mapToInt(t -> (int) t.getNotOrt()). //getNotOrt dounle olduğu için ilk int değerin içine koyduk
                min();
    }
}

