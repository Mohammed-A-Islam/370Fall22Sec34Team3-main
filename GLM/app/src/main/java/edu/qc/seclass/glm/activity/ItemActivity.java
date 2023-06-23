package edu.qc.seclass.glm.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.qc.seclass.glm.util.DividerItemDecoration;
import edu.qc.seclass.glm.R;
import edu.qc.seclass.glm.adapter.ItemAdapter;


public class ItemActivity extends AppCompatActivity {

    public static long selectedItemTypeId;
    private static String LOG_TAG = "ItemActivity";
    EditText itemNameValue;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ItemAdapter mAdapter;
    private edu.qc.seclass.glm.model.Item selectedItem;

    public static void setSelectedItemTypeId(long id) {
        selectedItemTypeId = id;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_activity);
        itemNameValue = (EditText) findViewById(R.id.ItemBox);

        Button buttonCompute = (Button) findViewById(R.id.buttonSearch);
        buttonCompute.setOnClickListener(new SearchListener());

        Button buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new AddListener());

        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ItemAdapter(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.item_view);
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
            ListItemActivity.setSelectedItemId(position);
            Intent returnIntent = new Intent();
            setResult(Activity.RESULT_OK, returnIntent);
            finish();
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                long item_type_id = selectedItemTypeId;
                selectedItem.setItemTypeId(item_type_id);
                selectedItem = mAdapter.addItem(selectedItem);
                ListItemActivity.setSelectedItemId(selectedItem.getId());
                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        } else if (resultCode == Activity.RESULT_CANCELED) {
            Log.i(LOG_TAG, " Bad Item Name ");
        }
    }

    private class SearchListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String name = itemNameValue.getText().toString();
            mAdapter.setItems(name);
            mRecyclerView.setAdapter(mAdapter);
            if(mAdapter.getItemCount()==0) {
                CharSequence text = "\""+name+"\" item not found. Click the \"ADD\" button to add it to your list.";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(ItemActivity.this, text, duration);
                toast.show();
            }
        }
    }

    private class AddListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String name = itemNameValue.getText().toString();
            if (name != null && !name.isEmpty()) {
                selectedItem = new edu.qc.seclass.glm.model.Item();
                selectedItem.setName(name);
                Intent intent = new Intent(ItemActivity.this, edu.qc.seclass.glm.activity.ItemTypeActivity.class);
                startActivityForResult(intent, 1);
            }
        }
    }
}

