package com.example.lint.registry;

import com.android.tools.lint.detector.api.Issue;
import com.example.lint.detectors.AndroidLogDetector;
import com.example.lint.detectors.DirectMaterialPaletteColorUsageDetector;
import com.example.lint.detectors.HardcodedColorsDetector;
import com.example.lint.detectors.NonMaterialColorsDetector;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LintRegistryTest {

    private LintRegistry lintRegistry;
    private static final int NUMBER_OF_EXISTING_DETECTORS = 4;

    @Before
    public void setUp() {
        lintRegistry = new LintRegistry();
    }

    @Test
    public void number_of_issues_registered() {
        int size = lintRegistry.getIssues().size();
        assertThat(size).isEqualTo(NUMBER_OF_EXISTING_DETECTORS);
    }

    @Test
    public void issues_verification() {
        List<Issue> actual = lintRegistry.getIssues();
        assertThat(actual).contains(AndroidLogDetector.ISSUE);
        assertThat(actual).contains(HardcodedColorsDetector.ISSUE);
        assertThat(actual).contains(DirectMaterialPaletteColorUsageDetector.ISSUE);
        assertThat(actual).contains(NonMaterialColorsDetector.ISSUE);
    }

}
