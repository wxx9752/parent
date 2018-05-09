package com.jk.login.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "power")
public class Power implements Serializable{
	private static final long serialVersionUID = 4477398685355837628L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
      private Integer id;
	@Column
      private String text;
	@Column
      private Integer parentid;
	@Column
      private String icon;
	@Column
      private String state;
	@Column
      private String url;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
