import java.util.ArrayList;

public class ProdactsMethod {

    public static double sum(Product[] newProducts){

        double sumVal = 0;

        for (int i = 0; i < newProducts.length; i++) {
            sumVal += newProducts[i].getPrice();
        }

        return sumVal;
    }

    public static String mostExpensive(Product[] newProducts){

        String mostExp = "";
        double tempPrice = 0;

        for (int i = 0; i < newProducts.length; i++) {
            if(newProducts[i].getPrice() > tempPrice){
                mostExp = newProducts[i].getName();
            }
        }

        return mostExp;
    }

    public static String maxFrequency(Product[] newProducts) {

        // minus metody to wskazanie pierwszego najczęstszego produktu, w przypadku produktu o tej samej ilości produktów nie zostanie on zwrócony
        // rozwiązanie sprawdzające tego samego producenta za każdym razem jak pojawi się podczas sprawdzania tablicy
        String producerName = "";
        int multiProd = 0;

        for (int x = 0; x < newProducts.length; x++) {
            int m = 0;
            int t = 0;
            do {
                if (newProducts[x].getProducer().equals(newProducts[t].getProducer())) {
                    m++;
                }
                t++;
            } while (t < newProducts.length);
            if (multiProd < m) {
                multiProd = m;
                producerName = newProducts[x].getProducer();
            }
        }
        return producerName;
    }
    public static String maxFrequency2(Product[] newProducts) {

        // minus metody to wskazanie pierwszego najczęstszego produktu, w przypadku produktu o tej samej ilości produktów nie zostanie on zwrócony
        // rozwiązanie sprawdzające danego producenta tylko jeden raz

        String producerName = "";
        int multiProd = 0;
        ArrayList<String> checkedVal = new ArrayList<String>();

        for (int x = 0; x < newProducts.length; x++) {
            int m = 0;
            int t = 0;
            if (!(checkedVal.contains(newProducts[x].getProducer()))){
                do {
                    if (newProducts[x].getProducer().equals(newProducts[t].getProducer())) {
                        m++;
                    }
                    t++;
                } while (t < newProducts.length);
                checkedVal.add(newProducts[x].getProducer());
                if (multiProd < m) {
                    multiProd = m;
                    producerName = newProducts[x].getProducer();
                }
            }

        }
        return producerName;
    }


}
