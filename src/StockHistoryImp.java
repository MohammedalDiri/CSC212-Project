import java.util.Date;

public class StockHistoryImp implements StockHistory {
    /*
     * A basic definition of this class is that it's basically a Time Series,
     * but rather than storing a generic type we'll store Stock data (CHeck the class).
     * The class is very clear, and our choice for bst is 100% the best for optimization.
     */
    TimeSeriesImp<StockData> SDTSI; // stands for stockDataTimeSeriesImp
    String companyCode;

    public StockHistoryImp() {
        SDTSI = new TimeSeriesImp<>();
    }

    @Override
    public int size() {
        return SDTSI.size();
    }

    @Override
    public boolean empty() {
        return SDTSI.empty();
    }

    @Override
    public void clear() { // I added clear to the timeSeries class.
        SDTSI.clear();
    }

    @Override
    public String getCompanyCode() { // normal setters and getters for the company code.
        return companyCode;
    }

    public void SetCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    @Override
    public TimeSeries<StockData> getTimeSeries() {
        return SDTSI; // idk is this is correct.
    }

    @Override
    public StockData getStockData(Date date) {
        return SDTSI.getDataPoint(date);
    }

    public boolean addStockData(Date date, StockData stockData) {
        DataPoint<StockData> newStockData = new DataPoint<>(date, stockData);
        return SDTSI.addDataPoint(newStockData);
    }

    @Override
    public boolean removeStockData(Date date) {
        return SDTSI.removeDataPoint(date);
    }

    public void display() {
        ((TimeSeriesImp) SDTSI).display_stock_history();
    }
}