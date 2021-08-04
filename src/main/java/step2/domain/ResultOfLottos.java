package step2.domain;

import step2.domain.lotto.LottoRank;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class ResultOfLottos {

    private static final Integer WIN_COUNT_ZERO = 0;

    private final Map<Integer, Integer> resultOfLottos;

    public ResultOfLottos() {
        this(new HashMap<>());
    }

    public ResultOfLottos(Map<Integer, Integer> resultOfLottos) {
        this.resultOfLottos = resultOfLottos;
    }

    public Integer sumMoney() {
        AtomicInteger sum = new AtomicInteger(0);

        resultOfLottos.forEach((rank, count) -> {
            LottoRank lottoRank = LottoRank.find(rank);
            sum.set(count * lottoRank.getMoney());
        });

        return sum.get();
    }


    public void put(int count) {
        resultOfLottos.put(count, resultOfLottos.getOrDefault(count, WIN_COUNT_ZERO) + 1);
    }

    public Integer winCount(int rank) {
        if (!resultOfLottos.containsKey(rank)) {
            return WIN_COUNT_ZERO;
        }

        return resultOfLottos.get(rank);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResultOfLottos that = (ResultOfLottos) o;
        return Objects.equals(resultOfLottos, that.resultOfLottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultOfLottos);
    }
}
