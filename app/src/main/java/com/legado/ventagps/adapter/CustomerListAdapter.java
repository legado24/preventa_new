package com.legado.ventagps.adapter;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.legado.ventagps.R;
import com.legado.ventagps.model.Customer;
import com.legado.ventagps.utils.CircleImageView;

import java.util.ArrayList;
import java.util.List;

public class CustomerListAdapter extends RecyclerView.Adapter<CustomerListAdapter.ViewHolder> {

    private Context ctx;
    private List<Customer> items;
    private OnClickListener onClickListener = null;

    private SparseBooleanArray selected_items;
    private int current_selected_idx = -1;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView codeCustomer, descCustomer,addresCustomer;
        public CircleImageView image;

        public View lyt_parent;

        public ViewHolder(View view) {
            super(view);

            codeCustomer = (TextView) view.findViewById(R.id.codeCustomer);
            descCustomer = (TextView) view.findViewById(R.id.descCustomer);
            addresCustomer=(TextView) view.findViewById(R.id.addresCustomer);
             //image_letter = (TextView) view.findViewById(R.id.image_letter);
            image = (CircleImageView) view.findViewById(R.id.image);
            // lyt_image = (RelativeLayout) view.findViewById(R.id.lyt_image);
            lyt_parent = (View) view.findViewById(R.id.lyt_parent);
        }

    }

    public CustomerListAdapter(Context mContext, List<Customer> items) {
        this.ctx = mContext;
        this.items = items;
        selected_items = new SparseBooleanArray();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_customer, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Customer customer = items.get(position);

        holder.codeCustomer.setText(customer.getCode());
        holder.descCustomer.setText(customer.getDescription());
        holder.addresCustomer.setText(customer.getAddress());
        holder.lyt_parent.setActivated(selected_items.get(position, false));
        holder.lyt_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener == null) return;
                onClickListener.onItemClick(v, customer, position);
            }
        });

        holder.lyt_parent.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onClickListener == null) return false;
                onClickListener.onItemLongClick(v, customer, position);
                return true;
            }
        });

        displayImage(holder, customer);

    }

    private void displayImage(ViewHolder holder, Customer customer) {
      if (customer.getStatus().equals("A")) {
          holder.image.setBorderColor(ctx.getResources().getColor(R.color.green_500));
      }else if (customer.getStatus().equals("P")){
          holder.image.setBorderColor(ctx.getResources().getColor(R.color.blue_500));
      }else if (customer.getStatus().equals("I")){
          holder.image.setBorderColor(ctx.getResources().getColor(R.color.red_500));
      }
    }


    public Customer getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void toggleSelection(int pos) {
        current_selected_idx = pos;
        if (selected_items.get(pos, false)) {
            selected_items.delete(pos);
        } else {
            selected_items.put(pos, true);
        }
        notifyItemChanged(pos);
    }

    public void clearSelections() {
        selected_items.clear();
        notifyDataSetChanged();
    }

    public int getSelectedItemCount() {
        return selected_items.size();
    }

    public List<Integer> getSelectedItems() {
        List<Integer> items = new ArrayList<>(selected_items.size());
        for (int i = 0; i < selected_items.size(); i++) {
            items.add(selected_items.keyAt(i));
        }
        return items;
    }

    public void removeData(int position) {
        items.remove(position);
        resetCurrentIndex();
    }

    private void resetCurrentIndex() {
        current_selected_idx = -1;
    }

    public interface OnClickListener {
        void onItemClick(View view, Customer obj, int pos);

        void onItemLongClick(View view, Customer obj, int pos);
    }
}