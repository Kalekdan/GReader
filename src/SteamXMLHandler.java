import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SteamXMLHandler{
  private String xmlContents;

  public SteamXMLHandler(String data){
    this.xmlContents = data;
  }

  public ArrayList<Games> parse(){
    String[] GameStrArray = xmlContents.split("<message>");
    String tempAppId;
    String tempName;
    String tempPlaytime;

    Pattern appidPat = Pattern.compile("<appid>(.+?)<\\/appid>", Pattern.DOTALL);
    Pattern namePat = Pattern.compile("<name>(.+?)<\\/name>", Pattern.DOTALL);
    Pattern playtimePat = Pattern.compile("<playtime_forever>(.+?)<\\/playtime_forever>", Pattern.DOTALL);

    ArrayList<Games> GameArray = new ArrayList<Games>();

    for(int i = 1; i < GameStrArray.length; i++){

      Matcher mat = appidPat.matcher(GameStrArray[i]);
      mat.find();
      tempAppId = mat.group(1);

      mat = namePat.matcher(GameStrArray[i]);
      mat.find();
      tempName = mat.group(1);

      mat = playtimePat.matcher(GameStrArray[i]);
      mat.find();
      tempPlaytime = mat.group(1);

      GameArray.add(new Games());
      GameArray.get(i-1).appid = Integer.parseInt(tempAppId);
      GameArray.get(i-1).name = tempName;
      GameArray.get(i-1).playtime = Integer.parseInt(tempPlaytime);
    }
    return GameArray;
  }

  public GamesTable ToGTable(ArrayList<Games> gArr){
    Object[][] data = new Object[gArr.size()][3];
    for(int g = 0; g < gArr.size(); g++){
      data[g][0] = new Integer(gArr.get(g).appid);
      data[g][1] = gArr.get(g).name;
      data[g][2] = new Integer(gArr.get(g).playtime);
    }
    String[] columnNames = {"App ID",
                      "Name",
                      "Playtime"};
    GamesTable tb = new GamesTable(data, columnNames);
    tb.setAutoCreateRowSorter(true);
    return tb;
  }
}
