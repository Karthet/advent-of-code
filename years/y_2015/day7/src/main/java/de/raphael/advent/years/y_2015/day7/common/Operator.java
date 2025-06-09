package de.raphael.advent.years.y_2015.day7.common;

import java.util.function.BinaryOperator;

public enum Operator {
    AND("AND", (l,r) -> checkBinary(l & r)),
    OR("OR", (l,r) -> checkBinary(l | r)),
    RSHIF("RSHIFT", (l,r) -> checkBinary(l >> r)),
    LSHIFT("LSHIFT", (l,r) -> checkBinary(l << r)),
    NOT("NOT", (l,r) -> checkBinary(~l)),
    SIGNAL("SIGNAL", (l, r) -> checkBinary(l)),
    COPY("COPY", (l,r) -> checkBinary(l));


    public final String operatorName;
    public final BinaryOperator<Integer> operate;

    Operator(String operatorName, BinaryOperator<Integer> operate) {
        this.operatorName = operatorName;
        this.operate = operate;
    }

    private static Integer checkBinary(Integer integer) {
        if (integer < 0 || integer > 0xffff) {
            return integer & 0xffff;
        } else {
            return integer;
        }
    }
}
