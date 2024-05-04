import java.util.Date;

public class NumericTimeSeriesImp implements NumericTimeSeries{
    TimeSeries<Double> TimeSeries;
    public NumericTimeSeriesImp() {
        TimeSeries = new TimeSeriesImp<Double>();
    }


    @Override
    public NumericTimeSeries calculateMovingAverage(int period) {
        return null;
    }

    @Override
    public DataPoint<Double> getMax() {
        return null;
    }

    @Override
    public DataPoint<Double> getMin() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean empty() {
        return false;
    }

    @Override
    public Double getDataPoint(Date date) {
        return 0.0;
    }

    @Override
    public DLL<Date> getAllDates() {
        return null;
    }

    @Override
    public Date getMinDate() {
        return null;
    }

    @Override
    public Date getMaxDate() {
        return null;
    }

    @Override
    public boolean addDataPoint(DataPoint<Double> dataPoint) {
        return false;
    }

    @Override
    public boolean updateDataPoint(DataPoint<Double> dataPoint) {
        return false;
    }

    @Override
    public boolean removeDataPoint(Date date) {
        return false;
    }

    @Override
    public DLL<DataPoint<Double>> getAllDataPoints() {
        return null;
    }

    @Override
    public DLL<DataPoint<Double>> getDataPointsInRange(Date startDate, Date endDate) {
        return null;
    }
}
