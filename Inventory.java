//add code here jake
package RPGC;

import java.util.ArrayList;

public class Inventory {
StringBuilder sb = new StringBuilder();
	
	public String displayInv(ArrayList<Item> Inventory) {
		sb.append("<html>");
		for (int i = 0; i < Inventory.size(); i++) {
			sb.append(Inventory.get(i) + "<br>");
		}
		sb.append("</html>");
		System.out.println(sb);
		return sb.toString();
	}

}
