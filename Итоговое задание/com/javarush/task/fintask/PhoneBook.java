//Итоговое задание
// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что в во входной структуре будут повторяющиеся имена с разными телефонами, 
// их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.

package com.javarush.task.fintask;

import java.util.*;
import java.util.stream.Collectors;

public class PhoneBook {
    private HashMap<String, List<String>> phoneBook;
    
    public PhoneBook() {
        phoneBook = new HashMap<>();
    }
    
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

    public HashMap<String, List<String>> getPhoneBook() {
        return phoneBook;
    }

    public void setPhoneBook(HashMap<String, List<String>> phoneBook) {
        this.phoneBook = phoneBook;
    }