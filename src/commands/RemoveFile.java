package commands;

import exceptions.DirectoryDoesNotExistException;
import exceptions.DirectoryExistsException;

import java.io.File;

public class RemoveFile extends Command{


    public RemoveFile(){}

    public RemoveFile(String input){
        super(input);
    }

    @Override
    public String[] run() throws DirectoryDoesNotExistException,
            DirectoryExistsException  {

        if(userInput.length() == 1 && userInput.contains("/")){
            throw new DirectoryExistsException("Directory / cannot be deleted");
        }

        File path = new File(userInput);
        if(!path.exists()){
            String[] input = userInput.split("/");
            throw new DirectoryDoesNotExistException("Directory "  +
                    input[input.length-1] + "does not exist");
        }
        else{
            path.delete();
            return new String[]{"", "directory " + userInput + " was removed"};
        }
    }
}
