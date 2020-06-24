package com.example.smartspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//JPA itu spesifikasi, hibernate ....
//JPA untuk integrasi dengan prangkat lain
@Entity
//entity utk menghubungkan?
//entiti termasuk konsep yg ada di JPA
@Table(name="T_OFFICE")
public class OfficeModel {
	//1.buat method variable
	//utk pemakaian nama tabel dan kolom
	@Id
	@Column (name="Nomor_Office")
	private int nomorOffice;
	
	@Column (name="Nama_Office")
	private String namaOffice;
	
	@Column (name="Total_Penjualan")
	private int totalPenjualan;
	
	//2. lalu buat POJO getter and setter
	//untuk memberi nilai tabel dan kolom
	public int getNomorOffice() {
		return nomorOffice;
	}
	public void setNomorOffice(int nomorOffice) {
		this.nomorOffice = nomorOffice;
	}
	public String getNamaOffice() {
		return namaOffice;
	}
	public void setNamaOffice(String namaOffice) {
		this.namaOffice = namaOffice;
	}
	public int getTotalPenjualan() {
		return totalPenjualan;
	}
	public void setTotalPenjualan(int totalPenjualan) {
		this.totalPenjualan = totalPenjualan;
	}
	
	
	
	
}
