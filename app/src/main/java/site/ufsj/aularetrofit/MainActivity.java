package site.ufsj.aularetrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    final ChamadaInterface iAlunoREST = ChamadaInterface.retrofit
            .create(ChamadaInterface.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.rv);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        final Call<List<Aluno>> call = iAlunoREST.getAluno();
        call.enqueue(new Callback<List<Aluno>>() {
            @Override
            public void onResponse(Call<List<Aluno>> call, Response<List<Aluno>> response){
                // specify an adapter (see also next example)
                mRecyclerView.setAdapter(new AdapterAluno(response.body()));
                Toast.makeText(getBaseContext(), "Criou Adapter com sucesso",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Aluno>> call, Throwable t) {
                Toast.makeText(getBaseContext(), "Não foi possível fazer a conexão",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void onClick(View v) {
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
