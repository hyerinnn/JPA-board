package jpabook.jpashop.domain.item;

import jpabook.jpashop.domain.Category;
//import jpabook.jpashop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //싱글테이블전략(한테이블에 다 넣겠다)
@DiscriminatorColumn(name = "dtype") // book, album, movie의 타입지정할 컬럼
@Getter @Setter
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

/*


    //==비즈니스 로직==//
    *//**
     * stock 증가
     *//*
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    *//**
     * stock 감소
     *//*
    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if (restStock < 0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }*/
}
