package clients;

public enum Plan {
    BASIC(20),
    MEDIUM(40),
    PREMIUM(60);

    private final int price;

    Plan(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
