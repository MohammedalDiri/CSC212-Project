import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeSeriesTest {
    public static void main(String[] args) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        TimeSeriesImp t1 = new TimeSeriesImp();

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
            t1.addDataPoint(new DataPoint(dates[i], (i + 1) * 100));

        }
        System.out.println("all datapoints are: ");
        t1.display();

        System.out.println("time series size=" + t1.size());

        System.out.println("time series empty?=" + t1.empty());
        DLL<Date> dl = t1.getAllDates();

        System.out.println("all dates in increasing order are ");
        TimeSeriesImp.display(dl);

        System.out.println("all data points sorted by date");
        DLL<DataPoint<Integer>> d2 = t1.getAllDataPoints();
        DLLImp.display(d2);
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


        System.out.println("all data points after updating date 4-2");
        t1.updateDataPoint(new DataPoint(new Date(2024 - 1900, 4 - 1, 2), 40000));
        t1.display();


        System.out.println("all data points after removing date 6-6");
        t1.removeDataPoint(new Date(2024 - 1900, 6 - 1, 6));

        t1.display();
        System.out.println("all dates in increasing order");
        DLL<Date> d3 = t1.getAllDates();

        DLLImp.display(d3);
        System.out.println("datapoints in range 5-1 to 19-9");

        DLLImp.display(t1.getDataPointsInRange(new Date(2024 -1900, 5-1, 1), new Date(2024- 1900, 9-1, 19)));

        System.out.println("datapoints in range null to 19-9  ");

                DLLImp.display(t1.getDataPointsInRange(null, new Date(2024 -1900, 9-1, 19)));

                        System.out.println("datapoints in range 5-1 to null");

        DLLImp.display(t1.getDataPointsInRange(new Date(2024 -1900, 5-1, 1), null));

                System.out.println("datapoints in range null to null");

                        DLLImp.display(t1.getDataPointsInRange(null, null));



    }
}
