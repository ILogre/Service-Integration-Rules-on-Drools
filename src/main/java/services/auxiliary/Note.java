package services.auxiliary;

public class Note {
	
	private String note;
	private boolean critical;
	
	public String getNote() {
		return note;
	}
	public boolean isCritical() {
		return critical;
	}
	public Note(String note, boolean critical) {
		super();
		this.note = note;
		this.critical = critical;
	}
}
