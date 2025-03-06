package com.avocado.tradeBook;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TradeBookService {

    private final JdbcTemplate jdbcTemplate;

    public void insertBulkData() {

        jdbcTemplate.update("DELETE FROM trade_books");
        jdbcTemplate.update("ALTER TABLE trade_books AUTO_INCREMENT = 1");
        System.out.println("Deleted old records from trade_books.");

        String sql = """
            INSERT INTO trade_books (oid, tms_detail_id, clientMemberCode, symbol, securityName, tradeTime, 
            exchangeTradeId, exchangeOrderId, buyOrSell, tradePrice, tradedQuantity, 
            disclosedQuantity, displayName, created_at, updated_at)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;

        List<Object[]> batchArgs = new ArrayList<>();

        for (int i = 1; i <= 1000; i++) {
            Timestamp createdAt = Timestamp.from(Instant.now());
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Timestamp updatedAt = Timestamp.from(Instant.now());

            long tmsDetailId = 1111 + ((i -1 ) / 10);

            String symbol = SymbolGenerator.getRandomSymbol();
            String security = SecurityGenerator.getRandomSecurity();

            batchArgs.add(new Object[]{
                    UUID.randomUUID().toString(),
                    tmsDetailId,
                    "Client_" + i,
                    symbol,
                    security,
                    createdAt,
                    "ETID" + i,
                    "EOID" + i,
                    (i % 2 == 0) ? 1 : 0,
                    BigDecimal.valueOf(100.50 + i),
                    10 + i,
                    5,
                    "Dipak_" + i,
                    createdAt,
                    updatedAt
            });
        }
            try {
                jdbcTemplate.batchUpdate(sql, batchArgs);
                System.out.println("Inserted 1000 records into trade_books with similar TMS IDs.");
            }
            catch (Exception e) {
                System.out.println("Error occurred while inserting data: " + e.getMessage());
        }
    }
}
