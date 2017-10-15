package poclin.carlos.retrofit.apirest;

import java.util.List;

import poclin.carlos.retrofit.apirest.model.Cliente;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CrudGalaxyService {

    @GET("clientes")
    Call<Response<List<Cliente>>> obtenerTodosLosClientes();

    @POST("clientes")
    Call<Response<Void>> registrarCliente(@Body Cliente cliente);

    @PUT ("clientes/{idCliente}") Call<Response<Void>> actualizarCliente(@Path("idCliente") Integer idCliente,
                                                                         @Body Cliente cliente);

    @DELETE ("clientes/{idCliente}") Call<Response<Void>> eliminarCliente(@Path("idCliente") Integer idCliente);
}

