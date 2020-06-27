package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TableTest {
	@DisplayName("해당 테이블 번호가 같은지 확인하는 테스트")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:false"}, delimiter = ':')
	void isSameNumberTest(int tableNumber, boolean expected) {
		Table table = new Table(1, new ArrayList<>());
		assertThat(table.isSameNumber(tableNumber)).isEqualTo(expected);
	}
}