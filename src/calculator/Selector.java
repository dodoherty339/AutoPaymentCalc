package calculator;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


public class Selector extends SelectionAdapter 
{
	private Shell sh;
	private List<List<Text>> saveVals = new ArrayList<List<Text>>();
	
	public Selector(Shell sh, List<List<Text>> saveVals) 
	{
		this.sh = sh;
		this.saveVals = saveVals;
	}
	
	@Override
	public void widgetSelected(SelectionEvent e)
	{
		for( List<Text> l : saveVals)
		{
			System.out.printf("%s = %s \n", l.get(0).getText(), l.get(1).getText());
		}
		
		sh.getDisplay().dispose();
		System.exit(0);
	}
}