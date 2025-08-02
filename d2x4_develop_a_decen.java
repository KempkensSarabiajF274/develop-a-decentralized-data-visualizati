import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class d2x4_develop_a_decen {

    public static void main(String[] args) {

        // Create a sample decentralized data structure
        Map<String, List<Double>> decentralizedData = new TreeMap<>();
        decentralizedData.put("Node 1", List.of(10.2, 20.5, 15.7));
        decentralizedData.put("Node 2", List.of(11.8, 30.2, 12.9));
        decentralizedData.put("Node 3", List.of(9.5, 35.1, 18.3));

        // Convert the data to a JSON string
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonData = gson.toJson(decentralizedData);

        // Create a SWT browser to display the data visualization
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setLayout(new GridLayout(1, false));

        Browser browser = new Browser(shell, SWT.NONE);
        GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
        browser.setLayoutData(gridData);

        // Initialize the browser with a basic HTML template
        browser.setText("<html><body><h1>Decentralized Data Visualization</h1><div id='chart'></div></body></html>");

        // Load the data into the browser using JavaScript
        browser.execute("var data = " + jsonData + ";");
        browser.execute("var chart = new Chart(document.getElementById('chart'), { type: 'line', data: data });");

        // Show the shell
        shell.pack();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }
}