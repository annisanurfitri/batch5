package com.example.smartspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.smartspring.model.PasienModel;

//repository kelasnya abstrak krn dia menginherit
//mengolah db dengan mengextend jpa
//JpaRepository <Tabel DB, Tipe Variabel Primary Key Tabelnya>
//cth: PK nya KodePasien tipe data nya sTring
public interface PasienRepository extends JpaRepository<PasienModel, String>{

	//kalo butuh search data, butuh tulis query disini
	//kalo cuma insert delete, udah ada.
	
	//@Query ("select p from pasienModel p")//==mencari seluruh pasiendata di pasienModel
	//p adalah alias tabel nya
	//manggil salah 1 kolom aja + p.namaPasien akhir
	//@Query ("select * from pasienModel")
	//bacadata apaan? 
	//List<PasienModel> bacaData();
	
	//@Query("select p from pasienModel p where p.namaPasien like %?1%")
	//%1% adalah 1 parameter. kalo 2? %2%
	//List<PasienModel> cariNama(String namaPasien);
	
	
	//JPQL
	@Query("select p from PasienModel p order by p.namaPasien desc")
	List<PasienModel> pasien();
	
	//ini buat CRUD di API ya bukan otomatis
	//?1 menandakan parameter kita jumlanya 1
	@Query("select p from PasienModel p where p.namaPasien LIKE '%a%'")
	//nama parameternya bebas gausah sesuai sama table
	List<PasienModel> cariDataYangMengandung();
	
	@Query("select p from PasienModel p where p.namaPasien LIKE 'a%'")
	//nama parameternya bebas gausah sesuai sama table
	List<PasienModel> cariDataDepanA();
	
	@Query("select p from PasienModel p where p.biaya > 2000")
	//nama parameternya bebas gausah sesuai sama table
	List<PasienModel> cariDataLebihBesar();
	
	@Query("select p from PasienModel p where p.biaya <1000 AND p.biaya >500")
	//nama parameternya bebas gausah sesuai sama table
	List<PasienModel> cariDataDan();
	
	
}
