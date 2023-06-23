package edu.qc.seclass.glm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.qc.seclass.glm.R;
import edu.qc.seclass.glm.Database.Item;

public class ItemAdapter extends RecyclerView
        .Adapter<ItemAdapter
        .DataObjectHolder>{
    private static String LOG_TAG = "ItemAdapter";
    private static MyClickListener myClickListener;
    private static List<edu.qc.seclass.glm.model.Item> items;
    private Item database;

    public ItemAdapter(Context context) {
        database = new Item(context);
        setItems("");
    }

    public void setItems(String name) {
        items = database.getAllItems(name);
    }

    public edu.qc.seclass.glm.model.Item addItem(edu.qc.seclass.glm.model.Item item) {
        return database.add(item);
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view_item, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        edu.qc.seclass.glm.model.Item item = items.get(position);
        holder.name.setText(item.getName());
        holder.itemType.setText(item.getItemType().getName());
    }

    @Override
    public int getItemCount() {
        return items==null? 0 : items.size();
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        ItemAdapter.myClickListener = myClickListener;
    }

    public interface MyClickListener {
        void onItemClick(int position, View v);
    }

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView name;
        TextView itemType;

        public DataObjectHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.itemViewItem);
            itemType = (TextView) itemView.findViewById(R.id.itemTypeViewItem);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int pos = getPosition();
            long id = items.get(pos).getId();
            myClickListener.onItemClick((int) id, v);
        }
    }
}
