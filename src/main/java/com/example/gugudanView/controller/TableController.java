package com.example.gugudanView.controller;

import com.example.gugudanView.dto.TableResponse;
import com.example.gugudanView.service.TableService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tables")
@CrossOrigin // (필요 시) 다른 포트에서 접근 허용
public class TableController {

    private final TableService tableService;

    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    // 예: /api/tables/7?op=mul  또는 /api/tables/7?op=div
    @GetMapping("/{dan}")
    public TableResponse getTable(
            @PathVariable int dan,
            @RequestParam(required = false, defaultValue = "mul") String op
    ) {
        return tableService.buildTable(dan, op);
    }
}
