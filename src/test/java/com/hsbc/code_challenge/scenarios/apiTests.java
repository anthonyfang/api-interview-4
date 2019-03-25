package com.hsbc.code_challenge.scenarios;

import com.hsbc.code_challenge.BaseTest;
import com.hsbc.code_challenge.model.Product;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.core.Is.is;


public class apiTests extends BaseTest {

    // API documentation http://localhost:8080/swagger-ui.html#/product45controller

    //TODO: Sample test that is failing. Check what is wrong and make it working. Assume that data received from api is correct.
    @Test
    public void exercise1_getProductListTest(){
        List<Product> expected = Stream.of(
                new Product("Spring Framework Guru Shirt", 1, "https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_shirt-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg", 18.95, "235268845711068308", 0),
                new Product("Spring Framework Guru Mug", 2, "https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_coffee_mug-r11e7694903c348e1a667dfd2f1474d95_x7j54_8byvr_512.jpg", 11.95, "168639393495335947", 0),
                new Product("Spring Framework Guru Stickers", 3, "https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_stickers-a23dsf67sufgjh34598thjg9r8hjg2f14747u5_gkmf04_8byvr_512.jpg", 10.55, "456839393495332345", 0)
        ).collect(Collectors.toList());
        List<Product> actual =
            given().
                contentType("application/json").
            when().
                get("/product/list").
            then().
                assertThat().statusCode(200).
            and().
                extract().body().jsonPath().getList("", Product.class);
        System.out.println(expected.get(0).diff(actual.get(1)).toString());
        assertThat("Actual list of products differs from expected. Expected list size() = "
                + expected.size() + " Actual list size() = "
                + actual.size(), actual, containsInAnyOrder(expected.toArray()));
    }

    //TODO: Similar to exercise 1, it needs to be repaired due to data change.
    @Test
    public void exercise2_getProductTest(){
        final int productId = 2;
        Product expected = new Product("Spring Framework Guru Mug", 2, "https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_coffee_mug-r11e7694903c348e1a667dfd2f1474d95_x7j54_8byvr_512.jpg", 11.95, "168639393495335947", 0);
        Product actual =
            given().
                contentType("application/json").
            when().
                get(String.format("/product/show/%d", productId)).
            then().
                assertThat().statusCode(200).
            and().
                extract().body().as(Product.class);

        assertThat("Diff: " + expected.diff(actual), actual, is(equalTo(expected)));
    }

    @Test
    public void exercise3_addProductTest(){
        Product newItem = new Product("Spring Framework Guru Gadget", 0, "https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_gadget-dsfdasgfdshgfgdshsdh98thjg9r8hjg2f1fdghfdhd5_gkmf04_8b56yr_512.jpg", 22.99, "3434239393495566778", 0);
        //TODO
    }

    @Test
    public void exercise4_deleteProductTest(){
        final int productId = 2;
        //TODO
    }

    @Test
    public void exercise5_updateProductTest(){
        //TODO
    }
}
