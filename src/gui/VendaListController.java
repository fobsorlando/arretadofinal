package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entities.Cliente;
import model.entities.Venda;
import model.services.VendaService;

public class VendaListController implements Initializable, DataChangeListener {

	private VendaService service;

	@FXML
	private TableView<Venda> tableViewVenda;

	@FXML
	private TableColumn<Venda, Integer> tableColumnID;

	@FXML
	private TableColumn<Venda, String> tableColumnName;
	
	@FXML
	private TableColumn <Venda, Venda> tableColumnREMOVE;
	
	@FXML
	private TableColumn <Venda, Venda> tableColumnEDIT;

	@FXML
	private Button btNovo;

	private ObservableList<Venda> obsList;

	@FXML
	public void onBtNovoAction(ActionEvent event) {
		Stage parentStage = Utils.currentStage(event);
		Venda obj = new Venda(); // criar vazio
		obj.setCliente(new Cliente());
		createDialogForm(obj, "/gui/VendaForm.fxml", parentStage);
	}

	public void setVendaService(VendaService service) {
		this.service = service;
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	private void initializeNodes() {
		tableColumnID.setCellValueFactory(new PropertyValueFactory<>("sg_venda"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("no_venda"));

		Stage stage = (Stage) Main.getMainScene().getWindow();

		// Venda acompanhar tamanho do menu
		tableViewVenda.prefHeightProperty().bind(stage.heightProperty());
	}

	public void updateTableView() {
		// testa se veio dados na dependencia service
		if (service == null) {
			throw new IllegalStateException("Serice veio NULLO");
		}

		List<Venda> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewVenda.setItems(obsList);
		initEditButtons(); // Acrescenta botão para alterar
		//initRemoveButtons(); // Botão para remover

	}

	private void createDialogForm(Venda obj, String absoluteName, Stage parentStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();

			// Pegar controldor da tela carregada acima
			VendaFormController controller = loader.getController();
			controller.setVenda(obj);
			controller.setVendaService(new VendaService()); // Inetando dependencia do servico
			controller.subscribeDataChangeListner(this);// Inscrever classe (ela mesma-this) para escutar evento
														// ONDATACHAGED
			controller.updateFormData(); // Carrega os dados do OBJ no formulario

			// novo Stage pq a janela vai ser modal.
			// tambem vai ser uma nova scena
			// uma janela em cima da outra

			Stage dialogStage = new Stage(); // novo palco
			dialogStage.setTitle("Incuir Venda");
			dialogStage.setScene(new Scene(pane)); // Nova scena, que é o pane feito acima
			dialogStage.setResizable(false);
			dialogStage.initOwner(parentStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();

		} catch (IOException e) {
			System.out.println(e.getMessage());
			Alerts.showAlert("ERRO IO", "ERRO CARREGA VIEW(E02)", e.getMessage(), AlertType.ERROR);

		}
	}

	@Override
	public void onDataChange() {
		updateTableView();

	}

	private void initEditButtons() {
		tableColumnEDIT.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnEDIT.setCellFactory(param -> new TableCell<Venda, Venda>() {
			private final Button button = new Button("Alterar");

			@Override
			protected void updateItem(Venda obj, boolean empty) {
				super.updateItem(obj, empty);
				if (obj == null) {
					setGraphic(null);
					return;
				}
				setGraphic(button);
				button.setOnAction(
						event -> createDialogForm(obj, "/gui/VendaForm.fxml", Utils.currentStage(event)));
			}
		});
	}

	/*
	private void initRemoveButtons() {
		tableColumnREMOVE.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnREMOVE.setCellFactory(param -> new TableCell<Venda, Venda>() {
			private final Button button = new Button("Exclui");

			@Override
			protected void updateItem(Venda obj, boolean empty) {
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
	
	private void removeEntity(Venda obj) {
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
				Alerts.showAlert("Erro Excluíndo Venda", null, e.getMessage(), AlertType.ERROR);
			}
		}
		return ;
	}
	*/
}
 
