package cli;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import cli.commands.Command;
import logic.FileSearcher;
import cli.commands.CommandCenter;

/**
 * Class for a Session. A Session combines the UserInterface with the
 * ModelRailWay. Handles the Terminal input and executes the fitting Command,
 * which is returned by the CommandCenter.
 * 
 * @author Christopher Roth
 * @version 1.0
 *
 */
public class Session {
    /**
     * Boolean for the while(true) loop in the run() method. Is set to false if exit
     * is typed in the Terminal.
     */
    private boolean finished = false;
    /**
     * A FileSearcher.
     */
    private FileSearcher fileSearcher;
    /**
     * Constructor, which initiates a ModelRailWay.
     */
    public Session() {
        this.fileSearcher = new FileSearcher();
    }

    /**
     * The method which is executed in the main-Class. Handles the Terminal input
     * and executes the fitting Command, which is returned by the CommandCenter.
     *
     */
    public void run() {
        CommandCenter center = new CommandCenter(this);

        while (!finished) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String name = reader.readLine();
                Command command = center.getCommand(name);
                command.execute();
            } catch (InputException i) {
                System.out.println(i.getMessage());
            } catch (IOException e) {
                System.out.println("Couldn't resolve path.");

            }
        }
    }

    /**
     * The method which sets finished to true, which leads to a termination of the
     * program.
     */
    public void quit() {
        finished = true;
    }

    /**
     * Getter for the ModelRailWay.
     * 
     * @return the ModelRailWay of the Session.
     */
    public FileSearcher getFileSearcher() {
        return this.fileSearcher;
    }
}