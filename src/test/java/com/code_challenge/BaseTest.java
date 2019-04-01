package com.code_challenge;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.junit.BeforeClass;

/**
 * Created by 45011470 on 13/09/2018.
 */
public class BaseTest {

    @BeforeClass
    public static void setup() {
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }
}
