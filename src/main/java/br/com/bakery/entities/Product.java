package br.com.bakery.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCT")
public class Product {

	@Id
	@Column(name = "CODE")
	private String code;

	@Column(name = "NAME")
	private String name;
	
	@OneToMany(mappedBy = "product", targetEntity = Pack.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Pack> packs;
	
}
