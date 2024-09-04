package com.eq.epharma.repo;
import java.util.ArrayList;
import java.util.List;


import com.eq.epharma.dto.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReportRepoImpl implements ReportRepo {
    
    private final JdbcTemplate jt;

        public ReportRepoImpl(JdbcTemplate jt) {
        this.jt = jt;
    }

        @Override
        public List<SalesDto> getSalesByDate(ReportDto report) {
            String sql="SELECT s.salesId, u.username, m.medicineName, s.quantity, s.price, s.checkOutDate, s.expiryDate, s.batchNo, s.systemDateTime  FROM Sales s INNER JOIN Medicines m ON s.medicineId = m.medicineId INNER JOIN Users u ON s.entryBy=u.userId where s.checkOutDate between ? and ?";
            try {
                return this.jt.query(sql, BeanPropertyRowMapper.newInstance(SalesDto.class),report.getStartDate(),report.getEndDate());
            } catch (Exception e) {                
                return new ArrayList<SalesDto>();
            }
        }

        @Override
        public List<StockDto> getStockByDate(ReportDto report) {
            String sql="SELECT s.stockId, u.username, m.medicineName, s.quantity, s.price, s.checkInDate, s.expiryDate, s.batchNo, s.systemDateTime FROM Stock s INNER JOIN Medicines m ON s.medicineId = m.medicineId INNER JOIN Users u ON s.entryBy=u.userId where checkInDate between ? and ?";
            try {
                return this.jt.query(sql, BeanPropertyRowMapper.newInstance(StockDto.class),report.getStartDate(),report.getEndDate());
            } catch (Exception e) {                
                return new ArrayList<StockDto>();
            }

                  
        }

        @Override
        public List<AvlStockDto> getAvlStock() {
            String sql = "SELECT m.medicineName, SUM(s.quantity) - COALESCE(t.totalSales, 0) as availableStock\n" +
             "FROM stock s\n" +
             "JOIN medicines m ON s.medicineId = m.medicineId\n" +
             "LEFT JOIN (\n" +
             "    SELECT medicineId, SUM(quantity) as totalSales\n" +
             "    FROM sales\n" +
             "    GROUP BY medicineId\n" +
             ") t ON m.medicineId = t.medicineId\n" +
             "GROUP BY m.medicineName;";
            try {
                return this.jt.query(sql, BeanPropertyRowMapper.newInstance(AvlStockDto.class));
            } catch (Exception e) {                
                return new ArrayList<AvlStockDto>();
            }
        }


    @Override
    public AvlStockDto getAvlStockByMedicineId(int medicationId) {
        String sql = """
                        SELECT m.medicineName,m.medicineId, SUM(s.quantity) - COALESCE(t.totalSales, 0) as availableStock
                        FROM stock s
                        JOIN medicines m ON s.medicineId = m.medicineId
                        LEFT JOIN (
                        SELECT medicineId, SUM(quantity) as totalSales
                        FROM sales
                        GROUP BY medicineId
                        ) t ON m.medicineId = t.medicineId where s.medicineId=?
                        GROUP BY m.medicineName;
                        """;
        try {
            return this.jt.queryForObject(sql, BeanPropertyRowMapper.newInstance(AvlStockDto.class),medicationId);
        } catch (Exception e) {
            return new AvlStockDto();
        }
    }

    @Override
    public List<AvlStockInBatchDto> getAvlStockAccordingToBatchNoAndExpiryDate() {
        String sql = "SELECT m.medicineName, m.medicineId,\n" +
                "       s.batchNo, \n" +
                "       s.expiryDate, \n" +
                "       s.quantity - COALESCE(sa.soldQuantity, 0) AS avlStock \n" +
                "FROM stock s \n" +
                "INNER JOIN medicines m ON s.medicineId = m.medicineId\n" +
                "LEFT JOIN (\n" +
                "  SELECT medicineId, batchNo, expiryDate, SUM(quantity) AS soldQuantity \n" +
                "  FROM sales \n" +
                "  GROUP BY medicineId, batchNo, expiryDate\n" +
                ") sa \n" +
                "ON s.medicineId = sa.medicineId \n" +
                "   AND s.batchNo = sa.batchNo \n" +
                "   AND s.expiryDate = sa.expiryDate ";
        try {
            return this.jt.query(sql, BeanPropertyRowMapper.newInstance(AvlStockInBatchDto.class));
        } catch (Exception e) {
            return new ArrayList<AvlStockInBatchDto>();
        }
    }
}
