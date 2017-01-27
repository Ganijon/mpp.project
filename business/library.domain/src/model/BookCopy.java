package model;

import java.io.Serializable;

public class BookCopy implements Serializable {

    private String bookCopyId;
    private boolean isAvailable;

    BookCopy(String id) {     // only package level access
        this.bookCopyId = id;
        this.isAvailable = true;
    }

    public String getBookCopyId() {
        return bookCopyId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" BookCopyId:");
        sb.append(getBookCopyId());
        sb.append(" Available:");
        sb.append(isAvailable ? "yes" : "no");
        return sb.toString();
    }

}
