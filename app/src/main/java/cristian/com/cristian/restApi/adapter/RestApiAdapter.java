package cristian.com.cristian.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cristian.com.cristian.restApi.ConstantesRestApi;
import cristian.com.cristian.restApi.EndPointApi;
import cristian.com.cristian.restApi.deserializador.MascotaRecentMediaDeserializador;
import cristian.com.cristian.restApi.deserializador.MascotaSearchDeserializador;
import cristian.com.cristian.restApi.model.MascotaResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Create
 */
public class RestApiAdapter {

    public EndPointApi establecerConexionRestApiInstagram(Gson gson) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        return retrofit.create(EndPointApi.class);

    }

    public Gson construyeGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class,new MascotaRecentMediaDeserializador());

        return   gsonBuilder.create();
    }


    public Gson construyeGsonDeserializadorSearch(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class,new MascotaSearchDeserializador());

        return   gsonBuilder.create();
    }
}
