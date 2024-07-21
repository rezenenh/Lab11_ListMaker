import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;


public class ListMaker {
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);

        final String menu = "A- Add, D- Delete, I- Insert, P- Print, Q- Quit";
        boolean done = false;
        String cmd = "";

        do
        {
            displayList();
            cmd = SafeInput.getRegExString(console, menu, "[AaDdIiPpQq]");
            cmd = cmd.toUpperCase();

            switch(cmd)
            {
                case "A":
                    Add();
                    break;
                case "D":
                    Delete();
                    break;
                case "I":
                    Insert();
                    break;
                case "P":
                    displayList();
                    break;
                case "Q":
                    Quit();
                    break;



            }
            System.out.println("You've selected " +cmd);
        }
        while(!done);
    }

    private static void Quit() {
        Scanner sc = new Scanner(System.in);
        String message = "Are you sure you want to quit?";
        boolean quit = SafeInput.getYNConfirm(sc,message);
        if(quit) {
            System.exit(1);
        }
        return;
    }
    private static void Delete() {
        Scanner sc = new Scanner(System.in);
        String message = "Enter the item number to delete";
        if(list.isEmpty()) {
            System.out.println("The list is empty");
            return;
        }
        int index = SafeInput.getRangedInt(sc, message,1, list.size());
        list.remove(index-1);
    }
    private static void Add() {
        Scanner sc = new Scanner(System.in);
        String item = SafeInput.getNonZeroLenString(sc, "Enter an item to add");
        list.add(item);

    }
    private static void Insert() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the item to insert: ");
        String item = sc.nextLine();
        System.out.println("Enter the position to insert the item: ");
        try {
            int position = Integer.parseInt(sc.nextLine());
            if (position >= 1 && position <= list.size() + 1) {
                list.add(position - 1, item);
                System.out.println("Item inserted.");
            } else {
                System.out.println("Invalid position.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }
    private static void displayList()
    {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        if(list.size() !=0)
        {


            for(int i =0; i < list.size(); i++)
            {
                System.out.printf("%3d%35s", i+1, list.get(i) );
                System.out.println();
            }
        }
        else
            System.out.println("+++ List is empty +++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
    }
}