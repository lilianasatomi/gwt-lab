package com.mySampleApplication.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.DOM;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Label;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class MySampleApplication implements EntryPoint {

/** // adicionar text fields dos campos da planilha do spreadsheet
  *  private TextBox txtNome = new TextBox();
  *  private TextBox txtIdade = new TextBox();
  *  private TextBox txtEmail = new TextBox();
*/
    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        final Button button = new Button("Hello World");
        final Label label = new Label();
        final VerticalPanel panel = new VerticalPanel();
        final TextBox txtName = new TextBox();
        final TextBox txtIdade = new TextBox();
        final Button buttonGoogle = new Button("SubmitGoogle");

        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (label.getText().equals("")) {
                    MySampleApplicationService.App.getInstance().getMessage("Hello, Lili!", new MyAsyncCallback(label));
                } else {
                    label.setText("");
                }


            }
        });

        Image image = new Image(); // Create a Image widget
        //set image source
        image.setUrl("http://prewww.superbid.net/home/logos_empresas/auction_40464.gif");
        //image.setUrl("(/Capturar.JPG)");
        // Add image to the root panel.
        panel.add(image);
        // Assume that the host HTML has elements defined whose
        // IDs are "slot1", "slot2".  In a real app, you probably would not want
        // to hard-code IDs.  Instead, you could, for example, search for all
        // elements with a particular CSS class and replace them with widgets.
        // teste
        //
        RootPanel.get("slot1").add(button);
        RootPanel.get("slot2").add(label);
        RootPanel.get("gwtContainer").add(panel);

        RootPanel.get("slot3").add(txtName);
        RootPanel.get("slot4").add(txtIdade);
        RootPanel.get("slot5").add(buttonGoogle);
    }

    private static class MyAsyncCallback implements AsyncCallback<String> {
        private Label label;
        public MyAsyncCallback(Label label) {
            this.label = label;
        }
        public void onSuccess(String result) {
            label.getElement().setInnerHTML(result);
        }
        public void onFailure(Throwable throwable) {
            label.setText("Failed to receive answer from server!");
        }
    }
}
