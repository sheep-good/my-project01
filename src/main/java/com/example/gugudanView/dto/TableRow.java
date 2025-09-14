package com.example.gugudanView.dto;

public class TableRow {
    private int left;       // 단(또는 피제수)
    private int right;      // 1~9
    private String op;      // "mul" or "div"
    private String expr;    // "7 x 3 = 21" 형태
    private double value;   // 결과값(숫자)

    public TableRow(int left, int right, String op, String expr, double value) {
        this.left = left;
        this.right = right;
        this.op = op;
        this.expr = expr;
        this.value = value;
    }
    public int getLeft() { return left; }
    public int getRight() { return right; }
    public String getOp() { return op; }
    public String getExpr() { return expr; }
    public double getValue() { return value; }
}
