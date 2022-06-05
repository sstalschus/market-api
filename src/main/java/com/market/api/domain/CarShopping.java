package com.market.api.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

/**
 * The type Car shopping.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarShopping {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToMany
  private List<ProductInCart> products;

  @Column
  private BigDecimal value;

  @ManyToOne
  private Customer customer;

  @Column(nullable = false, updatable = false)
  @CreationTimestamp
  private Date createdAt;

}
