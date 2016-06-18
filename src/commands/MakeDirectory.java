package commands;


import exceptions.DirectoryExistsException;

import java.io.File;

public class MakeDirectory extends Command{


    public MakeDirectory(){}

    public MakeDirectory(String userInput){
        super(userInput);
    }

    public String[] run() throws DirectoryExistsException{

        File path  = new File(userInput);
        if(path.exists()){
            throw new DirectoryExistsException("Directory: " + this.userInput
                    + " already exists");
        }
        else{
            path.mkdir();
            return new String[]{"", ""};
        }
    }
}
