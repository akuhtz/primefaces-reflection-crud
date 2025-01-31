package it.strazz.primefaces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import it.strazz.primefaces.columns.ColumnModel;
import it.strazz.primefaces.columns.ReflectionColumnModelBuilder;
import it.strazz.primefaces.model.User;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class BasicExampleBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<ColumnModel> columns = new ArrayList<ColumnModel>(0);
	
	@PostConstruct
	public void init() {
		columns = new ReflectionColumnModelBuilder(User.class).
					setExcludedProperties("id").
					build();
	}
	
	public List<User> getUsers(){
		return User.getAll();
	}

	public List<ColumnModel> getColumns() {
		return columns;
	}
}
