public class StockLoader_StockHistoryDataSetImp_Test {
    public static void main(String[] args) {
        StockDataLoaderImp st1 = new StockDataLoaderImp();

         st1.loadStockDataFile("/Users/badur/examples/C1.csv");
         StockHistory sh1 = st1.loadStockDataFile("/Users/badur/real/AAPL.csv");
         StockHistory sh2 = st1.loadStockDataFile("/Users/badur/examples/C1.csv");
         if (sh1 != null)
             ((StockHistoryImp) sh1).display();
         else
             System.out.println("StockHistory=" + sh1);

        StockHistoryDataSet dataSet1 = st1.loadStockDataDir("/Users/badur/examples");
        // dataSet1.getStockHistoryMap().dispalyAll_nodes_inorder();
        DLLImp.display(dataSet1.getStockHistoryMap().getKeys());
        System.out.println("all full histories are ");

    }

}
