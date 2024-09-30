package com.campusdual.classroom;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    private Map<String, Contact> contacts;

    public Phonebook() {
        contacts = new HashMap<>();
    }


    public void addContact(Contact contact) {
        contacts.put(contact.getCode(), contact);
    }


    public void deleteContact(String code) {
        contacts.remove(code);
    }


    public void showPhonebook() {
        if (contacts.isEmpty()) {
            System.out.println("El listín está vacío.");
        } else {
            for (Contact contact : contacts.values()) {
                contact.showContactDetails();
                System.out.println("-------------");
            }
        }
    }


    public Map<String, Contact> getData() {
        return contacts;
    }


    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("1. Añadir contacto");
            System.out.println("2. Mostrar listín");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Nombre: ");
                    String name = scanner.nextLine();
                    System.out.print("Apellidos: ");
                    String surnames = scanner.nextLine();
                    System.out.print("Teléfono principal: ");
                    String phone = scanner.nextLine();
                    Contact contact = new Contact(name, surnames, phone);
                    addContact(contact);
                    System.out.println("Contacto añadido.\n");
                    break;
                case 2:
                    showPhonebook();
                    break;
                case 3:
                    System.out.print("Ingrese el código del contacto a eliminar: ");
                    String code = scanner.nextLine();
                    deleteContact(code);
                    System.out.println("Contacto eliminado.\n");
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (option != 4);
    }
}
