private class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Item(Item source) {
        this.name = source.name;
        this.price = source.price;
        this.quantity = source.quantity;
    }

    public double getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }


    public int getQuantity() {
        return this.quantity;
    }

    public double setPrice(double price) {
        this.price = price;
    }

    public double setQuantity(int quantity) {
        this.quantity = quantity;
    }
}