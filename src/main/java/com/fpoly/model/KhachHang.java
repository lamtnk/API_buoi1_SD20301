package com.fpoly.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "khach_hang")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KhachHang {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Column(name = "ten_khach_hang")
	String tenKhachHang;
	
	@Column(name = "dia_chi")
	String diaChi;
	
	@Column(name = "so_dien_thoai")
	String sdt;
	
	String email;
	
	@Column(name = "ngay_sinh")
	LocalDate ngaySinh;
	
	@Column(name = "gioi_tinh")
	Boolean gioiTinh;
	
	@Column(name = "diem_tich_luy")
	Float diemTichLuy;
	
	@Column(name = "trang_thai")
	Boolean trangThai;
	
	@Column(name = "ghi_chu")
	String ghiChu;
	
	@OneToMany (mappedBy = "khachHang")
	@JsonIgnore
	List<DonHang> donHangs;
}
