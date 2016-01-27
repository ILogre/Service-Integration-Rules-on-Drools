package services.auxiliary;

public class Pair {

	private String element1;
	private String element2;
	private boolean bidirectionnal;
	
	public Pair(String model1, String model2, boolean bidirectionnal) {
		this.element1 = model1;
		this.element2 = model2;
		this.bidirectionnal = bidirectionnal;
	}
	
	  public String getPaired(String element) throws Exception{
		if(element==element1)
			return element2;
		else if (element == element2 && bidirectionnal )
			return element1;
	    else
	    	throw new Exception();
	  }

	  public Boolean contains(String model){
		 return model.equals(element1)||model.equals(element2);
	  }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((element1 == null) ? 0 : element1.hashCode());
		result = prime * result + ((element2 == null) ? 0 : element2.hashCode());
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
		if (this.element1.equals(other.element1) && this.element2.equals(other.element2))
			return true;
		if (this.element1.equals(other.element2) && this.element2.equals(other.element1))
			return true;
		return false;
	}
}
