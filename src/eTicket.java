import java.util.ArrayList;
import java.util.Date;

public class eTicket {

    private int age;
    private int weight;
    private int height;
    private int status;
    private ArrayList<Device> devicesEntries;
    private Date expireDate;

    public eTicket(int age, int weight, int height, int status, ArrayList<Device> devicesEntries, Date expireDate) {
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.status = status;
        this.devicesEntries = devicesEntries;
        this.expireDate = expireDate;
        devicesEntries=new ArrayList<Device>();
    }

    public void display_eTicket(){

        System.out.println("child's age is :" + age);
        System.out.println("child's weight is :" + weight);
        System.out.println("child's height is :" + height);
        System.out.println("child's status is :" + status);
        System.out.println("Expiration Date of the ticket is: " + expireDate.toString());
        System.out.println("These are the devices entries :");
        for (Device devicesEntry : devicesEntries) {
            System.out.println(devicesEntry.toString());
        }


    }

    public ArrayList<Device> get_suitable_devices(ePark park){
        ArrayList<Device> devicesToDisplay = new ArrayList<>();
        int counter = 0;
        System.out.println("These are the devices the child is allowed to go on:");
        for (int i = 0; i < park.getDevices().size(); i++) {
            if(park.getDevices().get(i).getMinAge() <= age && park.getDevices().get(i).getMinHeight() <= height && park.getDevices().get(i).getMinWeight() <= weight){
                devicesToDisplay.add(park.getDevices().get(i));
                System.out.println("Device number" + counter + ": ");
                counter++;
                System.out.println(park.getDevices().get(i).toString());
                System.out.println("----------------------------------------------");
            }
        }
        return devicesToDisplay;

    }





}
