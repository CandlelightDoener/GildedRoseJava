import java.util.Arrays;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;


public class ItemNameGenerator extends Generator<String> {

	public ItemNameGenerator() {
		super(String.class);
	}

	@Override
	public String generate(SourceOfRandomness random, GenerationStatus status) {
		return random.choose(Arrays.asList("hrfggrump", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert","Sulfuras, Hand of Ragnaros"));
	}

}
