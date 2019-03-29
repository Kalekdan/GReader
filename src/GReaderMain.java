import javax.swing.*;

public class GReaderMain {
    private static final String API_KEY = "9506AC4EFE548781359C59E8280406D6";
    private static String STEAMID = "";

    public static void main(String[] args) {
        STEAMID = handleArgs(args);
        PrimaryWindow window = new PrimaryWindow(400, 500);
        URLReader reader = new URLReader(API_KEY, STEAMID);
        SteamXMLHandler sHandler = new SteamXMLHandler(reader.ReadFromURL(reader.getActiveURL()));
        GamesTable gTable = sHandler.ToGTable(sHandler.parse());

        window.add(new JScrollPane(gTable));
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
