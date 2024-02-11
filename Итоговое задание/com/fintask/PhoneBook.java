//Итоговое задание/
// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что в во входной структуре будут повторяющиеся имена с разными телефонами, 
// их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.

package com.fintask;

import java.util.*;
class PhoneRow {
    private String _unit_name;
    private ArrayList<Integer> _phone_number = new ArrayList<>();

    PhoneRow(String name, int num) {
    System.out.println("Контакт: "+name);
        _unit_name = name;
        _phone_number.add(num);
    }

    public int getPhoneNumberCounter() {
        return this.getPhones().size();
    }

    public String toString() {
        return String.format("{%s:%s}", this._unit_name, this._phone_number.toString());
    }

    public String getName() {
        return this._unit_name;
    }

    public ArrayList<Integer> getPhones() {
        return this._phone_number;
    }
}


public class PhoneBook {
//создали класс PhoneBook, который содержит HashMap phoneBook, где ключ - это имя контакта (String), а значение - список его телефонов (List<String>).
    private HashMap<String, List<String>> phoneBook;
    
    public PhoneBook() {
        phoneBook = new HashMap<>();
    }
// Метод addContact добавляет контакт в телефонную книгу
    public void addContact(String name, String phone) {
        if (phoneBook.containsKey(name)) {
            List<String> phones = phoneBook.get(name);
            phones.add(phone);
        } else {
            List<String> phones = new ArrayList<>();
            phones.add(phone);
            phoneBook.put(name, phones);
        }
    }
//Метод removeContact удаляет контакт из телефонной книги по имени.
public void removeContact(String name) {
    phoneBook.remove(name);
}
//Метод removePhone удаляет конкретный телефон из списка телефонов контакта по имени контакта.
public void removePhone(String name, String phone) {
    if (phoneBook.containsKey(name)) {
        List<String> phones = phoneBook.get(name);
        phones.remove(phone);
        if (phones.isEmpty()) {
            phoneBook.remove(name);
        }
    }
}
public void printContacts() {
    // Создаем список пар "имя - количество телефонов" для сортировки
    List<Map.Entry<String, List<String>>> sortedContacts = new ArrayList<>(phoneBook.entrySet());
    sortedContacts.sort((a, b) -> b.getValue().size() - a.getValue().size());
    
    // Выводим отсортированные контакты
    for (Map.Entry<String, List<String>> entry : sortedContacts) {
        String name = entry.getKey();
        List<String> phones = entry.getValue();
        
        System.out.println(name + ": " + phones.toString());
    }
}

public static void main(String[] args) {
    PhoneBook phoneBook = new PhoneBook();
    phoneBook.addContact("Иван", "123-234-345");
    phoneBook.addContact("Иван", "444-555-666");
    phoneBook.addContact("Алиса", "707-808-909");
    phoneBook.printContacts();
    
    phoneBook.removePhone("Иван", "123-234-345");
    phoneBook.printContacts();
    
    phoneBook.removeContact("Алиса");
    phoneBook.printContacts();
}
public void add(String name2, int phone2) {
    throw new UnsupportedOperationException("Unimplemented method 'add'");
}
}