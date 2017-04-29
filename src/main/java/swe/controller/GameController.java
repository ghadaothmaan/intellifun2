package swe.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import swe.model.Game;
import swe.model.QuestionMCQ;
import swe.service.GameService;

@Controller
@RequestMapping("/")
public class GameController {
	
	GameService gameService = new GameService();
	Game game = new Game();
	QuestionMCQ question = new QuestionMCQ();
	
	// create game stuff
	@RequestMapping(value = "createGameForm", method = RequestMethod.GET)
	public String create (Model model) {
		model.addAttribute("game", game);
		
		return "/createGameForm";
	}
	
	@RequestMapping(value = "createGameForm", method = RequestMethod.POST)
	public String createPost (@ModelAttribute(value = "game") Game game, Model model) {
	//	model.addAttribute("game", game);
		System.out.println(game.getName() + " hmm");
		gameService.addGame(game);
		return "redirect:/newQuestion/" + game.getId();
	}
	
	@RequestMapping(value = "newQuestion/{id}", method = RequestMethod.GET)
	public String createq(Model model, @PathVariable int id, @ModelAttribute(value = "question") QuestionMCQ question) {
		
		//QuestionMCQ question = new QuestionMCQ();
		game = gameService.findGame(id);
		model.addAttribute("question", question);
		model.addAttribute("game", game);
		System.out.println("the game we're modifying: " + game.getName());
		game.addQuestion(question);
		System.out.println(question.getQuestionhead());
		if (game.getQuestions() != null) {
			for (int i = 0; i < game.getQuestions().size(); i++) {
				if (game.getQuestions().get(i) != null) 
					System.out.println(game.getQuestions().get(i).getQuestionhead() + " dafsdfsd");
				else System.out.println("uf");
				}
			}
		else System.out.println("mafish haga");
		
		return "/newQuestion";
		
	}
	
	@RequestMapping(value = "gameInf/{id}")
	public String createGameq (Model model, @PathVariable int id) {		
		game = gameService.findGame(id);
		model.addAttribute("game", game);
		System.out.println(game.getName());
		ArrayList<QuestionMCQ> questions = game.getQuestions();
		model.addAttribute("questions", questions);
		return "/gameInfo";
	}
		

	
	// play game stuff
	@RequestMapping(value = "playGame/{id}", method = RequestMethod.GET)
	public String play (@PathVariable int id, Model model, Model m) {
		Game game = new Game();
		Game usergame = new Game();
		
		game = gameService.findGame(id);
		
		System.out.println(game.getName());
		
		model.addAttribute("game", game);
		m.addAttribute("usergame", usergame);
		
		return "/playGame";
	}
	
	@RequestMapping(value = "playGame/{id}", method = RequestMethod.POST)
	public String getGame (@PathVariable int id, @ModelAttribute(value = "game") Game usergame, @ModelAttribute(value = "game") Game game) {		
		
		game = gameService.findGame(id);
		//int score = gameService.checkAnswers(game, usergame);
		
		//System.out.println("hellooooo" + score); // doesnt get printed
		
		return "/myerror";
		//return "redirect:/gameInfo/" + usergame.getId() + ".html";
	}
	
	@RequestMapping(value = "gameInfo/{id}" , method = RequestMethod.GET)
	public String gameInfo (@PathVariable int id, ModelMap modelMap ) {		
		Game game = gameService.findGame(id);
		modelMap.put("game", game);
		return "/gameInfo";
	}

	
}






