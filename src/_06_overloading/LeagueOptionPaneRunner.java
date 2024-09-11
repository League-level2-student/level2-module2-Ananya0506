package _06_overloading;

import java.awt.Color;

public class LeagueOptionPaneRunner {
	public static void main(String[] args) {
		LeagueOptionPane.showMessageDialog("The League is the Best");
		LeagueOptionPane.showMessageDialog("The League is the Best", "DOg");
		LeagueOptionPane.showMessageDialog("The League is the Best", "Puppy", "league.png");
		LeagueOptionPane.showMessageDialog("The League is the Best", "Coco", "league.png", Color.blue);
	}
}
