import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MounthReport {
    private List<Product> income = new LinkedList<>();
    private List<Product> outcome = new LinkedList<>();


    public int incomeResult(){
        int summ=0;
        for(int i=0; i<income.size(); i++){
            summ+=income.get(i).getSum_of_one() * income.get(i).getQuantity();
        }
        return summ;

    }
    public int outcomeResult(){
        int summ=0;
        for(int i=0; i<outcome.size(); i++){
            summ+=outcome.get(i).getSum_of_one() * outcome.get(i).getQuantity();
        }
        return summ;
    }
    public MounthReport addIncome(Product p){
        income.add(p);
        return this;
    }

    public MounthReport addOutcome(Product p){
        outcome.add(p);
        return this;
    }

    @Override
    public String toString() {
        return "MounthReport{" +
                "income=" + incomeResult() +
                " outcome=" + outcomeResult() +
                "}\n";
    }
}
