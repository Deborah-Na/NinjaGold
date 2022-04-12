package com.assignment.ninjagold.controllers;
import java.util.ArrayList;
import java.util.Random;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class GoldController {
@RequestMapping("/gold")
public String showActivities(HttpSession session) {
	if(session.getAttribute("gold") == null) {
		session.setAttribute("gold", 0);
	} 
	if(session.getAttribute("log")== null) {
		session.setAttribute("log", new ArrayList<String>());
	}
	session.getAttribute("log");
	return "index.jsp";
}
	
	@PostMapping("/gold")
	public String addGold(HttpSession session, 
			@RequestParam(value="location") String location) {
		Integer userGold = (Integer) session.getAttribute("gold");
		@SuppressWarnings("unchecked")
		ArrayList<String>goldLog = (ArrayList<String>) session.getAttribute("log");
		
	if(location.equals("farm")) {
		Integer totalGold = (Integer) new Random().nextInt(10)+11;
		userGold = totalGold + userGold;
		session.setAttribute("gold", userGold);	
		goldLog.add("You found " +totalGold + " gold from the farm!!");
		session.setAttribute("log", goldLog);
		
	}
	if(location.equals("cave")) {
		Integer totalGold = (Integer) new Random().nextInt(10);
		userGold = totalGold + userGold;
		session.setAttribute("gold", userGold);	
		goldLog.add("You found " +totalGold + " gold from the cave!!");
		session.setAttribute("log", goldLog);
	}
	if(location.equals("house")) {
		Integer totalGold = (Integer) new Random().nextInt(5) +1;
		userGold = totalGold + userGold;
		session.setAttribute("gold", userGold);	
		goldLog.add("You found " +totalGold + " gold from the house!!");
		session.setAttribute("log", goldLog);
	}

	if(location.equals("quest")) {
		//
		Integer quest = new Random().nextInt(2);
		Integer questGold = (Integer) new Random().nextInt(51);
		System.out.println(questGold);
		if(quest == 1) {
		
			userGold = questGold + userGold; 
			session.setAttribute("gold", userGold);
			goldLog.add("You found " +questGold + " gold from the quest!! Woohoo!");
			session.setAttribute("log", goldLog);
		} else {
			userGold = userGold - questGold  ;
			session.setAttribute("gold", userGold);
			goldLog.add("AWWW....You LOST " +questGold + " gold from the quest!! Maybe next time.");
			session.setAttribute("log", goldLog);
		}
			
		}

	return "redirect:/gold";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.removeAttribute("gold");
		session.removeAttribute("log");
		return "redirect:/gold";
		
	}
}

