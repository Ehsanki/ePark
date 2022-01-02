public class MasterCard {

    static public boolean getPermission(String id){return true;}
    static public boolean chargeAccount(String carNum,int amount)
    {
        System.out.println(ConsoleColors.GREEN_BOLD+"Charged Successfully"+ConsoleColors.RESET);
        return true;

    }
}
