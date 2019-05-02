import javax.swing.*;

public class SteamReader {
    private static final String API_KEY = "9506AC4EFE548781359C59E8280406D6";
    private static String STEAMID = "";

    public SteamReader(String STEAMID) {
        this.STEAMID = STEAMID;
        PrimaryWindow window = new PrimaryWindow(400, 500);
        URLReader reader = new URLReader(API_KEY, STEAMID);
        SteamXMLHandler sHandler = new SteamXMLHandler(reader.ReadFromURL(reader.getActiveURL()));
        GamesTable gTable = sHandler.ToGTable(sHandler.parse());

        window.add(new JScrollPane(gTable));
        window.setVisible(true);
    }
}
