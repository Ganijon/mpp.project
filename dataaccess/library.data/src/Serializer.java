
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer<T> {

    public boolean serialize(T object, String fileName) {

        try (FileOutputStream fileStream = new FileOutputStream(fileName);
                ObjectOutputStream objectStream = new ObjectOutputStream(fileStream)) {
            objectStream.writeObject(object);
        } catch (IOException inputOutputException) {
            System.err.printf("Exception Occurred while Serializing {}. Message is ", "WHAT to Write here instead of T.class", inputOutputException.getMessage());

            return false;
        }

        return true;
    }

    public T deSerialize(String fileName) {

        T object = null;
        try (FileInputStream fileStream = new FileInputStream(fileName);
                ObjectInputStream objectStream = new ObjectInputStream(fileStream)) {
            object = (T) objectStream.readObject();
        } catch (IOException | ClassNotFoundException inputOutputException) {
            System.err.printf("Exception Occurred while Serializing {}. Message is ", "WHAT to Write here instead of T.class", inputOutputException.getMessage());
        }

        return object;
    }
}
