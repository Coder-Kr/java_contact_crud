package coderuz.service;

import coderuz.dto.Contact;
import coderuz.repository.ContactRepository;

import java.util.List;

public class ContactService {
    private ContactRepository contactRepository; //IoC container

    public void addContact(Contact contact) {
        // check
        Contact exists = contactRepository.getByPhone(contact.getPhone());
        if (exists != null) {
            System.out.println("Phone already exists.");
            return;
        }
        // save
        boolean result = contactRepository.saveContact(contact);
        if (result) {
            System.out.println("dto.Contact added.");
        } else {
            System.out.println("Something wend wrong. Mazgi.");
        }
    }

    public void contactList() {
        List<Contact> contactList = contactRepository.getList();
        for (Contact contact : contactList) {
            System.out.println(contact.getName() + " " + contact.getSurname() + " " + contact.getPhone());
        }
    }

    public void deleteContact(String phone) {
        boolean result = contactRepository.delete(phone); // delete
        if (result) {
            System.out.println("dto.Contact successfully deleted.");
        } else {
            System.out.println("dto.Contact not exists. Mazgi.");
        }
    }

    public void search(String query) {
        List<Contact> contactList = contactRepository.search(query);
        for (Contact contact : contactList) {
            System.out.println(contact.getName() + " " + contact.getSurname() + " " + contact.getPhone());
        }
    }

    public void setContactRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
}
