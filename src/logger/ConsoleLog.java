package logger;


public class ConsoleLog {

    private String promptMessage = "/# ";
    public ConsoleLog(){}

    public void printPromptMessage(){

        System.out.print(promptMessage);
    }

    public void printOutput(String output){
        System.out.println(output);
    }

    public void setPromptMessage(String promptMessage) {
        this.promptMessage = promptMessage;
    }
}
