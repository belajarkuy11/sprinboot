package com.arca.tutorial;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v3")
public class OrangController {

	@Autowired
	OrangRepository orangRepo;
	
	@PostMapping("/simpan")
	public ResponseEntity<?> simpan(@RequestBody Orang or) {
		orangRepo.save(or);
		return new ResponseEntity<Orang>(or, HttpStatus.OK);
	}
	
	@GetMapping("/ambil/semua")
	public ResponseEntity<?> ambilList() {
		Optional<List<Orang>> lst = Optional.ofNullable(orangRepo.findAll());
		return new ResponseEntity< List<Orang> >(lst.get(), HttpStatus.OK); 
	}
	
	@GetMapping("/ambil/{nama}")
	public ResponseEntity<?> ambilNama(@PathVariable(value = "nama")String nama) {
		Optional<Orang> orang = orangRepo.findByNama(nama);		
		return new ResponseEntity<Orang>(orang.get(), HttpStatus.OK);
	}
}
