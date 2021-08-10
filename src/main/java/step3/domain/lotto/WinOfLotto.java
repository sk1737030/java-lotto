package step3.domain.lotto;

import java.util.List;

public class WinOfLotto {

    private final List<LottoNumber> winOfResultWithBonus;
    private final LottoNumber bonusNumber;

    public WinOfLotto(List<LottoNumber> winOfLottos, LottoNumber bonusNumber) {
        addBonusNumber(winOfLottos, bonusNumber);
        this.winOfResultWithBonus = winOfLottos;
        this.bonusNumber = bonusNumber;
    }

    private void addBonusNumber(List<LottoNumber> winOfLottos, LottoNumber bonusNumber) {
        winOfLottos.add(bonusNumber);
        validateWinOfLottos(winOfLottos, bonusNumber);
    }

    private void validateWinOfLottos(List<LottoNumber> winOfLottos, LottoNumber bonusNumber) {
        boolean duplication = winOfLottos.stream()
            .distinct()
            .count() != winOfLottos.size();

        if (duplication) {
            throw new IllegalArgumentException("이미 존재하는 로또 번호입니다.");
        }
    }

    public int correctCount(List<LottoNumber> numbers) {
        return (int) numbers.stream()
            .filter(winOfResultWithBonus::contains)
            .count();
    }

    public boolean hasBonusNumber(Lotto lotto) {
        return lotto.numbers().stream().anyMatch(bonusNumber::equals);
    }
}