package com.maeruiz.uagrmapp.AsyncTasks;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.maeruiz.uagrmapp.Activities.LoginActivity;
import com.maeruiz.uagrmapp.Exceptions.MoodleRestException;
import com.maeruiz.uagrmapp.Model.Business.UserBusiness;
import com.maeruiz.uagrmapp.Model.MoodleDao.User;
import com.maeruiz.uagrmapp.Model.MoodleDao.UserExtra;
import com.maeruiz.uagrmapp.Static.MoodleFields;
import com.maeruiz.uagrmapp.Static.MoodleMethods;

import java.io.IOException;

import javax.xml.xpath.XPathExpressionException;

/**
 * Created by maelyruiz on 5/26/17.
 */

public class UserThread extends AsyncTask<Object, Object, UserExtra> {

    private String username;
    private String password;
    private Context context;

    public UserThread(String username, String password, Context context) {
        this.username = username;
        this.password = password;
        this.context = context;
    }

    @Override
    protected UserExtra doInBackground(Object... voids) {

        UserBusiness userBusiness = new UserBusiness();

        try {
            UserExtra user = userBusiness.login(username,password);

            String[] values = new String[1];
            values[0] = username;
            if (user!=null) {
                User userMoodle = userBusiness.getUserByField(user.getToken(), MoodleFields.USER_USERNAME, values);
                if (userMoodle != null){

                    user.setUser(userMoodle);
                }
            }
            if (user!= null){
                Log.e("TESTING LOGIN","Usuario: "+user.getToken()+", login correcto");
                return user;
            }else
                Log.e("TESTING LOGIN","Usuario está nulo, login incorrecto");


        } catch (MoodleRestException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(UserExtra userExtra) {
        super.onPostExecute(userExtra);

        ((LoginActivity) context).onLoginAttemptResult(userExtra);
    }
}
