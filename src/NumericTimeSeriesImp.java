import java.util.Date;

public class NumericTimeSeriesImp implements NumericTimeSeries{
    TimeSeries<Double> TimeSeries;

    public NumericTimeSeriesImp()
    {
        TimeSeries = new TimeSeriesImp<Double>();
    }


    @Override
    public NumericTimeSeries calculateMovingAverage(int period)
    {
        return null;
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
            if(tmp.retrieve().value > max.value)
                max = tmp.retrieve() ;

            tmp.findNext();
        }
        return max;
    }

    @Override
    public DataPoint<Double> getMin()
    {
        if(TimeSeries.empty())
            return null;
        DLL<DataPoint<Double>> tmp = TimeSeries.getAllDataPoints();

        tmp.findFirst(); ;

        DataPoint<Double> min = tmp.retrieve() ;

        while(!tmp.last())
        {
            if(tmp.retrieve().value < min.value)
                min = tmp.retrieve() ;

            tmp.findNext();
        }
        return min;
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
