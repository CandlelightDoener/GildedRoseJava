import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

@RunWith(JUnitQuickcheck.class)
public class GildedRoseTest {

	@Test
	public void testTheTruth() {
		assertTrue(true);
	}

	@Property
	public void qualityIsNeverNegative(@InRange(minInt=-10, maxInt=10) int sellIn, @InRange(minInt=0, maxInt= 10) int quality){
		Item item = new Item("hhdwgdzgw", sellIn, quality);
		GildedRose.with(item).updateQuality();
		assertThat(item.getQuality(), not(lessThan(0)));
	}
}
