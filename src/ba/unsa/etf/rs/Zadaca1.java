package ba.unsa.etf.rs;


import java.util.ArrayList;
import java.util.Scanner;

class Zadaca1  {


    public static String najveciGrad(String[] niz){ //zadatak 1 - a)

        int max = 0, store = 2;

        for (int i = 2; i < niz.length; i+=3){                                                // Posto posteje uvjek barem 3 elementa i uvjek je 3 element broj stanovnika, Svako 2go mjesto povecano za 3 ce biti stanovnik
            niz[i] = niz[i].replaceAll("\\s","");                           // Trazi space u svim u svakom broj i uklanja ga kako bi broj stanovnika ovijek sadrzao samo int
            if (Integer.valueOf(niz[i]) > max){max = Integer.valueOf(niz[i]); store = i;}
            }
        System.out.println(niz[(store - 2)]);                                                 // Ispisuje grad

        return niz[store - 1];                                                                // Vraca drzavu
        }

    public static int najvecaSuma(int[] niz, int x){ //zadatak 1 - b)
       int suma = 0, max = 0, temp = 0, i, n;

        for (i = 0; i < x; i++){
            n = niz[i];
            while ( n > 0 ) {
                suma = suma + (n % 10);
                n = n / 10;
            }
            if (suma > max){ max = suma; temp = i;}
            suma = 0;
        }
        return niz[temp];

    }

    public static Double[] najmanjaSrednjaVrijednost(Double[][] niz){

        double min = srednjaVrijednost(niz[0]);
        int temp = 0;

        for (int i = 0; i < niz.length; i++){
            if (min > srednjaVrijednost(niz[i])){
                min = srednjaVrijednost(niz[i]);
                temp = i;
            }
        }
        return niz[temp];
    }

    public static Double srednjaVrijednost(Double[] niz){                                    //Dodao jos jedan module reda radi

        double se_vr = 0;
        for (int i = 0; i < niz.length; i++) se_vr = se_vr + niz[i];
       // System.out.println(se_vr + " " + se_vr/niz.length);
        return (se_vr / niz.length);
    }

    public static void main(String[] args) {
        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesite string sa gradovima (prazan red za kraj):");

        String[] temp = new String[3];
        ArrayList<String> lista = new ArrayList<String>();

        while (true){

            String grad = ulaz.nextLine();

            if (grad.equals("")) break;

            temp = grad.split(",");                                 //Razdvaja unos na 3 djela

            for (int i = 0; i < temp.length; i++) lista.add(temp[i]);     //Uzima svaki dio is niza is stavlja ga u arrayListu
        }

        String[] gradic = new String[lista.size()];
        lista.toArray(gradic);                                            //pretvara arrayListu u simple array kako bi je mogao prosljediti u module (StackOverflow FTW)

        System.out.println(najveciGrad(gradic));                          //posto u zadatku trazi da vrati drzavu, a u primjeru on je takodjer ispisan :D

        System.out.println("Unesite članove niza cijelih brojeva (0 za kraj): "); //zadatak 1 - b)

        int niz_cj_br[] = new int[100], x;

        for (x = 0; x < 100 ; x++){
            niz_cj_br[x] = ulaz.nextInt();
            if(niz_cj_br[x] == 0) break;
        }

        System.out.println("Broj sa najvećom sumom cifara je: " + najvecaSuma(niz_cj_br, x));

        System.out.println("Unesite broj redova matrice: ");
        Double matica[][] = new Double[ulaz.nextInt()][];

        for (int i = 0; i < matica.length; i++) {
            System.out.println("Unesite broj elemenata u "+ (i + 1) + ". redu: ");                  // +1 jer array pocinje sa 0
            matica[i] = new Double[ulaz.nextInt()];
            System.out.println("Unesite elemente: ");
            for (int j = 0; j < matica[i].length; j++) matica[i][j] = ulaz.nextDouble();
        }

        Double[] nsV = najmanjaSrednjaVrijednost(matica);                                           //nsV = najmanja srednja Vrijednost

        System.out.println("Red sa najmanjom srednjom vrijednošću glasi: ");
        for (int i = 0; i < nsV.length; i++) System.out.println(nsV[i]);
    }
}
