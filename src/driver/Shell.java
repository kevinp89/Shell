package driver;


import logger.ConsoleLog;
import runner.Runner;

import java.util.Scanner;

public class Shell {

    public void runShell(){
        ConsoleLog log = new ConsoleLog();
        Scanner input = new Scanner(System.in);
        log.printPromptMessage();
        String uI = input.nextLine();

        while(!uI.equals("exit")){

            Runner run = new Runner(uI);
            String[] output = run.runCommand();

            if(!output[0].equals("")){
                log.setPromptMessage(output[0]);
            }
            log.printOutput(output[1]);
            log.printPromptMessage();
            uI = input.nextLine();
        }
        System.out.println("exiting Shell");

    }

    public static void main(String[] args) {
        Shell shell = new Shell();
        shell.runShell();
    }

}
