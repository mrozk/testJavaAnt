package com.aplant.ws.vaadin;

import java.io.File;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.FilesystemContainer;
import com.vaadin.data.util.TextFileProperty;
import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
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
		final Button button = new Button("Push it!");

		button.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				 button.setCaption("You pushed it!");
				
			}

			
		});
		
		
		
		HorizontalSplitPanel split = new HorizontalSplitPanel();
		
		
		setContent(split);
		split.addComponent(docList);
		
		HorizontalLayout hl = new HorizontalLayout();
		hl.addComponent(button);
		hl.addComponent(docView);
		
		split.addComponent(hl);
		
		docList.addValueChangeListener(new ValueChangeListener() {
			@Override
			public void valueChange(ValueChangeEvent event) {
				docView.setPropertyDataSource(new TextFileProperty((File)event.getProperty().getValue()));
			}
		});
		docList.setImmediate(true);
    }
}
