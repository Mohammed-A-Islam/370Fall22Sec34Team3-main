package edu.qc.seclass.glm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.qc.seclass.glm.R;
import edu.qc.seclass.glm.Database.ListItem;

public class ListItemAdapter extends RecyclerView
        .Adapter<ListItemAdapter
        .DataObjectHolder> {
    private static String LOG_TAG = "ListItemAdapter";
    private static MyClickListener myClickListener;
    private static List<edu.qc.seclass.glm.model.ListItem> listItems;
    private static ListItem database;


    public ListItemAdapter(Context context) {
        database = new ListItem(context);
    }

    public void setListItems(long grocery_list_id) {
        listItems = database.getListItems(grocery_list_id);
    }

    public void setListItems(long grocery_list_id, String item_name) {
        listItems = database.getListItems(grocery_list_id, item_name);
    }

    public edu.qc.seclass.glm.model.ListItem addListItem(edu.qc.seclass.glm.model.ListItem item) {
        return database.addListItem(item);
    }

    public void updateListItem(edu.qc.seclass.glm.model.ListItem item) {
        database.updateListItem(item);
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_view_item, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.name.setText(listItems.get(position).getItem().getName());
        holder.itemType.setText(listItems.get(position).getItem().getItemType().getName());
        holder.quantity.setText("" + listItems.get(position).getQuantity());
        holder.checked.setChecked(listItems.get(position).isChecked());
        holder.listItem = listItems.get(position);
    }

    @Override
    public int getItemCount() {
        return listItems == null ? 0 : listItems.size();
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        ListItemAdapter.myClickListener = myClickListener;
    }

    public edu.qc.seclass.glm.model.ListItem getListItem(int id) {
        return database.getListItem(id);
    }

    public void deleteListItem(long id) {
        database.deleteListItem(id);
    }

    public void uncheckAll(long groceryListId) {
        database.uncheckAll(groceryListId);
    }

    public interface MyClickListener {
        void onItemClick(int position, View v);
    }

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView name;
        TextView itemType;
        TextView quantity;
        CheckBox checked;
        edu.qc.seclass.glm.model.ListItem listItem;

        public DataObjectHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.listItemViewItem);
            itemType = itemView.findViewById(R.id.listItemTypeViewItem);
            quantity = itemView.findViewById(R.id.listItemQuantityViewItem);
            checked = itemView.findViewById(R.id.listItemCheckedViewItem);

            checked.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (listItem != null) {
                    listItem.setChecked(isChecked);
                    database.updateListItem(listItem);
                }
            });
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int pos = getPosition();
            long id = listItems.get(pos).getId();
            myClickListener.onItemClick((int) id, v);
        }
    }
}
