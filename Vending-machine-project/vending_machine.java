public class Vending_machine {
    private Item[][] items;

    public vending_machine () {
        this.items = new Items[items[0].length][items[1].length];
        for (int i = 0; i < items[0].length; i++) {
            for (int j; j < items[1].length; j++) {
                this.items[i][j] = new Item(items[i][j]);
            }
        }
    }

    public void setItem(Item item, int row_index, int col_column) {
        this.items[row_index][col_column] = item;
    }

    // sell action
    public void sell(int row_index, int col_index) {
        if (this.items[row_index][col_index].getQuantity() > 1) {
            current_quantity = this.items[row_index][col_index].getQuantity();
            this.items[row_index][col_index].setQuantity(current_quantity-1);
        }
        else {
            this.items[row_index][col_index] = null;
        }
    }

    public String search(String name) {
        for (i = 0; i < items[0].length; i++) {
            for (j = 0; j < items[1].length; j++) {
                if (this.items[i][j] == null) {
                    continue;
                }
                else if (items[i][j].getName().equals(name) && items[i][j].getQuantity > 0) {
                    return "\n" + this.items[i][j].getName().toString() + ":" + this.items[i][j].getPrice().toString() + this.items[i][j].getQuantity().toString();
                }
            }
        }
        return "\nSorry the item is not available now";
    }
}