package edu.qc.seclass.glm.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import edu.qc.seclass.glm.R;
import edu.qc.seclass.glm.adapter.ItemTypeAdapter;
import edu.qc.seclass.glm.util.DividerItemDecoration;

public class ItemTypeActivity extends AppCompatActivity {

    private static String LOG_TAG = "ItemTypeActivity";
    EditText itemTypeNameValue;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ItemTypeAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_type_activity);
        itemTypeNameValue = (EditText) findViewById(R.id.itemTypeNameValue);

        Button buttonCompute = (Button) findViewById(R.id.buttonSearch);
        buttonCompute.setOnClickListener(new SearchListener());

        Button buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new AddListener());
        buttonAdd.setVisibility(View.INVISIBLE);

        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ItemTypeAdapter(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.item_type_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        //Add Lines between elements
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.setOnItemClickListener((position, v) -> {
            Intent returnIntent = new Intent();
            ItemActivity.setSelectedItemTypeId(position);
            setResult(Activity.RESULT_OK, returnIntent);
            finish();
        });
    }

    private class SearchListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String name = itemTypeNameValue.getText().toString();
            mAdapter.setItemTypes(name);
            mRecyclerView.setAdapter(mAdapter);
        }
    }

    private class AddListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String name = itemTypeNameValue.getText().toString();
            if(name!=null && !name.isEmpty()) {
                edu.qc.seclass.glm.model.ItemType newItemType = new edu.qc.seclass.glm.model.ItemType(name);
                newItemType.setName(name);
                mAdapter.addItemType(newItemType);
                mRecyclerView.setAdapter(mAdapter);
            }
        }
    }
}
