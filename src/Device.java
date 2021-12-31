public class Device {

    private int minAge;
    private double minHeight;
    private int minWeight;
    private String name;
    // Opening Hour
    // Closing Hour

    private boolean isValid; // ?? Do we need this ?
    private  boolean isExtreme;
    private float price;


    public Device(String name,int minAge, double minHeight, int minWeight, boolean isExtreme, float price) {
        this.name=name;
        this.minAge = minAge;
        this.minHeight = minHeight;
        this.minWeight = minWeight;
        this.isExtreme = isExtreme;
        this.price = price;

    }

    public Device(String name,int minAge, double minHeight, int minWeight, boolean isExtreme) {
        this.name=name;
        this.minAge = minAge;
        this.minHeight = minHeight;
        this.minWeight = minWeight;
        this.isExtreme = isExtreme;


    }

    @Override
    public String toString() {
        String out=ConsoleColors.YELLOW_BOLD+"Device Name :- "+ConsoleColors.RESET+this.name;
        out+="  Minimum Age : "+minAge;
        out+= "   Minimum Height : "+ minHeight;
        if(isExtreme) out+= "   Is Extreme : "+ConsoleColors.GREEN_BOLD+"Yes"+ConsoleColors.RESET;
        else out+= "    Is Extreme : "+ConsoleColors.RED_BOLD+"No"+ConsoleColors.RESET;


        return out;
    }

    /*** GETTERS **/
    public int getMinAge() {
        return minAge;
    }

    public double getMinHeight() {
        return minHeight;
    }

    public int getMinWeight() {
        return minWeight;
    }

    public boolean isValid() {
        return isValid;
    }

    public boolean isExtreme() {
        return isExtreme;
    }

    public float getPrice() {
        return price;
    }
    /** Getters Ends **/
}
