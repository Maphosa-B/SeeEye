package animals_logic;

//Imports
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import streams.animal;
import streams.myHttpRequests;

/**
 * Logic class which is used to simulate animal traits
 * @author BONGINKOSI
 *
 */
public class logic {
	//Private global variables
	private String animalName = null;
	private Socket s = null;
	private File selectedAnimalImageFile = null;
	private myHttpRequests requests = null;
	
	
	
	/**
	 * Constructor
	 * @param animalName - Animal name Which will be used for logic selection
	 * @param selectedAnimalImageFile - will be sent to server to get features
	 */
	public logic( String animalName, File selectedAnimalImageFile) 
	{
		try {
			s = new Socket("localhost",5000);
			this.animalName = animalName;
			this.selectedAnimalImageFile = selectedAnimalImageFile;	
			requests = new myHttpRequests(this.s);
		} catch (UnknownHostException e) {
			System.err.println("Invalid host name on logic class"); 
		} catch (IOException e) {
			System.err.println("Unable to bind to given port number");
		}
	}
	
	
	/**
	 * Method is responsible for sending image to server
	 * @return  returns an object of animal which contains description and edited image
	 */
	public animal getAnimalView()
	{
		//Animal object instantiation
		animal resultAnimal = new animal();
			
		//logic for different animals 
		if(this.animalName.toUpperCase().equals("FLY".toUpperCase()))
		{		
			resultAnimal.image = requests.getDilation(selectedAnimalImageFile);
			resultAnimal.Info = "The visual ecology of flies is outstanding among insects due to a combination of specific attributes. Flies’ compound eyes possess an open rhabdom and thus separate"
					+ " rhabdomeres in each ommatidium assigned to two visual pathways. The highly sensitive, monovariant neural superposition system is based on the excitation of the peripheral rhabdomeres"
					+ " of the retinula cells R1–6 and controls optomotor reactions. The two forms of central rhabdomeres of R7/8 retinula cells in each ommatidium build up a system with four "
					+ "photoreceptors sensitive in different wavelength ranges and thought to account for colour vision. Evidence from wavelength discrimination tests suggests that all colour stimuli are "
					+ "assigned to one of just four colour categories, but cooperation of the two pathways is also evident. Flies use colour cues for various behavioural reactions such as flower visitation,"
					+ " proboscis extension, host finding, and egg deposition. Direct evidence for colour vision, the ability to discriminate colours according to spectral shape but independent of intensity, "
					+ "has been demonstrated for few fly species only. Indirect evidence for colour vision provided from electrophysiological recordings of the spectral sensitivity of photoreceptors and opsin genes"
					+ " indicates similar requisites in various flies; the flies’ responses to coloured targets, however, are much more diverse.\r\n \r\n"
					+ "Lunau, K., 2014. Visual ecology of flies with particular reference to colour vision and colour preferences. Journal of Comparative Physiology A, 200(6), pp.497-512.";
		}else if(this.animalName.toUpperCase().equals("Bat".toUpperCase())) {
			
			resultAnimal.image = requests.getGrayScale(selectedAnimalImageFile);
			resultAnimal.Info = "Insectivorous bats are well known for their abilities to find and pursue flying insect prey at close range using echolocation,"
					+ " but they also rely heavily on vision. For example, at night bats use vision to orient across landscapes, avoid large obstacles, and locate roosts."
					+ " Although lacking sharp visual acuity, the eyes of bats evolved to function at very low levels of illumination. Recent evidence based on genetics, immunohistochemistry, "
					+ "and laboratory behavioral trials indicated that many bats can see ultraviolet light (UV), at least at illumination levels similar to or brighter than those before twilight. "
					+ "Despite this growing evidence for potentially widespread UV vision in bats, the prevalence of UV vision among bats remains unknown and has not been studied outside of the laboratory."
					+ " We used a Y-maze to test whether wild-caught bats could see reflected UV light and whether such UV vision functions at the dim lighting conditions typically experienced by night-flying bats."
					+ " Seven insectivorous species of bats, representing five genera and three families, showed a statistically significant 'escape-toward-the-light' behavior when placed in the Y-maze."
					+ " Our results provide compelling evidence of widespread dim-light UV vision in bats. \r\n \r\n"
					+ "Gorresen, P.M., Cryan, P.M., Dalton, D.C., Wolf, S. and Bonaccorso, F.J., 2015. Ultraviolet vision may be widespread in bats. Acta Chiropterologica, 17(1), pp.193-198.";
		
		}else if(this.animalName.toUpperCase().equals("Snake".toUpperCase()))
		{
			resultAnimal.image = requests.getCannyEdges(selectedAnimalImageFile);
			resultAnimal.Info = "Some snakes hunt by day, some by night. The eyes of these diurnal and nocturnal hunters have adapted to the visual challenges each lifestyle faces, and ultraviolet (UV) light plays an important part."
					+ "\r\n"
					+ "Whilst snake eye anatomy has been well studied for many years, recent techniques to understand vertebrate vision has focused on mammals, birds and fish. An international team of researchers have now used gene coding to study what a snake sees, in total analysing 69 species of the reptile."
					+ "\r\n"
					+ "The aim was to gain further understanding into the evolution of colour vision. Eyes are complex and diverse, even within snake species. Their eyes contain cells called rods and cones, which in turn contain receptor proteins that react to light, "
					+ "known as opsins. Cones are responsible for colour vision; the way in which the opsins in cones react to light are what allows the perception of different colours"
					+ "\r\n"
					+ "Humans are trichromatic: the opsins found in these cones react to wavelengths of light that allow us to see three primary colours, red, blue and green. The study found snakes to be dichromatic, meaning they can see two primary colours, blue and green."
					+ "\r\n"
					+ "In addition to their colour vision, many snakes have developed a sensitivity to UV light, allowing them to see in low light conditions. This adaptation was found in the majority of snakes analysed in the study.\r\n\r\n"
					+"Chen, C.M., Lu, H.H.S. and Lin, Y.C., 2000. An early vision-based snake model for ultrasound image segmentation. Ultrasound in medicine & biology, 26(2), pp.273-285.";
		}
			
		return resultAnimal;		
	}
	
	
}


