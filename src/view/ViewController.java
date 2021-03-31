/**
 * 
 */
package view;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import model.entities.Pessoa;

/**
 * classe controladora da View.fxml
 *
 */
public class ViewController implements Initializable{
	
	@FXML
	private ComboBox<Pessoa> comboxBoxPessoa;
	
	private ObservableList<Pessoa> obsList;
	
	@FXML
	private Button btAll;
	
	/**
	 * Percorre os elementos da combobox
	 */
	@FXML
	public void onBtAllAction() {
		for (Pessoa pessoa : comboxBoxPessoa.getItems()) {
			System.out.println(pessoa);
		}
	}
	
	
	@FXML
	public void onComboBoxPessoaAction() {
		// Pegando o item selecionado no comboBox:
		Pessoa pessoa = comboxBoxPessoa.getSelectionModel().getSelectedItem();
		System.out.println(pessoa);
	}
	

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		List<Pessoa> list = new ArrayList<>();
		list.add(new Pessoa(1, "Maria", "maria@gmail.com"));
		list.add(new Pessoa(2, "João", "joao@gmail.com"));
		list.add(new Pessoa(3, "Bob", "bob@gmail.com"));
		
		// Instancia o objt ObservableList<Pessoa> desta classe.
		obsList = FXCollections.observableArrayList(list); 
		// Carrega os dados da obsList no comboBox.
		comboxBoxPessoa.setItems(obsList);
		
		// Carrega somente os dados de nomes das pessoas para o comboBox:
		Callback<ListView<Pessoa>, ListCell<Pessoa>> factory = lv -> new ListCell<Pessoa>() {

			@Override
			protected void updateItem(Pessoa pessoa, boolean empty) {
				super.updateItem(pessoa, empty);
				setText(empty ? "" : pessoa.getNome());
			}
			
		};
		
		comboxBoxPessoa.setCellFactory(factory);
		comboxBoxPessoa.setButtonCell(factory.call(null));
		
	}
	
	
	
}
