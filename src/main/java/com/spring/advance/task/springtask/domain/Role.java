package com.spring.advance.task.springtask.domain;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
@AllArgsConstructor
@Entity
public class Role implements GrantedAuthority {
   @Id
   private Long id;
   private String name;
   @Transient
   @ManyToMany(mappedBy = "roles")
   private Set<User> users;
   public Role() {
   }

   @Override
   public String getAuthority() {
      return getName();
   }
}
