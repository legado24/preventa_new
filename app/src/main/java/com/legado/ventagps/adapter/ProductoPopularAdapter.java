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
import com.legado.ventagps.model.Producto;

import java.util.ArrayList;

public class ProductoPopularAdapter extends RecyclerView.Adapter<ProductoPopularAdapter.ProductoPopularesViewHolder> {
    ArrayList<Producto> productos=new ArrayList<>();
    Context context;

    public ProductoPopularAdapter(Context context, ArrayList<Producto> productos) {
        this.productos = productos;
        this.context=context;
    }

    @NonNull
    @Override
    public ProductoPopularesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_producto_pop_view,parent,false);
        ProductoPopularesViewHolder productoViewHolder=new ProductoPopularesViewHolder(view);
        return productoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoPopularesViewHolder holder, int position) {
        Producto producto=productos.get(position);
        holder.image.setImageResource(producto.getImagen());
         holder.nombre.setText(producto.getNombre());
         holder.descripcion.setText(producto.getDescripcion());
         holder.precio.setText(producto.getMoneda()+""+producto.getPrecio());
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }


    public static class ProductoPopularesViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView nombre;
        TextView descripcion;
        TextView precio;


        public ProductoPopularesViewHolder(@NonNull View itemView) {
            super(itemView);
            //hoocks
            image=itemView.findViewById(R.id.ivProductoPop);
            nombre=itemView.findViewById(R.id.tvNombreProdPop);
            descripcion=itemView.findViewById(R.id.tvDescProdPop);
            precio=itemView.findViewById(R.id.tvPrecioPop);
         }
    }
}
