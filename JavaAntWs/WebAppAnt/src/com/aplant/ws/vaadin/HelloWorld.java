package com.aplant.ws.vaadin;

import java.io.File;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.FilesystemContainer;
import com.vaadin.data.util.TextFileProperty;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
public class HelloWorld  extends UI  {
	
	FilesystemContainer docs = new FilesystemContainer(new File("/var/www/programermove/"));
	ComboBox docList = new ComboBox("Documents", docs);
	Label docView = new Label("", ContentMode.HTML);
	
	@Override
    protected void init(VaadinRequest request) {
		HorizontalSplitPanel split = new HorizontalSplitPanel();
		setContent(split);
		split.addComponent(docList);
		split.addComponent(docView);
		
		docList.addValueChangeListener(new ValueChangeListener() {
			@Override
			public void valueChange(ValueChangeEvent event) {
				docView.setPropertyDataSource(new TextFileProperty((File)event.getProperty().getValue()));
			}
		});
		docList.setImmediate(true);
    }
}
