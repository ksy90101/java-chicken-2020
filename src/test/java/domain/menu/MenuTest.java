package domain.menu;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MenuTest {

    @Test
    void testToString() {
        Menu menu = MenuRepository.getMenu(1);
        Assertions.assertThat(menu.toString()).isEqualTo("[치킨] 1 - 후라이드 : 16000원");
    }
}