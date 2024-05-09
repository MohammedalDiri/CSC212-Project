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

       DLLComp<String> AllCompaniesCodes = SDSAI.getAllCompanyCodes() ;
       AllCompaniesCodes.findFirst();
        for(int i = 0 ; i < AllCompaniesCodes.size() ; i++)
        {
            String companyCode = AllCompaniesCodes.retrieve();
            if (SDSAI.getStockHistoryMap().find(companyCode)) {
                StockHistory currentCompany = SDSAI.getStockHistoryMap().retrieve();
                TimeSeries<StockData> tmpSeries = currentCompany.getTimeSeries();
                DLL<DataPoint<StockData>> allDataPointsInRange = tmpSeries.getDataPointsInRange(startDate, endDate);

                if (allDataPointsInRange.size() > 1) {
                    allDataPointsInRange.findFirst();
                    double startPrice = allDataPointsInRange.retrieve().value.open; // Price at the start of the date range

                    double endPrice = 0.0;
                    while (!allDataPointsInRange.last()) {
                        allDataPointsInRange.findNext(); // Move to the next node
                    }
                    endPrice = allDataPointsInRange.retrieve().value.close; // Price at the end of the date range

                    double performance = ((endPrice - startPrice) / startPrice) * 100;
                    FinalCompanies.insert(new CompPair<>(companyCode, performance));
                }
            }
        }


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
