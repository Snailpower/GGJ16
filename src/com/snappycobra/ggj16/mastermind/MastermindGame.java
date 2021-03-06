package com.snappycobra.ggj16.mastermind;

import java.util.ArrayList;
import java.util.List;

import com.snappycobra.ggj16.model.Resource;

public class MastermindGame {
	private int length;
	Combination solution;
	Combination currentTry;
	List<OldCombination> oldTries;
	
	
	public MastermindGame(int length) {
		this.length = length;
		solution = Combination.generateSolution(length);
		currentTry = new Combination(length);
		oldTries = new ArrayList<>();
	}
	
	public void addResource(Resource res) {
		currentTry.addResource(res);
		if (currentTry.isFull()) {
			if (currentTry.Compare(solution)) {
				System.out.println("WINNNEER");
			} else {
				List<Integer> result = currentTry.checkInSolution(solution);
				oldTries.add(new OldCombination(currentTry,result.get(1),result.get(2)));
				currentTry = new Combination(length);
			}
		}
	}
}