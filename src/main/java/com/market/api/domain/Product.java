package com.market.api.domain;

import com.market.api.domain.enums.MeasureType;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

/**
 * The type Product.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  private Brand brand;

  @Column
  private String barcode;

  @Column
  private Integer quantity;

  @Column
  private BigDecimal price;

  @Column
  @Enumerated(EnumType.ORDINAL)
  private MeasureType measure;

  @Column
  private String picture;

  @Column(nullable = false, updatable = false)
  @CreationTimestamp
  private Date createdAt;

}
