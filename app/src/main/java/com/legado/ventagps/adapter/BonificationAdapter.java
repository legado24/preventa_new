package com.legado.ventagps.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.legado.ventagps.R;
import com.legado.ventagps.model.Categoria;
import com.legado.ventagps.model.Product;

import java.util.ArrayList;

public class BonificationAdapter extends RecyclerView.Adapter<BonificationAdapter.BonificationViewHolder> {
    ArrayList<Product> productos=new ArrayList<>();
    Context context;

    public BonificationAdapter(Context context, ArrayList<Product> productos) {
        this.productos = productos;
        this.context=context;
    }

    @NonNull
    @Override
    public BonificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_categoria_view_2,parent,false);
        BonificationViewHolder bonificationViewHolder=new BonificationViewHolder(view);
        return bonificationViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BonificationViewHolder holder, int position) {
        Product product=productos.get(position);
        Glide.with(context).load(product.getUri())
        .override(350, 550) // resizes the image to these dimensions (in pixel)
//                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.image);
        //apply(new RequestOptions().override(1000, 1000))
//        Glide.with(context)
//                .asBitmap()
//                .load(product.getUri())
//               // .error(R.drawable.no_result)
//                .override(holder.cvCategoria.getWidth(),holder.cvCategoria.getHeight())
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(new CustomTarget<Bitmap>() {
//                    @Override
//                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
//                        int width = resource.getWidth();
//                        int height = resource.getHeight();
//                        System.out.println(width+"*"+height);
//                        holder.image.setImageBitmap(resource);
//                       // holder.image.buildDrawingCache();
//
//                    }
//                    @Override
//                    public void onLoadCleared(@Nullable Drawable placeholder) { }
//                });


         holder.title.setText(product.getDescription());
      }

    @Override
    public int getItemCount() {
        return productos.size();
    }


    public static class BonificationViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title;
        CardView cvCategoria;

        public BonificationViewHolder(@NonNull View itemView) {
            super(itemView);
            //hoocks
            image=itemView.findViewById(R.id.ivCategoria);
            title=itemView.findViewById(R.id.tvTitle);
            cvCategoria=itemView.findViewById(R.id.cvCategoria);
        }
    }
}
