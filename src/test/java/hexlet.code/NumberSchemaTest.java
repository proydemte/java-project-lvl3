package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberSchemaTest {
    NumberSchema schema = new NumberSchema();

    @Test
    void blankSchemaTest() {
        Assertions.assertTrue(schema.isValid(null));
    }

    @Test
    void requiredTest() {
        schema.required();
        Assertions.assertTrue(schema.isValid(10));
        Assertions.assertFalse(schema.isValid(null));
        Assertions.assertFalse(schema.isValid("5"));
    }

    @Test
    void positiveTest() {
        Assertions.assertTrue(schema.positive().isValid(10));
        Assertions.assertFalse(schema.positive().isValid(-3));
    }

    @Test
    void rangeTest() {
        schema.range(5, 10);
        Assertions.assertTrue(schema.isValid(5));
        Assertions.assertTrue(schema.isValid(10));
        Assertions.assertTrue(schema.isValid(7));
        Assertions.assertFalse(schema.isValid(2));
        Assertions.assertFalse(schema.isValid(573));
    }
}

