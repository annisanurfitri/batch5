package com.example.smartspring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.smartspring.model.PasienModel;
import com.example.smartspring.repository.PasienRepository;

@Service
@Transactional
public class PasienService {
	//buat logic di service
	//service utk memaksimalkan penggunaan query dari repository
	
	@Autowired //digunakan utk mengambil fungsi2 yg ada di class lain
	//knp ga pake extend? krn extend cuma 1 kelas. kalo auto bisa banyhak
	//nama PasienRepos jadi pasienRepo. tar klo mau manggil jadi pasienRep.(titik)
	private PasienRepository pasienRepository; //membuat variabel baru dari class PasienRepository
	
	public void create(PasienModel pasienModel) {
		this.pasienRepository.save(pasienModel);
		//save = nyimpan data ke? tabel pasienModel
	}
	
	//
	public List<PasienModel> readData(){
		//utk tampilin semua data
		return this.pasienRepository.findAll();
	}
	public void update(PasienModel pasienModel) {
		this.pasienRepository.save(pasienModel);
	}
	
	//delete biasa digunakan pas create data
	//delete all, hapus semua yg ada di table
	//deletebyid, ngapus salah 1 data doang berdasaekan id (biasa di pakai)
	public void remove(String kodePasien) {
		this.pasienRepository.deleteById(kodePasien);
	}
	
	public List<PasienModel> pasienUrut(){
		//utk tampilin semua data
		return this.pasienRepository.pasien();
	}
	
	public List<PasienModel> cariDataMengandung(){
		//utk tampilin semua data
		return this.pasienRepository.cariDataYangMengandung();
	}
	public List<PasienModel> cariDataA(){
		//utk tampilin semua data
		return this.pasienRepository.cariDataDepanA();
	}
	
	public List<PasienModel> cariDataBesar(){
		//utk tampilin semua data
		return this.pasienRepository.cariDataLebihBesar();
	}
	
	public List<PasienModel> cariDataNegasi(){
		//utk tampilin semua data
		return this.pasienRepository.cariDataDan();
	}
}
