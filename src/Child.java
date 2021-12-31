public class Child {


    private Bracelet bracelet;
    private Guardian parent;


    public Child(Bracelet bracelet, Guardian parent) {
        this.bracelet = bracelet;
        this.parent = parent;
    }


    /*** GETTERS */
    public Bracelet getBracelet() {
        return bracelet;
    }

    public Guardian getParent() {
        return parent;
    }
    /*** GETTERS  Ends*/
}
