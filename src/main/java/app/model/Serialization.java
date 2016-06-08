package app.model;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by cduffau on 08/06/16.
 */
public class Serialization<T> {

    public Serialization(){

    }

    public void saveStudent(T object, File file) throws FileNotFoundException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(object,file);

    }

    public T getStudent(File file) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        T object= (T) jaxbUnmarshaller.unmarshal(file);
        return object;
    }
}
