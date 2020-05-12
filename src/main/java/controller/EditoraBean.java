package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import dao.EditoraDao;
import entities.Editora;

@ManagedBean(name = "EditoraBean")
@SessionScoped
@Named("EditoraBean")
@ApplicationScoped
public class EditoraBean extends GenericBean{
	
	private List<Editora> editoras;
	private List<Editora> filteredItens;
	private Editora editora; 
	
	EditoraDao editoraDao;
    
	
	public EditoraBean(){
		editoraDao = new  EditoraDao();
		this.editora = new Editora();
		this.loadGrid();
       	
         
	}


    
    public void setJogos(List<Editora> livros) {
			this.editoras = editoras;
		}

	public List<Editora> getEditoras() {
    	//System.out.println(jogos);
        return editoras;
    }

		
	public List<Editora> getFilteredItens() {
		return filteredItens;
	}

	public void setFilteredItens(List<Editora> filteredItens) {
		this.filteredItens = filteredItens;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	

	  public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
	        String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
	        if (filterText == null || filterText.equals("")) {
	            return true;
	        }
	        
	        int filterInt = this.getInteger(filterText);
	 
	        Editora livro = (Editora) value;
	        
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
		  this.editoras  = editoraDao.getInstance().getList("");
		  //new Editora(1L,"q","",1)
	  }
		 

	public void editForm(){
		this.setTitleTabFrom("Edição");
		this.editora = this.editoras.get(this.getIndexSelected());
	}
	
    public void create() {
    	this.cleanForm();
    }
    
    public void cleanForm(){
       this.setTitleTabFrom("Inserção");
       this.editora = new Editora();
	}
    
	public boolean save(){
		
		if(this.editora.getNome()==null||this.editora.getNome().equals("")) {
			this.addMessage("WARNING", "Preencha o campo nome!");
			return false;
		}

		
		boolean status;
		System.out.println(editora.getId());
		if(editora.getId()==null) {
			System.out.println("create");
			status = editoraDao.getInstance().create(editora);
		}else {
			System.out.println("update");
			status = editoraDao.getInstance().update(editora);
		}
		
	    if(status==true){
			this.addMessage("SUCCESS", "Editora salva com sucesso!");
			this.cleanForm();
			this.loadGrid();
		}else {
			this.addMessage("ERROR", "Não foi possível salvar a editora!");
		}
	    return true;
    }


	public void delete() { 
	    if(editoraDao.getInstance().delete(this.editoras.get(this.getIndexSelected()))) {
	    	this.addMessage("SUCCESS", "Item deletado com sucesso!");
	    	this.cleanForm();
			this.loadGrid();
	    }else {
	    	this.addMessage("ERROR", "Não foi possível deletar esse item!");
	    }
	}
	

     
}