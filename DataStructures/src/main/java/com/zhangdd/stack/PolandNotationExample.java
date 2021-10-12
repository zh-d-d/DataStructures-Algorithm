package com.zhangdd.stack;

import org.junit.Test;


/**
 * @author zhangdd on 2021/10/10
 */
public class PolandNotationExample {


    @Test
    public void polandNotationTest() {
        //String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
        PolandNotation polandNotation = new PolandNotation();
        String suffixExpression = polandNotation.infix2suffix("1+((3+3)*4)-5");
        int values = polandNotation.calculate(suffixExpression);
        System.out.println(values);
    }
}
