import java.util.ArrayList;
import java.util.Date;

public class eTicket {

    private int age;
    private int weight;
    private double height;
    private int status;
    private ArrayList<Device> devicesEntries;
    private Date expireDate;


    public eTicket(int age, int weight, double height, ArrayList<Device> devicesEntries, Date expireDate) {
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.status = status;
        this.devicesEntries = devicesEntries;
        this.expireDate = expireDate;
        devicesEntries=new ArrayList<Device>();
        ePark.systemObjects.add(this);
    }

    public eTicket(int age, int weight, double height) {
        this.age = age;
        this.weight = weight;
        this.height = height;
        expireDate=null;
        devicesEntries=new ArrayList<Device>();
        ePark.systemObjects.add(this);
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public int getStatus() {
        return status;
    }

    public ArrayList<Device> getDevicesEntries() {
        return devicesEntries;
    }

    public Date getExpireDate() {
        return expireDate;
    }


    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
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







}
