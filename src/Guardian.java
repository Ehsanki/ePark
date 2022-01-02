import java.util.ArrayList;

public class Guardian {

    private ParkAccount account;
    private ArrayList<Child> children;
    private String creditCardNumber;


    public Guardian(ParkAccount account, ArrayList<Child> children, String creditCardNumber) {
        this.children=new ArrayList<Child>();
        this.account = account;
        this.children = children;
        this.creditCardNumber = creditCardNumber;
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
        System.out.println("These are the devices the child is allowed to go on:");
        for (int i = 0; i < park.getDevices().size(); i++) {
            if(park.getDevices().get(i).getMinAge() <= child_a.geteTicket().getAge() && park.getDevices().get(i).getMinHeight() <= child_a.geteTicket().getHeight() && park.getDevices().get(i).getMinWeight() <= child_a.geteTicket().getWeight()){
                devicesToDisplay.add(park.getDevices().get(i));
                System.out.println("Device number" + counter + ": ");
                counter++;
                System.out.println(park.getDevices().get(i).toString());
                System.out.println("----------------------------------------------");
            }
        }
        return devicesToDisplay;
    }

    public void addDevice(ArrayList<Device> deviceArrayList, String deviceName) {
        System.out.println("complete");


    }



    public void RemoveDevice(ArrayList<Device> deviceArrayList, String deviceName) {

    }

    public void ChooseDevice(Device device) {

    }




}

