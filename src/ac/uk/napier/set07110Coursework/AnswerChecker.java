
package ac.uk.napier.set07110Coursework;

/**
 * Requirements:  add -Xmx1024m to the VM arguments using menu run --> run configurations in eclipse
 */
public class AnswerChecker {

	public static void main(String[] args) {
		if(args != null && args.length > 0){
			System.out.println(args[0]);
		}
		
		Answer11.main(null);
		Answer12.main(null);
		Answer13.main(null);
		Answer14.main(null);
		Answer15.main(null);
	} 
}
