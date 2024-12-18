package com.maeruiz.uagrmapp.WebServiceConnection;

import android.util.Log;

import org.xmlpull.v1.XmlPullParserException;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/**
 * Created by maelyruiz on 5/23/17.
 */

public class ConsumirNet {

    private static final String TAG = Consumir.class.getSimpleName();


    public static final String NAMESPACE = "http://www.geravd.com.br/Servicos/PessoaWebService";

    private static final String URLNet = "http://hmlsginaturabo.geravd.com.br/servicios/PessoaWebService.asmx";



    public String consumir( String metodo, Map<String, Object> parametros) throws IOException,
            XmlPullParserException {

        String responseString = "";
        String outputString = "";
        URL url = new URL(URLNet);

        String soapMessage = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "  <soap:Body>\n" +
                "    <"+metodo +" xmlns=\""+ NAMESPACE+"\">\n";
        if (parametros != null) {
            for (Map.Entry<String, Object> param : parametros.entrySet()) {
                soapMessage = soapMessage + "      <"+param.getKey()+">"+param.getValue()+"</"+param.getKey()+">\n";

            }
        }
        soapMessage = soapMessage + "    </"+ metodo+">\n" +
                "  </soap:Body>\n" +
                "</soap:Envelope>";

        Log.e("Message", soapMessage);

        URLConnection connection = url.openConnection();
        HttpURLConnection httpConn = (HttpURLConnection)connection;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        String xmlInput = soapMessage;

        byte[] buffer = new byte[xmlInput.length()];
        buffer = xmlInput.getBytes();
        bout.write(buffer);
        byte[] b = bout.toByteArray();
        String SOAPAction = NAMESPACE + metodo;

        httpConn.addRequestProperty("Content-Length",
                String.valueOf(b.length));
        httpConn.addRequestProperty("Content-Type", "text/xml; charset=utf-8");
        httpConn.addRequestProperty("SOAPAction", SOAPAction);
        httpConn.setRequestMethod("POST");

        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);
        OutputStream out = httpConn.getOutputStream();
        out.write(b);
        out.close();

        InputStreamReader isr = null;
        if (httpConn.getResponseCode() == 200) {
            isr = new InputStreamReader(httpConn.getInputStream());
        } else {
            isr = new InputStreamReader(httpConn.getErrorStream());
        }

        BufferedReader in = new BufferedReader(isr);

        while ((responseString = in.readLine()) != null) {
            outputString = outputString + responseString;
        }


        Log.e("Respuesta: ",outputString);
        return outputString;

    }
}