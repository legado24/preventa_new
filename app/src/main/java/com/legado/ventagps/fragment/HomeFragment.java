package com.legado.ventagps.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.legado.ventagps.R;
import com.legado.ventagps.adapter.CardCategoriaAdapter;
import com.legado.ventagps.adapter.ProductoPopularAdapter;
import com.legado.ventagps.model.Categoria;
import com.legado.ventagps.model.Producto;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView rvCategoria;
    private RecyclerView rvProdPopulares;
    CardCategoriaAdapter categoriaAdapter;
    ProductoPopularAdapter productoPopularAdapter;

    // TODO: Rename and change types of parameters
   // private String mParam1;
    //private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
         //   mParam1 = getArguments().getString(ARG_PARAM1);
          //  mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_home, container, false);
        rvCategoria=root.findViewById(R.id.rvCategoria);
        rvProdPopulares=root.findViewById(R.id.rvProdPopulares);
    View viewFloating= getActivity().findViewById(R.id.floatings);
     viewFloating.setVisibility(View.INVISIBLE);
        categoriaRecycler();
        productoPopRecycler();
        return root;
    }

    private void categoriaRecycler(){
        rvCategoria.setHasFixedSize(true);
        rvCategoria.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        ArrayList<Categoria> categorias=new ArrayList<>();
        categorias.add(new Categoria("Tacos",R.drawable.tacos_iimg,R.color.colorCat1));
        categorias.add(new Categoria("Frias",R.drawable.frias_img,R.color.colorCat2));
        categorias.add(new Categoria("Burger",R.drawable.burger_img,R.color.colorCat3));
        categorias.add(new Categoria("Pizza",R.drawable.pizza_img,R.color.colorCat4));
        categorias.add(new Categoria("Burritos",R.drawable.burritos_img,R.color.colorCat5));
        categoriaAdapter=new CardCategoriaAdapter(getContext(),categorias);
        rvCategoria.setAdapter(categoriaAdapter);
    }
    private void productoPopRecycler(){

        rvProdPopulares.setHasFixedSize(true);
        rvProdPopulares.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        ArrayList<Producto> productos=new ArrayList<>();
        productos.add(new Producto("Pizza Clásica","Salsa clásica de la casa","$",new Double(12.58),R.drawable.pizza_clasica));
        productos.add(new Producto("Hamburguesa mix","Doble carne con queso","$",new Double(12.58),R.drawable.hamburguesa_mix_img));
        productos.add(new Producto("Pizza Clásica","Salsa clásica de la casa","$",new Double(12.58),R.drawable.pizza_clasica));

        productoPopularAdapter=new ProductoPopularAdapter(getContext(),productos);
        rvProdPopulares.setAdapter(productoPopularAdapter);
    }
}