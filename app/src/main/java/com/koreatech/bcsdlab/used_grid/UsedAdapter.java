package com.koreatech.bcsdlab.used_grid;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxg12 on 2017-10-10.
 */

public class UsedAdapter extends RecyclerView.Adapter<UsedAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<UsedItem> usedList;
    UsedItem used;
    DatabaseHelper db;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, price, content;
        public ImageView thumbnail, overflow;


        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            price = (TextView) view.findViewById(R.id.price);
            content = (TextView) view.findViewById(R.id.content);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            overflow = (ImageView) view.findViewById(R.id.overflow);
        }
    }

    public UsedAdapter(Context mContext, ArrayList<UsedItem> usedList) {
        this.mContext = mContext;
        this.usedList = usedList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.used_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        used = usedList.get(position);
        holder.name.setText(used.getName());
        holder.price.setText(String.valueOf(used.getPrice()) + "원");
        holder.content.setText(used.getContent());

        // loading album cover using Glide library
        Glide.with(mContext).load(used.getThumbnail()).into(holder.thumbnail);

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow, used.getId());
            }
        });

    }

    private void showPopupMenu(View view, int id) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_item, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener(id));
        popup.show();
    }

    /**4
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {
        int id;
        public MyMenuItemClickListener(int id) {
            this.id = id;
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_edit_used:
                    return true;
                case R.id.action_delete_used:
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return usedList.size();
    }

}
