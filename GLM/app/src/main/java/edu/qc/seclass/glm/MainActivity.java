package edu.qc.seclass.glm;

import android.content.Intent;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import edu.qc.seclass.glm.Database.GroceryList;
import edu.qc.seclass.glm.Database.Item;
import edu.qc.seclass.glm.Database.ItemType;
import edu.qc.seclass.glm.Database.ListItem;
import edu.qc.seclass.glm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public static GroceryList groceryList;
    public static Item item;
    public static ItemType itemType;
    public static ListItem listItem;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        groceryList = new GroceryList(this);
        itemType = new ItemType(this);
        item = new Item(this);
        listItem = new ListItem(this);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.groceryListsButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, edu.qc.seclass.glm.activity.GroceryListActivity.class)));

    }
}