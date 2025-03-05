package com.avocado.tradeBook;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trade")
@RequiredArgsConstructor
public class TradeBookController {

    private final TradeBookService tradeBookService;


    @GetMapping("/insertBulk")
    public String insertBulkData() {
        tradeBookService.insertBulkData();
        return "Successfully inserted 1000 trade records";
    }
}
