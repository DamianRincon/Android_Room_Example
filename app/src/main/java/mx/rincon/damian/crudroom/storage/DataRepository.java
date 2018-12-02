package mx.rincon.damian.crudroom.storage;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import mx.rincon.damian.crudroom.nodos.Contact;

public class DataRepository {
    private DataHelper dataHelper;
    private LiveData<List<Contact>> contacts;

    DataRepository (Application application){
        DataSource dataSource = DataSource.getDatabase(application);
        dataHelper = dataSource.dataHelper();
        contacts = dataHelper.getAllContacts();
    }

    LiveData<List<Contact>> getAllContacts() { return contacts; }
    public void insert (Contact contact) { new InsertAsyncTask(dataHelper).execute(contact); }

    public class InsertAsyncTask extends AsyncTask<Contact, Void, Void> {
        private DataHelper dataHelper;
        InsertAsyncTask(DataHelper dataHelper){ this.dataHelper = dataHelper; }
        @Override
        protected Void doInBackground(Contact... contacts) {
            dataHelper.insert(contacts[0]);
            return null;
        }
    }
}
