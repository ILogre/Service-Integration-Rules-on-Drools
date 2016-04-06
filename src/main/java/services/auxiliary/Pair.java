package services.auxiliary;

public class Pair {
	
	private Thing element1;
	private Thing element2;
	private boolean bidirectionnal;
	
	 public Pair(Thing element1, Thing element2, boolean bidirectionnal) {
		super();
		this.element1 = element1;
		this.element2 = element2;
		this.bidirectionnal = bidirectionnal;
	}
	 
	 public Pair(String element, String type, String element2, String type2, boolean bidirectionnal) {
		super();
		
		this.element1 = new Thing(element,type);
		this.element2 = new Thing(element2,type2);
		this.bidirectionnal = bidirectionnal;
	}

	public Thing getPaired(Thing element, String lookingFor) throws LinkedElementNotFoundException{
		if(element.equals(element1) && element2.getType().equalsIgnoreCase(lookingFor))
			return element2;
		else if (element.equals(element2) && bidirectionnal && element1.getType().equalsIgnoreCase(lookingFor) )
			return element1;
	    else
	    	throw new LinkedElementNotFoundException("Element "+element.getElement()+" of type "+element.getType()+" has no linked element of type "+lookingFor);
	  }

	public Thing getPaired(String modelName, String modelType, String lookingFor) throws LinkedElementNotFoundException {
		Thing model = new Thing(modelName,modelType);
		return getPaired(model, lookingFor);
	}

	  public Boolean contains(Thing model, String lookingFor){
		 return (model.equals(element1) && element2.getType().equalsIgnoreCase(lookingFor))
				 ||( model.equals(element2) && element1.getType().equalsIgnoreCase(lookingFor));
	  }
	  

	  public Boolean contains(String modelName, String modelType, String lookingFor){
		 Thing model = new Thing(modelName,modelType);
		 return this.contains(model, lookingFor);
	  }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (bidirectionnal ? 1231 : 1237);
		result = prime * result
				+ ((element1 == null) ? 0 : element1.hashCode());
		result = prime * result
				+ ((element2 == null) ? 0 : element2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (bidirectionnal != other.bidirectionnal)
			return false;
		if (element1 == null) {
			if (other.element1 != null)
				return false;
		} else if (!element1.equals(other.element1))
			return false;
		if (element2 == null) {
			if (other.element2 != null)
				return false;
		} else if (!element2.equals(other.element2))
			return false;
		return true;
	}
}