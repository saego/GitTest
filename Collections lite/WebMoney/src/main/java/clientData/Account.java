package clientData;

/**
 Created by Saego on 12.06.2017.
 */
public class Account {
    private Integer moneyValue;
    private Integer requisites;

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

    public Integer getRequisites() {
        return requisites;
    }

    public void setRequisites(Integer requisites) {
        this.requisites = requisites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return requisites != null ? requisites.equals(account.requisites) : account.requisites == null;
    }

    @Override
    public int hashCode() {
        return requisites != null ? requisites.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "clientData.Account{" +
                "moneyValue=" + moneyValue +
                ", requisites=" + requisites +
                '}';
    }
}
