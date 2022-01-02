import java.util.ArrayList;
import java.util.Scanner;

public class Guardian {

    private ParkAccount account;
    private ArrayList<Child> children;
    private String creditCardNumber;
    private ePark park;


    public Guardian(ParkAccount account,  String creditCardNumber, ePark park) {
        this.children=new ArrayList<Child>();
        this.account = account;
        this.creditCardNumber = creditCardNumber;
        this.park=park;
        ePark.systemObjects.add(this);
    }

    public Guardian(ParkAccount account, String creditCardNumber) {
        this.account = account;
        this.creditCardNumber = creditCardNumber;
        children=new ArrayList<Child>();

    }

    public ArrayList<Child> getChildren() {
        return children;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public boolean GrantPermission(){
        return true;
    }

    public ParkAccount getAccount() {
        return account;
    }

    public void Manage_eTicket(int id, int pass){
        Child child_retrieved = retrieve_eTicket(id,pass);
        if(child_retrieved == null){
            return;
        }
        else{
            child_retrieved.geteTicket().display_eTicket();
        }
    }

    public Child retrieve_eTicket(int id, int password) {
        boolean retrieved = false;
        for (int i = 0; i < this.getChildren().size(); i++) {
            if (this.getChildren().get(i).getId() == id && this.getChildren().get(i).getPassword() == password) {
                retrieved = true;
                this.getChildren().get(i).geteTicket().display_eTicket();
                return this.getChildren().get(i);
            }
        }
        System.out.println("Did not find the ticket");
        return null;
    }

    public ArrayList<Device> get_suitable_devices(ePark park, int childId, int childPassword){
        ArrayList<Device> devicesToDisplay = new ArrayList<>();
        Child child_a = null;
        for (int i = 0; i < this.getChildren().size(); i++) {
            if (this.getChildren().get(i).getId() == childId && this.getChildren().get(i).getPassword() == childPassword) {
                child_a = this.getChildren().get(i);
            }
        }
        int counter = 0;
        for (int i = 0; i < park.getDevices().size(); i++) {
            if(park.getDevices().get(i).getMinAge() <= child_a.geteTicket().getAge() && park.getDevices().get(i).getMinHeight() <= child_a.geteTicket().getHeight() && park.getDevices().get(i).getMinWeight() <= child_a.geteTicket().getWeight()){
                devicesToDisplay.add(park.getDevices().get(i));
                System.out.println("Device number " + counter + ": ");
                counter++;
                System.out.println(park.getDevices().get(i).toString());
                System.out.println("----------------------------------------------");
            }
        }
        return devicesToDisplay;
    }

    public boolean addDevice(ArrayList<Device> deviceArrayList, String deviceName, int childId, int childPassword, Scanner sc) {
        boolean found_device = false;
        Device deviceToFind = null;
        for (Device device: deviceArrayList) {
            if (device.getName().equalsIgnoreCase(deviceName)){
                deviceToFind = device;
                found_device = true;
                break;
            }
        }
        if(found_device == false){
            System.out.println("The device you were looking for has not been found, Please choose a correct one");
            return false;
        }
        else{
            if(deviceToFind != null){
                Child child_a = null;
                for (int i = 0; i < this.getChildren().size(); i++) {
                    if (this.getChildren().get(i).getId() == childId && this.getChildren().get(i).getPassword() == childPassword) {
                        child_a = this.getChildren().get(i);
                    }
                }
                for (int k = 0; k < child_a.geteTicket().getDevicesEntries().size(); k++) {
                    if(child_a.geteTicket().getDevicesEntries().get(k).getName().equalsIgnoreCase(deviceName)){
                        System.out.println("The Device is already in there!");
                        return false;
                    }
                }
                if(deviceToFind.isExtreme() == true){
                    System.out.println("This device is an extreme device. are you sure you want to add it? (Y/N)");
                    String answer = sc.nextLine();
                    if(answer.equalsIgnoreCase("Y")){
                        child_a.geteTicket().getDevicesEntries().add(deviceToFind);
                        System.out.println("The device has been added to the ticket successfully!");
                        return true;
                    }
                    if(answer.equalsIgnoreCase("N")){
                        System.out.println("Very well. the device will not be added!");
                    }
                    if(answer.equalsIgnoreCase("N") == false &&  answer.equalsIgnoreCase("Y") == false){
                        System.out.println("Please enter Y or N");
                    }
                }
                else{
                    child_a.geteTicket().getDevicesEntries().add(deviceToFind);
                    System.out.println("The device has been added to the ticket successfully!");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean removeDevice(ArrayList<Device> deviceArrayList, String deviceName, int childId, int childPassword) {
        boolean found_device = false;
        boolean deviceInDevEntries = false;
        Device deviceToFind = null;
        for (Device device: deviceArrayList) {
            if (device.getName().equalsIgnoreCase(deviceName)){
                deviceToFind = device;
                found_device = true;
                break;
            }
        }
        if(found_device == false){
            System.out.println("The device you were looking for has not been found, Please choose a correct one");
            return false;
        }
        else{
            if(deviceToFind != null){
                Child child_a = null;
                for (int i = 0; i < this.getChildren().size(); i++) {
                    if (this.getChildren().get(i).getId() == childId && this.getChildren().get(i).getPassword() == childPassword) {
                        child_a = this.getChildren().get(i);
                    }
                }
                for (int k = 0; k < child_a.geteTicket().getDevicesEntries().size(); k++) {
                    if(child_a.geteTicket().getDevicesEntries().get(k).getName().equalsIgnoreCase(deviceName)){
                        deviceInDevEntries = true;
                    }
                }
                if(deviceInDevEntries == false){
                    System.out.println("The Device is not in the devices entries. Therefore, it cannot be removed");
                }
                else{
                    child_a.geteTicket().getDevicesEntries().remove(deviceToFind);
                    System.out.println("The device has been removed from the ticket successfully!");
                    return true;
                }
            }
        }
        return false;
    }

    public void exitPark(int id) {

        park.exitPark(id);
    }
    public Bracelet returnBracelet(int id)
    {
        Bracelet brace;
        for(Child ch:children)
        {
            if(ch.getId()==id)
            {
                brace=ch.getBracelet();
                children.remove(ch);
                return brace;
            }
        }
        return null;

    }

//    public void ChooseDevice(Device device) {
//
//    }




}

