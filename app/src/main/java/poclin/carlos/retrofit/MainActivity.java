package poclin.carlos.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import poclin.carlos.retrofit.apirest.CrudGalaxyService;
import poclin.carlos.retrofit.apirest.Response;
import poclin.carlos.retrofit.apirest.RetrofitUtil;
import poclin.carlos.retrofit.apirest.model.Cliente;
import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CrudGalaxyService service = RetrofitUtil.getInstance().create(CrudGalaxyService.class);

        Call<Response<List<Cliente>>> responseCall = service.obtenerTodosLosClientes();

        responseCall.enqueue(new Callback<Response<List<Cliente>>>() {
            @Override
            public void onResponse(Call<Response<List<Cliente>>> call, retrofit2.Response<Response<List<Cliente>>> response) {

                if(response.isSuccessful()){
                    Response<List<Cliente>> respuestaServicio = response.body();

                    if(respuestaServicio.status){
                        List<Cliente> listaClientes = respuestaServicio.body.data;

                        for (Cliente cliente : listaClientes){
                            Log.i("Cliente", cliente.getName()+cliente.getLastName());
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Ocurrió un error al obtener los clientes", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Response<List<Cliente>>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Ocurrió un error al obtener los clientes", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
