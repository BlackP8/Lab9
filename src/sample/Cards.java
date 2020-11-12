package sample;

import java.util.Stack;

public class Cards extends CardDeck{
    Stack<CardDeck> deck = new Stack<>();
       deck.push(new CardDeck("8 крести"));
       deck.push(new CardDeck("6 крести"));
       deck.push(new CardDeck("Туз пик"));
       deck.push(new CardDeck("Миллхаус Манашторм"));
       deck.push(new CardCard("Эдвин ван Клифф"));
}
