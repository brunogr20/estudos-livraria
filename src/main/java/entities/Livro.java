package entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="LIVRO")
public class Livro {
	
    @Id
	@Column(name="ID", nullable = false)
	@GeneratedValue(generator = "S_LIVRO")
	@SequenceGenerator(name = "S_LIVRO", sequenceName = "S_LIVRO", allocationSize = 1)
	private Long id;
    
    @Column(name="ID_EDITORA")
  	private Long idEditora;
      
    @Column(name="NOME")
	private String nome;
    
    @Column(name="AUTOR")
	private String autor;
    
    @Column(name="DESCRICAO")
	private String descricao;
    
    @Column(name="PRECO")
	private Double  preco;
    
    @Column(name="STATUS")
   	private boolean status;
    
	public Livro(){}

	public Livro(Long id, Long idEditora, String nome, String autor, String descricao, Double preco, boolean status) {
		this.id = id;
		this.idEditora=idEditora;
		this.nome = nome;
		this.autor = autor;
		this.descricao = descricao;
		this.preco = preco;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getIdEditora() {
		return idEditora;
	}

	public void setIdEditora(Long idEditora) {
		this.idEditora = idEditora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	

}
