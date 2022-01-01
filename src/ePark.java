import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ePark {
    /**
     *  This Class will manage the park ,
     * Contains objects list
     * */
    static Scanner reader=new Scanner(System.in);
    private String name;

    static public ArrayList<Object> systemObjects; // Saves all live object in it

    private ArrayList<Guardian> guardians;

    private ArrayList<Child> children;
    private ArrayList<Device> devices;

    public static Scanner getReader() {
        return reader;
    }

    public ArrayList<Guardian> getGuardians() {
        return guardians;
    }

    public ArrayList<Child> getChildren() {
        return children;
    }

    public ArrayList<Device> getDevices() {
        return devices;
    }

    public ePark(String name) {
        this.name = name;
        systemObjects=new ArrayList<>();
        guardians=new ArrayList<Guardian>();
        children=new ArrayList<Child>();
        devices=new ArrayList<Device>();

        // Add Devices
        Device d1,d2,d3;
        d1=new Device("Mamba Ride",12,1.4,0,true);
        d2=new Device("Giant Wheel",0,0,0,false);
        d3=new Device("Carrousel",8,0,0,false);
        devices.add(d1);
        devices.add(d2);
        devices.add(d3);

        systemObjects.add(d1);
        systemObjects.add(d2);
        systemObjects.add(d3);
        ////////////////

    }


    public void registerChild()
    { /**
        Take Child Details from a Guardian ,
        and register the child to ePark
     */
    String fullName=enterChildFullName();








    }

    private String enterChildFullName() {
        /** This method Takes child name from guardian ,
         * verify details ,
         * */
        String firstName, lastName;
        boolean wrongInput;
        do {
            wrongInput=false;
            System.out.println("Fill Out Registration From");
            System.out.println("Enter Child's First Name :- ");
            firstName = reader.nextLine();
            System.out.println("Enter Child's Last Name :- ");
            lastName = reader.nextLine();

            boolean fNameIsValid=checkName(firstName);
            boolean lNameIsValid=checkName(lastName);

            if( !fNameIsValid || !lNameIsValid)
            {
                System.out.println("Wrong Details : ");
                if(!fNameIsValid) System.out.println(ConsoleColors.RED+"inValid First Name !"+ ConsoleColors.RESET);
                if(!lNameIsValid) System.out.println(ConsoleColors.RED+"inValid Last Name !"+ ConsoleColors.RESET);

                System.out.println(ConsoleColors.YELLOW_BOLD+"Please ReFill The From."+ ConsoleColors.RESET);
                wrongInput=true;

            }

        } while(wrongInput);



        return firstName+" "+lastName;



    }

    private boolean checkName(String firstName) {
        /** INPUT - string first name
         * checks if Name is valid Using Regex
         * return Boolean
         * */
        String nameRegex="[a-zA-Z]{2,}(?: [A-Z][a-z]*)*$";
        Pattern pVar=Pattern.compile(nameRegex);
        Matcher mVar = pVar.matcher(firstName);
        return mVar.matches();
    }


    public void ShowObjects()
    {

        for (Object i:systemObjects
             ) {
            System.out.println(i);

        }

    }

    public void addDevice(ArrayList<Device> deviceArrayList){
        System.out.println("Which devices would like to add?");


    }

    public void RemoveDevice(){

    }

    public void ChooseDevice(Device device){

    }

    public void retrieve_eTicket(int id, int password){
        boolean retrieved = false;
        for (int i = 0; i < this.getChildren().size(); i++) {
            if(this.getChildren().get(i).getId() == id && this.getChildren().get(i).getPassword() == password){
                this.getChildren().get(i).geteTicket().display_eTicket();
                retrieved = true;
            }
        }
        if(retrieved == true){
            return;
        }
        else{
            System.out.println("Did not find the ticket");
        }
    }
}
