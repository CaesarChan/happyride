package io.vividcode.happyride.driverservice.model;

import io.vividcode.happyride.common.BaseEntityWithGeneratedId;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "drivers")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Driver extends BaseEntityWithGeneratedId {
  @Column(name = "name")
  private String name;

  @Column(name = "email")
  @Email
  private String email;

  @Column(name = "mobile_phone_number")
  private String mobilePhoneNumber;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "driver_id", referencedColumnName = "id", nullable = false)
  private Set<Vehicle> vehicles = new HashSet<>();
}
