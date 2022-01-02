import java.util.ArrayList;
import java.util.Scanner;
public class Main {



    public static void main(String[] args) {
        ePark park=new ePark("Safari");
        park.ShowObjects();
        int choice; // for storing user's choice
        int inner_add_remove;
        Scanner sc = new Scanner(System.in); // creating object of Scanner class
        int curr_id;
        int curr_password;
        String dev_name;
        boolean addBool;
        String addAnother;
        boolean removeBool;
        String removeAnother;
        boolean addedSuccessfully;
        boolean removedSuccessfully;

        lp : while(true) // labeling the while loop
        {
            // displaying the menu
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("Welcome to ePark!");
            System.out.println("1. Register Child");
            System.out.println("2. Manage ticket");
            System.out.println("3. Exit park");
            System.out.println("4. Exit");
            System.out.print("Make your choice: ");
            choice = sc.nextInt(); // reading user's choice
            switch (choice)
            {
                case 1:
                    park.registerChild();
                    break;
                case 2:
                    System.out.println("Please enter id: ");
                    curr_id= sc.nextInt();
                    System.out.println("Please enter password: ");
                    curr_password= sc.nextInt();
                    Guardian g1 = park.FindGuardian(curr_id,curr_password);
                    if(g1 == null){
                        System.out.println("Guardian has not been found, Please enter correct information");
                        break;
                    }
                    g1.Manage_eTicket(curr_id, curr_password);
                    ArrayList<Device> devicesAddRemove = g1.get_suitable_devices(park,curr_id,curr_password);
                    System.out.println("2.1 Add ride");
                    System.out.println("2.2 Remove ride");
                    System.out.print("To add a ride print 1, to remove a ride print 2 :");
                    inner_add_remove = sc.nextInt();
                    switch(inner_add_remove)
                    {
                        case 1:
                            addBool = true;
                            while (addBool){
                                System.out.println("Which devices would like to add? Please enter the Device's name: ");
                                sc.nextLine();
                                dev_name = sc.nextLine();
                                addedSuccessfully = g1.addDevice(devicesAddRemove,dev_name, curr_id, curr_password, sc);
                                if(addedSuccessfully){
                                    g1.getAccount().add_to_bill(dev_name,devicesAddRemove);
                                }
                                System.out.println("Would you like to add another device? (Y/N)");
                                addAnother = sc.nextLine();
                                if(addAnother.equalsIgnoreCase("Y")){
                                    continue;
                                }
                                if(addAnother.equalsIgnoreCase("N")){
                                    addBool = false;
                                    break;
                                }
                                if(addAnother.equalsIgnoreCase("N") == false &&  addAnother.equalsIgnoreCase("Y") == false){
                                    System.out.println("Please enter Y or N");
                                }

                            }

                            break;
                        case 2:
                            removeBool = true;
                            while (removeBool) {
                                System.out.println("Which devices would like to Remove? Please enter the Device's name: ");
                                sc.nextLine();
                                dev_name = sc.nextLine();
                                removedSuccessfully = g1.removeDevice(devicesAddRemove, dev_name, curr_id, curr_password);
                                if(removedSuccessfully){
                                    g1.getAccount().remove_from_bill(dev_name, devicesAddRemove);
                                }
                                System.out.println("Would you like to remove another device? (Y/N)");
                                removeAnother = sc.nextLine();
                                if (removeAnother.equalsIgnoreCase("Y")) {
                                    continue;
                                }
                                if (removeAnother.equalsIgnoreCase("N")) {
                                    removeBool = false;
                                    break;
                                }
                                if (removeAnother.equalsIgnoreCase("N") == false && removeAnother.equalsIgnoreCase("Y") == false) {
                                    System.out.println("Please enter Y or N");
                                }
                            }
                        default:
                                System.out.println("Please Enter either 1 or 2");
                    }
                    break;
                case 3:
                    break;
                case 4:
                    // exiting from the switch-case as well as from the while loop using its label lp
                    break lp;
                default:
                    System.out.println("Invalid choice! Please make a valid choice. \n\n");
            }
        }

    }
}
