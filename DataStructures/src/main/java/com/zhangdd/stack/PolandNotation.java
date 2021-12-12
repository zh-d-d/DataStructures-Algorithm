package com.zhangdd.stack;


import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhangdd on 2021/10/10
 */
public class PolandNotation {


    public String infix2suffix(String infixExpression) {
        //将中缀表达式转化成集合方便遍历
        char[] chars = infixExpression.toCharArray();
        List<String> elements = new ArrayList<>();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            builder.append(c);
            //当前字符是数字，且下一位未越界且也是数字
            if (String.valueOf(c).matches("\\d+")
                    && i + 1 < chars.length && String.valueOf(chars[i + 1]).matches("\\d+")) {
            } else {
                elements.add(builder.toString());
                builder.delete(0, builder.length());
            }
        }


        //将中缀表达式转换为后缀表达式
        Stack<String> s1 = new Stack<>();
        List<String> s2 = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            String s = elements.get(i);
            if (s.matches("\\d+")) {
                s2.add(s);
            } else if (s.equals("(")) {
                s1.push(s);
            } else if (s.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();
            } else {
                while (true) {
                    if (s1.isEmpty() || s1.peek().equals("(")) {
                        s1.push(s);
                        break;
                    } else if (OpeEnum.obtainOpe(s).getPriority() >
                            OpeEnum.obtainOpe(s1.peek()).getPriority()) {
                        s1.push(s);
                        break;
                    } else {
                        s2.add(s1.pop());
                    }
                }
            }
        }

        while (!s1.isEmpty()) {
            s2.add(s1.pop());
        }
        return String.join(" ", s2);
    }


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
        ADD("+", 1),
        SUB("-", 1),
        MULTI("*", 2),
        DIV("/", 2),
        ;

        private static final Map<String, OpeEnum> values = Arrays.stream(OpeEnum.values()).collect(Collectors.toMap(OpeEnum::getOpe, item -> item));

        private String ope;
        private int priority;

        OpeEnum(String ope, int priority) {
            this.ope = ope;
            this.priority = priority;
        }

        public String getOpe() {
            return ope;
        }

        public int getPriority() {
            return priority;
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
