import java.util.ArrayList;

public class Guardian {

    private ParkAccount account;
    private ArrayList<Child> children;
    private String creditCardNumber;


    public Guardian(ParkAccount account, ArrayList<Child> children, String creditCardNumber) {
        this.account = account;
        this.children = children;
        this.creditCardNumber = creditCardNumber;
    }

    public boolean GrantPermission(){
        return true;
    }






}

