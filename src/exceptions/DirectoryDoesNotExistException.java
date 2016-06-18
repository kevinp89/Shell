package exceptions;


public class DirectoryDoesNotExistException extends Exception{

    public DirectoryDoesNotExistException(){
        super("Directory does not exist");
    }
    public DirectoryDoesNotExistException(String message){
        super(message);
    }
}
