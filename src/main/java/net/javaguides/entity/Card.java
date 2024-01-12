package net.javaguides.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CARD_ID")
    private Long cardId;
    @Column(name = "CARD_Number")
    private String cardNumber;
    @Column(name = "MEMBER_ID")
    private Long memberId;
    @OneToOne
    @JoinColumn(name = "MEMBER_ID",insertable = false, updatable = false)
    private Member member;
    @Column(name = "BANK")
    private String bank;
    @Column(name = "VALID_Y_M")
    private String validYM;
}
