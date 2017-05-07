package abd.p1.model;

public enum GeneroEnum {
MASCULINO("masculino"),FEMENINO("femenino");

	private GeneroEnum genero;
    @SuppressWarnings("unused")
	private String rep;
    
    private GeneroEnum(String rep){
      this.rep=rep;	
    }
	public GeneroEnum getGeneroEnum(){
		return genero;
	}

}