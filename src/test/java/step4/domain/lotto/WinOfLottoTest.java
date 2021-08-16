package step4.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class WinOfLottoTest {

    @DisplayName("우승번호와 보너스번호가 겹치면 IllegalArgumentException 발생")
    @Test
    void validateWinOfLottos() {
        // Given
        List<LottoNumber> lottoNumbers = new ArrayList<>(LottoNumbersFactory.buildLottoNumbers(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = LottoNumber.of(6);

        // When && Then
        assertThrows(IllegalArgumentException.class, () -> new WinOfLotto(lottoNumbers, bonusNumber));
    }

    @DisplayName("우승번호와 보너스번호가 겹치지 않으면 우승 로또가 만들어진다")
    @Test
    void winOfLottos() {
        // Given
        List<LottoNumber> lottoNumbers = new ArrayList<>(LottoNumbersFactory.buildLottoNumbers(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = LottoNumber.of(7);

        // When && Then
        new WinOfLotto(lottoNumbers, bonusNumber);
    }
}