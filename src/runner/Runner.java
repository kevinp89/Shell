package runner;


import commands.Command;
import exceptions.DirectoryDoesNotExistException;
import exceptions.DirectoryExistsException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import java.util.Hashtable;

public class Runner {

    private String input;

    private Hashtable<String, String> classes = new Hashtable<String, String>
            (){
        {
            put("mkdir", "commands.MakeDirectory");
            put("rm", "commands.RemoveFile");
        }
    };

    public Runner(){}

    public Runner(String input){
        this.input = input;
    }

    public String[] runCommand(){
        String[] cmd = input.split(" ");

        String commad = classes.get(cmd[0]);
        
        try{
            Class<?> foundedCommand = java.lang.Class.forName(commad);
            Constructor cons = foundedCommand.getConstructor(String.class);
            Command runCmd = (Command) cons.newInstance(cmd[1]);
            return runCmd.run();

        }
        catch (DirectoryDoesNotExistException e){
            return new String[]{"", e.getMessage()};
        }
        catch (DirectoryExistsException e){
            return new String[]{"", e.getMessage()};
        }

        catch (ClassNotFoundException e){
            e.printStackTrace();
            return new String[]{"", e.getMessage()};
        }
        catch (NoSuchMethodException e){
            return new String[]{"", e.getMessage()};
        }
        catch (InstantiationException e){
            return new String[]{"", e.getMessage()};
        }
        catch (IllegalAccessException e){
            return new String[]{"", e.getMessage()};}
        catch (InvocationTargetException e){
            return new String[]{"", e.getMessage()};}

    }
}
