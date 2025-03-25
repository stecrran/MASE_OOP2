// Name: 

package mase.oop2.code1;

import java.util.Scanner;

public class Sample {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        final int TOPIC1 = 1, TOPIC2= 2, TOPIC3= 3, EXIT = 4;
        String userContinue = "y";

        while (userContinue.equalsIgnoreCase("y")) {
            switch (userChoice()) {
                case TOPIC1:
                    method1();
                    break;
                case TOPIC2:
                    method2();
                    break;
                case TOPIC3:
                    method3();
                    break;
                case EXIT:
                    System.out.println("Exiting...");
                    userContinue = "n";
                    break;
                default:
                    System.out.println("Unknown entry : ");
                    break;
            }
        }
    }

    public static void method1(){
    }
    
    public static void method2(){
    }

    public static void method3(){
    }
   
    public static int userChoice() {
        System.out.println("What do you want to do ?");
        System.out.println("1. Topic 1");
        System.out.println("2. Topic 2");
        System.out.println("3. Topic 3");
        System.out.println("4. Exit");
        System.out.print("Enter choice --> ");
        return sc.nextInt();
    }
}