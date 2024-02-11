//Итоговое задание
// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что в во входной структуре будут повторяющиеся имена с разными телефонами, 
// их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.

package com.fintask;

import java.util.*;

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