package br.com.bakery.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PACK")
public class Pack {

	@Id
	@GeneratedValue
	@Column(name = "PACK_ID")
	private Integer id;

	@Column(name = "PRODUCT_QUANTITY")
	private Integer productQuantity;
	
	@Column(name = "PACK_COST")
	private Double packCost;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="CODE", nullable=false)
    private Product product;
	
}
