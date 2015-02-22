package net.yanzm.mth.sample.model;

/**
 * Created by root1 on 1/30/15.
 */
public class item_friends {

    public item_friends() {

    }

    String Imageurl;
    String txt_name;
    String txt_friends;

    public item_friends(String Imageurl, String txt_name, String txt_friends) {
        this.Imageurl = Imageurl;
        this.txt_name = txt_name;
        this.txt_friends = txt_friends;

    }

    public String getImageurl() {
        return Imageurl;
    }

    public String getTxt_name() {
        return txt_name;
    }

    public String getTxt_friends() {
        return txt_friends;
    }

    public void setImageurl(String imageurl) {
        Imageurl = imageurl;
    }

    public void setTxt_name(String txt_name) {
        this.txt_name = txt_name;
    }

    public void setTxt_friends(String txt_friends) {
        this.txt_friends = txt_friends;
    }


}
