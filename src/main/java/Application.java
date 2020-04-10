import controller.PosController;
import domain.state.State;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        State state;

        do {
            state = PosController.start();

            if (state == State.ORDER) {
                PosController.enrollOrder();
            }

            if (state == State.PAYMENT) {
                PosController.Payment();
            }
        } while (state != State.EXIT);
    }
}
