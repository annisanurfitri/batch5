package com.example.smartspring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//di ctrl space yg banyak
//controller itu untuk perpindahan halaman, pagination, untuk memberikan url pada halaman tertentu
public class UtamaController {
	
	@RequestMapping("/")
	//utk memberikan sebuah alamat kpd method bawahnya
	//untuk memanggil halaman 
	public String utama() {
		//string atau int harus dikasih nilai return biar ga eror
		//utama biru itu nama file
		String home ="Utama";
		return home;
	}
	
	@RequestMapping("/login")
	public String login(){
		String log ="login";
		return log;
	}
	@RequestMapping("/hobi")
	public String hobi(){
		String log ="Hobi";
		return log;
	}
	
	@RequestMapping("/login/action")
	public String home(HttpServletRequest request, Model model){
		
		String mintaUser = request.getParameter("username"); //data dari nilai yg ada di username diberikan ke mintaUSer
		String mintaPassword = request.getParameter("password");
		
		model.addAttribute("userLempar", mintaUser);//value yg udah ada dari minta user...
		//diberikan ke userLempar
		//nilai dari mintUSer di bundle di userLempar
		model.addAttribute("userLemparin", mintaPassword);
		String home ="Home";
		return home;
	}
	

}
