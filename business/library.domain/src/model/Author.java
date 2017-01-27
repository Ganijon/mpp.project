package model;

import java.io.Serializable;

public class Author extends Person implements Serializable {

    private boolean credentials;
    private String shortBio;

    public Author(String firstName, String lastName, String phoneNumber, Address address, boolean credentials, String ShortBio) {
        super(firstName, lastName, phoneNumber, address);
        this.credentials = credentials;
        this.shortBio = ShortBio;
    }

    public boolean isCredentials() {
        return credentials;
    }

    public void setCredentials(boolean credentials) {
        this.credentials = credentials;
    }

    public String getShortBio() {
        return shortBio;
    }

    public void setShortBio(String ShortBio) {
        this.shortBio = ShortBio;
    }

}
