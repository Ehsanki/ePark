public class Child {

    private  int age;
    private String fullName;
    private Bracelet bracelet;
    private Guardian parent;
    private eTicket eTicket;

    private int id;
    private int password;
    private boolean isRegistered = false;

    public Child(String fullName, Bracelet bracelet, Guardian parent, int id,int age) {
        this.fullName = fullName;
        this.bracelet = bracelet;
        this.parent = parent;
        this.id = id;
        this.age=age;
    }

    public int getAge() {
        return age;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getPassword() {
        return password;
    }

    /*** GETTERS */
    public Bracelet getBracelet() {
        return bracelet;
    }

    public Guardian getParent() {
        return parent;
    }

    public int getId() {
        return id;
    }

    public eTicket geteTicket() {
        return eTicket;
    }
/*** GETTERS  Ends*/
}
