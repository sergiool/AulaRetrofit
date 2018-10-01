package site.ufsj.aularetrofit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AdapterAluno extends
        RecyclerView.Adapter<AdapterAluno.MyViewHolder> {

    List<Aluno> alunos;
    public AdapterAluno(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.leiaute_aluno, parent, false);
        return new MyViewHolder(layoutView, parent.getContext());

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textViewNome.setText(alunos.get(position).getNome());
        holder.textViewMatricula.setText(alunos.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return alunos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNome;
        TextView textViewMatricula;

        public MyViewHolder(View itemView, final Context context) {
            super(itemView);
            textViewNome = itemView.findViewById(R.id.textViewNome);
            textViewMatricula = itemView.findViewById(R.id.textViewMatricula);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Cliquei: "
                                    + getAdapterPosition(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
