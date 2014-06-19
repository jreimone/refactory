
public class EclipseDemoCampMain {

	private static String[] presentations = {
		"Refactoring Models",
		"JPA in OSGi-Anwendungen",
		"Computer-Aided Warehouse Engineering",
		"Modellbasiertes Testen mit Xtext und Fit",
		"Easy and clean seperation of hand-written methods in EMF models with eJava"
	};
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Eclipse Demo Camp 2010 in Dresden");
		System.out.println("This are the presentations we'll see tonight:");
		for (String presentation : presentations) {
			System.out.println(presentation);
		}
		System.out.println("Relax and get entertained");
	}

}
