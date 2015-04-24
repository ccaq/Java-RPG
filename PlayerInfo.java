//add code here
package RPGC;

public class PlayerInfo {
	int level = 1;
	int gold = 10;
	int xp = 0;
	
	public String toString() {
		
		return "<html>Level = " + level +"<br>\nCurrent XP = " + xp + "/" + getLevelXP(level) + "<br>\nGold = " + gold + "</html>";
	}
	
 public void addXP(int xp) {
	 this.xp = xp;
	 level ++;
		xp = 0;
	}
	public int getLevelXP(int level) {
		int levelXP = level * (int) (Math.pow(100, 1.0 + (level / 100.0)));
		return levelXP;
	}
	
}
	
	



