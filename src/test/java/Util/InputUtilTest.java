package Util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputUtilTest {
    @DisplayName("문자를 숫자로 변환하는 테스트")
    @Test
    void convertNumberTest() {
        Assertions.assertThat(InputUtil.convertNumber("1")).isEqualTo(1);
    }
}