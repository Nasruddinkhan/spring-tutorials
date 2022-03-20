package com.mypractice.outbound;

import lombok.experimental.UtilityClass;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.xml.bind.JAXBException;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;
import java.io.StringWriter;

public class Util {
    public static <T> String marshallXml(final Jaxb2Marshaller marshaller, final T obj) throws JAXBException {
        StringWriter sw = new StringWriter();
        Result result = new StreamResult(sw);
        marshaller.marshal(obj, result);
        return sw.toString();
    }

    // (tries to) unmarshall(s) an InputStream to the desired object.
    @SuppressWarnings("unchecked")
    public <T> T unmarshallXml(final Jaxb2Marshaller marshaller, final InputStream xml) throws JAXBException {
        return (T) marshaller.unmarshal(new StreamSource(xml));
    }
}
