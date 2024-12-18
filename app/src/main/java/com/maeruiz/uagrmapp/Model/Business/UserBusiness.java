package com.maeruiz.uagrmapp.Model.Business;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.maeruiz.uagrmapp.Exceptions.MoodleRestException;
import com.maeruiz.uagrmapp.Model.MoodleDao.User;
import com.maeruiz.uagrmapp.Model.MoodleDao.UserExtra;
import com.maeruiz.uagrmapp.Static.MoodleFields;
import com.maeruiz.uagrmapp.Static.MoodleMethods;
import com.maeruiz.uagrmapp.WebServiceConnection.RestClient;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.LinkedList;

import javax.xml.xpath.XPathExpressionException;

/**
 * Created by maelyruiz on 5/25/17.
 */

public class UserBusiness {

    private RestClient restClient;
    private Gson gson;

    public UserExtra login(String username, String password) throws IOException, MoodleRestException, XPathExpressionException {

        restClient = new RestClient();

        UserExtra element;
        StringBuilder data = new StringBuilder();
        data.append("&").append(URLEncoder.encode("field", MoodleMethods.ENCODING)).append("=").append(MoodleFields.USER_USERNAME);
        data.append("&").append(URLEncoder.encode("values[0]", MoodleMethods.ENCODING)).append("=").append(username);
        data.trimToSize();

        String response= restClient.getToken(username,password);

        gson = new Gson();

        if (response.substring(2,10).contains("exception")||response.substring(2,10).contains("error")){
            return null;
        }else {
            element = gson.fromJson(response, new TypeToken<UserExtra>() {
            }.getType());


                return element;
        }


    }

    public User getUserByField(String token, String field, String[] values) throws MoodleRestException, XPathExpressionException, IOException {

        restClient = new RestClient();


        LinkedList<User> elements;

        StringBuilder data = new StringBuilder();
        data.append("&").append(URLEncoder.encode("field", MoodleMethods.ENCODING)).append("=").append(field.toString());
        for (int i=0;i<values.length;i++) {
            if (values!=null)
            data.append("&").append(URLEncoder.encode("values["+i+"]", MoodleMethods.ENCODING)).append("=").append(values[i]);
        }
        data.trimToSize();

        String response= restClient.call(MoodleMethods.GET_USERS_BY_FIELD,token,data.toString());

        gson = new Gson();

        elements = gson.fromJson(response.toString(),new TypeToken<LinkedList<User>>(){}.getType());

        if(elements!=null && elements.size()>0)
            return elements.get(0);

        return null;
    }
}
