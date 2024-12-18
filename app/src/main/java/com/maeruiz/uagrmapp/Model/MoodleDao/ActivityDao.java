package com.maeruiz.uagrmapp.Model.MoodleDao;

/**
 * Created by maelyruiz on 5/30/17.
 */

public class ActivityDao {

    private long id;
    private String name;
    private int typeActivity;

    public ActivityDao() {

    }

    public ActivityDao(long id, String name, int typeActivity) {
        this.id = id;
        this.name = name;
        this.typeActivity = typeActivity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTypeActivity() {
        return typeActivity;
    }

    public void setTypeActivity(int typeActivity) {
        this.typeActivity = typeActivity;
    }
}
