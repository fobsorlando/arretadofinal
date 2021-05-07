package model.entities;

import java.io.Serializable;

public class Fornecedor implements Serializable  {

	
	/**
	 *  Orlando Saboia
	 *  Abril / 2021
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer Id;
	private String no_fornecedor;
	private String no_fantasia;
	private String no_contato;
	private String no_email1;
	private String no_email2;
	private String nr_telefone1;
	private String nr_telefone2;
	private String nr_cep;
	private String no_endereco;
	private Integer nr_numero;
	private String no_complemento;
	private String no_cidade;
	private String sg_uf;
	private String no_observacao;
	private String nr_cpf_cnpj;
	
	
	public Fornecedor() {
		
	}
	
	public Fornecedor(int id, String no_fornecedor) {
		this.Id = id;
		this.no_fornecedor = no_fornecedor;
		
	}


	public Fornecedor(String no_fornecedor, String no_fantasia, String no_contato, String no_email, String nr_telefone1,
			String nr_telefone2, String nr_cep, String no_endereco, Integer nr_numero, String no_complento,
			String no_cidade, String sg_uf, String no_observacao) {
		super();
		this.no_fornecedor = no_fornecedor;
		this.no_fantasia = no_fantasia;
		this.no_contato = no_contato;
		this.no_email1 = no_email1;
		this.no_email2 = no_email2;
		this.nr_telefone1 = nr_telefone1;
		this.nr_telefone2 = nr_telefone2;
		this.nr_cep = nr_cep;
		this.no_endereco = no_endereco;
		this.nr_numero = nr_numero;
		this.no_complemento = no_complento;
		this.no_cidade = no_cidade;
		this.sg_uf = sg_uf;
		this.no_observacao = no_observacao;
	}


	public String getNo_fornecedor() {
		return no_fornecedor;
	}


	public void setNo_fornecedor(String no_fornecedor) {
		this.no_fornecedor = no_fornecedor;
	}


	public String getNo_fantasia() {
		return no_fantasia;
	}


	public void setNo_fantasia(String no_fantasia) {
		this.no_fantasia = no_fantasia;
	}


	public String getNo_contato() {
		return no_contato;
	}


	public void setNo_contato(String no_contato) {
		this.no_contato = no_contato;
	}


	public String getNo_email1() {
		return no_email1;
	}


	public void setNo_email1(String no_email1) {
		this.no_email1 = no_email1;
	}
	
	public String getNo_email2() {
		return no_email2;
	}


	public void setNo_email2(String no_email2) {
		this.no_email2 = no_email2;
	}

	public String getNr_telefone1() {
		return nr_telefone1;
	}


	public void setNr_telefone1(String nr_telefone1) {
		this.nr_telefone1 = nr_telefone1;
	}


	public String getNr_telefone2() {
		return nr_telefone2;
	}


	public void setNr_telefone2(String nr_telefone2) {
		this.nr_telefone2 = nr_telefone2;
	}


	public String getNr_cep() {
		return nr_cep;
	}


	public void setNr_cep(String nr_cep) {
		this.nr_cep = nr_cep;
	}


	public String getNo_endereco() {
		return no_endereco;
	}


	public void setNo_endereco(String no_endereco) {
		this.no_endereco = no_endereco;
	}


	public Integer getNr_numero() {
		return nr_numero;
	}


	public void setNr_numero(Integer nr_numero) {
		this.nr_numero = nr_numero;
	}


	public String getNo_complemento() {
		return no_complemento;
	}


	public void setNo_complemento(String no_complemento) {
		this.no_complemento = no_complemento;
	}


	public String getNo_cidade() {
		return no_cidade;
	}


	public void setNo_cidade(String no_cidade) {
		this.no_cidade = no_cidade;
	}


	public String getSg_uf() {
		return sg_uf;
	}


	public void setSg_uf(String sg_uf) {
		this.sg_uf = sg_uf;
	}


	public String getNo_observacao() {
		return no_observacao;
	}


	public void setNr_cpf_cgc(String nr_cpf_cnpj) {
		this.nr_cpf_cnpj = nr_cpf_cnpj;
	}
	public String getNr_cpf_cnpj() {
		return nr_cpf_cnpj;
	}


	public void setNo_observacao(String no_observacao) {
		this.no_observacao = no_observacao;
	}

	public Integer getId() {
		return Id;
	}
	
	public void setId(Integer id) {
		this.Id = id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((no_fornecedor == null) ? 0 : no_fornecedor.hashCode());
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
		Fornecedor other = (Fornecedor) obj;
		if (no_fornecedor == null) {
			if (other.no_fornecedor != null)
				return false;
		} else if (!no_fornecedor.equals(other.no_fornecedor))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Fornecedor [Id=" + Id + ", no_fornecedor=" + no_fornecedor + ", no_fantasia=" + no_fantasia
				+ ", no_contato=" + no_contato + ", no_email=" + no_email1 + ", nr_telefone1=" + nr_telefone1
				+ ", nr_telefone2=" + nr_telefone2 + ", nr_cep=" + nr_cep + ", no_endereco=" + no_endereco
				+ ", nr_numero=" + nr_numero + ", no_complento=" + no_complemento + ", no_cidade=" + no_cidade
				+ ", sg_uf=" + sg_uf + ", no_observacao=" + no_observacao + "]";
	}
		
	
}
