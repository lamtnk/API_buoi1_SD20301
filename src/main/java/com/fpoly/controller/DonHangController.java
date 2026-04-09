package com.fpoly.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.model.DonHang;
import com.fpoly.repository.DonHangRepository;
import com.fpoly.service.DonHangService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/donHang")
public class DonHangController {
	@Autowired
	DonHangService donHangSer;
	
	@GetMapping
	public List<Map<String, Object>> getAll() { // read
		return donHangSer.getAll();
	}
	
	@PostMapping
	public DonHang insert(@RequestBody DonHang donHang) {
		return donHangSer.insert(donHang);
	}
	
	@GetMapping("/{id}")
	public Optional<Map<String, Object>> getOne(@PathVariable Integer id) {
		return donHangSer.getOne(id);
	}
	
	@PutMapping("/{id}")
	public DonHang update(@PathVariable Integer id, 
			@RequestBody DonHang donHang) {
		return donHangSer.update(id, donHang);
	}
	
	@DeleteMapping("/{id}")
	public Map delete(@PathVariable Integer id) {
		donHangSer.delete(id);
		return Map.of("message", "Xóa thành công");
	}
}
