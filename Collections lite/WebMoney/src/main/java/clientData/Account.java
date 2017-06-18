package clientData;

/**
 Created by Saego on 12.06.2017.
 */
public class Account {
    private Integer moneyValue;
    private long requisites;

    public Account(Integer moneyValue, long requisites) {
        this.moneyValue = moneyValue;
        this.requisites = requisites;
    }

    public Integer getMoneyValue() {
        return moneyValue;
    }

    public void setMoneyValue(Integer moneyValue) {
        this.moneyValue = moneyValue;
    }

    public long getRequisites() {
        return requisites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return requisites == account.requisites && (moneyValue != null ? moneyValue.equals(account.moneyValue) : account.moneyValue == null);
    }

    @Override
    public int hashCode() {
        int result = moneyValue != null ? moneyValue.hashCode() : 0;
        result = 31 * result + (int) (requisites ^ (requisites >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "moneyValue=" + moneyValue +
                ", requisites=" + requisites +
                '}';
    }
}
