import java.util.ArrayList;
import java.util.List;

public class Bracelet {


    private String location;
    private List<Device> allowedDevices;

    public Bracelet()
    {
        this.allowedDevices = new ArrayList<>();
    }


    public void addDevices(List<Device> newAllowedDevices) {
        if(newAllowedDevices != null) {
            for(Device device : newAllowedDevices){
                if(!this.allowedDevices.contains(device)) {
                    this.allowedDevices.add(device);
                }
            }
        }
    }





}
