

public class BookCopy {

    private int BookCopyID;
    private boolean isAvailable;
    private static int instance=0;

    public BookCopy() {
        instance++;
        this.BookCopyID = instance;
        this.isAvailable = true;
    }
    
    
    
}
