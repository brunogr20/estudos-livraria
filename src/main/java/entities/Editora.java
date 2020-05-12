package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EDITORA")
public class Editora {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(generator = "S_EDITORA")
	@SequenceGenerator(name = "S_EDITORA", sequenceName = "S_EDITORA", allocationSize = 1)
	private Long id;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Column(name="STATUS")
	private boolean status;
		 
   // @ManyToMany
   // @JoinTable(name="JOGO_PLATAFORMA",
    //joinColumns=@JoinColumn(name="ID"),inverseJoinColumns=@JoinColumn(name="ID"))
	//private List<Livro> jogos;
	
	public Editora(){}
	
	public Editora(Long id, String nome, String descricao,boolean status) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.status = status;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

}
