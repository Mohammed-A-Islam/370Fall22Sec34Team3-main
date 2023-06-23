package edu.qc.seclass.glm.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.qc.seclass.glm.MainActivity;
import edu.qc.seclass.glm.R;
import edu.qc.seclass.glm.model.GroceryList;


public class GroceryListAdapter extends RecyclerView
        .Adapter<GroceryListAdapter
        .DataObjectHolder>{
    private static String LOG_TAG = "GroceryListAdapter";
    private static MyClickListener myClickListener;
    private static List<GroceryList> groceryLists;


    public GroceryListAdapter() {
        setGroceryLists("");
    }

    public static void setGroceryLists(String name) {
        groceryLists = MainActivity.groceryList.getAllLists(name);
    }

    public static void updateGroceryList(long id, String name) {
        MainActivity.groceryList.update(id, name);
    }

    public static void deleteGroceryList(long id) {
        MainActivity.groceryList.deleteList(id);
    }

    public void addGroceryList(GroceryList groceryList){
        MainActivity.groceryList.addList(groceryList);
        setGroceryLists("");
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grocery_list_view_item, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.name.setText(groceryLists.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return groceryLists==null? 0 : groceryLists.size();
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        GroceryListAdapter.myClickListener = myClickListener;
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
            name = (TextView) itemView.findViewById(R.id.groceryListViewItem);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int pos = getPosition();
            long id = groceryLists.get(pos).getId();
            myClickListener.onItemClick((int) id, v);
        }
    }
}
