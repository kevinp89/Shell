package exceptions;

public class DirectoryExistsException extends Exception{

    public DirectoryExistsException(){
        super("Directory already Exists");
    }
    public DirectoryExistsException(String message){
        super(message);
    }
}
