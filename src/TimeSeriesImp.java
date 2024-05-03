import javax.xml.crypto.Data;
import java.util.Date;

public class TimeSeriesImp<T> implements TimeSeries<T> { // This class stores a set of data points in a DLL.
    // We know it's a DLL because of the method getAllDataPoints.
    DLLCompImp<CompPair<DataPoint<T>, Date>> DataPoints;

    public TimeSeriesImp() {
        DataPoints = new DLLCompImp<CompPair<DataPoint<T>, Date>>();
    }

    @Override
    public int size() {
        return DataPoints.size(); // Returns the lists size.
    }

    @Override
    public boolean empty() { // This method checks whether the list is empty
        return DataPoints.empty();
    }

    @Override
    public T getDataPoint(Date date) { // Time comp:O(n) Space Comp: O(1)
        if (empty()) // If the list is empty return null as per the specs.
            return null;
        else {
            DataPoints.findFirst();
            while (!DataPoints.last()) {
                if (DataPoints.retrieve().second.compareTo(date) == 0) // this checks whether the data point date is equivalent to the date passed.
                    return DataPoints.retrieve().first.value; // If so return first which refers to the data point.
                DataPoints.findNext();
            }
            if (DataPoints.retrieve().second.compareTo(date) == 0) // This checks the last element since its not covered in the loop.
                return DataPoints.retrieve().first.value;

            return null;
        }
    }

    @Override
    public DLL<Date> getAllDates() { // Time comp:(O(nlogn) (sort)) Space Comp: O(n^3)
        if (DataPoints.empty())
            return null;
        else {
            DLL<Date> SortedDate = new DLLCompImp<>(); // Initialize a DLL of dates.
            DataPoints.findFirst();
            while (!DataPoints.last()) {
                SortedDate.insert(DataPoints.retrieve().second); // Inserts dates into the list.
                DataPoints.findNext();
            }
            SortedDate.insert(DataPoints.retrieve().second);
            ((DLLCompImp)SortedDate).sort(true); // This sorts the new made list not our list.
            return SortedDate; // Returns a list of sorted dates.
        }
    }

    @Override
    public Date getMinDate() { // Time comp: O(n) , Space comp O(1),
        if (DataPoints.empty()) // As per the specs of the method, if the list os empty return null.
            return null;
        else {
            return DataPoints.getMin().second; // the method getMin explained in DLLCompImp
        }

    }

    public Date getMaxDate() { // Already explained.
        if (DataPoints.empty())
            return null;
        else {
            return DataPoints.getMax().second;
        }

    }

    @Override
    public boolean addDataPoint(DataPoint<T> dataPoint) { // Time comp: O(n), Space comp: O(1).
        CompPair<DataPoint<T>, Date> NewDP = new CompPair<>(dataPoint, dataPoint.date);
        if (DataPoints.empty()) {
            DataPoints.insert(NewDP);
            return true;
        } else { // First check if the data point exists as per the method specs if so return false, if not return true.
            DataPoints.findFirst();
            while (!DataPoints.last()) {
                if (DataPoints.retrieve().compareTo(NewDP) == 0)
                    return false;
                DataPoints.findNext();
            }
            if (DataPoints.retrieve().compareTo(NewDP) == 0) // Checks the last element.
                return false;

            DataPoints.insert(NewDP);
            return true;
        }
    }

    @Override
    public boolean updateDataPoint(DataPoint<T> dataPoint) { // Time comp: O(n), Space comp: O(1)
        if (DataPoints.empty())
            return false; // The data point doesn't exist.
        else {
            DataPoints.findFirst();
            while (!DataPoints.last()) {
                if (DataPoints.retrieve().second.compareTo(dataPoint.date) == 0) { // This checks whether if the data point exists or not.
                    CompPair<DataPoint<T>, Date> NewDP = new CompPair<DataPoint<T>, Date>(dataPoint, dataPoint.date);
                    NewDP.first.date = DataPoints.retrieve().second; // If so it edits the data point, but notice the date is the same.
                    NewDP.second = DataPoints.retrieve().second;
                    DataPoints.update(NewDP);
                    return true;
                }
                DataPoints.findNext();
            }
            if (DataPoints.retrieve().second.compareTo(dataPoint.date) == 0) { // Checks the last element.
                CompPair<DataPoint<T>, Date> NewDP = new CompPair<DataPoint<T>, Date>(dataPoint, dataPoint.date);
                NewDP.first.date = DataPoints.retrieve().second;
                NewDP.second = DataPoints.retrieve().second;
                DataPoints.update(NewDP);
                return true;
            }
            return false;
        }
    }
    private boolean search(Date val) { // search method we need it in removeDataPoint method
        boolean found = false;
        DataPoints.findFirst();
        while (!DataPoints.last() && !found) { // it makes sure that the list doesn't get out of bounds and if the element is found it stops.
            if (DataPoints.retrieve().second.compareTo(val) == 0)
                found = true;

            DataPoints.findNext();
        }
        // Check if the last node contains the value
        if (!found && DataPoints.retrieve().second.compareTo(val) == 0)
            found = true;

        return found;
    }
    @Override
    public boolean removeDataPoint(Date date) {
        if(DataPoints.empty()) // Check first if the list is empty.
            return false;

        if (search(date)) { // Search for the value
            DataPoints.remove();
            return true; // Return true indicating successful removal
        } else {
            return false; // Return false if the value is not found
        }
    }
    @Override
    public DLL<DataPoint<T>> getAllDataPoints() {
        if (DataPoints.empty()) {
            return new DLLImp<>(); // Return an empty DLL
        }
        DLLCompImp<CompPair<DataPoint<T>, Date>> tmpList = new DLLCompImp<>();
        DataPoints.findFirst();
        while(!DataPoints.last())
        {
            tmpList.insert(DataPoints.retrieve());
            DataPoints.findNext();
        }
        tmpList.insert(DataPoints.retrieve()); // insert last DataPoint

        // it will sort list by date in increasing order
        tmpList.sort(true);

        // Empty the Sorted List in a normal DLL of type DataPoint
        DLL<DataPoint<T>> finalList = new DLLImp<>();
        tmpList.findFirst();
      while(!tmpList.last())
      {
          finalList.insert(tmpList.retrieve().first); // to insert only the DataPoint without the Date
          tmpList.findNext();
      }
        finalList.insert(tmpList.retrieve().first); // insert of the last element

        return finalList;
    }

    @Override
    public DLL<DataPoint<T>> getDataPointsInRange(Date startDate, Date endDate) {
        DLL<DataPoint<T>> list = new DLLImp<>();
        if(startDate == null) // As per the specs if the start date is null pass the value of the minimum date to it.
            startDate = getMinDate() ;

        if(endDate == null)
            endDate = getMaxDate() ;

        if(DataPoints.empty())
            return list;

        DLLCompImp<CompPair<DataPoint<T>, Date>> tmpList = new DLLCompImp<>();
        DataPoints.findFirst();
        while(!DataPoints.last())
        {
            tmpList.insert(DataPoints.retrieve());
            DataPoints.findNext();
        }
        tmpList.insert(DataPoints.retrieve()); // insert last DataPoint

        // it will sort list by date in increasing order
        tmpList.sort(true);

        while (!tmpList.last())
        { // checking if its in between using compareTo()
            if(tmpList.retrieve().second.compareTo(startDate) >= 0 && tmpList.retrieve().second.compareTo(endDate) <= 0)
                list.insert(tmpList.retrieve().first);
            tmpList.findNext();
        }
        if(tmpList.retrieve().second.compareTo(startDate) >= 0 && tmpList.retrieve().second.compareTo(endDate) <= 0)
            list.insert(tmpList.retrieve().first);
        // check sorting
        return list;
    }
}
