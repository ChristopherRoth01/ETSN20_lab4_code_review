package cli.commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cli.InputException;

public class Search extends Command {

    private final Pattern pattern = Pattern.compile("search [a-zA-Z0-9]+ .+");
    private final String[] arguments = new String[2];

    @Override
    public void execute() {
        try {
            System.out.println(fileSearcher.fileSearch(arguments[0], arguments[1]));
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    @Override
    void setArguments(String argument) throws InputException {
        this.arguments[0] = argument.split(" ")[1];
        this.arguments[1] = argument.split(" ")[2];

    }

    @Override
    Pattern getPattern() {
        return this.pattern;
    }    
}