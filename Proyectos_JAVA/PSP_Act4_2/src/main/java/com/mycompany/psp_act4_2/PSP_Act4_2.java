package com.mycompany.psp_act4_2;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Fran
 */
public class PSP_Act4_2 {

    public static void main(String[] args) {

        try {

            //ApiKey para poder obtener los datosCorrectos de la AEMET
            String apiKey = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIzOTc5MTk5QGFsdS5tdXJjaWFlZHVjYS5l"
                    + "cyIsImp0aSI6IjdiMDI5ZTNhLTI5OWQtNDM4YS1iYTY4LTg1Y2M1ZWM4YzE5ZSIsImlzcyI6I"
                    + "kFFTUVUIiwiaWF0IjoxNzA1NDIwNDIwLCJ1c2VySWQiOiI3YjAyOWUzYS0yOTlkLTQzOGEtYmE"
                    + "2OC04NWNjNWVjOGMxOWUiLCJyb2xlIjoiIn0.OH3NlTy1chb6BsT-P0om9l7cdmovJwGuWltsKZR5EWw";

            //Url desde la que vamos a extraer el JSON. En nuestro caso de Molina de Segura cod: 30027
            String url = "https://opendata.aemet.es/opendata/api/prediccion/especifica/municipio/diaria/30027/?api_key=" + apiKey;

            GestorPeticionesHTTP gp = new GestorPeticionesHTTP();

            //Obtenemos el json que nos proporciona la AEMET
            StringBuilder json = gp.getContenidoMetodoGet(url);
            
            //Pero nosotros sólo necesitamos la url de datosCorrectos
            JSONObject job = new JSONObject(json.toString());            
            String datosCorrectos = job.getString("datos");
            
            //Una vez conseguida la url del JSON, vamos a obtener el mismo
            StringBuilder jsonCorrecto = gp.getContenidoMetodoGet(datosCorrectos);
            JSONArray jsonMolina = new JSONArray(jsonCorrecto.toString()); //El contenido es un array de JSONObject
            
            //Mostramos el JSON por consola
            System.out.println(jsonMolina.toString(2));

        } catch (Exception ex) {

            System.out.println("Error: " + ex.getMessage());

        }

    }

}
