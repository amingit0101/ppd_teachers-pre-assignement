package model;

public class ChoosenModule {
	public class ChoosenModules {
	    private int chosenMId;
	    private int choiceModule;
	    private String choiceType;
	    private int assgnId;
	    private String statuse;

	    public ChoosenModules() {}
	    public ChoosenModules(int chosenMId, int choiceModule, String choiceType, int assgnId, String statuse) {
	        this.chosenMId = chosenMId;
	        this.choiceModule = choiceModule;
	        this.choiceType = choiceType;
	        this.assgnId = assgnId;
	        this.statuse = statuse;
	    }
	    
	    // Getters/Setters
	    public int getChosenMId() { return chosenMId; }
	    public void setChosenMId(int chosenMId) { this.chosenMId = chosenMId; }
	    public int getChoiceModule() { return choiceModule; }
	    public void setChoiceModule(int choiceModule) { this.choiceModule = choiceModule; }
	    public String getChoiceType() { return choiceType; }
	    public void setChoiceType(String choiceType) { this.choiceType = choiceType; }
	    public int getAssgnId() { return assgnId; }
	    public void setAssgnId(int assgnId) { this.assgnId = assgnId; }
	    public String getStatuse() { return statuse; }
	    public void setStatuse(String statuse) { this.statuse = statuse; }
	}
}
