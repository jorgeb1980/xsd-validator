package xsd;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XsdValidator {

    private Validator validator;
    
    private File getFile(String location) {
        return new File(location);
    }
    
    public XsdValidator(String xsdPath) throws SAXException {
        var factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        var schemaFile = new StreamSource(getFile(xsdPath));
        var schema = factory.newSchema(schemaFile);
        validator = schema.newValidator();
    }

    public boolean isValid(String xmlPath) throws IOException, SAXException {
        try {
            validator.validate(new StreamSource(getFile(xmlPath)));
            return true;
        } catch (SAXException e) {
            return false;
        }
    }
}
