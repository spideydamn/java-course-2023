package edu.hw3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Task6 {
    private Task6() {
    }

    public static Comparator<Stock> stockPriceComparator = (stock1, stock2) -> stock2.price - stock1.price;

    interface StockMarket {
        void add(Stock stock);

        void remove(Stock stock);

        Stock mostValuableStock();
    }

    public record Stock(String name, Integer price) {
    }

    public static class StockMarketExample implements StockMarket {
        private final PriorityQueue<Stock> stocks = new PriorityQueue<>(stockPriceComparator);

        @Override
        public void add(Stock stock) {
            stocks.add(stock);
        }

        @Override
        public void remove(Stock stock) {
            stocks.remove(stock);
        }

        @Override
        public Stock mostValuableStock() {
            return stocks.peek();
        }
    }
}
