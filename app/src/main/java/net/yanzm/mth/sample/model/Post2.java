package net.yanzm.mth.sample.model;

import java.util.ArrayList;

/**
 * Created by root1 on 2/22/15.
 */
public class Post2 {

    private String id;
    private String active;
    private String googleMapName;
    private String postId;
    private String recipientId;
    private String seen;
    private String text;
    private String time;
    private String timeLineId;
    private String timeStamp;
    private String type1;
    private String type2;
    private String view;
    private String followCount;
    private String clip;
    private String soundCound;
    private String youTube;

    private Author author;
    private Media media;
    private ArrayList<Love> love = new ArrayList<>();
    private ArrayList<Comment> comments = new ArrayList<>();
    private ArrayList<Follow> follows = new ArrayList<>();

    public Post2() {

    }

    public String getFollowCount() {
        return followCount;
    }

    public void setFollowCount(String followCount) {
        this.followCount = followCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getGoogleMapName() {
        return googleMapName;
    }

    public void setGoogleMapName(String googleMapName) {
        this.googleMapName = googleMapName;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

    public String getSeen() {
        return seen;
    }

    public void setSeen(String seen) {
        this.seen = seen;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimeLineId() {
        return timeLineId;
    }

    public void setTimeLineId(String timeLineId) {
        this.timeLineId = timeLineId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getClip() {
        return clip;
    }

    public void setClip(String clip) {
        this.clip = clip;
    }

    public String getSoundCound() {
        return soundCound;
    }

    public void setSoundCound(String soundCound) {
        this.soundCound = soundCound;
    }

    public String getYouTube() {
        return youTube;
    }

    public void setYouTube(String youTube) {
        this.youTube = youTube;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public ArrayList<Love> getLove() {
        return love;
    }

    public void setLove(ArrayList<Love> love) {
        this.love = love;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public ArrayList<Follow> getFollows() {
        return follows;
    }

    public void setFollows(ArrayList<Follow> follows) {
        this.follows = follows;
    }


}
