package com.legado.ventagps.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.legado.ventagps.R;
import com.legado.ventagps.model.Categoria;

import java.util.ArrayList;

public class CardCategoriaAdapter extends RecyclerView.Adapter<CardCategoriaAdapter.CategoriaViewHolder> {
    ArrayList<Categoria> categorias=new ArrayList<>();
    Context context;

    public CardCategoriaAdapter(Context context, ArrayList<Categoria> categorias) {
        this.categorias = categorias;
        this.context=context;
    }

    @NonNull
    @Override
    public CategoriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_categoria_view,parent,false);
        CategoriaViewHolder categoriaViewHolder=new CategoriaViewHolder(view);
        return categoriaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaViewHolder holder, int position) {
        Categoria categoria=categorias.get(position);
        holder.image.setImageResource(categoria.getImage());
        holder.title.setText(categoria.getTitle());
        holder.cvCategoria.setCardBackgroundColor(context.getResources().getColor(categoria.getColor()));
       // holder.cvCategoria.setCardBackgroundColor(categoria.getColor());
    }

    @Override
    public int getItemCount() {
        return categorias.size();
    }


    public static class CategoriaViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title;
        CardView cvCategoria;

        public CategoriaViewHolder(@NonNull View itemView) {
            super(itemView);
            //hoocks
            image=itemView.findViewById(R.id.ivCategoria);
            title=itemView.findViewById(R.id.tvTitle);
            cvCategoria=itemView.findViewById(R.id.cvCategoria);
        }
    }
}
