package bandago.views;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import bandago.utils.Parameters;

public class ParameterConfigurator extends Dialog {
	
	private Text txtMSTE;
	private Text txtTMP;
	private Text txtMDI;
	private Text txtNOS;
	private Text txtCDF;
	private Text txtTPS;
	private Group grpSimulatedAnnealing;
	private Button btnMSTE;
	private Button btnTMP;
	private Button btnMDI;
	private Button btnNOS;
	private Button btnCDF;
	private Button btnTPS;
	private Button btnBCR;
	private Text txtBCR;
	
	
	public ParameterConfigurator(Shell parentShell) {
		super(parentShell);
	}
	
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(null);
		
		grpSimulatedAnnealing = new Group(container, SWT.NONE);
		grpSimulatedAnnealing.setText("Simulated Annealing Parameters");
		grpSimulatedAnnealing.setBounds(10, 10, 385, 225);
		
		txtMSTE = new Text(grpSimulatedAnnealing, SWT.BORDER);
		txtMSTE.setText(Integer.toString(Parameters.getMSTE()));
		txtMSTE.setBounds(31, 25, 59, 22);
		txtMSTE.setEnabled(false);
		txtMSTE.setToolTipText("Minimum number of lines of code present in an extraction. \nWe recommend do this with " + Parameters.DMSTE + " lines.");
		
		txtTMP = new Text(grpSimulatedAnnealing, SWT.BORDER);
		txtTMP.setText(Double.toString(Parameters.getTMP()));
		txtTMP.setBounds(31, 75, 59, 22);
		txtTMP.setEnabled(false);
		txtTMP.setToolTipText("Algorithm Temperature. \nWe recommend to use a value next to " + Parameters.DTMP + ".");
		
		txtMDI = new Text(grpSimulatedAnnealing, SWT.BORDER);
		txtMDI.setText(Integer.toString(Parameters.getMDI()));
		txtMDI.setBounds(31, 125, 59, 22);
		txtMDI.setEnabled(false);
		txtMDI.setToolTipText("Maximum amount of iterations performed by the algorithm . \nWe recommend to use a value next to " + Parameters.DMDI + ".");
		
		txtNOS = new Text(grpSimulatedAnnealing, SWT.BORDER);
		txtNOS.setText(Integer.toString(Parameters.getNOS()));
		txtNOS.setBounds(230, 25, 59, 22);
		txtNOS.setEnabled(false);
		txtNOS.setToolTipText("Amount of solutions generated by Bandago. \nWe recommend a value arround " + Parameters.DNOS + ".");
		
		txtCDF = new Text(grpSimulatedAnnealing, SWT.BORDER);
		txtCDF.setText(Double.toString(Parameters.getCDF()));
		txtCDF.setBounds(230, 75, 59, 22);
		txtCDF.setEnabled(false);
		txtCDF.setToolTipText("Algorithm Cooldown Factor. \nWe recommend tu use a value next to " + Parameters.DCDF + ".");
		
		txtTPS = new Text(grpSimulatedAnnealing, SWT.BORDER);
		txtTPS.setToolTipText("Maximum time to look for a single solution . \nWe recommend to use a value next to " + Parameters.DTPS + " seconds.");
		txtTPS.setText(Long.toString(Parameters.nanoToSec(Parameters.getTPS())));
		txtTPS.setEnabled(false);
		txtTPS.setBounds(230, 125, 59, 22);
		
		txtBCR = new Text(grpSimulatedAnnealing, SWT.BORDER);
		txtBCR.setToolTipText("Benefit/Cost ratio allowed . \nWe recommend to use a value next to " + Parameters.DBCR + ".");
		txtBCR.setText(Double.toString(Parameters.getBCR()));
		txtBCR.setEnabled(false);
		txtBCR.setBounds(31, 173, 59, 22);
		
		btnMSTE = new Button(grpSimulatedAnnealing, SWT.CHECK);
		btnMSTE.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				selectParameter(btnMSTE,txtMSTE);
			}
		});
		btnMSTE.setBounds(10, 5, 194, 18);
		btnMSTE.setText("Minimum Statements to Extract");
		
		btnTMP = new Button(grpSimulatedAnnealing, SWT.CHECK);
		btnTMP.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				selectParameter(btnTMP,txtTMP);
			}
		});
		btnTMP.setBounds(10, 55, 95, 18);
		btnTMP.setText("Temperature");
		
		btnMDI = new Button(grpSimulatedAnnealing, SWT.CHECK);
		btnMDI.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				selectParameter(btnMDI,txtMDI);
			}
		});
		btnMDI.setBounds(10, 105, 129, 18);
		btnMDI.setText("Max Deep Iterations");
		
		btnNOS = new Button(grpSimulatedAnnealing, SWT.CHECK);
		btnNOS.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				selectParameter(btnNOS,txtNOS);
			}
		});
		btnNOS.setBounds(210, 5, 131, 18);
		btnNOS.setText("Number of Solutions");
		
		btnCDF = new Button(grpSimulatedAnnealing, SWT.CHECK);
		btnCDF.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				selectParameter(btnCDF,txtCDF);
			}
		});
		btnCDF.setBounds(210, 55, 129, 18);
		btnCDF.setText("Cooldown Factor");
		
		btnTPS = new Button(grpSimulatedAnnealing, SWT.CHECK);
		btnTPS.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				selectParameter(btnTPS,txtTPS);
			}
		});
		btnTPS.setText("Time Per Solution (Seconds)");
		btnTPS.setBounds(210, 105, 170, 18);
		
		
		Button btnRestoreDefaultValues = new Button(grpSimulatedAnnealing, SWT.NONE);
		btnRestoreDefaultValues.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				restoreDefault();
			}
		});
		btnRestoreDefaultValues.setBounds(210, 169, 158, 28);
		btnRestoreDefaultValues.setText("Restore Default Values");
		
		btnBCR = new Button(grpSimulatedAnnealing, SWT.CHECK);
		btnBCR.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				selectParameter(btnBCR,txtBCR);
			}
		});
		btnBCR.setText("Benefit/Cost Ratio");
		btnBCR.setBounds(10, 153, 129, 18);
		
		Label separator = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		separator.setBounds(15, 235, 375, 2);
		
		return container;
	}
	
	protected void setTxtField(Text txtField,String txt,int x,int y,int w,int h,boolean enabled,String toolTip ){
		txtField = new Text(grpSimulatedAnnealing, SWT.BORDER);
		txtField.setText(txt);
		txtField.setBounds(x, y, w, h);
		txtField.setEnabled(enabled);
		txtField.setToolTipText(toolTip);
	}

	protected void restoreDefault() {
		txtMSTE.setText(Integer.toString(Parameters.DMSTE));
		txtTMP.setText(Double.toString(Parameters.DTMP));
		txtMDI.setText(Integer.toString(Parameters.DMDI));
		txtNOS.setText(Integer.toString(Parameters.DNOS));
		txtCDF.setText(Double.toString(Parameters.DCDF));
		txtTPS.setText(Long.toString(Parameters.nanoToSec(Parameters.DTPS)));
		txtBCR.setText(Double.toString(Parameters.DBCR));
	}

	protected void createButtonsForButtonBar(Composite parent) {
		Button button = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		button.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				okButtonPressed();
			}
		});
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	private void okButtonPressed() {
		if(btnMSTE.getSelection() && isInteger(txtMSTE.getText()))
			Parameters.setMSTE(Integer.parseInt(txtMSTE.getText()));
		if(btnTMP.getSelection() && isDouble(txtTMP.getText()))
			Parameters.setTMP(Double.parseDouble(txtTMP.getText()));
		if(btnMDI.getSelection() && isInteger(txtMDI.getText()))
			Parameters.setMDI(Integer.parseInt(txtMDI.getText()));
		if(btnNOS.getSelection() && isInteger(txtNOS.getText()))
			Parameters.setNOS(Integer.parseInt(txtNOS.getText()));
		if(btnCDF.getSelection() && isDouble(txtCDF.getText()))
			Parameters.setCDF(Double.parseDouble(txtCDF.getText()));
		if(btnTPS.getSelection() && isLong(txtTPS.getText()))
			Parameters.setTPS(Parameters.secToNano(Long.parseLong(txtTPS.getText())));
		if(btnBCR.getSelection() && isDouble(txtBCR.getText()))
			Parameters.setBCR(Double.parseDouble(txtBCR.getText()));
	}
	
	protected void selectParameter(Button btn,Text txt){
		if(btn.getSelection()==true)
			txt.setEnabled(true);
		if(btn.getSelection()==false)
			txt.setEnabled(false);
	}
	
	@SuppressWarnings("unused")
	private boolean isInteger(String str){
		try  
		  {  
		    int i = Integer.parseInt(str);  
		  }  
		  catch(NumberFormatException nfe)  
		  {  
		    return false;  
		  }  
		  return true;
	}
	
	@SuppressWarnings("unused")
	private boolean isDouble(String str){
		try  
		  {  
		    double d = Double.parseDouble(str);  
		  }  
		  catch(NumberFormatException nfe)  
		  {  
		    return false;  
		  }  
		  return true;
	}
	
	@SuppressWarnings("unused")
	private boolean isLong(String str) {
		try  
		  {  
		    long l = Long.parseLong(str,10);  
		  }  
		  catch(NumberFormatException nfe)  
		  {  
		    return false;  
		  }  
		  return true;
	}

	protected Point getInitialSize() {
		return new Point(405, 310);
	}
}