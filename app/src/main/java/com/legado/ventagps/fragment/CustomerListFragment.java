package com.legado.ventagps.fragment;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.view.ActionMode;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.legado.ventagps.R;
import com.legado.ventagps.adapter.CustomerListAdapter;
import com.legado.ventagps.api.ApiRetrofitShort;
import com.legado.ventagps.model.Customer;
import com.legado.ventagps.model.CustomerListResponse;
import com.legado.ventagps.widget.LineItemDecoration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.legado.ventagps.model.Constants.Config.BASE_URL;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CustomerListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CustomerListFragment extends Fragment {

    private RecyclerView recyclerView;
    private CustomerListAdapter mAdapter;
    private ActionMode actionMode;
    private ProgressDialog pd;
    Dialog dialog;
    private BottomSheetBehavior mBehavior;
    private BottomSheetDialog mBottomSheetDialog;
    private View bottom_sheet;

    public CustomerListFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CustomerListFragment newInstance() {
        CustomerListFragment fragment = new CustomerListFragment();
      //  Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
      //  fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_customer, container, false);
        View viewFloating = getActivity().findViewById(R.id.floatings);
        viewFloating.setVisibility(View.VISIBLE);
        dialog = onCreateDialog();
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new LineItemDecoration(getActivity(), LinearLayout.VERTICAL));
        recyclerView.setHasFixedSize(true);
        bottom_sheet =v.findViewById(R.id.bottom_sheet);
        mBehavior = BottomSheetBehavior.from(bottom_sheet);
        cargarClientes();
        return v;
    }

    public Dialog onCreateDialog() {
        Dialog dialog = new Dialog(getActivity());
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setTitle(null);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.setCancelable(false);
        return dialog;
    }

    private void cargarClientes() {
        dialog.show();
        Map<String, String> dataConsulta = new HashMap<>();
        dataConsulta.put("usuario", "CHINCHAH");
        Call<CustomerListResponse> loginCall = ApiRetrofitShort.getInstance(BASE_URL).getCustomerService().clientesByDiaV3(dataConsulta);
        loginCall.enqueue(new Callback<CustomerListResponse>() {
            @Override
            public void onResponse(Call<CustomerListResponse> call, Response<CustomerListResponse> response) {
                List<Customer> items = response.body().getCustomers();
                //set data and list adapter
                mAdapter = new CustomerListAdapter(getContext(), items);
                recyclerView.setAdapter(mAdapter);

                mAdapter.setOnClickListener(new CustomerListAdapter.OnClickListener() {
                    @Override
                    public void onItemClick(View view, Customer obj, int pos) {

                    }

                    @Override
                    public void onItemLongClick(View view, Customer obj, int pos) {
                        showBottomSheetDialog(obj);
                     }
                });

                dialog.dismiss();

            }

            @Override
            public void onFailure(Call<CustomerListResponse> call, Throwable t) {


                System.out.println("");
            }
        });
    }

    private void showBottomSheetDialog(final Customer customer) {
        if (mBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            mBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }
        final View view = getLayoutInflater().inflate(R.layout.sheet_list, null);
       TextView txtVendedor=((TextView) view.findViewById(R.id.txtVendedor));
       txtVendedor.setText(customer.getDescription());

//        ((View) view.findViewById(R.id.lyt_preview)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), "Preview '" + people.name + "' clicked", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        ((View) view.findViewById(R.id.lyt_share)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), "Share '" + people.name + "' clicked", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        ((View) view.findViewById(R.id.lyt_get_link)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), "Get link '" + people.name + "' clicked", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        ((View) view.findViewById(R.id.lyt_make_copy)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), "Make a copy '" + people.name + "' clicked", Toast.LENGTH_SHORT).show();
//            }
//        });

        mBottomSheetDialog = new BottomSheetDialog(getActivity());
        mBottomSheetDialog.setContentView(view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mBottomSheetDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        mBottomSheetDialog.show();
        mBottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                mBottomSheetDialog = null;
            }
        });
    }
}