import java.text.SimpleDateFormat;
import java.util.Date;

public class NumericTimeSeriesTest {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        NumericTimeSeriesImp t1 = new NumericTimeSeriesImp();

        Date[] dates = new Date[10];

        for (int i = 0; i < 10; i++) {

            if (i % 2 == 0) {

                dates[i] = new Date(2024 - 1900, i + 3, 2 * (i + 1));

            } else if (i < 5) {

                dates[i] = new Date(2024 - 1900, 2 * i, 2 * (i + 1));

            } else {

                dates[i] = new Date(2024 - 1900, i - 2, 2 * (i + 1));

            }

        }
        for (int i = 0; i < 10; i++) {
            t1.addDataPoint(new DataPoint(dates[i], (i + 1) * 100.0));
        }
        System.out.println("all datapoints are :");
        t1.display();

        System.out.println("time series size=" + t1.size());
        System.out.println("time series empty?=" + t1.empty());

        System.out.println("max value= "+t1.getMax());
        System.out.println("min value= "+t1.getMin());

        DLL<Date> d1 = t1.getAllDates();
        System.out.println("all dates in increasing order are ");
        DLLImp.display(d1);

        System.out.println("---------all data points sorted by date--------");
        DLL<DataPoint<Double>> d2 = t1.getAllDataPoints();
        DLLImp.display(d2);
        {
            System.out.println("-calculateMoving averages with period" + 3 + "--------");
            NumericTimeSeries num = t1.calculateMovingAverage(3);
            ((NumericTimeSeriesImp)num).display();
            System.out.println("-------------------------------------------");
        }
        if (t1.getMinDate() != null) {
            System.out.println("min date=" + dateFormat.format(t1.getMinDate()));
        } else {
            System.out.println(t1.getMinDate());
        }

        if (t1.getMaxDate() != null) {
            System.out.println("max date=" + dateFormat.format(t1.getMaxDate()));
        } else {
            System.out.println(t1.getMaxDate());
        }





    }
}