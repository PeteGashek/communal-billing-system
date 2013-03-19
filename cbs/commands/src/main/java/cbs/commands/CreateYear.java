//package cbs.commands;
//
//import org.apache.felix.gogo.commands.Argument;
//import org.apache.felix.gogo.commands.Command;
//import org.apache.karaf.shell.console.OsgiCommandSupport;
//
//@Command(scope = "cbs", name = "newyear", description = "create year")
//public final class CreateYear extends OsgiCommandSupport {
//    @Argument(index = 0, name = "year", description = "create year", required = true, multiValued = false)
//    private int year;
//
//    @Override
//    protected Object doExecute() throws Exception {
//        Commands.createYear(year);
//        return null;
//    }
//
//    public void setYear(int year) {
//        this.year = year;
//    }
//
//}
