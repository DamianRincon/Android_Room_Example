package mx.rincon.damian.crudroom.storage;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import mx.rincon.damian.crudroom.nodos.Contact;

@Database(entities = {Contact.class}, version = 1)

public abstract class DataSource extends RoomDatabase {
    public abstract DataHelper dataHelper();
    private static volatile DataSource INSTANCE;
    static DataSource getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DataSource.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DataSource.class, "contacts")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}