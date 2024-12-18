package com.maeruiz.uagrmapp.Fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;


import com.google.gson.Gson;
import com.maeruiz.uagrmapp.Exceptions.MoodleRestException;
import com.maeruiz.uagrmapp.Model.Business.CourseBusiness;
import com.maeruiz.uagrmapp.Model.MoodleDao.Course;
import com.maeruiz.uagrmapp.Model.MoodleDao.User;
import com.maeruiz.uagrmapp.R;
import com.maeruiz.uagrmapp.Static.AppConstants;

import java.io.IOException;
import java.util.LinkedList;

import javax.xml.xpath.XPathExpressionException;

/**
 * Created by maelyruiz on 5/29/17.
 */

public class CoursesFragment extends Fragment {

    private String token;
    private Context context;
    private ExpandableListView expandableListView;
    private User user;
    private Gson gson;
    LinearLayout llHeaderProgress;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_courses, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        expandableListView = (ExpandableListView) this.getActivity().findViewById(R.id.expand_list_courses);

        llHeaderProgress = (LinearLayout) this.getActivity().findViewById(R.id.llHeaderProgressCourses);

        gson = new Gson();
        SharedPreferences preferences = this.getActivity().getSharedPreferences(AppConstants.APP_PACKAGE,Context.MODE_PRIVATE);
        String tokenDef = null;
        String userDef = null;
        token = preferences.getString(AppConstants.TOKEN_PREFS_KEY, tokenDef);
        userDef = preferences.getString(AppConstants.USER_PREFS_KEY,userDef);
        if (userDef!= null) {
            user = gson.fromJson(userDef, User.class);

            GettingCourses gettingCourses = new GettingCourses();
            gettingCourses.execute();
        }else{

            //Handle error!!!!!!!!!!!
        }
    }

    private class GettingCourses extends AsyncTask<Object, Object, LinkedList<Course>> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            llHeaderProgress.setVisibility(View.VISIBLE);
        }


        @Override
        protected LinkedList<Course> doInBackground(Object... voids) {

            CourseBusiness courseBusiness = new CourseBusiness();

            if (token!=null) {
                try {

                    LinkedList<Course> courses = courseBusiness.getCoursesFromUser(token,user.getId());

                    if (courses != null) {
                        for (int i = 0; i < courses.size(); i++) {
                            Log.e("COURSES FRAGMENT", "Curso: " + courses.get(i).getFullname() + ".");
                        }
                        return courses;
                    } else
                        Log.e("COURSES FRAGMENT", "Cursos nulos, login incorrecto");

                } catch (IOException | MoodleRestException | XPathExpressionException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(LinkedList<Course> aVoid) {
            super.onPostExecute(aVoid);
            llHeaderProgress.setVisibility(View.GONE);
        }

    }
}
