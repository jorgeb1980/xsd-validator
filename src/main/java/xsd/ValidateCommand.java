package xsd;

import cli.annotations.Command;
import cli.annotations.Parameter;
import cli.annotations.Run;

import java.nio.file.Path;

@Command(command="validate", description="Validates an xml file against an xsd schema")
public class ValidateCommand {

    @Parameter(name="xml", description="xml file")
    String xml;
    public void setXml(String xml) { this.xml = xml; }

    @Parameter(name="xsd", description="xsd file")
    String xsd;
    public void setXsd(String xsd) { this.xsd = xsd; }

    @Run
    // Entry point for df
    public int execute(Path cwd) throws Exception {
        var validator = new XsdValidator(xsd);
        if (validator.isValid(xml)) {
            System.out.println("The file is valid!");
            return 0;
        } else {
            System.out.println("ERROR! The file is not valid for this xsd");
            return -1;
        }        
    }
}