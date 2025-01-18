package io.gordonpm.tests.utils;

import io.gordonpm.tests.vendorportal.model.VendorPortalTestData;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.bidi.module.Input;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Demo {

    public static void main(String[] args) throws IOException {
//        InputStream stream = ResourceLoader.getResource("dummy.txt");
//        String content = IOUtils.toString(stream, StandardCharsets.UTF_8);
//        System.out.println(content);

//        VendorPortalTestData testData = JsonUtil.getTestData("test-data/vendor-portal/sam.json");

//        System.out.println(testData.annualEarning());

        System.setProperty("browser", "edge");
        Config.initialize();
    }
}
