package edu.qc.seclass.glm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import edu.qc.seclass.glm.R;
import edu.qc.seclass.glm.adapter.GroceryListAdapter;
import edu.qc.seclass.glm.model.GroceryList;
import edu.qc.seclass.glm.util.DividerItemDecoration;

public class GroceryListActivity extends AppCompatActivity {

    private static String LOG_TAG = "GroceryListActivity";
    EditText groceryListNameValue;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private static GroceryListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grocery_list_activity);
        groceryListNameValue = findViewById(R.id.groceryListNameValue);

        Button buttonCompute = findViewById(R.id.buttonSearch);
        buttonCompute.setOnClickListener(new SearchListener());


        Button buttonAdd = findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new AddListener());

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView = findViewById(R.id.grocery_list_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);

        resetAdapter();


        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);
    }

    public void resetAdapter() {
        mAdapter = new GroceryListAdapter();
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.setOnItemClickListener((position, v) -> {
            Intent intent = new Intent(GroceryListActivity.this, ListItemActivity.class);
            ListItemActivity.setSelectedGroceryListId(position);
            startActivity(intent);
        });
    }

    private class SearchListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String name = groceryListNameValue.getText().toString();
            GroceryListAdapter.setGroceryLists(name);
            mRecyclerView.setAdapter(mAdapter);
        }
    }

    private class AddListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String name = groceryListNameValue.getText().toString();
            if(name!=null && !name.isEmpty()) {
                GroceryList newGroceryList = new GroceryList();
                newGroceryList.setName(name);
                mAdapter.addGroceryList(newGroceryList);
                mRecyclerView.setAdapter(mAdapter);
            }
        }
    }
}
