package com.maeruiz.uagrmapp.AsyncTasks;

import android.os.AsyncTask;
import android.util.Log;

import com.maeruiz.uagrmapp.Exceptions.MoodleRestException;
import com.maeruiz.uagrmapp.Model.Business.UserBusiness;
import com.maeruiz.uagrmapp.Model.MoodleDao.Course;
import com.maeruiz.uagrmapp.Model.MoodleDao.User;
import com.maeruiz.uagrmapp.Model.MoodleDao.UserExtra;
import com.maeruiz.uagrmapp.Static.MoodleMethods;
import com.maeruiz.uagrmapp.WebServiceConnection.Consumir;
import com.maeruiz.uagrmapp.WebServiceConnection.ConsumirNet;
import com.maeruiz.uagrmapp.WebServiceConnection.RestClient;

import org.ksoap2.serialization.SoapPrimitive;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;

import javax.xml.xpath.XPathExpressionException;

/**
 * Created by maelyruiz on 5/22/17.
 */

public class WebServiceTest extends AsyncTask<Void,Void,Void> {

    @Override
    protected Void doInBackground(Void... voids) {

        UserBusiness userBusiness = new UserBusiness();

        try {
            UserExtra user = userBusiness.login("Admin","1234");
            if (user!= null){
                Log.e("TESTING LOGIN","Usuario: "+user.getToken()+", login correcto");
            }else
                Log.e("TESTING LOGIN","Usuario está nulo, login incorrecto");

            /*
            for (int i = 0; i<result.length; i++){
                Log.e("Curso "+i+": ",result[i].getFullname());
            }

            */
        } catch (MoodleRestException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private String buscar(String parametro, String result) {

        int posStart = result.lastIndexOf("<"+parametro+">");
        int posEnd = result.indexOf("</"+parametro+">")-1;

        if (posStart>-1 && posEnd>-1)
        return result.substring(posStart,posEnd);
        else
            return "";
    }
}
