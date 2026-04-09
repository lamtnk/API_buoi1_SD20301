package com.fpoly.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.model.DonHang;
import com.fpoly.repository.DonHangRepository;

@Service
public class DonHangService {
	@Autowired
	DonHangRepository donHangRepo;
	
	public List<Map<String, Object>> getAll() {
		List<Map<String, Object>> listMap = donHangRepo.findAll()
				.stream().map(donHang -> {
			Map<String, Object> map = new HashMap<>();
			map.put("id", donHang.getId());
			map.put("maDonHang", donHang.getMaDonHang());
			map.put("ngayDat", donHang.getNgayDat());
			map.put("tongTien", donHang.getTongTien());
			map.put("tenKhachHang", donHang.getKhachHang().getTenKhachHang());
			map.put("diaChi", donHang.getKhachHang().getDiaChi());
			return map;
		}).collect(Collectors.toList());
		return listMap;
	}
	
	public DonHang insert(DonHang dh) {
		return donHangRepo.save(dh);
	}
	
	public Optional<Map<String, Object>> getOne(Integer id) {
		Optional<Map<String, Object>> donHang = 
				donHangRepo.findById(id).map(d -> {
			Map<String, Object> map = new HashMap<>();
			map.put("id", d.getId());
			map.put("maDonHang", d.getMaDonHang());
			map.put("ngayDat", d.getNgayDat());
			map.put("tongTien", d.getTongTien());
			map.put("tenKhachHang", d.getKhachHang().getTenKhachHang());
			map.put("diaChi", d.getKhachHang().getDiaChi());
			return map;
		});
		return donHang;
	}
	
	public DonHang update(Integer id, DonHang donHang) {
		donHang.setId(id);
		return donHangRepo.save(donHang);
	}
	
	public void delete(Integer id) {
		donHangRepo.deleteById(id);
	}
}
