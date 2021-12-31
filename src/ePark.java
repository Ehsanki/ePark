import java.util.ArrayList;
import java.util.Scanner;

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


    public void ShowObjects()
    {

        for (Object i:systemObjects
             ) {
            System.out.println(i);

        }

    }
}
