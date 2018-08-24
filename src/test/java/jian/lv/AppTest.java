package jian.lv;
import com.greghaskins.spectrum.Spectrum;
import org.junit.runner.RunWith;

import static com.greghaskins.spectrum.Spectrum.it;
import static com.greghaskins.spectrum.dsl.specification.Specification.context;
import static com.greghaskins.spectrum.dsl.specification.Specification.describe;
import static org.assertj.core.api.Assertions.*;

@RunWith(Spectrum.class)
public class AppTest {{
    describe("Given an App", () -> {
        context("When it start", () -> {
            it("says greeting", () -> {
                App app = new App();
                assertThat(app.getGreeting()).isEqualTo("Hello world.");
            });
        });
    });
}}
