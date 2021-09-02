package com.sheikhimtiaz;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OperatorFactory {


    public interface Operation {
        int apply(int a, int b);
    }

    public static class Addition implements Operation {
        @Override
        public int apply(int a, int b) {
            return a + b;
        }
    }
    public static class Division implements Operation {
        @Override
        public int apply(int a, int b) {
            return a / b;
        }
    }

    static Map<String, Operation> operationMap = new HashMap<>();
    static {
        operationMap.put("add", new Addition());
        operationMap.put("divide", new Division());
        // more operators
    }

    public static Optional<Operation> getOperation(String operator) {
        return Optional.ofNullable(operationMap.get(operator));
    }
}

