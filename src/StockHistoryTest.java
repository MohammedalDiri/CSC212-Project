import java.util.Date;

public class StockHistoryTest {
    public static void main(String[] args) {
        StockHistoryImp st1 = new StockHistoryImp();
        st1.SetCompanyCode("C1.csv");
        System.out.println("company code=" + st1.getCompanyCode());
        System.out.println("size=" + st1.size());
        System.out.println("is empty? :" + st1.empty());
        st1.display();

        System.out.print("all time series =");
        TimeSeries series = st1.getTimeSeries();
        ((TimeSeriesImp) series).display_stock_history();

        st1.removeStockData(new Date(2024 - 1900, 4 - 1, 1));
        System.out.println("----After removing 2024-04-01--------");
        st1.display();

        System.out.println("stock data with date 2024-03-01 is: ");
        StockData stock0 = st1.getStockData(new Date(2024 - 1900, 3 - 1, 1));
        System.out.println(stock0 + " ");
        System.out.println("");

        System.out.println("-----------------------------------");
        System.out.println("--------adding then testing--------");

        Date d1 = new Date(2024 - 1900, 1 - 1, 1);
        StockData stock1 = new StockData(8, 10, 11, 5, 20);
        st1.addStockData(d1, stock1);
        System.out.println("size=" + st1.size());
        st1.display();

        System.out.println("-------------------");

        Date d2 = new Date(2024 - 1900, 2 - 1, 1);
        StockData stock2 = new StockData(12, 11, 14, 10, 30);
        st1.addStockData(d2, stock2);
        System.out.println("size=" + st1.size());
        st1.display();

        System.out.println("-------------------");
        Date d3 = new Date(2024 - 1900, 3 - 1, 1);
        StockData stock3 = new StockData(10, 12, 13, 7, 50);
        st1.addStockData(d3, stock3);
        System.out.println("size=" + st1.size());
        st1.display();
        System.out.println("-------------------");

        Date d4 = new Date(2024 - 1900, 4 - 1, 1);
        StockData stock4 = new StockData(11, 13, 15, 10, 50);
        st1.addStockData(d4, stock4);
        System.out.println("size=" + st1.size());
        st1.display();

        System.out.println("-------------------");

        Date d5 = new Date(2024 - 1900, 5 - 1, 1);
        StockData stock5 = new StockData(10, 14, 16, 9, 40);
        st1.addStockData(d5, stock5);
        System.out.println("size=" + st1.size());
        st1.display();

        System.out.println("-------------------");

        Date d6 = new Date(2024 - 1900, 6 - 1, 1);
        StockData stock6 = new StockData(10, 12, 13, 7, 50);
        st1.addStockData(d6, stock6);
        System.out.println("size=" + st1.size());
        st1.display();


        System.out.println("all time series =");
        TimeSeries series2 = st1.getTimeSeries();
        ((TimeSeriesImp) series).display_stock_history();
        st1.removeStockData(d4);
        System.out.println("----After removing 2024-04-01--------");
        st1.display();

        System.out.print("stock data with date 2024-03-01 is: ");
        StockData stock = st1.getStockData(d3);

        System.out.print(stock.open + " ");
        System.out.print(stock.close + " ");
        System.out.print(stock.high + " ");
        System.out.print(stock.low + " ");
        System.out.println(stock.volume + " ");

        System.out.println("---------after clear-----------");
        st1.clear();
        System.out.println("company code=" + st1.getCompanyCode());
        System.out.println("size=" + st1.size());
        System.out.println("is empty? :" + st1.empty());
        st1.display();



    }

}
