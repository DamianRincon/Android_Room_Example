package mx.rincon.damian.crudroom.storage;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import mx.rincon.damian.crudroom.nodos.Contact;

@Dao
public interface DataHelper {

    @Insert
    void insert(Contact contact);

    @Update
    void update(Contact contact);

    @Query("DELETE FROM contacts")
    void deleteAll();

    @Query("SELECT * from contacts ORDER BY id ASC")
    LiveData<List<Contact>> getAllContacts();

}
