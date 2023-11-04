import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File ResourcesFiles = new File("./resources");
        YearReport yReport = new YearReport();
        File yFile = null;
        //System.out.println(ResourcesFiles.exists());
        if(ResourcesFiles.exists()){
            File[] list = ResourcesFiles.listFiles();
            for(int i = 0; i< Objects.requireNonNull(list).length; i++){
                if(list[i].getName().startsWith("m")){
                    //System.out.println(list[i].getName());
                    scanMounthReport(list[i], yReport);
                }
                else if(list[i].getName().startsWith("y")) {
                    yFile=list[i];
                }
            }


        }

        //System.out.println(compare(yFile,yReport));
        //System.out.println(yReport);
        System.out.println((compare(yFile,yReport))?"соответствует":"не соответствует");
//        Product p1 = new Product("Утюг", 120,1222);
//        Product p2 = new Product("Утюг2", 1230,124);
//        Product p3 = new Product("Утюг3", 1240,1232);
//        Product p4 = new Product("Утюu4г", 1240,142);
//
//        MounthReport report1 = new MounthReport();
//        report1.addIncome(p1);
//        report1.addIncome(p2);
//        report1.addIncome(p3);
//        report1.addOutcome(p4);
//        System.out.println(report1);
    }

    public static boolean compare(File file, YearReport yReport) throws FileNotFoundException {

        Scanner scan = new Scanner(file);
        int length = file.getName().length();
        scan.nextLine();
        while(scan.hasNext()) {
            String line = scan.nextLine();
            String[] arr = line.split(",");
            int numMounth = Integer.parseInt(arr[0]);
            int summ = Integer.parseInt(arr[1]);
            String op = arr[2];
            if (op.equals("false")){
                if (yReport.getReport(numMounth-1).incomeResult()!=summ){
                    return false;
                }
            }
            if (op.equals("true")){
                if (yReport.getReport(numMounth-1).outcomeResult()!=summ){
                    return false;
                }
            }
        }
        return true;
    }

    public static void scanMounthReport(File file, YearReport yReport) throws FileNotFoundException {

        MounthReport mounth = new MounthReport();
        Scanner scan = new Scanner(file);
        int length = file.getName().length();
        String numMounth = file.getName().substring(length-6,length-4);
       // System.out.println(numMounth);
        scan.nextLine();
        while(scan.hasNext()){
            String line = scan.nextLine();
            String[] arr = line.split(",");
            if (arr[1].equals("TRUE"))
                yReport.addReport(mounth.addOutcome(new Product(
                        arr[0],
                        Integer.parseInt(arr[2]),
                        Integer.parseInt(arr[3])
                )),Integer.parseInt(numMounth)-1);
            else
                yReport.addReport(mounth.addIncome(new Product(
                        arr[0],
                        Integer.parseInt(arr[2]),
                        Integer.parseInt(arr[3])
                )),Integer.parseInt(numMounth)-1);
        }
    }
}