package hu.infokristaly.homework4ndef;

import com.google.gson.GsonBuilder;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.nfctools.tools.NdefListenerThread;
import org.nfctools.tools.json.NdefJsonMessage;

public class FXMLController implements Initializable, NDefMessageListener {

    @FXML
    private TextArea txtLog;

    @FXML
    private TextField txtFieldNDef;

    private Thread thread;
    private String newLine;
    private NdefListenerThread ndefListenerThread;

    public void sendToJavaScript(NdefJsonMessage ndefJsonMessage) {
        String json = toJson(ndefJsonMessage);
        txtLog.appendText(json);
        txtLog.appendText(newLine);
        System.out.println(json);
    }

    private String toJson(Object object) {
        try {
            return new GsonBuilder().create().toJson(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void sendNDefTag(String jsonMessage) {
        ndefListenerThread.addMessage(jsonMessage);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        newLine = System.getProperty("line.separator");
        ndefListenerThread = new NdefListenerThread(this);
        thread = new Thread(ndefListenerThread);
        thread.start();
    }

    @FXML
    public void sendNDefJSon(ActionEvent e) {
        sendNDefTag(txtFieldNDef.getText());
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
    
    
}
