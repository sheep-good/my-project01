package com.example.gugudanView.service;

import com.example.gugudanView.dto.TableResponse;
import com.example.gugudanView.dto.TableRow;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TableService {

    public TableResponse buildTable(int dan, String op) {
        // op 기본값: mul
        if (op == null || (!op.equals("mul") && !op.equals("div"))) {
            op = "mul";
        }

        List<TableRow> rows = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (op.equals("mul")) {
                int result = dan * i;
                String expr = dan + " x " + i + " = " + result;
                rows.add(new TableRow(dan, i, op, expr, result));
            } else { // div
                double result = (double) dan / i;
                // 소수 둘째 자리까지 표시(프론트에서 표시 조절 가능)
                String expr = dan + " ÷ " + i + " = " + String.format("%.2f", result);
                rows.add(new TableRow(dan, i, op, expr, result));
            }
        }
        return new TableResponse(dan, op, rows);
    }
}
