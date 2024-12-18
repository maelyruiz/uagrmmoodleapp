package com.maeruiz.uagrmapp.Model.MoodleDao;

import java.util.List;

/**
 * Created by maelyruiz on 5/30/17.
 */

public class GroupsDao {

    private Course course;
    private int id;
    private List<ActivityDao> activities;

    public GroupsDao() {
        course = new Course();
    }

    public GroupsDao(Course course, int id, List<ActivityDao> activities) {
        this.course = course;
        this.id = id;
        this.activities = activities;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ActivityDao> getActivities() {
        return activities;
    }

    public void setActivities(List<ActivityDao> activities) {
        this.activities = activities;
    }

    public void addActivity(ActivityDao activityDao){

        if (activityDao==null)
            activityDao = new ActivityDao();
        activities.add(activityDao);
    }
}
