package swe.service;

import java.util.ArrayList;
import java.util.Arrays;

import swe.model.Game;
import swe.model.QuestionMCQ;

public class GameService {

	private ArrayList<QuestionMCQ> qs = new ArrayList<>(Arrays.asList(
			new QuestionMCQ("question1", "a1", "a2", "a3", "a4", "a1"),
			new QuestionMCQ("question2", "a1", "a2", "a3", "a4", "a1"),
			new QuestionMCQ("question3", "a1", "a2", "a3", "a4", "a1")
			));
	
	private ArrayList<Game> games = new ArrayList<>(Arrays.asList (
			new Game(1, "TF", "game1", qs),
			new Game(2, "MCQ", "game2", qs),
			new Game(3, "TF", "game3", qs)
			));
	
	public void addGame(Game g) {
		games.add(g); // add game to database 
	}
	
	public void createGame (String type, String name, ArrayList<QuestionMCQ> qs) {
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


