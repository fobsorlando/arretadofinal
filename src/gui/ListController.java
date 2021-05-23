/*package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
import db.DbIntegrityException;
import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entities.Fornecedor;
import model.services.FornecedorService;

public class ListController implements Initializable, DataChangeListener {

	private FornecedorService service;

	@FXML
	private TableView<Fornecedor> tableViewFornecedor;

	@FXML
	private TableColumn<Fornecedor, Integer> tableColumnID;

	@FXML
	private TableColumn<Fornecedor, String> tableColumnName;
	
	@FXML
	private TableColumn<Fornecedor, String> tableColumnFantasia;
	
	@FXML
	private TableColumn<Fornecedor, String> tableColumnContato;
	
	@FXML
	private TableColumn<Fornecedor, String> tableColumnEmail1;
	
	@FXML
	private TableColumn<Fornecedor, String> tableColumnEmail2;
	
	@FXML
	private TableColumn<Fornecedor, String> tableColumnFone1;
	
	@FXML
	private TableColumn<Fornecedor, String> tableColumnFone2;
	
	@FXML
	private TableColumn <Fornecedor, Fornecedor> tableColumnREMOVE;
	
	@FXML
	private TableColumn <Fornecedor, Fornecedor> tableColumnEDIT;

	@FXML
	private Button btNovo;

	private ObservableList<Fornecedor> obsList;

	@FXML
	public void onBtNovoAction(ActionEvent event) {
		Stage parentStage = Utils.currentStage(event);
		Fornecedor obj = new Fornecedor(); // criar vazio
		createDialogForm(obj, "/gui/FornecedorForm.fxml", parentStage);
	}

	public void setFornecedorService(FornecedorService service) {
		this.service = service;
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	private void initializeNodes() {
		tableColumnID.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("no_fornecedor"));

		Stage stage = (Stage) Main.getMainScene().getWindow();

		// Fornecedor acompanhar tamanho do menu
		tableViewFornecedor.prefHeightProperty().bind(stage.heightProperty());
	}

	public void updateTableView() {
		// testa se veio dados na dependencia service
		if (service == null) {
			throw new IllegalStateException("Serice veio NULLO");
		}

		List<Fornecedor> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewFornecedor.setItems(obsList);
		initEditButtons(); // Acrescenta botão para alterar
		initRemoveButtons(); // Botão para remover

	}

	private void createDialogForm(Fornecedor obj, String absoluteName, Stage parentStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();

			// Pegar controldor da tela carregada acima
			FornecedorFormController controller = loader.getController();
			controller.setFornecedor(obj);
			controller.setFornecedorService(new FornecedorService()); // Inetando dependencia do servico
			controller.subscribeDataChangeListner(this);// Inscrever classe (ela mesma-this) para escutar evento
														// ONDATACHAGED
			controller.updateFormData(); // Carrega os dados do OBJ no formulario

			// novo Stage pq a janela vai ser modal.
			// tambem vai ser uma nova scena
			// uma janela em cima da outra

			Stage dialogStage = new Stage(); // novo palco
			dialogStage.setTitle("Incuir Fornecedor");
			dialogStage.setScene(new Scene(pane)); // Nova scena, que é o pane feito acima
			dialogStage.setResizable(false);
			dialogStage.initOwner(parentStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();

		} catch (IOException e) {
			Alerts.showAlert("ERRO IO", "ERRO CARREGA VIEW(E02)", e.getMessage(), AlertType.ERROR);

		}
	}

	@Override
	public void onDataChange() {
		updateTableView();

	}

	private void initEditButtons() {
		tableColumnEDIT.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnEDIT.setCellFactory(param -> new TableCell<Fornecedor, Fornecedor>() {
			private final Button button = new Button("Alterar");

			@Override
			protected void updateItem(Fornecedor obj, boolean empty) {
				super.updateItem(obj, empty);
				if (obj == null) {
					setGraphic(null);
					return;
				}
				setGraphic(button);
				button.setOnAction(
						event -> createDialogForm(obj, "/gui/FornecedorForm.fxml", Utils.currentStage(event)));
			}
		});
	}

	private void initRemoveButtons() {
		tableColumnREMOVE.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnREMOVE.setCellFactory(param -> new TableCell<Fornecedor, Fornecedor>() {
			private final Button button = new Button("Exclui");

			@Override
			protected void updateItem(Fornecedor obj, boolean empty) {
				super.updateItem(obj, empty);
				if (obj == null) {
					setGraphic(null);
					return;
				}
				setGraphic(button);
				button.setOnAction(event -> removeEntity(obj));
			}

		});
	}
	
	private void removeEntity(Fornecedor obj) {
		Optional <ButtonType> result =   Alerts.showConfirmation("Excluí", "Confirma Exclusão?");
		
		if (result.get() == ButtonType.OK) {
			if (service == null) {
				throw new IllegalStateException("Serice veio NULLO");
			}
			try { 
			 service.remove(obj);
			 updateTableView();
			}
			catch (DbIntegrityException e) {
				Alerts.showAlert("Erro Excluíndo Fornecedor", null, e.getMessage(), AlertType.ERROR);
			}
		}
		return ;
	}
}
 */
