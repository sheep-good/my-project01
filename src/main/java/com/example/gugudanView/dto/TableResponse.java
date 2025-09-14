package com.example.gugudanView.dto;

import java.util.List;

public class TableResponse {
    private int dan;
    private String op; // "mul" or "div"
    private List<TableRow> rows;

    public TableResponse(int dan, String op, List<TableRow> rows) {
        this.dan = dan;
        this.op = op;
        this.rows = rows;
    }
    public int getDan() { return dan; }
    public String getOp() { return op; }
    public List<TableRow> getRows() { return rows; }
}
