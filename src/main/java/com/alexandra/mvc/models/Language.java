package com.alexandra.mvc.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
// should be plural
@Table(name = "languages")
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 1, max = 100)
    private String name;
    @Size(min = 5, max = 20)
    private String creator;
    @Size(min = 3, max = 20)
    private String version;
    // This will not allow the column createdat and updatedat be changed after created
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
//    constructor
    public Language() {
    	
    }
//    constructor
    public Language(String name, String creator, String version) {
    	this.name = name;
    	this.creator = creator;
    	this.version = version;
    }
//    getters and setters
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
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
    
    

}
