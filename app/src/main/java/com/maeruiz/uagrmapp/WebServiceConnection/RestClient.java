package com.maeruiz.uagrmapp.WebServiceConnection;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.maeruiz.uagrmapp.Exceptions.MoodleRestCourseException;
import com.maeruiz.uagrmapp.Exceptions.MoodleRestException;
import com.maeruiz.uagrmapp.Formats.OptionParameter;
import com.maeruiz.uagrmapp.Model.MoodleDao.Course;
import com.maeruiz.uagrmapp.Static.MoodleMethods;

import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

/**
 * Created by maelyruiz on 5/22/17.
 */

public class RestClient {

    private static final String TAG = Consumir.class.getSimpleName();
    //private static final String TOKEN = "b13b886ee9c8b9490da73484f6d209be";

    public static final String NAMESPACE = "http://190.129.204.202/moodle/";
    private static final String url = NAMESPACE + "webservice/rest/server.php?";
    private Gson gson;


    public String getToken(String username, String password) throws IOException {

        //MoodleCallRestWebService moodleCallRestWebService = new MoodleCallRestWebService();
        //moodleCallRestWebService.init(url,null);
        StringBuilder data=new StringBuilder();

        String restAction=NAMESPACE+"login/token.php?username="+username+"&password="+password+"&service=moodle_mobile_app";
        Log.e("Consumir",restAction);
        // Request
        HttpURLConnection con = null;

        con = (HttpURLConnection) new URL(restAction).openConnection();
        con.setRequestMethod("POST");


        con.setRequestProperty("Content-Type",
                "application/x-www-form-urlencoded");
        con.setRequestProperty("Content-Language", "en-US");
        con.setDoOutput(true);
        con.setUseCaches (false);
        con.setDoInput(true);
        DataOutputStream wr = new DataOutputStream (
                con.getOutputStream ());

        wr.flush ();
        wr.close ();

        //Get Response

        Log.e("Response code: ",con.getResponseCode()+"");
        InputStream is =con.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuilder response = new StringBuilder();

        boolean error=false;
        while ((line=rd.readLine())!=null) {
            if (error) {
                String errMess=line.substring(line.indexOf('>')+1, line.indexOf('<', line.indexOf('>')+1));
                line=rd.readLine();
                if (line!=null) {
                    if (line.contains("<MESSAGE>")) {
                        errMess+=(": "+line.replace("<MESSAGE>", "").replace("</MESSAGE>", ""));
                    }
                }

            }
            if (line.contains("<EXCEPTION"))
                error=true;
            response.append(line).append('\n');
        }
        rd.close();

        XPath xpath= XPathFactory.newInstance().newXPath();
        InputSource source=new InputSource( new ByteArrayInputStream(response.toString().getBytes()));
        Log.e("Evaluando", response.toString());

        return response.toString();
    }

    public String call( String methodName, String token, String parameters) throws IOException, XPathExpressionException, MoodleRestException {

        //MoodleCallRestWebService moodleCallRestWebService = new MoodleCallRestWebService();
        //moodleCallRestWebService.init(url,token);
        StringBuilder data=new StringBuilder();

        String functionCall=MoodleCallRestWebService.isLegacy()? methodName:methodName;
/*
        if (MoodleCallRestWebService.getAuth()==null)
            throw new MoodleRestException();
        else
            data.append(MoodleCallRestWebService.getAuth());
        */

        data.append(URLEncoder.encode("wstoken",MoodleMethods.ENCODING)).append("=").append(URLEncoder.encode(token,MoodleMethods.ENCODING));
        data.append("&").append(URLEncoder.encode("wsfunction", MoodleMethods.ENCODING)).append("=").append(URLEncoder.encode(functionCall, MoodleMethods.ENCODING));

        String restAction=url  +data+ "&moodlewsrestformat=json";

        if (parameters!= null) {

            restAction=restAction+parameters;
        }

        Log.e("Consumir",restAction);
        // Request
        HttpURLConnection con = null;

            con = (HttpURLConnection) new URL(restAction).openConnection();
            con.setRequestMethod("POST");


            con.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            con.setRequestProperty("Content-Language", "en-US");
            con.setDoOutput(true);
            con.setUseCaches (false);
            con.setDoInput(true);
            DataOutputStream wr = new DataOutputStream (
                    con.getOutputStream ());

            wr.flush ();
            wr.close ();

            //Get Response

            Log.e("Response code: ",con.getResponseCode()+"");
            InputStream is =con.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuilder response = new StringBuilder();

            boolean error=false;
            while ((line=rd.readLine())!=null) {
                if (error) {
                    String errMess=line.substring(line.indexOf('>')+1, line.indexOf('<', line.indexOf('>')+1));
                    line=rd.readLine();
                    if (line!=null) {
                        if (line.contains("<MESSAGE>")) {
                            errMess+=(": "+line.replace("<MESSAGE>", "").replace("</MESSAGE>", ""));
                        }
                    }

                }
                if (line.contains("<EXCEPTION"))
                    error=true;
                response.append(line).append('\n');
            }
            rd.close();

            XPath xpath= XPathFactory.newInstance().newXPath();
            InputSource source=new InputSource( new ByteArrayInputStream(response.toString().getBytes()));
            Log.e("Evaluando", response.toString());

            return response.toString();


    }


}
