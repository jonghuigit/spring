package myspring.di.xml;

public class Hello {
	// OOP - 캡슐화 (=은닉) ==> setter에 의해서만 데이터 변경 가능
	private String name;
	private Printer printer;
	
	public void setName(String name) {	// name Field에 기본형 값을 주입받기 위한 메서드
		this.name = name;
	}
	public void setPrinter(Printer printer) {	// printer Field에 참조형 값을 주입받기 위한 메서드
		this.printer = printer;
	}
	
	public String sayHello() {
		return "Hello "  + name;
	}
	
	public void print() {	
		// 어떤 객체가 주입되었는가에 따라서 다르게 동작한다.
		// OOP - 다형성 ==> 유연하게 동작
		//			  ==> setPrinter에서 ConsolePrinter/StringPrinter에 따라 달라짐
		printer.print(sayHello());
	}
}
