import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        ePark park=new ePark("Safari");
        park.ShowObjects();
        int choice; // for storing user's choice
        Scanner sc = new Scanner(System.in); // creating object of Scanner class
        // displaying the menu
        System.out.println("Welcome to ePark!");
        System.out.println("1. Register Child");
        System.out.println("2. Manage ticket");
        System.out.println("3. Add ride");
        System.out.println("4. Remove ride");
        System.out.println("5. Exit park");
        System.out.println("6. Exit");
        lp : while(true) // labeling the while loop
        {
            System.out.print("Make your choice: ");
            choice = sc.nextInt(); // reading user's choice
            switch (choice)
            {
                case 1: // for Right Angled Triangle
                    park.registerChild();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    // exiting from the switch-case as well as from the while loop using its label lp
                    break lp;
                default:
                    System.out.println("Invalid choice! Please make a valid choice. \n\n");
            }
        }

    }
}
