package com.everis.prj_appointmentbook_app.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.everis.prj_appointmentbook_app.DataSource.ContactRepository;
import com.everis.prj_appointmentbook_app.Model.Contact;

import java.util.List;

public class ContactViewModel extends AndroidViewModel {

    private ContactRepository repository;
    private LiveData<List<Contact>> allContacts;

    public ContactViewModel(@NonNull Application application) {
        super(application);
        repository = new ContactRepository(application);
        allContacts = repository.getAllContacts();
    }

    public void insert(Contact contact){
        repository.insert(contact);
    }

    public void update(Contact contact){
        repository.update(contact);
    }

    public void delete(Contact contact){
        repository.delete(contact);
    }

    public LiveData<List<Contact>> getAllContacts() {
        return allContacts;
    }
}
