package jian.lv;

import com.greghaskins.spectrum.Spectrum;
import org.junit.runner.RunWith;

import java.util.LinkedList;
import java.util.List;

import static com.greghaskins.spectrum.Spectrum.it;
import static com.greghaskins.spectrum.dsl.specification.Specification.context;
import static com.greghaskins.spectrum.dsl.specification.Specification.describe;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

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

    describe("Mockito", () -> {
        it("mocks", () -> {
            List mockedList = mock(List.class);

            mockedList.add("1");
            mockedList.clear();

            verify(mockedList).add("1");
            verify(mockedList).clear();
        });

        it("stubs", () -> {
            List mockedList = mock(List.class);
            when(mockedList.get(0))
                    .thenReturn("1");

            assertThat(mockedList.get(0)).isEqualTo("1");
            assertThat(mockedList.get(2)).isNull();
        });

        it("stub spy", () -> {
            List numbers = new LinkedList();
            List spy = spy(numbers);

            spy.add(1);

            assertThat(spy.get(0)).isEqualTo(1);

            doReturn(5).when(spy).get(4);
            assertThat(spy.get(4)).isEqualTo(5);
        });

        it("bdd style", () -> {
            List mockedList = mock(List.class);
            given(mockedList.get(anyInt())).willReturn(1);

            assertThat(mockedList.get(0)).isEqualTo(1);
        });
    });
}}
