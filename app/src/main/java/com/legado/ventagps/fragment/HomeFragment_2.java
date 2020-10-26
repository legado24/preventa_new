package com.legado.ventagps.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.legado.ventagps.R;
import com.legado.ventagps.adapter.BonificationAdapter;
import com.legado.ventagps.adapter.ProductoPopularAdapter;
import com.legado.ventagps.api.ApiRetrofitShort;
import com.legado.ventagps.model.ProductListResponse;
import com.legado.ventagps.model.Producto;
import com.legado.ventagps.model.StatusResponse;
import com.tuanfadbg.snackalert.SnackAlert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.legado.ventagps.model.Constants.Config.BASE_URL;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment_2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment_2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView rvCategoria;
    private RecyclerView rvProdPopulares;
    BonificationAdapter bonificacionAdapter;
    ProductoPopularAdapter productoPopularAdapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment_2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment_2 newInstance(String param1, String param2) {
        HomeFragment_2 fragment = new HomeFragment_2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_home_2, container, false);
        rvCategoria=root.findViewById(R.id.rvCategoria);
        rvProdPopulares=root.findViewById(R.id.rvProdPopulares);
    View viewFloating= getActivity().findViewById(R.id.floatings);
     viewFloating.setVisibility(View.INVISIBLE);
     callBonifItem();
        //categoriaRecycler();
        productoPopRecycler();
        return root;
    }
//
//    private void categoriaRecycler(){
//        rvCategoria.setHasFixedSize(true);
//        rvCategoria.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
//        ArrayList<Categoria> categorias=new ArrayList<>();
//        categorias.add(new Categoria("Tacos",R.drawable.tacos_iimg,R.color.colorCat1));
//        categorias.add(new Categoria("Frias",R.drawable.frias_img,R.color.colorCat2));
//        categorias.add(new Categoria("Burger",R.drawable.burger_img,R.color.colorCat3));
//        categorias.add(new Categoria("Pizza",R.drawable.pizza_img,R.color.colorCat4));
//        categorias.add(new Categoria("Burritos",R.drawable.burritos_img,R.color.colorCat5));
//        categoriaAdapter=new CardCategoriaAdapter(getContext(),categorias);
//        rvCategoria.setAdapter(categoriaAdapter);
//    }
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
    private void callBonifItem() {
         Map<String, String> dataConsulta = new HashMap<>();
        dataConsulta.put("page", "1");
        dataConsulta.put("limit", "10");
         Call<ProductListResponse> callUpdateUser = ApiRetrofitShort.getInstance(BASE_URL).getProductService().bonifItem(dataConsulta);
        callUpdateUser.enqueue(new Callback<ProductListResponse>() {
            @Override
            public void onResponse(Call<ProductListResponse> call, Response<ProductListResponse> response) {
                StatusResponse statusResponse = response.body().getStatus();
                if (statusResponse.getStatusCode().equals("1")) {

                    rvCategoria.setHasFixedSize(true);
                    rvCategoria.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
//                    ArrayList<Categoria> categorias=new ArrayList<>();
//                    categorias.add(new Categoria("Tacos",R.drawable.tacos_iimg,R.color.colorCat1));
//                    categorias.add(new Categoria("Frias",R.drawable.frias_img,R.color.colorCat2));
//                    categorias.add(new Categoria("Burger",R.drawable.burger_img,R.color.colorCat3));
//                    categorias.add(new Categoria("Pizza",R.drawable.pizza_img,R.color.colorCat4));
//                    categorias.add(new Categoria("Burritos",R.drawable.burritos_img,R.color.colorCat5));
                    bonificacionAdapter=new BonificationAdapter(getContext(),response.body().getProducts());
                    rvCategoria.setAdapter(bonificacionAdapter);



                    new SnackAlert(getActivity())
                            .setTitle("Alerta")
                            .setMessage(statusResponse.getStatusText())
                            .setType(SnackAlert.SUCCESS)
                            .show();

                } else if (statusResponse.getStatusCode().equals("0")) {

                    new SnackAlert(getActivity())
                            .setTitle("Alerta")
                            .setMessage(statusResponse.getStatusText())
                            .setType(SnackAlert.WARNING)
                            .show();
                } else if (statusResponse.getStatusCode().equals("-1")) {

                    new SnackAlert(getActivity())
                            .setTitle("Error")
                            .setMessage(statusResponse.getStatusText())
                            .setType(SnackAlert.ERROR)
                            .show();
                }


            }

            @Override
            public void onFailure(Call<ProductListResponse> call, Throwable t) {

                new SnackAlert(getActivity())
                        .setTitle("Error")
                        .setMessage(t.getMessage())
                        .setType(SnackAlert.ERROR)
                        .show();
            }
        });
    }

}