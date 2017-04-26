package com.SWEProject.game;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.SWEProject.Game;

@Controller
@RequestMapping("/")
public class GameController {
	
	// create game stuff
	@RequestMapping(value = "createGameForm", method = RequestMethod.GET)
	public String create (Model model) {
		Game game = new Game();
		model.addAttribute("game", game);
		System.out.println(game.getQuestions().size());
		return "/createGameForm";
	}
	
	//th:each i state(index): $(object name) <radio gwa el tag
	
	@RequestMapping(value = "createGameForm", method = RequestMethod.POST)
	public String createGame (@ModelAttribute(value = "game") Game g) {		
		//GameService gameService = new GameService();
		//gameService.createGame(g.getType(), g.getName(), g.getQuestions()); 
		
		System.out.println(g.getName());
		
		return "/gameInfo";
	}
	
	// play game stuff
	@RequestMapping(value = "playGame/{id}", method = RequestMethod.GET)
	public String play (@PathVariable int id, Model model, Model m) {
		Game game = new Game();
		Game usergame = new Game();
		GameService gameService = new GameService();
		
		game = gameService.findGame(id);
		
		System.out.println(game.getName());
		
		model.addAttribute("game", game);
		m.addAttribute("usergame", usergame);
		
		return "/playGame";
	}
	
	@RequestMapping(value = "playGame/{id}", method = RequestMethod.POST)
	public String getGame (@PathVariable int id, @ModelAttribute(value = "game") Game usergame, @ModelAttribute(value = "game") Game game) {		
		
		GameService gameService = new GameService();
		game = gameService.findGame(id);
		//int score = gameService.checkAnswers(game, usergame);
		
		//System.out.println("hellooooo" + score); // doesnt get printed
		
		return "/myerror";
		//return "redirect:/gameInfo/" + usergame.getId() + ".html";
	}
	
	@RequestMapping(value = "gameInfo/{id}" , method = RequestMethod.GET)
	public String gameInfo (@PathVariable int id, ModelMap modelMap ) {		
		GameService gameService = new GameService();
		Game game = gameService.findGame(id);
		modelMap.put("game", game);
		return "/gameInfo";
	}

	
}






