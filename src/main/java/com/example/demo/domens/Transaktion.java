package com.example.demo.domens;




import javax.persistence.*;

@Entity
@Table(name="Transactions")
public class Transaktion {

    @Id //первичный ключ
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    //клиент кторый запросил транзакцию
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user; //у тарнзакции может быть только один клиент - заказчик

    //счет с которго снимаются деньги
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_from_id")
    private Account from; //у тарнзакции может быть только один счет истоник

    //счет на который кладутся деньги
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_too_id")
    private Account too; //у транзакции может быть только один счет приемник
    //валюта в которой происходит транзакция
    private String currency;

    //сумма транзакции
    private Double amount;

    //конвертация в валюту(если нет конвертации то null)
    private String convertationToo;

    //сумма после конвертации
    private Double amountAfterConvert;

    public Transaktion() {
    }

    public Transaktion(Users user, Account from, Account too, String currency,
                       Double amount, String convertationToo, Double amountAfterConvert) {
        this.user = user;
        this.from = from;
        this.too = too;
        this.currency = currency;
        this.amount = amount;
        this.convertationToo = convertationToo;
        this.amountAfterConvert = amountAfterConvert;
    }

    public void setClient(Users user) {
        this.user = user;
    }

    public void setFrom(Account from) {
        this.from = from;
    }

    public void setToo(Account too) {
        this.too = too;
    }

    public Long getId() {
        return id;
    }
}