package com.example.smartspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BerandaController {
	
	@RequestMapping ("/beranda")
	public String beranda() {
		String html = "beranda";
		return html;
	}
	

}
//1. buat halaman /HTML bernama utamaOffice -- tampilkan di browser
//a. buat form sederhana saja, ada 2 textfield dan 1 button
//2. buat halaman /HTML bernama penjualanOffice di dalam folder office:
//a. buat tabel sederhana saja, dengan kolom no, barang, harga, jumlah penjualan
//3. buat halaman html bernama karyawanOffice di dalam folder karyawan yang ada di dalam folder office. office/karyawan/..:
//a. buat tabel sederhana daftar nama karyawan, (no, nama, jabatan), 