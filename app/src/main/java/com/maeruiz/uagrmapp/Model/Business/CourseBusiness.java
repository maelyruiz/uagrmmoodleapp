package com.maeruiz.uagrmapp.Model.Business;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.maeruiz.uagrmapp.Exceptions.MoodleRestCourseException;
import com.maeruiz.uagrmapp.Exceptions.MoodleRestException;
import com.maeruiz.uagrmapp.Model.MoodleDao.Course;
import com.maeruiz.uagrmapp.Static.MoodleMethods;
import com.maeruiz.uagrmapp.WebServiceConnection.MoodleCallRestWebService;
import com.maeruiz.uagrmapp.WebServiceConnection.RestClient;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.LinkedList;

import javax.xml.xpath.XPathExpressionException;

/**
 * Created by maelyruiz on 5/25/17.
 */

public class CourseBusiness {

    private RestClient restClient;
    private Gson gson;

    public LinkedList<Course> getAllCourses(String token) throws IOException, MoodleRestException, XPathExpressionException {

        restClient = new RestClient();

        LinkedList<Course> elements;
        String response= restClient.call(MoodleMethods.GET_COURSES,token,null);

        gson = new Gson();
        elements = gson.fromJson(response.toString(),new TypeToken<LinkedList<Course>>(){}.getType());

        return elements;
    }

    public LinkedList<Course> getCoursesFromUser(String token, Long id) throws IOException, MoodleRestException, XPathExpressionException {

        restClient = new RestClient();

        LinkedList<Course> elements;

        StringBuilder data = new StringBuilder();
        data.append("&").append(URLEncoder.encode("userid", MoodleMethods.ENCODING)).append("=").append(id.toString());

        data.trimToSize();

        String response= restClient.call(MoodleMethods.GET_ENROL_USER_COURSES,token,data.toString());

        gson = new Gson();
        elements = gson.fromJson(response.toString(),new TypeToken<LinkedList<Course>>(){}.getType());

        return elements;
    }
}