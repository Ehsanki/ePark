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






}

