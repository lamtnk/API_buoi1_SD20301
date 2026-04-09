package com.fpoly.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "don_hang")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonHang {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Column(name = "ma_don_hang")
	String maDonHang;
	
	@Column(name = "ngay_dat")
	LocalDate ngayDat;
	
	@Column(name = "tong_tien")
	Float tongTien;
	
	@Column(name = "dia_chi_giao")
	String diaChiGiao;
	
	@Column(name = "so_dien_thoai_giao")
	String sdtGiao;
	
	@Column(name = "ghi_chu")
	String ghiChu;
	
	@Column(name = "trang_thai")
	String trangThai;
	
	@Column(name = "nguoi_xu_ly")
	String nguoiXuLy;
	
	@ManyToOne
	@JoinColumn (name = "khach_hang_id")
	KhachHang khachHang;
	
	@JsonProperty("khachHangId")
	public void setKhachHangId(Integer id) {
		this.khachHang = new KhachHang();
		this.khachHang.setId(id);
	}
}
