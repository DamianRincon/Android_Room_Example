package mx.rincon.damian.crudroom.storage;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import mx.rincon.damian.crudroom.nodos.Contact;

public class ContactViewModel extends AndroidViewModel {
    private DataRepository repository;
    private LiveData<List<Contact>> contacts;

    public ContactViewModel(@NonNull Application application) {
        super(application);
        repository = new DataRepository(application);
        contacts = repository.getAllContacts();
    }

    public LiveData<List<Contact>> getAllContacts() { return contacts; }
    public void insert(Contact contact) { repository.insert(contact); }


}
