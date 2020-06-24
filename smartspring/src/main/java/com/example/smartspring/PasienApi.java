package com.example.smartspring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.smartspring.model.PasienModel;
import com.example.smartspring.service.PasienService;

@RestController
//di sini boleh dimapping
@RequestMapping("/api/pasien")
public class PasienApi {
	
	//			| DI API NAMANYA :
	//INSERT	| POST
	//READ		| GET
	@Autowired
	private PasienService pasienService;
	
	//POST || INSERT
	//map untuk masang sebuah pesan
	@PostMapping ("/post") //digunakan untuk  me-mapping suatu method sebagai fungsi insert data dalam API
	//kalo insert, pakai create
	//Http status
	//bagusnya dipakein code, misal 200 itu code buat berhasil insert
	@ResponseStatus(code=HttpStatus.CREATED)
	public Map<String, Object> postMapping(@RequestBody PasienModel pasienModel) {
		//post itu insert kalo dalam API
		
		//maksudnya ketika data ditambahkan, tar masuknya ke pasienModel
		this.pasienService.create(pasienModel);
		
		Map<String, Object> map = new HashMap<String, Object>();
		//dengan hashmap kita bisa buat pesan ketika berhasil
		
		map.put("success", Boolean.TRUE);
		map.put("pesan", "datanya sudah masuk");
		return map;
		
	}
	
	//GET || READ
	@GetMapping("/get")
	//kalo mau lihat data, pake OK
	//200
	@ResponseStatus(code=HttpStatus.OK)
	public List<PasienModel> getMapping(){
		
		List<PasienModel> pasienModelList = new ArrayList<PasienModel>();
		pasienModelList = this.pasienService.readData();
		return pasienModelList;
	}
	
		//pada dasarnya update tu isi data kan?
		//nah update pakai fungsi yg hampir sama kaya pas create data
		
		
		//PUT || UPDATE
		@PutMapping ("/put")
		@ResponseStatus(code=HttpStatus.OK)
		public Map<String, Object> putMapping(@RequestBody PasienModel pasienModel){
			
			this.pasienService.update(pasienModel);
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("success", Boolean.TRUE);
			map.put("pesan", "update berhasil");
			return map;
		}
		
		//DELETE
		@DeleteMapping("/delete/{kodePasien}")
		//path itu lokasi kan, lebih spesifik
		//pathVariable harus pasang sebagai ID/primary key
		//oh iya delete nya tergantung yg di service
		public Map<String, Object> remove(@PathVariable String kodePasien){
			
			this.pasienService.remove(kodePasien);
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("success", Boolean.TRUE);
			map.put("delete", "Berhasil");
			return map;
		}
	
	//tamilkan data berdasarkan Nama dari urutan terbesar hingga terkecil(Z-A)
	
		//GET || READ
		@GetMapping("/getUrut")
		//kalo mau lihat data, pake OK
		//200
		@ResponseStatus(code=HttpStatus.OK)
		public List<PasienModel> getUrutMapping(){
			
			List<PasienModel> pasienModelList = new ArrayList<PasienModel>();
			pasienModelList = this.pasienService.pasienUrut();
			return pasienModelList;
		}
		
		
		@GetMapping("/getNamaMengandung")
		@ResponseStatus(code=HttpStatus.OK)
		public List<PasienModel> getMengandung(){
			
			List<PasienModel> pasienModelList = new ArrayList<PasienModel>();
			pasienModelList = this.pasienService.cariDataMengandung();
			return pasienModelList;
		}
		
		
		@GetMapping("/getNamaDepan")
		@ResponseStatus(code=HttpStatus.OK)
		public List<PasienModel> getHuruf(){
			
			List<PasienModel> pasienModelList = new ArrayList<PasienModel>();
			pasienModelList = this.pasienService.cariDataA();
			return pasienModelList;
		}
		
		@GetMapping("/getBiayaLebihBesar")
		@ResponseStatus(code=HttpStatus.OK)
		public List<PasienModel> getBiayaBesar(){
			
			List<PasienModel> pasienModelList = new ArrayList<PasienModel>();
			pasienModelList = this.pasienService.cariDataBesar();
			return pasienModelList;
		}
		
		@GetMapping("/getBiayaDan")
		@ResponseStatus(code=HttpStatus.OK)
		public List<PasienModel> getBiayaNegasi(){
			
			List<PasienModel> pasienModelList = new ArrayList<PasienModel>();
			pasienModelList = this.pasienService.cariDataNegasi();
			return pasienModelList;
		}
}