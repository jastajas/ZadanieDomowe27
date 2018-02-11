import java.io.*;
import java.util.Scanner;

public class ProductTest {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        Product[] products = {new Product("mleko","Mlekovita", 2.40),
                new Product("ser biały","Piątnica", 2.77),
                new Product("ketchup","Heinz",
                        17.55),new Product("ser żółty","Mlekovita", 9.88)};

        FileWriter fw = new FileWriter("productsList.csv");
        BufferedWriter bfw = new BufferedWriter(fw);

        for (Product product : products) {
            bfw.write(product.toString());
            bfw.newLine();
        }
        bfw.close();

        FileReader file = new FileReader("productsList.csv");
        BufferedReader bfr = new BufferedReader(file);

        String temp = null;
        int i = 0;
        while ((temp = bfr.readLine()) != null){
            i++;
        }

        FileReader newFile = new FileReader("productsList.csv");
        BufferedReader newBfr = new BufferedReader(newFile);
        Product[] newProducts = new Product[i];

        for (int n = 0; n < newProducts.length; n++) {
            String line = newBfr.readLine();
            String[] data = line.split(";");

            newProducts[n] = new Product(data[0], data[1],Double.valueOf(data[2]));
            System.out.println(newProducts[n].toString());
        }


        System.out.println(ProdactsMethod.maxFrequency(newProducts));

        System.out.println(ProdactsMethod.maxFrequency2(newProducts));

        System.out.println(ProdactsMethod.mostExpensive(newProducts));

        System.out.println(ProdactsMethod.sum(newProducts));
    }

}
