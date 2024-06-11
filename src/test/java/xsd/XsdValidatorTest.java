package xsd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static test.Sandbox.sandbox;

public class XsdValidatorTest {
    

    @Test
    public void testRighXml() {
        var sandbox = sandbox();
        sandbox.runTest(tempDir -> {
            var xsd = sandbox.copyResource("/shiporder.xsd");
            var xml = sandbox.copyResource("/shiporder_right.xml");

            var validator = new XsdValidator(xsd.getAbsolutePath());
            assertTrue(validator.isValid(xml.getAbsolutePath()));
        });
    }

    @Test
    public void testWrongXml() {
        var sandbox = sandbox();
        sandbox.runTest(tempDir -> {
            var xsd = sandbox.copyResource("/shiporder.xsd");
            var xml = sandbox.copyResource("/shiporder_wrong.xml");

            var validator = new XsdValidator(xsd.getAbsolutePath());
            assertFalse(validator.isValid(xml.getAbsolutePath()));
        });
    }
}
