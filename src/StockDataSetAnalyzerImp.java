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

    @Override
    public DLLComp<CompPair<String, Double>> getSortedByPerformance(Date startDate, Date endDate)
    {
        DLLComp<CompPair<String, Double>> FinalCompanies = new DLLCompImp<>() ;
       if( startDate == null || endDate == null )
            return null;

       if(SDSAI.getStockHistoryMap().empty())
           return FinalCompanies ;

       DLLComp<String> AllCompaniesCodes = SDSAI.getAllCompanyCodes() ;
       AllCompaniesCodes.findFirst();
       while(!AllCompaniesCodes.last())
       {
           if(SDSAI.getStockHistoryMap().find(AllCompaniesCodes.retrieve())) // current will be in the right company
           {
               StockHistory CurrentCompany = SDSAI.getStockHistoryMap().retrieve() ;
               TimeSeries<StockData> tmpSeries = CurrentCompany.getTimeSeries() ;
               DLL<DataPoint<StockData>> allDataPointsInRange = tmpSeries.getDataPointsInRange(startDate, endDate) ;
           }


       }
        if(SDSAI.getStockHistoryMap().find(AllCompaniesCodes.retrieve())) // current will be in the right company
        {
            StockHistory CurrentCompany = SDSAI.getStockHistoryMap().retrieve() ;
            TimeSeries<StockData> tmpSeries = CurrentCompany.getTimeSeries() ;
            DLL<DataPoint<StockData>> allDataPointsInRange = tmpSeries.getDataPointsInRange(startDate, endDate) ;
        }
        //this is not finished i just gave up on it midWay , the 3 methods are same and the
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
