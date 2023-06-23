package edu.qc.seclass.glm.model;



import androidx.databinding.BaseObservable;

public class ItemType extends BaseObservable {
    private long id;
    private String name;
    private String description;

    public ItemType(String description) {

        this.description = description;
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

    @Override
    public String toString() {
        return name;
    }
}
