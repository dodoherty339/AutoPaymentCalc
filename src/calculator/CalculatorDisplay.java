package calculator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class CalculatorDisplay 
{
	private Shell sh;
	private Display dsp;
	private int nLeft, nTop;
	private String title = "Auto Loan Calculator";
	private Selector s;	//Selection Adapter
	
	public CalculatorDisplay(Integer h, Integer w)
	{
		dsp = new Display();
		sh = new Shell(dsp);
		sh.setText(title);
		sh.setSize(h, w);
		center();
	}
	
	//centers window
	private void center()
	{
		Monitor [] monitors = dsp.getMonitors(); //Get the number of monitors
		Rectangle mBounds = monitors[0].getBounds(); 
		Point p = sh.getSize();
		nLeft = (mBounds.width - p.x)/2;
		nTop = (mBounds.height - p.y)/2;
		
		sh.setBounds(nLeft, nTop, p.x, p.y);
	}
	
	public void openShell()
	{
		sh.pack();
		sh.open();
	}
	
	public void genInitValEntryPage()
	{
		List<List<Text>> initVals = new ArrayList<>();
		String[][] labels = {{"Start Date", ""},{"Interest Rate", ""},
				{"Interest Per Day", "0.0%"}, {"Loan Amount", ""}, {"Term (Months)", ""}};
		Text t;
		
		GridLayout gl = new GridLayout(2, true);
		gl.horizontalSpacing = 2;
		gl.verticalSpacing = 5;
		gl.marginBottom = 5;
		gl.marginTop = 5;
		sh.setLayout(gl);
		
		for( String[] l : labels)
		{
			List<Text> label = new ArrayList<>();
			//Create the label
			t = new Text(sh, SWT.READ_ONLY | SWT.LEFT);
			t.setText(l[0]);
			label.add(t);
			
			//Create the text box
			if(l[0].compareTo(labels[2][0])==0)
			{
				t = new Text(sh, SWT.BORDER | SWT.READ_ONLY | SWT.RIGHT);
			}
			else
			{	
				
				t = new Text(sh, SWT.BORDER | SWT.RIGHT);
			}
			t.setText(l[1]);
			label.add(t);
			
			initVals.add(label);
		}
		
		Button calcButton = new Button(sh, SWT.PUSH | SWT.CENTER);
		s = new Selector(sh, initVals);
		calcButton.setText("Calculate");
		calcButton.setSize(80,30);
		calcButton.setLocation(50, 100);
		calcButton.addSelectionListener(s);
	}
	
	public void genPaymentMatrix()
	{
		
	}
	
	public void sleep()
	{
		//While sh is not disposed read the event queue
		while(!sh.isDisposed())
		{
			//returns false if the caller can sleep until another
			//event is placed into the event queue
			if(!dsp.readAndDispatch())
			{
				dsp.sleep();
			}
		}
	}
	
	public void close()
	{
		dsp.dispose();
	}
}
