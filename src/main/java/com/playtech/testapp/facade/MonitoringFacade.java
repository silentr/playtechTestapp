package com.playtech.testapp.facade;

import com.playtech.testapp.operation.Operation;
import com.playtech.testapp.operation.OperationType;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Path("/")
public class MonitoringFacade {

    @GET
    @Path("/operation/{type}/data/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Operation> getOperations(@PathParam("type") String type, @PathParam("userId")Long userId) {
        OperationType operationType = OperationType.valueOf(type.toUpperCase());

        //service call that will query DB based on userId and operationType should be present here
        //it might look like this
        //List<Operation> operations = operationService.getLastHourOperations(operationType, userId);

        //stub operations
        List<Operation> operations = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            Operation op = new Operation();
            op.setUserId(userId);
            op.setType(operationType);

            Map<String, Object> data = new HashMap<>();

            for (String field : operationType.getFields()) {
                data.put(field, "Value" + random.nextInt(10000));
            }

            op.setData(data);
            operations.add(op);
        }

        return operations;
    }

    @GET
    @Path("/operation/{type}/definition")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getOperationFields(@PathParam("type") String type) {
        OperationType operationType = OperationType.valueOf(type.toUpperCase());

        return operationType.getFields();
    }
}
