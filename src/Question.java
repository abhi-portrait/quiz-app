
public class Question {
private String name;
private int q_id;
private int rightanswer;
private Answer ans;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getQ_id() {
	return q_id;
}
public void setQ_id(int qId) {
	q_id = qId;
}
public int getRightanswer() {
	return rightanswer;
}
public void setRightanswer(int rightanswer) {
	this.rightanswer = rightanswer;
}
public Answer getAns() {
	return ans;
}
public void setAns(Answer ans) {
	this.ans = ans;
}
}
