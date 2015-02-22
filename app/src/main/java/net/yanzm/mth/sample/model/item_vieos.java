package net.yanzm.mth.sample.model;

/**
 * Created by root1 on 1/31/15.
 */
public class item_vieos {


    String title;
    String image_url;
    String detail;
    String urlvdo;
    String txt1;
    String txt2;

    public item_vieos() {

    }

    public item_vieos(String title, String image_url, String detail, String urlvdo, String txt1, String txt2) {

        this.title = title;
        this.image_url = image_url;
        this.detail = detail;
        this.urlvdo = urlvdo;
        this.txt1 = txt1;
        this.txt2 = txt2;

    }

    public String getTitle() {
        return title;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getDetail() {
        return detail;
    }

    public String getUrlvdo() {
        return urlvdo;
    }

    public String getTxt1() {
        return txt1;
    }

    public String getTxt2() {
        return txt2;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setUrlvdo(String urlvdo) {
        this.urlvdo = urlvdo;
    }

    public void setTxt1(String txt1) {
        this.txt1 = txt1;
    }

    public void setTxt2(String txt2) {
        this.txt2 = txt2;
    }

}
