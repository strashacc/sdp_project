package com.openlibrary.Service;

import com.openlibrary.Model.Book;

// Observer.java (interface)

// NotificationService.java (Observer)
public class NotificationService implements Observer {
    private static NotificationService instance;



    private NotificationService() {}

    public static NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    @Override
    public void update(Book book) {
        if(book == null){
            System.out.println("A book hass been removed");
        }
        else
            System.out.println("Notification: New book added - " + book.getTitle());
    }
}

