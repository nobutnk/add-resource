package com.nobutnk.addresource;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Map;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigourous Test :-)
     * @throws Exception Test Failure (cannot read file)
     */
    @Test
    public void testApp() throws Exception {
        App app = new App();
        Map<String, String> actual = app.map("testdata1/sample.txt");
        assertThat(actual.get("header"), is("key,value"));
        assertThat(actual.get("key1"), is("value1"));
        assertThat(actual.get("key2"), is("value2"));
        assertThat(actual.get("key3"), is("value3"));
    }
}
