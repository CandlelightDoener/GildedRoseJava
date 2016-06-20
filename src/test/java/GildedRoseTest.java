import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.internal.generator.GeneratorRepository;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

@RunWith(JUnitQuickcheck.class)
public class GildedRoseTest {

	public static GeneratorRepository repo;

	@BeforeClass
	public static void setup(){
		repo = new GeneratorRepository(null);
		repo.register(new ItemNameGenerator());
	}

	@Test
	public void testTheTruth() {
		assertTrue(true);
	}

	@Property
	public void qualityIsNeverNegative(@From(ItemNameGenerator.class) String randomItemName, @InRange(minInt=-10, maxInt=10) int sellIn, @InRange(minInt=0, maxInt=10) int quality){
		Item item = new Item(randomItemName, sellIn, quality);
		GildedRose.with(item).updateQuality();
		assertThat(item.getQuality(), not(lessThan(0)));
	}
}
