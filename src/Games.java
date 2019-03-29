public class Games {

    public int appid;
    public String name;
    public int playtime;

    public Games() {

    }

    public Games(int appid, String name, int playtime) {
        this.appid = appid;
        this.name = name;
        this.playtime = playtime;
    }

    @Override
    public String toString() {
        return "App ID: " + appid + ", Name: " + name + ", Mins played: " + playtime + "mins";
    }
}
