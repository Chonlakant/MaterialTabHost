package net.yanzm.mth.sample.model;

/**
 * Created by root1 on 3/2/15.
 */
public class Youtube {

    String id;
    String title;
    String description;
    String thumbnail;

    public Youtube(String id, String title, String description, String thumbnail) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;

    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
