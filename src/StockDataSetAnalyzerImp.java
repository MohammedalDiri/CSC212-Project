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

        if(SDSAI.empty() || startDate == null || endDate == null)
            return FinalCompanies ;

        DLLImp<StockHistory> AllCompaniesStockHistory = SDSAI.getAllCompanyStockHistory() ;

        AllCompaniesStockHistory.findFirst();

        for(int i = 0 ; i < AllCompaniesStockHistory.size() ; i++)
        {
            StockHistory currentCompany = AllCompaniesStockHistory.retrieve();
            TimeSeries<StockData> tmpSeries = currentCompany.getTimeSeries();

            double startPrice = tmpSeries.getDataPoint(startDate).close;
            double endPrice =  tmpSeries.getDataPoint(endDate).close;
            double performance = ((endPrice - startPrice) / startPrice) ;
            FinalCompanies.insert(new CompPair<>(currentCompany.getCompanyCode(), performance));

            AllCompaniesStockHistory.findNext();
        }


        FinalCompanies.sort(false);
        return FinalCompanies ;
    }

    @Override
    public DLLComp<CompPair<String, Long>> getSortedByVolume(Date startDate, Date endDate)
    {
        DLLComp<CompPair<String, Long>> FinalCompanies = new DLLCompImp<>() ;

        if(SDSAI.empty())
            return FinalCompanies ;


        DLLImp<StockHistory> AllCompaniesStockHistory = SDSAI.getAllCompanyStockHistory() ;

        AllCompaniesStockHistory.findFirst();
        for(int i = 0 ; i < AllCompaniesStockHistory.size() ; i++)
        {
            StockHistory currentCompany = AllCompaniesStockHistory.retrieve();
            TimeSeries<StockData> tmpSeries = currentCompany.getTimeSeries();
            DLL<DataPoint<StockData>> allDataPointsInRange = tmpSeries.getDataPointsInRange(startDate, endDate);

            if (allDataPointsInRange.size() > 1)
            {
                allDataPointsInRange.findFirst();
                long sum = 0;
                for(int j = 0; allDataPointsInRange.size() > j; j++) {
                    sum += allDataPointsInRange.retrieve().value.volume; // Price at the start of the date range
                    allDataPointsInRange.findNext();
                }
                FinalCompanies.insert(new CompPair<>(currentCompany.getCompanyCode(), sum));
            }
            AllCompaniesStockHistory.findNext();
        }
        FinalCompanies.sort(false);
        return FinalCompanies ;
    }

    @Override
    public DLLComp<CompPair<Pair<String, Date>, Double>> getSortedByMSDPI(Date startDate, Date endDate)
    {
        DLLComp<CompPair<Pair<String, Date>, Double>> FinalCompanies = new DLLCompImp<>() ;

        if(SDSAI.empty())
            return FinalCompanies ;


        DLLImp<StockHistory> AllCompaniesStockHistory = SDSAI.getAllCompanyStockHistory() ;

        AllCompaniesStockHistory.findFirst();
        for(int i = 0 ; i < AllCompaniesStockHistory.size() ; i++)
        {
            StockHistory currentCompany = AllCompaniesStockHistory.retrieve();
            TimeSeries<StockData> tmpSeries = currentCompany.getTimeSeries();
            DLL<DataPoint<StockData>> allDataPointsInRange = tmpSeries.getDataPointsInRange(startDate, endDate);

            if (allDataPointsInRange.size() > 1)
            {
                allDataPointsInRange.findFirst();
                double MaxIncrease = 0;
                Date Maxdate = null;
                for(int j = 0; allDataPointsInRange.size() > j; j++)
                {
                    if(MaxIncrease < (allDataPointsInRange.retrieve().value.close - allDataPointsInRange.retrieve().value.open) / allDataPointsInRange.retrieve().value.open) {
                        MaxIncrease = (allDataPointsInRange.retrieve().value.close - allDataPointsInRange.retrieve().value.open) / allDataPointsInRange.retrieve().value.open;
                        Maxdate = allDataPointsInRange.retrieve().date;
                    }
                    allDataPointsInRange.findNext();
                }
                FinalCompanies.insert(new CompPair<>(new Pair<String,Date>(AllCompaniesStockHistory.retrieve().getCompanyCode(), Maxdate), MaxIncrease));
            }
            AllCompaniesStockHistory.findNext();
        }
        FinalCompanies.sort(false);
        return FinalCompanies ;
    }


}
