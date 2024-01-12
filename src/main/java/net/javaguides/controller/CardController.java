package net.javaguides.controller;

import net.javaguides.entity.Card;
import net.javaguides.service.CardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("VueTestApi/api/VueTest")
public class CardController {
    private CardService cardService;

    public CardController(CardService cardService) {
        this.cardService=cardService;
    }

    @PostMapping("/creatcard")
    public Card createCard(@RequestBody Card card) throws Exception {
        return cardService.createCard(card);
    }

    @GetMapping("/deletecard")
    public Map<String, Object> deletecard(@RequestParam String cardNumber) {
        Map<String, Object> resultMap = new HashMap<>();
        if(!cardNumber.isBlank()) {
            cardService.deletecard(cardNumber);
            resultMap.put("Message", "刪除成功");
        } else {
            resultMap.put("Message", "刪除失敗");
        }
        return resultMap;
    }

}
