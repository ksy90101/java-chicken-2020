import controller.PosController;
import domain.state.State;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        do {
            State state = PosController.start();

            if (state == State.ORDER) {
                PosController.enrollOrder();
            }

            if (state == State.EXIT) {
                PosController.Payment();
            }
        } while (true);
    }
}
