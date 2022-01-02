import java.util.ArrayList;

public class ParkAccount {
    private float totalToPay = 0;
    private Integer m_limit;

    public ParkAccount(float total, Integer limit) {
        this.totalToPay = total;
        this.m_limit = limit;
        ePark.systemObjects.add(this);
    }

        public void remove_from_bill(String deviceName, ArrayList<Device> deviceArrayList){
            for (Device device: deviceArrayList
            ) {
                if(deviceName.equalsIgnoreCase(device.getName())){
                    if(this.totalToPay - device.getPrice() >=0){
                        this.totalToPay = this.totalToPay - device.getPrice();
                        System.out.println("Removed from bill successfully");
                    }
                    else{
                        System.out.println("Can not pay less than zero. Something is wrong!");
                    }

                }
            }

    }

    public void add_to_bill(String deviceName, ArrayList<Device> deviceArrayList){
        for (Device device: deviceArrayList
             ) {
            if(deviceName.equalsIgnoreCase(device.getName())){
                if(this.totalToPay + device.getPrice() <= this.m_limit.floatValue()){
                    this.totalToPay = this.totalToPay + device.getPrice();
                    System.out.println("Added to Bill successfully");
                }
                else{
                    System.out.println("Limit has been exceeded");
                }
            }

        }

    }
}
