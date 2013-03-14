package cbs.commands;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;

@Command(scope = "cbs", name = "hello", description = "hello world")
public final class HelloWorld extends OsgiCommandSupport {

    @Override
    protected Object doExecute() throws Exception {
        System.out.println("Hello from cbs");
        return null;
    }

}
