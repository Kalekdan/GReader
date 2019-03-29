import java.net.*;
import java.io.*;

public class URLReader{
  private static final String[] URL_FRAMEWORK = {"http://api.steampowered.com/IPlayerService/GetOwnedGames/v0001/?key=", "&steamid=", "&include_appinfo=1&format=xml"};

  private String apikey;
  private String steamid;

  private URL activeURL;

  public URLReader(String apikey, String steamid){
    this.apikey = apikey;
    this.steamid = steamid;
    setActiveURL(createURL());
  }

  /**
   * Reads the content of passed and returns the file content as a string
   * Returns null if exception
   * @param  url the url to read from
   * @return the contents of the url
   */
  public String ReadFromURL(URL url){
    BufferedReader in;
    try{
      in = new BufferedReader(new InputStreamReader(url.openStream()));
      String fileString = "";
      String inputLine;
      while ((inputLine = in.readLine()) != null)
          fileString += inputLine;
      in.close();
      return fileString;
    }
    catch(IOException e){
      System.out.println("No data found for that STEAMID");
      return null;
    }
  }

  /**
   * Updates the value for steamid
   * @param val the new value for steamid
   */
  public void setSteamID(String val){
    steamid = val;
  }

  /**
   * Updates the value for activeURL
   * @param newURL the new value for activeURL
   */
  private void setActiveURL(String newURL){
    try {
      activeURL = new URL(newURL);
    }
    catch (MalformedURLException mue){
      System.out.println(mue);
    }
  }

  /**
   * Creates a string URL using current values for apikey and steamid
   * @return URL as a string
   */
  private String createURL(){
    return URL_FRAMEWORK[0] + apikey + URL_FRAMEWORK[1] + steamid + URL_FRAMEWORK[2];
  }

  public URL getActiveURL(){
    return activeURL;
  }
}
