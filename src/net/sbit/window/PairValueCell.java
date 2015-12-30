package net.sbit.window;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableRow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Pair;
import net.sbit.controller.ControladorAsignarVentanaEnComponente;

public class PairValueCell extends TableCell<Pair<String, Object>, Object> {

    @Override
    protected void updateItem(Object item, boolean empty) {
	super.updateItem(item, empty);

	if (item != null) {
	    if (item instanceof String) {
		setText((String) item);
		setGraphic(null);
	    } else if (item instanceof Integer) {
		setText(Integer.toString((Integer) item));
		setGraphic(null);
	    } else if (item instanceof Boolean) {
		CheckBox checkBox = new CheckBox();
		checkBox.setSelected((boolean) item);
		checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {

		    @SuppressWarnings({ "rawtypes", "unchecked" })
		    @Override
		    public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
			TableRow row = (TableRow) getParent();
			Pair<String, Object> valor = (Pair<String, Object>) row.getItem();
			ControladorAsignarVentanaEnComponente.modificarValorEnObservableList(valor.getKey());
		    }

		});
		setGraphic(checkBox);
	    } else if (item instanceof Image) {
		setText(null);
		ImageView imageView = new ImageView((Image) item);
		imageView.setFitWidth(100);
		imageView.setPreserveRatio(true);
		imageView.setSmooth(true);
		setGraphic(imageView);
	    } else {
		setText("N/A");
		setGraphic(null);
	    }
	} else {
	    setText(null);
	    setGraphic(null);
	}
    }
}