package lab7.bank.jms;


public class JMSSender implements IJMSSender{

	public void sendJMSMessage (String text){
		System.out.println("JMSSender: sending JMS message ="+text);
	}

}
