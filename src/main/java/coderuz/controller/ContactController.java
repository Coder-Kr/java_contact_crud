package coderuz.controller;

import coderuz.dto.Contact;
import coderuz.service.ContactService;
import coderuz.service.ScannerService;

public class ContactController {
    private ContactService contactService;
    private ScannerService scannerService;

    public void start() {
        boolean b = true;

        while (b) {
            showMenu();
            int action = getAction();

            switch (action) {
                case 1:
                    System.out.println("Add dto.Contact");
                    addContact();
                    break;
                case 2:
                    System.out.println("dto.Contact List");
                    contactList();
                    break;
                case 3:
                    System.out.println("Delete dto.Contact");
                    deleteContact();
                    break;
                case 4:
                    System.out.println("Search");
                    search();
                    break;
                case 0:
                    System.out.println("Exit");
                    b = false;
                    break;
                default:
                    b = false;
            }

        }
    }

    public void showMenu() {
        System.out.println("*** Menu ***");
        System.out.println("1. Add dto.Contact");
        System.out.println("2. dto.Contact List");
        System.out.println("3. Delete dto.Contact");
        System.out.println("4. Search dto.Contact");
        System.out.println("0. Exit");
    }

    public int getAction() {
        System.out.println("Enter action: ");
        return scannerService.getNumScanner().nextInt();
    }

    public void addContact() {
        System.out.println("Enter name: ");
        String name = scannerService.getStrScanner().next();

        System.out.println("Enter surname: ");
        String surname = scannerService.getStrScanner().next();

        System.out.println("Enter phone: ");
        String phone = scannerService.getStrScanner().next();

        Contact contact = new Contact(); //IOC container
        contact.setName(name);
        contact.setSurname(surname);
        contact.setPhone(phone);

        contactService.addContact(contact);
    }

    public void contactList() {
        contactService.contactList();
    }

    public void deleteContact() {
        System.out.println("Enter Phone: ");
        String phone = scannerService.getStrScanner().next();
        contactService.deleteContact(phone);
    }

    public void search() {
        System.out.println("Enter query: ");
        String query = scannerService.getStrScanner().next();
        contactService.search(query);
    }

    public ContactService getContactService() {
        return contactService;
    }

    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }

    public void setScannerService(ScannerService scannerService) {
        this.scannerService = scannerService;
    }
}
