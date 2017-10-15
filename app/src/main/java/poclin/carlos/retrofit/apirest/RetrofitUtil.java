package poclin.carlos.retrofit.apirest;

import android.provider.SyncStateContract;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {

    private static Retrofit retrofit;

    public static Retrofit getInstance (){
        if(retrofit==null){
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()

                    .addInterceptor(interceptor)
                    .build();

                    retrofit = new Retrofit.Builder()
                    .baseUrl("https://mantenimientogalaxy.herukoapp.com/api/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
