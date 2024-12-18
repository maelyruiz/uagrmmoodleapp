package com.maeruiz.uagrmapp.WebServiceConnection;

/**
 * Updated by maelyruiz on 4/3/17.
 */

import android.util.Log;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.MarshalFloat;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.Map;

/**
 * Created by MaeRuiz on 10/9/2015.
 */
public class Consumir {

    public static final String TAG = Consumir.class.getSimpleName();
    public static final String NAMESPACE = "http://www.geravd.com.br/Servicos/PessoaWebService/";
    public static final String URL = "http://hmlsginaturabo.geravd.com.br/servicos/PessoaWebService.asmx";

    public Object consumir(String metodo,
                           Map<String, Object> parametros) throws IOException,
            XmlPullParserException {

        Log.e("Comsumir: ", URL);

        String accionSoap = NAMESPACE + metodo;
        // Request
        SoapObject soapObject = new SoapObject(NAMESPACE, metodo);

        if (parametros != null) {
            for (Map.Entry<String, Object> param : parametros.entrySet()) {
                soapObject.addProperty(param.getKey(), param.getValue());
            }
        }

        // Sobre
        SoapSerializationEnvelope sobre = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        sobre.dotNet=true;
        sobre.setOutputSoapObject(soapObject);

        // Marshal
        MarshalFloat marshalFloat = new MarshalFloat();
        marshalFloat.register(sobre);

        // Transporte
        HttpTransportSE httpTransport = new HttpTransportSE(URL);

        try {
            //llamda
            httpTransport.call(accionSoap, sobre);

            //resultado
            return sobre.getResponse();

        } catch (IOException e) {
            Log.e(TAG + "io ", e.getMessage());
            throw new IOException(
                    "GenericWebService:consumir:Error de conexion con el servidor. "
                            + e.getMessage());
        } catch (XmlPullParserException e) {
            Log.e(TAG + " xmlpull erro", e.getMessage());
            throw new XmlPullParserException(
                    "GeneriWebService::consumir:Error al hacer el parser en la respuesta. "
                            + e.getMessage());
        }

    }
}
