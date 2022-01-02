
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ePark {
    static public ArrayList<Object> systemObjects; // Saves all live object in it
    /**
     * This Class will manage the park ,
     * Contains objects list
     */
    static int childId = 0;
    static Scanner reader = new Scanner(System.in);
    private String name;
    private ArrayList<Guardian> guardians;

    private ArrayList<Child> children;
    private ArrayList<Device> devices;

    public ePark(String name) {
        this.name = name;
        systemObjects = new ArrayList<>();
        guardians = new ArrayList<Guardian>();
        children = new ArrayList<Child>();
        devices = new ArrayList<Device>();

        // Add Devices
        Device d1, d2, d3;
        d1 = new Device("Mamba Ride", 12, 1.4, 0, true);
        d2 = new Device("Giant Wheel", 0, 0, 0, false);
        d3 = new Device("Carrousel", 8, 0, 0, false);
        systemObjects.add(this);
        devices.add(d1);
        devices.add(d2);
        devices.add(d3);
        ////////////////

    }

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

    public void registerChild() { /**
     Take Child Details from a Guardian ,
     and register the child to ePark
     */
        String fullName = enterChildFullName(); // 1-3
        int age = getChildAge();

        List<Object> getDetails= getCardDetails();
        String cardNumber = (String) getDetails.get(0); //4-5
        Integer CardLimit = (Integer) getDetails.get(1);
        boolean creditCardAuth = MasterCard.getPermission(cardNumber); // 6-7//
        Bracelet brace = new Bracelet();
        Guardian guardian=null;
        boolean guardianExist = false;

        // 8 Check if Guardian Exist before making new one
        for (Guardian g : guardians
        ) {
            if (g.getCreditCardNumber().equals(cardNumber)) {
                guardian = g;
                guardianExist = true;
                break;
            }
        }
        ParkAccount guardAccount = new ParkAccount(0, CardLimit);
        if(!guardianExist){
             guardian = new Guardian(guardAccount, cardNumber);
        }

        Child child = new Child(fullName, brace, guardian, childId++, age);
        guardians.add(guardian);
        children.add(child);
        guardian.getChildren().add(child);

        //10
        eTicket childTicket = new eTicket(age, 0, 0);
        child.seteTicket(childTicket);
        Date dNow = new Date(1996,10,30);
        childTicket.setExpireDate(dNow);

        //11-12
        setHeightWeight(childTicket);
        child.setPassword(1234);
        System.out.println(ConsoleColors.WHITE_BOLD + "-----------------------" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.CYAN + "Child's ID :-    " + ConsoleColors.RESET + child.getId());
        System.out.println(ConsoleColors.CYAN + "Child's Password :-   " + ConsoleColors.RESET + " 1234");

        System.out.println(ConsoleColors.GREEN_BOLD + "Registration Successful!" + ConsoleColors.RESET);


    }

    private void setHeightWeight(eTicket childTicket) {
        double height;
        int weight;
        System.out.println("Please Enter Child's Height  :- " + ConsoleColors.CYAN + "( E.g - 1.4 )" + ConsoleColors.RESET);
        height = reader.nextDouble();

        System.out.println("Please Enter Child's Weight :- ");
        weight = reader.nextInt();

        childTicket.setHeight(height);
        childTicket.setHeight(weight);


    }

    private int getChildAge() {
        int age = 0;
        String ageStr;
        boolean flag;
        do {
            flag = false;
            System.out.println("Enter Child's Age:- ");
            ageStr = reader.nextLine();

            try {
                age = Integer.parseInt(ageStr);
            } catch (Exception e) {
                flag = true;
                System.out.println("Invalid Value");
            }

        } while (flag);

        return age;

    }


    private List<Object> getCardDetails() {
        int limit = 0;
        ArrayList<Object> out = new ArrayList<>(2); // [ cardNumber , card Limit ] /
        String cardNum;
        boolean flag;
        do {
            System.out.println("Enter Card Number:- " + ConsoleColors.CYAN_BOLD + "( 4-10 digits digits no spaces )" + ConsoleColors.RESET);
            flag = false;

            cardNum = reader.nextLine();
            String cardNumRegex = "^[1-9][0-9]{4,16}(?: [0-9]*)*$";
            Pattern pVar = Pattern.compile(cardNumRegex);
            Matcher mVar = pVar.matcher(cardNum);

            if (!mVar.matches()) {
                System.out.println("Please Enter Valid Card Number");
                flag = true;
            }

        } while (flag);

        System.out.println("Enter Pay Limit:-");
        limit = reader.nextInt();
        out.add(0, cardNum);
        out.add(1, limit);


        return out;

    }

    private String enterChildFullName() {
        /** This method Takes child name from guardian ,
         * verify details ,
         * */
        String firstName, lastName;
        boolean wrongInput;
        do {
            wrongInput = false;
            System.out.println("Fill Out Registration From");
            System.out.println("Enter Child's First Name :- ");
            firstName = reader.nextLine();
            System.out.println("Enter Child's Last Name :- ");
            lastName = reader.nextLine();

            boolean fNameIsValid = checkName(firstName);
            boolean lNameIsValid = checkName(lastName);

            if (!fNameIsValid || !lNameIsValid) {
                System.out.println("Wrong Details : ");
                if (!fNameIsValid) System.out.println(ConsoleColors.RED + "inValid First Name !" + ConsoleColors.RESET);
                if (!lNameIsValid) System.out.println(ConsoleColors.RED + "inValid Last Name !" + ConsoleColors.RESET);

                System.out.println(ConsoleColors.YELLOW_BOLD + "Please ReFill The From." + ConsoleColors.RESET);
                wrongInput = true;

            }

        } while (wrongInput);


        return firstName + " " + lastName;


    }

    private boolean checkName(String firstName) {
        /** INPUT - string first name
         * checks if Name is valid Using Regex
         * return Boolean
         * */
        String nameRegex = "[a-zA-Z]{2,}(?: [A-Z][a-z]*)*$";
        Pattern pVar = Pattern.compile(nameRegex);
        Matcher mVar = pVar.matcher(firstName);
        return mVar.matches();
    }

    public Guardian FindGuardian(int childId, int childPassword){
        Guardian guardian=null;
        boolean guardianExist = false;
        for (Guardian g : guardians
        ) {
            for (int i = 0; i < g.getChildren().size(); i++) {
                if (g.getChildren().get(i).getId() == childId && g.getChildren().get(i).getPassword() == childPassword ) {
                    guardian = g;
                    guardianExist = true;
                    break;
                }
            }
        }
        return guardian;
    }


    public void ShowObjects() {

        for (Object i : systemObjects
        ) {
            System.out.println(i);

        }

    }


}
