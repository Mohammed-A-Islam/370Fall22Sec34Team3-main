package edu.qc.seclass.glm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.qc.seclass.glm.R;
import edu.qc.seclass.glm.Database.ItemType;


public class ItemTypeAdapter extends RecyclerView
        .Adapter<ItemTypeAdapter
        .DataObjectHolder>{
    private static String LOG_TAG = "ItemTypeAdapter";
    private static MyClickListener myClickListener;
    private static List<edu.qc.seclass.glm.model.ItemType> itemTypes;
    private ItemType db;

    public ItemTypeAdapter(Context context) {
        db = new ItemType(context);
        setItemTypes("");
    }

    public void setItemTypes(String name) {
        itemTypes = db.getTypes(name);
    }

    public void addItemType(edu.qc.seclass.glm.model.ItemType itemType){
        db.addType(itemType);
        setItemTypes("");
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_type_view_item, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.name.setText(itemTypes.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return itemTypes==null? 0 : itemTypes.size();
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        ItemTypeAdapter.myClickListener = myClickListener;
    }

    public interface MyClickListener {
        void onItemClick(int position, View v);
    }

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView name;

        public DataObjectHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.itemTypeViewItem);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int pos = getPosition();
            long id = itemTypes.get(pos).getId();
            myClickListener.onItemClick((int) id, v);
        }
    }
}
