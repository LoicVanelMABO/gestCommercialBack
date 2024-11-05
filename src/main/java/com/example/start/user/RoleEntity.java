package com.example.start.user;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "role")
public class RoleEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer id;

        @Column(name = "role", nullable = false, length = 255)
        private String role;

        @JsonManagedReference
        @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<UserEntity> users;

        // Getters and Setters

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return role;
        }

        public void setName(String role) {
            this.role = role;
        }

        public List<UserEntity> getUsers() {
            return users;
        }

        public void setUsers(List<UserEntity> users) {
            this.users = users;
        }
}
