//add code here jake
package RPGC;

public class Item {

	String name;
	int amount;
	boolean haveIt;

	public String toString() {
		if (haveIt) {
			if (amount > 0) {
				return name + " x " + amount;
			}
			return name + "\n";
		}
		return "";
	}

	public Item(String name) {
		this.name = name;
		this.haveIt = false;
	}

	public void give(int amount) {
		this.amount = amount;
		this.haveIt = true;
	}

	public void remove() {
		this.haveIt = false;
	}

}
