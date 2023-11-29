package cli.commands;

import java.util.regex.Pattern;

import cli.InputException;
import cli.Session;

/**
 * Class for the Exit Pattern.
 * 
 * @author Christopher Roth
 * @version 1.0
 */
class Help extends Command {
    /**
     * Pattern.
     */
    private final Pattern exitPattern = Pattern.compile("^exit$");

    /**
     * This command gets a session in contrast to the other commands, because this
     * is the only Command which is executed on the session.
     */
    private Session session;

    /**
     * Getter for the Pattern.
     * 
     * @return the Pattern of this Command.
     */
    public Pattern getPattern() {
        return this.exitPattern;
    }

    @Override
    public void execute() {
        System.out.println("This program lets you search for a pattern in a file. \n"
                + "To search for a pattern in a file, type in the following: \n"
                + "search <pattern> <path to file> \n"
                + "To exit the program, type in the following: \n"
                + "exit \n"
                + "To get help, type in the following: \n"
                + "help \n");
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    void setArguments(String argument) throws InputException {
        // no arguments are needed for this Command.
    }
}