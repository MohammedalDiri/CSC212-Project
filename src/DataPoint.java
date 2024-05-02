import java.text.SimpleDateFormat;
import java.util.Date;

// Represents a single data point in a time series. Each data point consists of a date and a corresponding value.
public class DataPoint<T> {

	// The date of the data point.
	public Date date;

	// The value of the data point.
	public T value; // value here is referring to the class StockData.

	public DataPoint(Date date, T value) {
		this.date = date;
		this.value = value;
	}

	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // The simple format is available because of the import of SimpleDateFormat.
		return dateFormat.format(date) + " : " + value.toString(); // As we already said the value refers stock data, so we may need to implement a display method in StockData.
 	}
}
