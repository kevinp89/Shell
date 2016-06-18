package commands;


import exceptions.DirectoryDoesNotExistException;
import exceptions.DirectoryExistsException;

public abstract class Command {

    protected String userInput;

    public Command(){}
    public Command(String userInput){
        this.userInput = userInput;
    }

    public abstract String[] run() throws DirectoryExistsException,
            DirectoryDoesNotExistException;

}
