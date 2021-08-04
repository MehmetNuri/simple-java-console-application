package com.uniyaz.yb;

import com.uniyaz.yb.util.ConsoleColors;

import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main( String[] args )  throws IOException {

        Scanner input = new Scanner(System.in);
        int choice;
        while(true){
            printMenu();
            while (!input.hasNextInt())
            {
                System.out.println(ConsoleColors.RED_BOLD +"Lütfen menüden geçerli bir seçenek giriniz"+ ConsoleColors.RESET);
                printMenu();
                input.next();
            }
            choice = input.nextInt();
            switch(choice){

                case 1:

                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:
                    System.out.println("");
                    break;

                case 6:
                    System.out.println(ConsoleColors.BLACK_BACKGROUND_BRIGHT +"Programdan çıkılıyor.."+ ConsoleColors.RESET);
                    System.exit(0);
                    break;
                default :
                    System.out.println(ConsoleColors.RED_BOLD +"Lütfen menüden geçerli bir seçenek giriniz"+ ConsoleColors.RESET);
                    break;

            }

        }

    }

    private static void printMenu() {
        System.out.println(ConsoleColors.CYAN_BOLD + "Teklif Platformuna Hoş Geldiniz\n"+ConsoleColors.RESET );
        System.out.print("1.) Ürün Ekle \n");
        System.out.print("2.) Ürün Listele.\n");
        System.out.print("3.) Ürün Fiyat Gir.\n");
        System.out.print("4.) Ürün Fiyat Listele.\n");
        System.out.print("5.) Program Hakkında.\n");
        System.out.print("6.) Çıkış\n");
        System.out.print(ConsoleColors.YELLOW_BACKGROUND  +"Lütfen menüden yapmak istediğiniz işlemi seçiniz: "+ConsoleColors.RESET );
    }

}



