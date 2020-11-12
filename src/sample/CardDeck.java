package sample;

public class CardDeck {
    private String name;

    public CardDeck(String name) {
        this.name = name;
    }

    public CardDeck () {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Карта: " + name;
    }

}
