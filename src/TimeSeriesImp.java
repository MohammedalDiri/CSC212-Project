import javax.xml.crypto.Data;
import java.util.Date;

public class TimeSeriesImp<T> implements TimeSeries<T> { // This class stores a set of data points in a DLL.
    // We know it's a DLL because of the method getAllDataPoints.
    BST<Date, DataPoint<T>> dataPoints;

    public TimeSeriesImp() {
        dataPoints = new BST<>();
    }

    @Override
    public int size() {
        return dataPoints.size(); // Size of the BST
    }

    @Override
    public boolean empty() {
        return dataPoints.empty(); // Check if the BST is empty
    }

    @Override
    public T getDataPoint(Date date) {
        if (dataPoints.find(date)) { // Search for the date in BST
            return dataPoints.retrieve().value;
        }
        return null; // Date not found, return null
    }

    @Override
    public DLL<Date> getAllDates() {
        // Getting all keys from BST, which are the dates
        DLLComp<Date> dates = dataPoints.getKeys();
        return dates; // Could just return it straight away.
    }

    @Override
    public Date getMinDate() {
        return (dataPoints.find_min(dataPoints.root).key) ; // Find the minimum date in BST
    }

    @Override
    public Date getMaxDate() {
        return (dataPoints.find_max(dataPoints.root).key) ;  // Find the maximum date in BST
    }

    @Override
    public boolean addDataPoint(DataPoint<T> dataPoint) {
        return dataPoints.insert(dataPoint.date, dataPoint); // Insert new data point into BST
    }

    @Override
    public boolean updateDataPoint(DataPoint<T> dataPoint) {
        if (dataPoints.find(dataPoint.date)) { // Find the data point in BST
            dataPoints.update(dataPoint); // Update it
            return true;
        }
        return false; // Data point not found
    }

    @Override
    public boolean removeDataPoint(Date date) {
        return dataPoints.remove(date); // Remove the data point by date
    }

    @Override
    public DLL<DataPoint<T>> getAllDataPoints() {
//        DLL<DataPoint<T>> allDataPoints = new DLLImp<>();
//        DLLComp<Date> tmp = dataPoints.getKeys();
//        tmp.findFirst();
//        while(!tmp.last()) { // Loop through all dates
//            dataPoints.find(tmp.retrieve());
//            DataPoint<T> tmpElement = dataPoints.current.data;
//            allDataPoints.insert(tmpElement); // Insert each data point into the DLL
//            tmp.findNext();
//        }
//        dataPoints.find(tmp.retrieve()) ;
//        DataPoint<T> tmpElement = dataPoints.current.data;
//        allDataPoints.insert(tmpElement); // Insert each data point into the DLL
//        return allDataPoints;

        return dataPoints.getData(); // Way better Time comp, check the BST class for details.
    }

    @Override
    public DLL<DataPoint<T>> getDataPointsInRange(Date startDate, Date endDate) {
        DLL<DataPoint<T>> pointsInRange = new DLLImp<>();
        if (startDate == null)
            startDate = getMinDate() ;
        if (endDate == null)
            endDate = getMaxDate() ;
        if(dataPoints.empty())
            return pointsInRange;

        DLLComp<Date> tmp = dataPoints.getKeys() ;
        DLL<DataPoint<T>> SortedData = dataPoints.getData();
        tmp.findFirst();
        SortedData.findFirst();
        while(!tmp.last()) {
            if ( (tmp.retrieve().compareTo(startDate) >= 0 && tmp.retrieve().compareTo(endDate) <= 0) )
                      pointsInRange.insert(SortedData.retrieve()); // Insert data points within the specified range
            tmp.findNext();
            SortedData.findNext(); // Both lists are sorted, and their pointers move together with each iteration.
        }
        return pointsInRange;
    }
}

