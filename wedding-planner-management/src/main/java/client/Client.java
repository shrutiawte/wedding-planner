package client;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String weddingDate;
    private Double budget;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWeddingDate() {
		return weddingDate;
	}
	public void setWeddingDate(String weddingDate) {
		this.weddingDate = weddingDate;
	}
	public Double getBudget() {
		return budget;
	}
	public void setBudget(Double budget) {
		this.budget = budget;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", weddingDate=" + weddingDate + ", budget=" + budget + "]";
	}

    // Getters and Setters
    
}
