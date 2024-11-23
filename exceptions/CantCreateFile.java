package exceptions;

public class CantCreateFile extends Exception{
    public CantCreateFile(String s){
        System.out.println(s);
    }
}
