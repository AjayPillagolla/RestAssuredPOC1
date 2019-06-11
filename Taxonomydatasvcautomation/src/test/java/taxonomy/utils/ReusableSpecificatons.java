package taxonomy.utils;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class ReusableSpecificatons {

    public static ResponseSpecBuilder respec;
    public static ResponseSpecification responseSpecification;

    public static ResponseSpecification getGenericResponsespec() {
        respec =new ResponseSpecBuilder();
        respec.expectHeader("content-type", "application/json;charset=UTF-8");
        respec.expectHeader("transfer-encoding", "chunked");
        responseSpecification = respec.build();
        return responseSpecification;

    }

}
