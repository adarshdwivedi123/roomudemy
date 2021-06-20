package com.example.roomudemy.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roomudemy.modal.NoDo;

import java.util.List;

//how we know this is dowclass so that why we use Dao
@Dao
public interface NoDoDao {
    //curd
    @Insert
    void insert(NoDo noOD);

    //table is mention  in noDo.jaa
    @Query("DELETE FROM nodo_table")
    void deleteAll();

// delete a one item from the table
    @Query("DELETE FROM nodo_table WHERE id =:id")
        int deleteANoDo(int id);

//how can we update from the table
    @Query("UPDATE nodo_table SET nodo_col=:nodoText where id =:id")
    int updateNoDoItem(int id,String nodoText);

    @Query("SELECT * FROM nodo_table ORDER BY nodo_col DESC")
    LiveData<List<NoDo>> getAllNoDos();

}
