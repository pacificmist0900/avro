package com.example;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.apache.avro.Schema;
import org.apache.avro.specific.SpecificData;
import org.junit.Test;

/**
 * Unit test for demonstrating specific data potential issue.
 */
public class AppTest {


    public static final Schema FULLNAME_SCHEMA = (new Schema.Parser()).parse("{\n" +
            "     \"type\": \"record\",\n" +
            "     \"namespace\": \"com.example\",\n" +
            "     \"name\": \"FullName\",\n" +
            "     \"fields\": [\n" +
            "       { \"name\": \"first\", \"type\": \"string\" },\n" +
            "       { \"name\": \"last\", \"type\": \"string\" }\n" +
            "     ]\n" +
            "}");


    @Test
    public void testClassLoad() {

        try {
            SpecificData.get().getClass(FULLNAME_SCHEMA);
        } catch (Exception e) {
            fail();
        }
    }
}
