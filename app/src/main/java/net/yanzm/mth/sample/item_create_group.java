package net.yanzm.mth.sample;

/**
 * Created by root1 on 2/1/15.
 */
public class item_create_group {

    String group_name;
    String count;
    String members;
    String add;
    String image_url_group;
    String image_url_add;

    public item_create_group() {

    }

    public item_create_group(String group_name, String count, String members, String add, String image_url_group, String image_url_add) {

        this.group_name = group_name;
        this.count = count;
        this.members = members;
        this.add = add;
        this.image_url_group = image_url_group;
        this.image_url_add = image_url_add;

    }

    public String getGroup_name() {
        return group_name;
    }

    public String getCount() {
        return count;
    }

    public String getMembers() {
        return members;
    }

    public String getAdd() {
        return add;
    }

    public String getImage_url_group() {
        return image_url_group;
    }

    public String getImage_url_add() {
        return image_url_add;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public void setImage_url_group(String image_url_group) {
        this.image_url_group = image_url_group;
    }

    public void setImage_url_add(String image_url_add) {
        this.image_url_add = image_url_add;
    }

}
