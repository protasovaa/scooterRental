import entity.Penalty;
import service.PenaltyService;

public class Main {
    public static void main(String[] args) {
        PenaltyService penaltyService = new PenaltyService();
        Penalty penalty=new Penalty();
        penalty.setType("uh");
        penalty.setAmount(800);
        penaltyService.add(penalty);

    }
}
