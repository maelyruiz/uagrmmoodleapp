package com.maeruiz.uagrmapp.Model.MoodleDao;

import com.maeruiz.uagrmapp.Model.MoodleDao.UserFields.UserCustomField;
import com.maeruiz.uagrmapp.Model.MoodleDao.UserFields.UserEnrolledCourse;
import com.maeruiz.uagrmapp.Model.MoodleDao.UserFields.UserGroup;
import com.maeruiz.uagrmapp.Model.MoodleDao.UserFields.UserPreference;
import com.maeruiz.uagrmapp.Model.MoodleDao.UserFields.UserRole;

import java.util.ArrayList;

/**
 * Created by maelyruiz on 5/25/17.
 */

public class User {

    public static final int EMAIL_FORMAT_NONE = 0;
    /**
     *
     */
    public static final int EMAIL_FORMAT_HTML = 1;

    private Long id=null;
    private String username=null;
    private String fullname = null;
    private String email=null;
    private String department=null;
    private Long firstaccess=null;
    private Long lastaccess=null;
    private String auth=null;
    private Boolean confirmed=false;
    private String lang=null;
    private String theme=null;
    private String timezone=null;
    private int mailformat=EMAIL_FORMAT_HTML;
    private String description=null;
    private Long descriptionformat=null;
    private String profileimageurlsmall=null;

    private String profileimageurl=null;
    private UserPreference[] preferences=null;

    private String password=null;
    private String firstname=null;
    private String lastname=null;
    private String idnumber=null;
    private String city=null;
    private String country=null;
    private String address=null;
    private String phone1=null;
    private String phone2=null;
    private String icq=null;
    private String skype=null;
    private String yahoo=null;
    private String msn=null;
    private String aim=null;
    private String institution=null;
    private String interests=null;
    private String url=null;
    private String alternatename=null;
    private String firstnamephonetic=null;
    private String lastnamephonetic=null;
    private ArrayList<UserCustomField> customfields=null;
    private ArrayList<UserGroup> groups=null;
    private ArrayList<UserRole> roles=null;
    private ArrayList<UserEnrolledCourse> enrolledcourses=null;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getMailformat() {
        return mailformat;
    }

    public void setMailformat(int mailformat) {
        this.mailformat = mailformat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getIcq() {
        return icq;
    }

    public void setIcq(String icq) {
        this.icq = icq;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getYahoo() {
        return yahoo;
    }

    public void setYahoo(String yahoo) {
        this.yahoo = yahoo;
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }

    public String getAim() {
        return aim;
    }

    public void setAim(String aim) {
        this.aim = aim;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public Long getFirstaccess() {
        return firstaccess;
    }

    public void setFirstaccess(Long firstaccess) {
        this.firstaccess = firstaccess;
    }

    public Long getLastaccess() {
        return lastaccess;
    }

    public void setLastaccess(Long lastaccess) {
        this.lastaccess = lastaccess;
    }

    public boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Long getDescriptionformat() {
        return descriptionformat;
    }

    public void setDescriptionformat(Long descriptionformat) {
        this.descriptionformat = descriptionformat;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProfileimageurlsmall() {
        return profileimageurlsmall;
    }

    public void setProfileimageurlsmall(String profileimageurlsmall) {
        this.profileimageurlsmall = profileimageurlsmall;
    }

    public String getProfileimageurl() {
        return profileimageurl;
    }

    public void setProfileimageurl(String profileimageurl) {
        this.profileimageurl = profileimageurl;
    }

    public String getAlternatename() {
        return alternatename;
    }

    public void setAlternatename(String alternatename) {
        this.alternatename = alternatename;
    }

    public String getFirstnamephonetic() {
        return firstnamephonetic;
    }

    public void setFirstnamephonetic(String firstnamephonetic) {
        this.firstnamephonetic = firstnamephonetic;
    }

    public String getLastnamephonetic() {
        return lastnamephonetic;
    }

    public void setLastnamephonetic(String lastnamephonetic) {
        this.lastnamephonetic = lastnamephonetic;
    }

    public ArrayList<UserCustomField> getCustomfields() {
        return customfields;
    }

    public void setCustomfields(ArrayList<UserCustomField> customfields) {
        this.customfields = customfields;
    }

    public ArrayList<UserGroup> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<UserGroup> groups) {
        this.groups = groups;
    }

    public ArrayList<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<UserRole> roles) {
        this.roles = roles;
    }

    public UserPreference[] getPreferences() {
        return preferences;
    }

    public void setPreferences(UserPreference[] preferences) {
        this.preferences = preferences;
    }

    public ArrayList<UserEnrolledCourse> getEnrolledcourses() {
        return enrolledcourses;
    }

    public void setEnrolledcourses(ArrayList<UserEnrolledCourse> enrolledcourses) {
        this.enrolledcourses = enrolledcourses;
    }
}
