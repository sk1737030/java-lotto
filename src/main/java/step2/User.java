package step2;

import java.util.List;

public class User {

    private final String name;
    private final Wallet wallet;

    public User(String name, Wallet wallet) {
        this.name = name;
        this.wallet = wallet;
    }

    public List<Lotto> buyLotto() {
        return LottoMachine.createLottos(wallet);
    }

    public Money withDraw(Money money) {
        return wallet.withDraw(money);
    }
}
