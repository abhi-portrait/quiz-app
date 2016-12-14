
public class Test {
	public static void main(String[] args) {
		Question q=new Question();
		q.setName("what is java ?");
		q.setQ_id(1);
		q.setRightanswer(2);
		Answer ans=new Answer();
		ans.setAns_id(1);
		ans.setOpt1("java is 1");
		ans.setOpt2("java is 2");
		ans.setOpt3("java is 3");
		ans.setOpt4("java is 4");
		q.setAns(ans);
		
		Question q1=new Question();
		q1.setName("what is oops ?");
		q1.setQ_id(2);
		q1.setRightanswer(3);
		Answer ans1=new Answer();
		ans1.setAns_id(5);
		ans1.setOpt1("java is 1");
		ans1.setOpt2("java is 2");
		ans1.setOpt3("java is 3");
		ans1.setOpt4("java is 4");
		q1.setAns(ans1);
		
		Question qq[]={q,q1};
		
		Question t=qq[0];
		Answer tt=t.getAns();
		
		System.out.println(tt.getOpt1());
	
		
		
	}

}
