import java.util.Arrays;

public class YearReport {
    public MounthReport getReport(int index) {
        return report[index];
    }

    private MounthReport[] report = new MounthReport[12];

    public void addReport(MounthReport mReport, int index){
        report[index]=mReport;
    }

    @Override
    public String toString() {
        return "YearReport{" +
                "report=" + Arrays.toString(report) +
                '}';
    }
}
