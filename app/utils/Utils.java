package utils;

import org.xml.sax.InputSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class Utils {

    @SuppressWarnings("unchecked")
    public static <T> T unmarshall(String content, Class<T> type) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(type);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (T) jaxbUnmarshaller.unmarshal(new InputSource(new StringReader(content)));
    }
}
