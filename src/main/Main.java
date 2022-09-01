package main;

import shablon.MyException;
import shablon.Rabotnic;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Количество сотрудников: ");
        Rabotnic[] rabotnic = new Rabotnic[scanner.nextInt()];
        scanner.nextLine();
        for (int i = 0; i < rabotnic.length; i++) {
            rabotnic[i] = new Rabotnic();

            String name = writeName(i,"name");
            String lastname = writeName(i,"lastname");
            int year = checkInt1(i,"both");
            int yearWorking = checkInt2(i,"startWorking");

            rabotnic[i].setName(name);
            rabotnic[i].setLastname(lastname);
            rabotnic[i].setYear(year);
            rabotnic[i].setStartWorking(yearWorking);
        }
        for (Rabotnic r:rabotnic) {
            System.out.println("Имя: "+r.getName()+"\nФамилия: "+r.getLastname() );
            System.out.println("Год рождения: "+r.getYear() );
            System.out.println("В каком году устраиволся на работу: "+r.getStartWorking() );
        }
    }
    public static boolean checkWord(String name) {
        int counter = 0;
        for (int i = 0; i < name.length(); i++) {
            if (Character.isLetter(name.charAt(i) ) ) {
                counter++;
            }
        }
        return name.length() == counter;
    }
    public static String writeName(int i, String word) {
        i++;
        System.out.printf("Print %s %d ",word,i);
        String name = scanner.nextLine();
        try {
            if (!checkWord(name)) {
                throw new MyException();
            }
        } catch (MyException e) {
            while (!checkWord(name)) {
                System.out.println("404");
                System.out.printf("Print %s %d \n",word,i);
                name = scanner.nextLine();
            }
        }
        return name;
    }

    public static int checkInt1(int i,String word) {
        i++;
        while (true) {
            try {
                System.out.printf("Print %s year: %d ",word,i);
                int year = scanner.nextInt();
                if (LocalDateTime.now().getYear() - year > 0 && (year > 1950) ) {
                    scanner.nextLine();
                    return year;
                }
                throw new Exception();
            } catch (Exception e) {
                scanner.nextLine();
                System.out.printf("404\n",i);
            }

        }
    }
    public static int checkInt2(int i,String word) {
        i++;
        Rabotnic rabotnic = new Rabotnic();
        while (true) {
            try {
                System.out.printf("Print %s year: %d ",word,i);
                int year = scanner.nextInt();
                if ( (year + rabotnic.getYear() ) % 100 >= 18) {
                    scanner.nextLine();
                    return year;
                }
                throw new MyException();
            } catch (MyException e) {
                scanner.nextLine();
                System.out.printf("404\n",i);
            }
        }
    }
}