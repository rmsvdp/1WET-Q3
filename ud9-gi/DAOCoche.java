import java.util.ArrayList;

public class DAOCoche implements DAO{

	private ArrayList<Coche> misCoches = new ArrayList<Coche>();
	
	public DAOCoche() {
		// TODO Auto-generated constructor stub
	}

    public void addCoche(Coche c) {
    
    	misCoches.add(c);	// Añado el coche al arrayList Existente
    };
    public void updateCoche(Coche _old, Coche _new) {
    	// Decidimos no cambiar la matrícula
    	_old.setModelo(_new.getModelo());
    	_old.setColor(_new.getColor());
    	_old.setYear(_new.getYear());
    };
    public boolean deleteCoche(Coche c) {
    	
    	Coche _t;
    	 _t = misCoches.remove(misCoches.indexOf(c));
    	 if (_t != null) return true;
    	 else			 return false;
    };
    public Coche findCoche(String matricula) {
    	
    	for (Coche c: misCoches) {   		
    		if (c.getMatricula().equals(matricula)) return c;
    	}
    	return null;
    };
    public ArrayList<Coche> getCoches() {
    	
    	return misCoches;
    };
}
