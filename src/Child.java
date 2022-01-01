public class Child {

    private String fullName;
    private Bracelet bracelet;
    private Guardian parent;
    private int id;




    public Child(String fullName, Bracelet bracelet, Guardian parent, int id) {
        this.fullName = fullName;
        this.bracelet = bracelet;
        this.parent = parent;
        this.id = id;
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
/*** GETTERS  Ends*/
}
