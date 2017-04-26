package com.SWEProject.game;

import java.util.ArrayList;
import java.util.Arrays;

import com.SWEProject.Game;
import com.SWEProject.Question;

public class GameService {

	private ArrayList<String> as = new ArrayList<>(Arrays.asList("a1", "a2", "a3"));

	private ArrayList<Question> qs = new ArrayList<>(Arrays.asList(
			new Question("question1", 1, as),
			new Question("question2", 2, as),
			new Question("question3", 3, as)
			));
	
	private ArrayList<Game> games = new ArrayList<>(Arrays.asList (
			new Game(1, "TF", "game1", qs),
			new Game(2, "MCQ", "game2", qs),
			new Game(3, "TF", "game3", qs)
			));
	
	public void addGame(Game g) {
		games.add(g); // add game to database 
	}
	
	public void createGame (String type, String name, ArrayList<Question> qs) {
		Game newGame = new Game(games.size() + 1, type, name, qs);
		addGame(newGame);
	}
	
	public Game findGame (int id) {
		for (int i = 0; i < games.size(); i++) {
			if (games.get(i).getId() == id) {
				return games.get(i); 
			}
		}
		return null;
	}
	
//	public int checkAnswers(Game g, Game user) {
//		int score = 0;
//		for (int i = 0; i < g.getAnswers().size(); i++) {
//			if (user.getAnswers().get(i).equals(g.getAnswers().get(i)))
//				score++;
//		}
//		return score;
//	}
	
}


