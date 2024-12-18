package com.maeruiz.uagrmapp.Model.MoodleDao;

import com.maeruiz.uagrmapp.Formats.DescriptionFormat;
import com.maeruiz.uagrmapp.Formats.OptionParameter;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by maelyruiz on 5/22/17.
 */

public class Course implements Serializable {
    /**
     *
     */
    public static final int SUMMARY_FORMAT_NO = 0;
    /**
     *
     */
    public static final int SUMMARY_FORMAT_YES = 1;
    /**
     *
     */
    public static final String FORMAT_TOPICS = "topics";
    /**
     *
     */
    public static final String FORMAT_SCORM = "scorm";
    /**
     *
     */
    public static final String FORMAT_WEEKS = "weeks";
    /**
     *
     */
    public static final String FORMAT_SOCIAL = "social";
    /**
     *
     */
    public static final boolean SHOW_GRADES_NO = false;
    /**
     *
     */
    public static final boolean SHOW_GRADES_YES = true;
    /**
     *
     */
    public static final int SHOW_REPORTS_NO = 0;
    /**
     *
     */
    public static final int SHOW_REPORTS_YES = 1;
    /**
     *
     */
    public static final int HIDDEN_SECTIONS_COLLAPSED = 0;
    /**
     *
     */
    public static final int HIDDEN_SECTIONS_INVISIBLE = 1;
    /**
     *
     */
    public static final int GROUP_MODE_NO_GROUPS = 0;
    /**
     *
     */
    public static final int GROUP_MODE_SEPARATE_GROUPS = 1;
    /**
     *
     */
    public static final int GROUP_MODE_VISIBLE_GROUPS = 2;
    /**
     *
     */
    public static final int GROUP_MODE_FORCE_NO = 0;
    /**
     *
     */
    public static final int GROUP_MODE_FORCE_YES = 1;
    /**
     *
     */
    public static final boolean COURSE_VISIBLE_TO_STUDENTS_NO = false;
    /**
     *
     */
    public static final Integer COURSE_VISIBLE_TO_STUDENTS_YES = 1;
    /**
     *
     */
    public static final boolean COMPLETION_DISABLED = false;
    /**
     *
     */
    public static final boolean COMPLETION_ENABLED = true;
    /**
     *
     */
    public static final Integer COMPLETION_NOTIFY_DISABLED = 0;
    /**
     *
     */
    public static final boolean COMPLETION_NOTIFY_ENABLED = true;
    /**
     *
     */
    public static final boolean COMPLETION_ON_ENROLL_DISABLED = false;
    /**
     *
     */
    public static final boolean COMPLETION_ON_ENROLL_ENABLED = true;


    private Long id=null;


    private String shortname=null;
    private Long categoryid=null;
    private Integer categorysortorder=null;

    private String fullname=null;

    private String displayname=null;
    private String idnumber=null;
    private String summary=null;

    private DescriptionFormat summaryformat=DescriptionFormat.MOODLE;
    private String format=FORMAT_TOPICS;
    private boolean showgrades=SHOW_GRADES_YES;
    private Integer newsitems=1;
    private Long startdate=null;

    private Integer numsections=1;
    private Long maxbytes=0L;
    private Integer showreports=SHOW_REPORTS_NO;
    private Integer visible=COURSE_VISIBLE_TO_STUDENTS_YES;

    private Integer groupmode=GROUP_MODE_NO_GROUPS;
    private Integer groupmodeforce=GROUP_MODE_FORCE_NO;
    private Long defaultgroupingid=0L;
    private Long timecreated=null;
    private Long timemodified=null;

    private boolean enablecompletion=COMPLETION_DISABLED;

    private Integer completionnotify=COMPLETION_NOTIFY_DISABLED;


    private String lang=null;

    private String forcetheme=null;
    private ArrayList<OptionParameter> courseformatoptions=null;

    public Course(Long id, String shortname, Long categoryid) {
        this.id = id;
        this.shortname = shortname;
        this.categoryid = categoryid;
    }

    public Course() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public Integer getCategorysortorder() {
        return categorysortorder;
    }

    public void setCategorysortorder(Integer categorysortorder) {
        this.categorysortorder = categorysortorder;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public DescriptionFormat getSummaryformat() {
        return summaryformat;
    }

    public void setSummaryformat(DescriptionFormat summaryformat) {
        this.summaryformat = summaryformat;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public boolean getShowgrades() {
        return showgrades;
    }

    public void setShowgrades(boolean showgrades) {
        this.showgrades = showgrades;
    }

    public Integer getNewsitems() {
        return newsitems;
    }

    public void setNewsitems(Integer newsitems) {
        this.newsitems = newsitems;
    }

    public Long getStartdate() {
        return startdate;
    }

    public void setStartdate(Long startdate) {
        this.startdate = startdate;
    }

    public Integer getNumsections() {
        return numsections;
    }

    public void setNumsections(Integer numsections) {
        this.numsections = numsections;
    }

    public Long getMaxbytes() {
        return maxbytes;
    }

    public void setMaxbytes(Long maxbytes) {
        this.maxbytes = maxbytes;
    }

    public Integer getShowreports() {
        return showreports;
    }

    public void setShowreports(Integer showreports) {
        this.showreports = showreports;
    }

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    public Integer getGroupmode() {
        return groupmode;
    }

    public void setGroupmode(Integer groupmode) {
        this.groupmode = groupmode;
    }

    public Integer getGroupmodeforce() {
        return groupmodeforce;
    }

    public void setGroupmodeforce(Integer groupmodeforce) {
        this.groupmodeforce = groupmodeforce;
    }

    public Long getDefaultgroupingid() {
        return defaultgroupingid;
    }

    public void setDefaultgroupingid(Long defaultgroupingid) {
        this.defaultgroupingid = defaultgroupingid;
    }

    public Long getTimecreated() {
        return timecreated;
    }

    public void setTimecreated(Long timecreated) {
        this.timecreated = timecreated;
    }

    public Long getTimemodified() {
        return timemodified;
    }

    public void setTimemodified(Long timemodified) {
        this.timemodified = timemodified;
    }

    public boolean getEnablecompletion() {
        return enablecompletion;
    }

    public void setEnablecompletion(boolean enablecompletion) {
        this.enablecompletion = enablecompletion;
    }

    public Integer getCompletionnotify() {
        return completionnotify;
    }

    public void setCompletionnotify(Integer completionnotify) {
        this.completionnotify = completionnotify;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getForcetheme() {
        return forcetheme;
    }

    public void setForcetheme(String forcetheme) {
        this.forcetheme = forcetheme;
    }

    public ArrayList<OptionParameter> getCourseformatoptions() {
        return courseformatoptions;
    }

    public void setCourseformatoptions(ArrayList<OptionParameter> courseformatoptions) {
        this.courseformatoptions = courseformatoptions;
    }
}
