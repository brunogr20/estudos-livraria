package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CloseEvent;
import org.primefaces.event.MoveEvent;
import org.primefaces.event.UnselectEvent;

import entities.Editora;
import entities.Livro;
import dao.EditoraDao;
//import service.JogoService;
import dao.LivroDao;


@ManagedBean(name = "LivroBean")
@SessionScoped
@Named("LivroBean")
@ApplicationScoped
public class LivroBean extends GenericBean{
	
	private List<Livro> livros;
	private List<Livro> filteredItens;
	private Livro livro; 
	private List<Editora> editoras;
	
	LivroDao livroDao;
	EditoraDao editoraDao;   
	
	public LivroBean(){
		livroDao = new  LivroDao();
		editoraDao = new  EditoraDao();
		
		this.livro = new Livro();
		editoras = editoraDao.getInstance().getEditoras();
		this.loadGrid();     	        
	}
	
    
    public void setJogos(List<Livro> livros) {
			this.livros = livros;
		}

	public List<Livro> getLivros() {
        return livros;
    }

		
	public List<Livro> getFilteredItens() {
		return filteredItens;
	}
	
	public List<Editora> getEditoras() {
		return editoras;
	}


	public void setEditoras(List<Editora> editoras) {
		this.editoras = editoras;
	}


	public void setFilteredItens(List<Livro> filteredItens) {
		this.filteredItens = filteredItens;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setJogo(Livro livro) {
		this.livro = livro;
	}
	

	  public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
	        String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
	        if (filterText == null || filterText.equals("")) {
	            return true;
	        }
	        
	        int filterInt = this.getInteger(filterText);
	 
	        Livro livro = (Livro) value;
	        
	        //if(!livro.getId().equals("")&&livro.getId()==filterText) {
	        if(livro.getId()!=null&&livro.getId().toString().contains(filterText)) {
	        	return true;
	        }
	        if(livro.getNome()!=null&&livro.getNome().toLowerCase().contains(filterText)) {
	        	return true;
	        }
	        if(livro.getDescricao()!=null&&livro.getDescricao().toLowerCase().contains(filterText)) {
	        	 return true;
	        }

	        return false;
	    }
	  
	  public void loadGrid() {
		  this.livros= livroDao.getInstance().getList("");
	  }
		 

	public void editForm(){
		this.setTitleTabFrom("Edição");
		this.livro = this.livros.get(this.getIndexSelected());
	}
	
    public void create() {
    	this.cleanForm();
    }
    
    public void cleanForm() {
       this.setTitleTabFrom("Inserção");
       this.livro = new Livro();
	}
    
	public boolean save() {
		
		if(this.livro.getIdEditora()==null||this.livro.getIdEditora().equals("")) {
			this.addMessage("WARNING", "Preencha o campo editora!");
			return false;
		}
		
		if(this.livro.getNome()==null||this.livro.getNome().equals("")) {
			this.addMessage("WARNING", "Preencha o campo nome!");
			return false;
		}
		if(this.livro.getAutor()==null||this.livro.getAutor().equals("")) {
			this.addMessage("WARNING", "Preencha o campo autor!");
			return false;
		}
	  /*  if(this.livro.getPreco().toString().equals("")) {
				this.addMessage("WARNING", "Preencha o campo preço!");
				return false;
		}
		System.out.println(this.isDouble(this.livro.getPreco().toString()));
		System.out.println("passou");
	    if(this.isDouble(this.livro.getPreco().toString())) {
			this.addMessage("WARNING", "Preencha o campo preço!");
			return false;
		}*/
			
		boolean status;
		System.out.println(livro.getId());
		if(livro.getId()==null) { 
			status = livroDao.getInstance().create(livro);
		}else {
			status = livroDao.getInstance().update(livro);
		}
		
	    if(status==true){
			this.addMessage("SUCCESS", "Livro salvo com sucesso!");
			this.cleanForm();
			this.loadGrid();
		}else {
			this.addMessage("ERROR", "Não foi possível salvar o livro!");
		}
	    return true;
    }


	public void delete() { 
	    if(livroDao.getInstance().delete(this.livros.get(this.getIndexSelected()))) {
	    	this.addMessage("SUCCESS", "Item deletado com sucesso!");
	    	this.cleanForm();
			this.loadGrid();
	    }else {
	    	this.addMessage("ERROR", "Não foi possível deletar esse item!");
	    }
	}
	

     
}