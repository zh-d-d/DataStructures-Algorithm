package com.zhangdd.stack;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author zhangdd on 2021/10/10
 */
public class PolandNotation {

    public int calculate(String suffixExpression) {
        String[] values = suffixExpression.split(" ");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < values.length; i++) {
            String value = values[i];
            if (isNum(value)) {
                stack.push(value);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int calculateValue = doCalculator(num1, num2, value);
                stack.push(String.valueOf(calculateValue));
            }
        }

        return Integer.parseInt(stack.peek());
    }

    @SuppressWarnings("DuplicatedCode")
    private int doCalculator(int num1, int num2, String ope) {
        OpeEnum opeEnum = OpeEnum.obtainOpe(ope);
        int result = 0;
        switch (opeEnum) {
            case ADD:
                result = num1 + num2;
                break;
            case SUB:
                result = num1 - num2;
                break;
            case MULTI:
                result = num1 * num2;
                break;
            case DIV:
                result = num1 / num2;
                break;
        }
        return result;
    }

    private boolean isNum(String s) {
        return s.matches("\\d+");
    }

    public enum OpeEnum {
        ADD("+"),
        SUB("-"),
        MULTI("*"),
        DIV("/"),
        ;

        private static final Map<String, OpeEnum> values = Arrays.stream(OpeEnum.values()).collect(Collectors.toMap(OpeEnum::getOpe, item -> item));

        private String ope;

        OpeEnum(String ope) {
            this.ope = ope;
        }

        public String getOpe() {
            return ope;
        }

        public Map<String, OpeEnum> getValues() {
            return values;
        }

        public static OpeEnum obtainOpe(String ope) {
            OpeEnum opeEnum = values.get(ope);
            if (opeEnum == null) {
                throw new RuntimeException("操作符不存在");
            }
            return opeEnum;
        }
    }

}
