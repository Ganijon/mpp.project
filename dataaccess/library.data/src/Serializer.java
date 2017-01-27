
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer<T> {

    private static final String PATH = "data/";

    public boolean serialize(T object, String fileName) {

        try (FileOutputStream fileStream = new FileOutputStream(PATH + fileName);
                ObjectOutputStream objectStream = new ObjectOutputStream(fileStream)) {
            objectStream.writeObject(object);
        } catch (IOException ioException) {
            System.err.print("Error while Serializing. " + ioException.getMessage());
            return false;
        }

        return true;
    }

    public T deSerialize(String fileName) {

        T object = null;
        try (FileInputStream fileStream = new FileInputStream(PATH + fileName);
                ObjectInputStream objectStream = new ObjectInputStream(fileStream)) {
            object = (T) objectStream.readObject();
        } catch (IOException | ClassNotFoundException ioException) {
            System.err.print("Error while Serializing. " + ioException.getMessage());
        }

        return object;
    }
}
