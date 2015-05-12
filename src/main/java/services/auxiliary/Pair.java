package services.auxiliary;

public class Pair {

	private String model1;
	private String model2;
	public Pair(String model1, String model2) {
		this.model1 = model1;
		this.model2 = model2;
	}
	
	  public String getPaired(String model) throws Exception{
		if(model==model1)
			return model2;
		else if (model == model2)
			return model1;
	    else
	    	throw new Exception();
	  }

	  public Boolean contains(String model){
		 return model.equals(model1)||model.equals(model2);
	  }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((model1 == null) ? 0 : model1.hashCode());
		result = prime * result + ((model2 == null) ? 0 : model2.hashCode());
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
		if (this.model1.equals(other.model1) && this.model2.equals(other.model2))
			return true;
		if (this.model1.equals(other.model2) && this.model2.equals(other.model1))
			return true;
		return false;
	}
}
