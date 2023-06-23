package edu.qc.seclass.glm.model;



import androidx.databinding.BaseObservable;

public class GroceryList extends BaseObservable {
    private long id;
    private String name;

    public GroceryList() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId(){
        return this.id;
    }

    public void setId(long id){
        this.id = id;
    }
}
