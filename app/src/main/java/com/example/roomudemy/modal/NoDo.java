 package com.example.roomudemy.modal;

 import androidx.annotation.NonNull;
 import androidx.room.ColumnInfo;
 import androidx.room.Entity;
 import androidx.room.PrimaryKey;
// here i learn how to create  a table
 // this is  table name

 @Entity(tableName="nodo_table")
public class NoDo {
     // here we create priamry key
     @PrimaryKey(autoGenerate = true)
     private int id;

     // now its a column
     @NonNull
     @ColumnInfo(name="nodo_col")
    private String noDo;


    public NoDo(@NonNull  String noDo) {
        this.noDo = noDo;
    }
     public void setNoDo(String noDo) {
         this.noDo = noDo;
     }

    public String getNoDo() {
        return noDo;
    }

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }
 }
