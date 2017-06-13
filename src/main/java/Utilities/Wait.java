package Utilities;


public class Wait {


    public static void sleep(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
