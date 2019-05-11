package com.ecommerce.order.about;

import com.ecommerce.order.BaseApiTest;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;

class AboutControllerApiTest extends BaseApiTest {

    @Test
    public void should_display_about_info() {
        given()
                .when()
                .get("/about")
                .then()
                .statusCode(200)
                .body("deployTime", containsString("Asia/Shanghai"))
                .body("author", is("tw"));
    }

    @Test
    public void should_display_authors_address() {
        given()
                .when()
                .get("/about")
                .then()
                .statusCode(200)
                .body("deployTime", containsString("Asia/Shanghai"))
                .body("company", is("ThoughtWorks"));
    }
}