package banking;

import clientData.Account;
import clientData.Passport;
import clientData.User;

import java.util.*;

/**
 *Created by Saego on 13.06.2017.
 */
public class Tracker {

    private Map<User, List<Account>> userListMap = new HashMap<User, List<Account>>();

    public void addClient(User user){
        userListMap.put(user, new ArrayList<Account>());
    }

    public Set<User> getAllClients(){
        return this.userListMap.keySet();
    }

    public void addAccount(User user, Account account){
        this.userListMap.get(user).add(account);
    }

    public void removeClient(User user){
        this.userListMap.remove(user);
    }

    public void removeAccount(User user, Account account){
        this.userListMap.get(user).remove(account);
    }

    public List<Account> clientAccounts(User user){
        return this.userListMap.get(user);
    }

    public boolean transferMoney(User sourceUsr, Account sourceAcc, User destinationUsr, Account destinationAcc, int amountOfTransfer){
        boolean resultOfTransfer = false;
        if (this.userListMap.get(sourceUsr).contains(sourceAcc) && this.userListMap.get(destinationUsr).contains(destinationAcc)) {
            if (this.userListMap.get(sourceUsr).get(this.userListMap.get(sourceUsr).indexOf(sourceAcc)).getMoneyValue() >= amountOfTransfer){
                this.userListMap.get(sourceUsr).get(this.userListMap.get(sourceUsr).indexOf(sourceAcc)).setMoneyValue(
                        this.userListMap.get(sourceUsr).get(this.userListMap.get(sourceUsr).indexOf(sourceAcc)).getMoneyValue() - amountOfTransfer
                );
                this.userListMap.get(destinationUsr).get(this.userListMap.get(destinationUsr).indexOf(destinationAcc)).setMoneyValue(
                        this.userListMap.get(destinationUsr).get(this.userListMap.get(destinationUsr).indexOf(destinationAcc)).getMoneyValue() + amountOfTransfer
                );
                resultOfTransfer = true;
            }
        }
        return resultOfTransfer;
    }

    public User getUsrByPassport(Passport passport){
        User user = null;
        for (Map.Entry<User, List<Account>> usr:
             this.userListMap.entrySet()) {
            if (usr.getKey().getPassport().equals(passport)){
                user = usr.getKey();
                break;
            }
        }            
        return user;
    }

    public Account getAccount(User user, long requisites){
        Account account = null;
        List<Account> accounts = this.userListMap.get(user);
        for (Account acc:
             accounts) {
            if (acc.getRequisites() == requisites){
                account = acc;
                break;
            }
        }
        return account;
    }

    public void updateUser(User user, User newUser){
        for (Map.Entry<User, List<Account>> user1:
             this.userListMap.entrySet()) {
            if (user1.getKey().equals(user)){
                user1.getKey().setName(newUser.getName());
                user1.getKey().getPassport().setNumber(newUser.getPassport().getNumber());
                user1.getKey().getPassport().setSerial(newUser.getPassport().getSerial());
            }
        }
    }

}
