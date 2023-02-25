import java.util.Scanner;

public class Facture {

	
	public float calcul1ligne(int quantite, float prixU) {
		return quantite*prixU;
	}
	
	public float commandeUnitaire() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez la quantité du produit");
		int quantite = sc.nextInt();
		System.out.println("Entrez le prix unitaire du produit");
		float prixU = sc.nextFloat();
		float prix = calcul1ligne(quantite, prixU);
		System.out.println("Le coût de la ligne est de " + prix);
		return prix;
	}
	
	public float commandeMultiple() {
		Scanner sc = new Scanner(System.in);
		boolean fini = false;
		float total = 0;
		while (!fini) {
			total += commandeUnitaire();
			System.out.println("Avez-vous fini ? o/n");
			String reponse = sc.nextLine();
			if (reponse.equals("o")) {
				fini = true;
			}
		}
		
		System.out.println("Le montant total de la commande (avant discount et taxes) est de " + total);
		total = calculDiscount(total);
		System.out.println("Le montant total de la commande après discount et sans taxes) est de " + total);
		
		System.out.println("Prix après taxe : " + calculTaxe(total));
		return 0;
	}
	
	public float calculDiscount(float prix) {
		if (prix <1000) {
			return prix;
		}
		if (prix <5000 && prix >= 1000) {
			return prix*0.97f;
		}
		if (prix <7000 && prix >= 5000) {
			return prix*0.95f;
		}
		if (prix <10000 && prix >= 7000) {
			return prix*0.93f;
		}
		if (prix <50000 && prix >= 10000) {
			return prix*0.9f;
		}
		
		return prix*0.85f;

	}
	
	public float calculTaxe(float prix) {
		Scanner sc = new Scanner(System.in);
		String code ="";
		System.out.println("Quel est le code de l'état ?");
		code = sc.nextLine();
		switch(code) {
		case "UT" :
			prix = prix*1.0685f;
			break;
		case "NV" :
			prix = prix*1.08f;
			break;
		case "TX" :
			prix = prix*1.0625f;
			break;
		case "AL" :
			prix = prix*1.04f;
			break;
		case "CA" :
			prix = prix*1.0825f;
			break;
		}
		return prix;
	}
	
	
	public static void main(String[] args) {
		
		Facture f = new Facture();
		
		f.commandeMultiple();
		
	}
		
}
