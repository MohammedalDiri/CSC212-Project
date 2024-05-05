import java.util.Date;

public class NumericTimeSeriesImp implements NumericTimeSeries{
    TimeSeries<Double> TimeSeries;

    public NumericTimeSeriesImp()
    {
        TimeSeries = new TimeSeriesImp<Double>();
    }


    @Override
    public NumericTimeSeries calculateMovingAverage(int period)
    { if(period <= 0 || TimeSeries.empty() )
            return new NumericTimeSeriesImp();

        NumericTimeSeries result = new NumericTimeSeriesImp();

        DLL<DataPoint<Double>> allDataPoints = TimeSeries.getAllDataPoints();
        int DataSize = allDataPoints.size();

        if(DataSize < period) // If there is fewer data points than the period, return an empty series.
            return result;

        allDataPoints.findFirst();

        double sum = 0 ;
        for(int i = 0 ; i < period ; i++) // // calc the sum with the first period data points
        {
                sum += allDataPoints.retrieve().value ;
            if (i < period - 1)
                allDataPoints.findNext();
        }

        // Calculate the first average and add it to the results
        DataPoint<Double> currentDataPoint = allDataPoints.retrieve();
        double average = sum / period;
        result.addDataPoint(new DataPoint<Double>(currentDataPoint.date, average));


        allDataPoints.findFirst();  // Start from the beginning of the list again
        for (int i = 0; i < DataSize - period; i++) {
            sum -= allDataPoints.retrieve().value;  // Subtract the element that's leaving the window
            allDataPoints.findNext();
            allDataPoints.findNext();
            currentDataPoint = allDataPoints.retrieve();
            sum += currentDataPoint.value;

            average = sum / period;  // Calculate new average
            result.addDataPoint(new DataPoint<Double>(currentDataPoint.date, average));
            allDataPoints.findPrevious();  // Move back to the start of the window for the next iteration
        }
        return result ;

    }

    @Override
    public DataPoint<Double> getMax()
    {
        if(TimeSeries.empty())
         return null;
        DLL<DataPoint<Double>> tmp = TimeSeries.getAllDataPoints();

        tmp.findFirst(); ;

        DataPoint<Double> max = tmp.retrieve() ;
        while(!tmp.last())
        {
            tmp.findNext();
        }
        return tmp.retrieve();
    }

    @Override
    public DataPoint<Double> getMin()
    {
        if(TimeSeries.empty())
            return null;


        DLL<DataPoint<Double>> tmp = TimeSeries.getAllDataPoints();
        tmp.findFirst();
        return tmp.retrieve();
    }

    @Override
    public int size()
    {
        return TimeSeries.size();
    }

    @Override
    public boolean empty()
    {
        return TimeSeries.empty();
    }

    @Override
    public Double getDataPoint(Date date)
    {
        if (TimeSeries.getDataPoint(date) != null )
        {
            return TimeSeries.getDataPoint(date);
        }
        return 0.0;
    }

    @Override
    public DLL<Date> getAllDates()
    {
        return TimeSeries.getAllDates();
    }

    @Override
    public Date getMinDate()
    {
        return TimeSeries.getMinDate() ;
    }

    @Override
    public Date getMaxDate()
    {
        return TimeSeries.getMaxDate() ;
    }

    @Override
    public boolean addDataPoint(DataPoint<Double> dataPoint)
    {
        return TimeSeries.addDataPoint(dataPoint) ;
    }

    @Override
    public boolean updateDataPoint(DataPoint<Double> dataPoint)
    {
        if ( TimeSeries.getDataPoint(dataPoint.date) != null ) {
            TimeSeries.updateDataPoint(dataPoint) ;
            return true;
        }
        return false;
    }

    @Override
    public boolean removeDataPoint(Date date)
    {
        return TimeSeries.removeDataPoint(date) ;
    }

    @Override
    public DLL<DataPoint<Double>> getAllDataPoints()
    {
        return TimeSeries.getAllDataPoints() ;
    }

    @Override
    public DLL<DataPoint<Double>> getDataPointsInRange(Date startDate, Date endDate)
    {
      return TimeSeries.getDataPointsInRange(startDate, endDate) ;
    }




}
