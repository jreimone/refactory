package smell_model.ui;

import smell_model.Observer;
import smell_model.impl.ModelSmellModelImpl;

public class View_Tree implements Observer{
	
	public View_Tree(){
		ModelSmellModelImpl.getMain().register(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
