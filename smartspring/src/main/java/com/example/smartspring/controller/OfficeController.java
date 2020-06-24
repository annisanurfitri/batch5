package com.example.smartspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/office")
//kelasnya di mapping, biar ga bingung 
//mapping kelas perfolder aja
public class OfficeController {
	
	//master/modul
	//misal ada projek namanya kampus
	//master namanya fakultas
	//modul namanya SI TIF
	
	//jadi pembuatan controller itu per master
	//permaster, per controller
	
	//404 tdk ditemukan direktori/mapping tdk ditemukan
	//500 server bermasalah
	@RequestMapping ("/penjualan")
	public String penjualan() {
		//pemanggilan yg ini harus benar
		String html = "office/penjualanOffice";
		return html;
	}
	
	//buat sesuai lokasi/direktori aja biar ga crash/bingung
	@RequestMapping ("/karyawan/karyawan")
	public String karyawan() {
		String html = "office/karyawan/karyawanOffice";
		return html;
	}
}