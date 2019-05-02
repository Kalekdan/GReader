import javax.swing.*;

public class GReaderMain {
    private static String STEAMID = "";

    public static void main(String[] args) {
        PrimaryWindow menuWindow = new PrimaryWindow(400,400);
        AddMainMenuButtons(menuWindow);


        SteamReader steamReader = new SteamReader(handleArgs(args));
    }

    private static void AddMainMenuButtons(PrimaryWindow menuWindow) {
        JButton steamBtn = new JButton("Calculate Steam Data");
        JButton closeBtn = new JButton("close");

        menuWindow.add(steamBtn);
        menuWindow.add(closeBtn);
    }

    /**
     * Handles if user does not provide arguments/requests help
     *
     * @param args user passed arguments
     * @return returns first argument i.e. steamid
     */
    private static String handleArgs(String[] args) {
        if (args.length == 0) {
            System.out.println(" Please provide command line arguments...");
            System.out.println(getHelpMsg());
            System.exit(0);
        } else if (args[0].equals("-help")) {
            System.out.println(getHelpMsg());
            System.exit(0);
        }
        return args[0];
    }

    private static String getHelpMsg() {
        return ("   Takes user STEAMID as an argument: \n     e.g. java GReaderMain 12345678901234567");
    }

}
