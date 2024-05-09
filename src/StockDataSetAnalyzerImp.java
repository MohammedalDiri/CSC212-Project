import java.util.Date;

public class StockDataSetAnalyzerImp implements StockDataSetAnalyzer
{
    StockHistoryDataSet SDSAI ;

    public StockDataSetAnalyzerImp()
    {
        SDSAI = new StockHistoryDataSetImp();
    }

    @Override
    public StockHistoryDataSet getStockHistoryDataSet()
    {
        return SDSAI;
    }

    @Override
    public void setStockHistoryDataSet(StockHistoryDataSet stockHistoryDataSet)
    {
        this.SDSAI = stockHistoryDataSet ;
    }

    // this is a bomb method im not sure at all about it
    @Override
    public DLLComp<CompPair<String, Double>> getSortedByPerformance(Date startDate, Date endDate)
    {
        DLLComp<CompPair<String, Double>> FinalCompanies = new DLLCompImp<>() ;

       if(SDSAI.getStockHistoryMap().empty() || startDate == null || endDate == null)
           return FinalCompanies ;


        DLLImp<StockHistory> AllCompaniesStockHistory = SDSAI.getAllCompanyStockHistory() ;

        AllCompaniesStockHistory.findFirst();
        for(int i = 0 ; i < AllCompaniesStockHistory.size() ; i++)
        {
                StockHistory currentCompany = AllCompaniesStockHistory.retrieve();
                String CurrentCompanyCode = currentCompany.getCompanyCode() ;
                TimeSeries<StockData> tmpSeries = currentCompany.getTimeSeries();
                DLL<DataPoint<StockData>> allDataPointsInRange = tmpSeries.getDataPointsInRange(startDate, endDate);

                if (allDataPointsInRange.size() > 1)
                {
                    allDataPointsInRange.findFirst();
                    double startPrice = allDataPointsInRange.retrieve().value.close; // Price at the start of the date range

                    double endPrice = 0.0;



                    endPrice = allDataPointsInRange.getLast().data.value.close; // Price at the end of the date range

                    double performance = ((endPrice - startPrice) / startPrice) * 100;
                    FinalCompanies.insert(new CompPair<>(currentCompany.getCompanyCode(), performance));
                }
                AllCompaniesStockHistory.findNext();
            }


    FinalCompanies.sort(true);
    return FinalCompanies ;
    }

    @Override
    public DLLComp<CompPair<String, Long>> getSortedByVolume(Date startDate, Date endDate) {
        return null;
    }

    @Override
    public DLLComp<CompPair<Pair<String, Date>, Double>> getSortedByMSDPI(Date startDate, Date endDate) {
        return null;
    }
}
