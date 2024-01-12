package net.javaguides.service;

import net.javaguides.entity.Card;
import net.javaguides.entity.Member;
import net.javaguides.repository.CardRepository;
import net.javaguides.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CardServiceImpl implements CardService{

    private final CardRepository cardRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository,MemberRepository memberRepository) {
        this.cardRepository=cardRepository;
        this.memberRepository=memberRepository;
    }


    @Override
    public Card createCard(Card card) throws Exception {
        Member member=memberRepository.findByMemberId(card.getMemberId()).stream().findFirst().orElse(null);
        if (member==null) {
            throw new Exception("Member not found");
        }
        card.setCardNumber(card.getCardNumber());
        card.setBank(card.getBank());
        card.setValidYM(card.getValidYM());
        card.setMember(member);
        return cardRepository.save(card);
    }

    @Override
    public void deletecard(String cardNumber) {
        cardRepository.deletecard(cardNumber);
    }
}
