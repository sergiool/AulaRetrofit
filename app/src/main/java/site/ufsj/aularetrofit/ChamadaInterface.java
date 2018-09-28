package site.ufsj.aularetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ChamadaInterface {

    @POST("Aluno")
    Call<Void> insereAluno(@Body Aluno aluno);
    @GET("Aluno")
    Call<List<Aluno>> getAluno();
    @GET("Aluno/{id}")
    Call<Aluno> getAlunoPorId(@Path("id") String id);
    @PUT("Aluno/{id}")
    Call<Void> alteraAluno(@Path("id") String id, @Body Aluno aluno);
    @DELETE("Aluno/{id}")
    Call<Void> removeAluno(@Path("id") String id);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://ufsj.site/chamada.php/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
