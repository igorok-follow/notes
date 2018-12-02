

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class capital_manager {

    public static void ClearNotes() throws FileNotFoundException {
        File file = new File("note.txt");
        PrintWriter printWriter = new PrintWriter(file.getAbsoluteFile());
        try {
            printWriter.flush();
        }finally {
            printWriter.close();
        }
    }

    public static void ClearCookies() throws FileNotFoundException{
        File file1 = new File("login.txt");
        File file2 = new File("password.txt");
        PrintWriter printWriter = new PrintWriter(file1.getAbsoluteFile());
        PrintWriter printWriter1 = new PrintWriter(file2.getAbsoluteFile());
        try {
            printWriter.flush();
        } finally {
            printWriter.close();
        }
        try {
            printWriter1.flush();
        }finally {
            printWriter1.close();
        }
    }

    public static int k;

    public static void Logining() throws IOException{
        Scanner logining = new Scanner(System.in);

        System.out.println("Enter the login: ");
        String user = logining.nextLine();
        System.out.println("Enter the password: ");
        String password = logining.nextLine();

        Scanner in = new Scanner(new File("login.txt"));
        Scanner in2 = new Scanner(new File("password.txt"));

        while(in.hasNext()){
            if (in.nextLine().equals(user)){
                if(in2.nextLine().equals(password)){
                    System.out.println("Welcome, " + user + "!");
                    k = 1;
                        if(k == 1){
                            notes();
                        }
                }
            }else {
                System.out.println("Incorrect login or password.");
            }
        }
    }

    public static void showLogin() throws IOException{
            System.out.print("Your login: ");
            FileReader reader = new FileReader("login.txt");
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.print("\nYour password:");
            FileReader reader1 = new FileReader("password.txt");
            int d;
            while ((d = reader1.read()) != -1) {
                System.out.print((char) d);
        }
        }

    public static void notes() throws IOException{
        Scanner in = new Scanner(System.in);
        System.out.println("U want create a new note or show your old notes? \n 1.Create new note \n 2.Show notes \n 3.Clear notes \n4.I want nothing");
        int v = in.nextInt();
        if(v == 1){
            Scanner on = new Scanner(System.in);
            System.out.println("What new with you happened today?");
            FileWriter writer = new FileWriter("note.txt", true);
            String string = on.nextLine();
            writer.write(string + "  ");
            writer.flush();
        }

        if(v == 2){
            ShowNotes();
        }

        if(v == 3){
            ClearNotes();
        }

        if(v == 4){
            System.out.println("Good buy!)");
        }
    }

    public static void ShowNotes() throws IOException {
        FileReader reader = new FileReader("note.txt");
        int c;
        while ((c = reader.read()) != -1) {
            System.out.print((char) c);
        }
    }

    public static void register(){
            Scanner strin = new Scanner(System.in);
            System.out.println("Enter the login: ");
            try ( FileWriter writer = new FileWriter("login.txt", true)) {
                String str = strin.nextLine();
                writer.write(str);
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Enter the password: ");
            try ( FileWriter writer = new FileWriter("password.txt", true)) {
                String str = strin.nextLine();
                writer.write(str);
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
        }
        }
//    static ArrayList<String> notes = new ArrayList<>();

    public static void main(String[] args)throws IOException {
        Scanner in = new Scanner(System.in);
        Scanner strin = new Scanner(System.in);
        System.out.println("|----------|");
        System.out.println("|1.Register|\n|2.Logining|");
        System.out.println("|----------|");
        int b = in.nextInt();
            if (b == 1) {
                System.out.println("1.Register \n2.Read data\n3.Clear data");
                int a = in.nextInt();
                    if (a == 1){
                        register();
                    }
                    if (a == 2){
                        showLogin();
                    }
                    if (a == 3){
                        ClearCookies();
                    }
            }
        if (b == 2){
            Logining();
        }
    }
}