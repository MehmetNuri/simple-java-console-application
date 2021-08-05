package com.uniyaz.yb;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.uniyaz.yb.entitiy.ListContainer;
import com.uniyaz.yb.entitiy.Product;
import com.uniyaz.yb.entitiy.ProductOffer;
import com.uniyaz.yb.util.ConsoleColors;
import com.uniyaz.yb.util.ResourceHelper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

@SuppressWarnings("unchecked")
public class App {
    private static String fileName = "src/main/resources/data.txt";

    public static void main(String[] args) throws IOException {


        System.out.println(ConsoleColors.CYAN_BOLD + "Teklif Platformuna Hoş Geldiniz\n" + ConsoleColors.RESET);
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            printMenu();

            choice = input.nextInt();
            switch (choice) {

                case 1:

                    addProduct(input);

                    break;

                case 2:
                    listProduct();

                    break;

                case 3:

                    addProductOffer(input);
                    break;

                case 4:

                    listProductOffer();
                    break;

                case 5:

                    break;

                case 6:
                    System.out.println(ConsoleColors.BLACK_BACKGROUND_BRIGHT + "Programdan çıkılıyor.." + ConsoleColors.RESET);
                    System.exit(0);
                    break;
                default:
                    System.out.println(ConsoleColors.RED_BOLD + "Lütfen menüden geçerli bir seçenek giriniz" + ConsoleColors.RESET);
                    break;


            }
        } while (choice != 7);

    }

    private static void listProductOffer() throws IOException {

        Collections.sort(ListContainer.productOfferDb, ProductOffer.comparePrice);
        System.out.println(ListContainer.productOfferDb.get(0).getPrice());


    }

    private static void addProductOffer(Scanner input) {
        System.out.println("Lütfen Şirket Adını Giriniz: ");
        String company_name = input.next();

        System.out.println("Lütfen Şirket Numarasını Giriniz: ");
        String phone = input.next();

        System.out.println("Lütfen Fiyat Girmek İstediğiniz Ürünün Id 'sini Giriniz: ");
        String productId = input.next();

        ProductOffer productOffer = new ProductOffer();
        productOffer.setCompany_name(company_name);
        productOffer.setPhone(phone);
        for (Product product : ListContainer.productDb) {

            if (product.getId() == Integer.parseInt(productId)) {
                productOffer.setProduct(product);
                System.out.println(product.getName() + " ürünü için fiyat giriniz: ");
                break;
            }

        }
        String price = input.next();
        productOffer.setPrice(price);


        ListContainer.productOfferDb.add(productOffer);
    }

    private static void listProduct() {
        for (Product product : ListContainer.productDb) {
            System.out.println(product);
            System.out.println(product.getId());
            System.out.println(product.getName());
        }
    }

    private static void addProduct(Scanner input) {
        System.out.println("Ürün ismini giriniz: ");
        String name = input.next();
        Product product = new Product();
        product.setName(name);
        ListContainer.productDb.add(product);

        App objectIO = new App();


        objectIO.WriteObjectToFile(product);

    }

    public void WriteObjectToFile(Object serObj) {

        try {

            FileOutputStream fileOut = new FileOutputStream("src/main/resources/data.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }


        Product e = null;
        try {
            FileInputStream fileIn = new FileInputStream("src/main/resources/data.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (Product) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
        }

        System.out.println(e.getName());


    }

    private static void printMenu() {

        System.out.print("1.) Ürün Ekle \n");
        System.out.print("2.) Ürün Listele.\n");
        System.out.print("3.) Ürün Fiyat Gir.\n");
        System.out.print("4.) Ürün Fiyat Listele.\n");
        System.out.print("5.) Program Hakkında.\n");
        System.out.print("6.) Çıkış\n");
        System.out.print(ConsoleColors.YELLOW_BACKGROUND + "Lütfen menüden yapmak istediğiniz işlemi seçiniz: " + ConsoleColors.RESET);
    }

}



