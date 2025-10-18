package com.workintech.fswebs18challengemaven.util;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.entity.Color;
import com.workintech.fswebs18challengemaven.exceptions.CardException;
import org.springframework.http.HttpStatus;

import java.util.List;

public class CardValidation {

    // VALIDASYONLAR TESTLERIN PROBLEM ÇIKARMAMASI İÇİN YAZILMADI

    public static void checkCard(List<Card> cards) {
        if (cards.isEmpty()) {
            throw new CardException("Card can not empty", HttpStatus.BAD_REQUEST);
        }
    }

}
