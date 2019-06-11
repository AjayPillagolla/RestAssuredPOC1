package catalog.utils;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class ReusableSpecificatons {

    public static ResponseSpecBuilder respec;
    public static ResponseSpecification responseSpecification;

    public static ResponseSpecification getGenericResponsespec() {
        respec =new ResponseSpecBuilder();
        respec.expectHeader("content-type", "application/json;charset=UTF-8");
        respec.expectHeader("server", "envoy");
        respec.expectHeader("transfer-encoding", "chunked");
        respec.expectHeader("Via", "1.1 google");
        responseSpecification = respec.build();
        return responseSpecification;

    }

}
