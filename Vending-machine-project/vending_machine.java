public class Vending_machine {
    private Item[][] items;

    public vending_machine (Item[][] items) {
        this.items = new Items[items.length][items[0].length];
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                this.items[i][j] = new Item(items[i][j]);
            }
        }
    }
    
    public Item getItem(int row_index, int col_index) {
        return new Item(this.items[row_index][col_index]);
    }

    public void setItem(Item item, int row_index, int col_column) {
        this.items[row_index][col_column] = new Item(item);
    }

    // sell action
    public boolean dispense(int row_index, int col_index) {
        if (this.items[row_index][col_index].getQuantity() > 0) {
            items[row_index][col_index].setQuantity(items[row_index][col_index].getQuantity() - 1);
            return true;
        } 
        return false;
    }

    public String toString() {

        String temp = "";
        for (int i = 0; i < items.length; i++) {
            temp += "\t";
            for (int j = 0; j < items[i].length; j++) {
                temp += items[i][j].toString() + " ";
            }
            temp += "\n\n";
        }
        temp += "\t************************************************";
        return temp;
    }
}
