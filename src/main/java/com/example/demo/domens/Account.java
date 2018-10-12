package com.example.demo.domens;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;


    //владелец счета
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")

    //обратная связь c Transaction, ссылки на транзакции кторые снимали деньги со счета
    @OneToMany(mappedBy = "from", cascade = CascadeType.ALL) //связано с полем from в классе transaction
    private List<Transaktion> transactionsGet = new ArrayList<>(); //cо счета можно много раз снимать

    //обратная связь c Transaction, ссылки на транзакции кторые добавляли деньги на счет
    @OneToMany(mappedBy = "too", cascade = CascadeType.ALL) //связано с полем too в too transaction
    private List<Transaktion> transactionsPut = new ArrayList<>(); //на счет можно много раз ложить

    private Users user;

    private  String currency;

    private Double amount = 0.0;

    public Account() {
    }

    public Account(String currency) {
        this.currency = currency;
    }

    public Long getId() {
        return id;
    }

    public Users getUser() {
        return user;
    }

    public String getCurrency() {
        return currency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void addTransactionPut(Transaktion transaction){
        transaction.setToo(this);
        transactionsPut.add(transaction);
    }

    public void addTransactionGet(Transaktion transaction){
        transaction.setFrom(this);
        transactionsGet.add(transaction);
    }

    public List<Transaktion> getTransactionsGet() {
        return transactionsGet;
    }

    public List<Transaktion> getTransactionsPut() {
        return transactionsPut;
    }
}
