package br.mil.eb.ccomsex.sistema.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "fracao")
public class Fracao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "nome_fracao")
	private String nomeFracao;
	@ManyToOne
	@JoinColumn(name = "fracao_pai_id")
	private Fracao fracaoPai;
	@OneToMany(mappedBy = "fracaoPai", cascade = CascadeType.ALL)
	private List<Fracao> fracaoFilha = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeFracao() {
		return nomeFracao;
	}

	public void setNomeFracao(String nomeFracao) {
		this.nomeFracao = nomeFracao;
	}

	public Fracao getFracaoPai() {
		return fracaoPai;
	}

	public void setFracaoPai(Fracao fracaoPai) {
		this.fracaoPai = fracaoPai;
	}

	public List<Fracao> getFracaoFilha() {
		return fracaoFilha;
	}

	public void setFracaoFilha(List<Fracao> fracaoFilha) {
		this.fracaoFilha = fracaoFilha;
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
		Fracao other = (Fracao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
