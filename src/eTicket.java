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





}
