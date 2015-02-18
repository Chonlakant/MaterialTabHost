package net.yanzm.mth.sample;

/**
 * Created by root1 on 2/6/15.
 */
public class itemChannels {

    String Title_url;
    String name;
    String Vdo_url;

    public itemChannels(){

    }
    public itemChannels(String Title_url, String name, String Vdo_url){
        this.Title_url = Title_url;
        this.name  = name;
        this.Vdo_url = Vdo_url;

    }
    public String getTitle_url() {
        return Title_url;
    }

    public String getName() {
        return name;
    }

    public String getVdo_url() {
        return Vdo_url;
    }

    public void setTitle_url(String title_url) {
        Title_url = title_url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVdo_url(String vdo_url) {
        Vdo_url = vdo_url;
    }

}
