package com.example.smartspring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.smartspring.model.PasienModel;
import com.example.smartspring.service.PasienService;

@Controller
public class MenuController {
	
	@Autowired
	//bikin nama baru utk PasienService dengan nama pasienService
	private PasienService pasienService;
	
	@RequestMapping ("/menu/menu1")
	public String menu1 (HttpServletRequest request, Model model) {
		String mintaNomor = request.getParameter("noPasien");
		
		model.addAttribute("noLempar", mintaNomor);
		
		String menu ="menu/menu1";
		return menu;
	}
	
	@RequestMapping("/pasien/create")
	public String pasienCreate(HttpServletRequest request, Model model) throws ParseException {
		String nomorPasien = request.getParameter("noPasien");
		String namaPasien = request.getParameter("namaPasien");
		String gender = request.getParameter("gender");
		String kategori = request.getParameter("kategori");
		int biaya = Integer.parseInt(request.getParameter("biaya")) ;
		//Date tanggalLahir = Date.valueOf(request.getParameter("tanggalLahir")) ;
		//konversi date
		String tanggalLahir = request.getParameter("tanggalLahir");
		SimpleDateFormat formatDate = new SimpleDateFormat ("yyy-MM-dd");
		Date tanggalLahirDate = formatDate.parse(tanggalLahir);
		System.out.println(tanggalLahirDate);
		
		//instance pasienModel
		PasienModel pasienModel = new PasienModel();
		
		//simpan ke masing2 kolom di database
		pasienModel.setKodePasien(nomorPasien);
		pasienModel.setNamaPasien(namaPasien);
		pasienModel.setGender(gender);
		pasienModel.setKategoriPasien(kategori);
		pasienModel.setBiaya(biaya);
		pasienModel.setTanggalLahir(tanggalLahirDate);
		
		
		//save
		this.pasienService.create(pasienModel);
		
		//list
		//
		this.ListPasien(model);
		
		String html = "/pasien/list";
		return html;
	}
	
	//@RequestMapping ("/pasien/list")
	//void krn ga return apapun
	//model buat ambil data dari backend ke frontend
	public void ListPasien (Model model) {
		//kalo datanya banyak, instance pake list
		//klo 1, pake new biasa.
		List<PasienModel> pasienModelList = new ArrayList<PasienModel>();
		//disini data udah kebaca
		pasienModelList = pasienService.readData();
		
		//penamaan pasienModelList buat penamaan doang di lempar ke depan
		model.addAttribute("pasienModelList", pasienModelList);
	}
}
