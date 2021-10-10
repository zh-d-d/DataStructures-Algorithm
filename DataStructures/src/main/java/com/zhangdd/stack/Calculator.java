package com.zhangdd.stack;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhangdd on 2021/10/10
 */
public class Calculator {

    /**
     * 计算表达式的值，暂时不对表达式的合法性做校验
     */
    public int calculate(String expression) {
        char[] chars = expression.toCharArray();

        ArrayStack numStack = new ArrayStack(20);
        ArrayStack opeStack = new ArrayStack(20);

        int currentIndex = -1;


        StringBuilder tempValueBuilder = new StringBuilder();

        while (true) {
            //表达式被解析完毕
            if (currentIndex == chars.length - 1) {
                break;
            }

            currentIndex++;
            char c = chars[currentIndex];
            //如果是操作符
            if (isOpe(c)) {

                if (opeStack.isEmpty() || OpeEnum.obtainOpe(c).priority >= OpeEnum.obtainOpe((char) opeStack.peek()).priority) {
                    opeStack.push(c);
                } else {
                    int num2 = numStack.pop();
                    int num1 = numStack.pop();
                    int ope = opeStack.pop();
                    int calculateResult = doCalculator(num1, num2, (char) ope);
                    numStack.push(calculateResult);
                    opeStack.push(c);
                }

            } else {
                tempValueBuilder.append(c);

                //当前字符是数字的情况下，下一位未越界并且还是数字
                if (chars.length > currentIndex + 1 && !isOpe(chars[currentIndex + 1])) {
                    continue;
                } else {
                    numStack.push(Integer.parseInt(tempValueBuilder.toString()));
                    tempValueBuilder.delete(0, tempValueBuilder.length());
                }

            }

        }

        while (true) {
            if (opeStack.isEmpty()) {
                break;
            }
            int num2 = numStack.pop();
            int num1 = numStack.pop();
            int ope = opeStack.pop();
            int calculateResult = doCalculator(num1, num2, (char) ope);
            numStack.push(calculateResult);
        }

        return numStack.peek();
    }

    private int doCalculator(int num1, int num2, char ope) {
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

    /**
     * 判断当前字符是不是操作符
     */
    private boolean isOpe(char c) {
        return OpeEnum.getValues().get(c) != null;
    }


    public static class ArrayStack {
        private int[] stack;
        private final int stackSize;
        private int top = -1;


        public ArrayStack(int stackSize) {
            this.stackSize = stackSize;
            stack = new int[stackSize];
        }

        /**
         * 当前栈是否满
         * <p>
         * 栈顶索引位置等于栈的大小减1
         */
        private boolean isFull() {
            return top == stackSize - 1;
        }

        /**
         * 当前栈是否为空
         * <p>
         * 栈顶索引位置等于-1
         */
        private boolean isEmpty() {
            return top == -1;
        }

        public void push(int value) {
            if (isFull()) {
                System.out.println("当前栈已满");
                return;
            }
            top++;
            stack[top] = value;
        }

        public int pop() {
            int value = peek();
            top--;
            return value;
        }

        public int peek() {
            if (isEmpty()) {
                throw new RuntimeException("当前栈为空");
            }
            return stack[top];
        }


    }


    /**
     * 操作符
     * <p>
     * 操作符描述和优先级，优先级是整型数字 数字越大优先级表示当前操作符优先级越高
     */
    public enum OpeEnum {
        ADD('+', 1),
        SUB('-', 1),
        MULTI('*', 2),
        DIV('/', 2),
        ;
        private char ope;
        private int priority;

        private static final Map<Character, OpeEnum> values = Arrays.stream(OpeEnum.values())
                .collect(Collectors.toMap(item -> item.ope, item -> item));

        OpeEnum(char ope, int priority) {
            this.ope = ope;
            this.priority = priority;
        }

        public char getOpe() {
            return ope;
        }

        public int getPriority() {
            return priority;
        }

        public static Map<Character, OpeEnum> getValues() {
            return values;
        }

        /**
         * 判断获取表达式的操作符
         */
        public static OpeEnum obtainOpe(char ope) {
            OpeEnum opeEnum = values.get(ope);
            if (null == opeEnum) {
                throw new RuntimeException("暂不支持的类型");
            }
            return opeEnum;
        }
    }
}
