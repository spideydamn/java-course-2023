package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Task6Test {
    void compareStocks(Task6.Stock stock1, Task6.Stock stock2) {
        if (stock1 != null) {
            assertEquals(stock1.price(), stock2.price());
            assertEquals(stock1.name(), stock2.name());
        } else {
            assertNull(stock2);
        }
    }

    @Test
    @DisplayName("Проверка работы всех команд")
    void testingAllCommands() {
        Task6.StockMarketExample stockMarket = new Task6.StockMarketExample();

        stockMarket.add(new Task6.Stock("Tatneft", 625));
        compareStocks(new Task6.Stock("Tatneft", 625), stockMarket.mostValuableStock());

        stockMarket.add(new Task6.Stock("BSPB", 248));
        compareStocks(new Task6.Stock("Tatneft", 625), stockMarket.mostValuableStock());

        stockMarket.add(new Task6.Stock("VTB", 1));
        compareStocks(new Task6.Stock("Tatneft", 625), stockMarket.mostValuableStock());

        stockMarket.add(new Task6.Stock("Bashneft", 1626));
        compareStocks(new Task6.Stock("Bashneft", 1626), stockMarket.mostValuableStock());

        stockMarket.remove(new Task6.Stock("BSPB", 248));
        compareStocks(new Task6.Stock("Bashneft", 1626), stockMarket.mostValuableStock());

        stockMarket.remove(new Task6.Stock("Bashneft", 1626));
        compareStocks(new Task6.Stock("Tatneft", 625), stockMarket.mostValuableStock());

        stockMarket.remove(new Task6.Stock("Tatneft", 625));
        compareStocks(new Task6.Stock("VTB", 1), stockMarket.mostValuableStock());

        stockMarket.remove(new Task6.Stock("VTB", 1));
        compareStocks(null, stockMarket.mostValuableStock());

        stockMarket.remove(new Task6.Stock("Gazprom", 167));
        compareStocks(null, stockMarket.mostValuableStock());

        stockMarket.add(new Task6.Stock("VK", 578));
        compareStocks(new Task6.Stock("VK", 578), stockMarket.mostValuableStock());
    }
}
