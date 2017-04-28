package swe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import swe.model.Game;
import swe.model.QuestionMCQ;
import swe.service.GameService;

@Controller
@RequestMapping("/")
public class GameController {
	
	GameService gameService = new GameService();
	Game game = new Game();
	
	// create game stuff
	@RequestMapping(value = "createGameForm", method = RequestMethod.GET)
	public String create (Model model) {
		model.addAttribute("game", game);
		System.out.println(game.getQuestions().size());
		return "/createGameForm";
	}
	
	@RequestMapping(value = "createGameForm", method = RequestMethod.POST)
	public String createGame (@ModelAttribute(value = "game") Game g) {		
		gameService.createGame(g.getType(), g.getName(), g.getQuestions()); 
		
		System.out.println(g.getName());
		
		return "redirect:/newQuestion";
	}
	
	// question
	@RequestMapping(value = "newQuestion", method = RequestMethod.GET)
	public String createq (@RequestParam(value = "action", required = false) String action, Model model) {
		
		QuestionMCQ question = new QuestionMCQ();
		
		model.addAttribute("question", question);
		model.addAttribute("game", game);
		
		game.addQuestion(question);
		
		System.out.println("ahlan ");
		System.out.println(action);
		
		if (action == "finish") return "redirect/gameInfo/" + game.getId();
		
		else return "/newQuestion";
		
	}
		
	@RequestMapping(value = "newQuestion", method = RequestMethod.POST)
	public String createGameq (@ModelAttribute(value = "game") Game g) {		
		//gameService.createGame(g.getType(), g.getName(), g.getQuestions()); 
		
		System.out.println("wasahln ");
		
		return "redirect:/newQuestion";
		
		
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






