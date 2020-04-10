package domain.state;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StateTest {

    @DisplayName("종료 기능을 선택했는지 확인하는 테스트")
    @Test
    void isContinueTest() {
        assertThat(State.isContinue(3)).isFalse();
    }

    @DisplayName("제대로된 기능인 경우 테스트")
    @Test
    void correctState() {
        assertThat(State.isCorrectState(3)).isEqualTo(State.EXIT);
    }

    @DisplayName("제대로 된 기능이 아닌 경우 테스트")
    @Test
    void inCorrectState() {
        assertThatThrownBy(() -> State.isCorrectState(4))
                .isInstanceOf(IllegalArgumentException.class);
    }
}