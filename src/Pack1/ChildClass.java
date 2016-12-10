package Pack1;

import org.openqa.selenium.By;

//Overloading: 
public class ChildClass extends WaitforObjectFluentWait{
	public static void main(String[] args) {
		Parentclass parent=new Parentclass();
		/*parent.sum2numbers(10, 3);
		parent.sum3numbers(12, 23, 45);*/
		WaitforObjectFluentWait fluentwait=new WaitforObjectFluentWait();
		fluentwait.waitForElementToAppear(By.linkText("Gmail"));
		parent.sum(12, 23,34);
	}

}
