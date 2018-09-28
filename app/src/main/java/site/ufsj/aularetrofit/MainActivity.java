package site.ufsj.aularetrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        final ChamadaInterface iAlunoREST = ChamadaInterface.retrofit
                .create(ChamadaInterface.class);
        Aluno aluno = new Aluno();
        EditText editNome = findViewById(R.id.editNome);
        EditText editMatricula = findViewById(R.id.editMatricula);
        aluno.setNome(editNome.getText().toString());
        aluno.setId(editMatricula.getText().toString());
        final Call<Void> call = iAlunoREST.insereAluno(aluno);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response){
                Toast.makeText(getBaseContext(), "Inserido com sucesso",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(getBaseContext(), "Não foi possível fazer a conexão",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
