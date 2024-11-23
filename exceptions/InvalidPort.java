package exceptions;

public class InvalidPort extends Exception{
    public InvalidPort(String s){
        System.out.println(s);
    }
}
