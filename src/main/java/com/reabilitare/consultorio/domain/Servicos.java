package com.reabilitare.consultorio.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Servicos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String servicos;
	private Integer valor;
	private Integer quantidade;
	
	public Servicos() {
		
	}

		public Servicos(Integer id, String servicos, Integer valor, Integer quantidade) {
		super();
		this.id = id;
		this.servicos = servicos;
		this.valor = valor;
		this.quantidade = quantidade;
	}


	public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getServicos() {
			return servicos;
		}

		public void setServicos(String servicos) {
			this.servicos = servicos;
		}

		public Integer getValor() {
			return valor;
		}

		public void setValor(Integer valor) {
			this.valor = valor;
		}

		public Integer getQuantidade() {
			return quantidade;
		}

		public void setQuantidade(Integer quantidade) {
			this.quantidade = quantidade;
		}



	@Override
		public String toString() {
			return "Sevicos [id=" + id + ", servicos=" + servicos + ", valor=" + valor + ", quantidade=" + quantidade
					+ "]";
		}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servicos other = (Servicos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
}
