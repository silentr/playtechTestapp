package com.playtech.testapp.operation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum OperationType {

    DEPOSIT,
    TRANSFER,
    WITHDRAWAL;

    private List<String> fields;

    OperationType() {
        this.fields = new ArrayList<>();

        //stubbing field names for operations
        //in real app this field names could be queried from DB and stored in memory for latter use
        //this would not be an enum in that case, but plain class

        for (int i = 0; i < 50; i++) {
            String field = this.name() + "Field" + (i + 1);

            this.fields.add(field);
        }

        this.fields = Collections.unmodifiableList(this.fields);
    }

    public List<String> getFields() {
        return fields;
    }
}
