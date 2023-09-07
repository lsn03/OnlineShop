package com.example.springsecurityofficial.entity.product;

import jakarta.persistence.*;

@Entity
@Table(name = "аудио_информация")
public class AudioInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Монитор_id")
	private int id;
	@Column(name = "Выход_на_наушники")
	private String headphoneOutput;
	@Column(name = "Мощность_динамиков")
	private String powerDynamic;
	@Column(name = "Встроенные_динамики")
	private String includedDynamic;
	
	public AudioInfo() {
	}
	
	public AudioInfo(String headphoneOutput, String powerDynamic, String includedDynamic) {
		this.headphoneOutput = headphoneOutput;
		this.powerDynamic = powerDynamic;
		this.includedDynamic = includedDynamic;
	}
	
	@Override
	public String toString() {
		return "AudioInfo{" +
				"id=" + id +
				", headphoneOutput='" + headphoneOutput + '\'' +
				", powerDynamic='" + powerDynamic + '\'' +
				", includedDynamic='" + includedDynamic + '\'' +
				'}';
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getHeadphoneOutput() {
		return headphoneOutput;
	}
	
	public void setHeadphoneOutput(String headphoneOutput) {
		this.headphoneOutput = headphoneOutput;
	}
	
	public String getPowerDynamic() {
		return powerDynamic;
	}
	
	public void setPowerDynamic(String powerDynamic) {
		this.powerDynamic = powerDynamic;
	}
	
	public String getIncludedDynamic() {
		return includedDynamic;
	}
	
	public void setIncludedDynamic(String includedDynamic) {
		this.includedDynamic = includedDynamic;
	}
}
