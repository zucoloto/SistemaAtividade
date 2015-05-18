package br.mil.eb.ccomsex.sistema.model.entity;

public enum StatusAtividade {

	ADIADA("Adiada"), AGUARDANDO_ALGUEM("Aguardando Alguém"), CONCLUIDA("Concluída"), EM_ANDAMENTO("Em Andamento"), NAO_INICIADA("Não Iniciada");

	private String descricao;

	StatusAtividade(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
