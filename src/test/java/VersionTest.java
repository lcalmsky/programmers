import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VersionTest {
    // ... write your unit tests here ...

    static final String errorVersionMustNotBeNull = "'version' must not be null!";
    static final String errorOtherMustNotBeNull = "'other' must not be null!";

    // expected error messages:
    static final String errorVersionMustMatchPattern = "'version' must match: 'major.minor.patch(-SNAPSHOT)'!";

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void exampleTest() {
        Version version = new Version("3.8.0");
        // ...
    }

    @Test
    public void exampleTest2() {
        Version version = new Version("3.8.0-SNAPSHOT");
        // ...
    }

    @Test
    public void givenVersionObject_whenConstructorArgumentIsNull_thenThrowsException() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(errorVersionMustNotBeNull);
        Version version = new Version(null);
    }

    @Test
    public void givenVersion_whenNotMatchesRegex_thenThrowsException() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(errorVersionMustMatchPattern);
        Version version = new Version("a.9.0");
    }

    @Test
    public void givenVersions_whenCheckFormats_thenCorrect() {
        Version versionX = new Version("1.0.0");
        Version versionXWithSnapshot = new Version("1.0.0-SNAPSHOT");
        Version versionXY = new Version("1.1.0");
        Version versionXYWithSnapshot = new Version("1.1.0-SNAPSHOT");
        Version versionXYZ = new Version("1.1.1");
        Version versionXYZWithSnapshot = new Version("1.1.1-SNAPSHOT");
    }

    @Test
    public void givenVersion_whenCheckWhetherIsSnapshot_thenCorrect() {
        Version version = new Version("1.0.0");
        Assert.assertFalse(version.isSnapshot());
        version = new Version("1.0.0-SNAPSHOT");
        Assert.assertTrue(version.isSnapshot());

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(errorVersionMustMatchPattern);

        version = new Version("1.0.0-SNAPSHOt");
        Assert.assertFalse(version.isSnapshot());
    }

    @Test
    public void givenNullVersionObject_whenCompare_thenThrowsException() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(errorOtherMustNotBeNull);

        Version version = new Version("1.0.0");
        version.compareTo(null);
    }

    @Test
    public void givenVersionsWithOrWithoutSnapshot_whenCompare_thenCorrect() {
        Version version = new Version("1.0.0");
        int comparison = version.compareTo(new Version("1.0.0-SNAPSHOT"));
        Assert.assertTrue(comparison > 0);
    }

    @Test
    public void givenTwoVersions_whenCompare_thenCorrect() {
        Version version1 = new Version("1.0.0");
        Version version2 = new Version("1.1.0");
        int comparison = version2.compareTo(version1);
        Assert.assertTrue(comparison > 0);
        version1 = new Version("1.1.0");
        comparison = version2.compareTo(version1);
        Assert.assertEquals(0, comparison);
        version2 = new Version("1.1.1");
        comparison = version2.compareTo(version1);
        Assert.assertTrue(comparison > 0);
        version1 = new Version("1.1.1");
        comparison = version2.compareTo(version1);
        Assert.assertEquals(0, comparison);
    }

    @Test
    public void givenVersion_whenTheVersionHasMoreThanThreePart_thenThrowsException() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(errorVersionMustMatchPattern);
        Version version = new Version("1.1.1.1");
    }
}

class Version implements Comparable<Version> {

    public static final Pattern PATTERN = Pattern.compile("\\d+(\\.\\d+){0,2}(-SNAPSHOT)?");
    private String version;

    public Version(String version) {
        if (version == null) throw new IllegalArgumentException("'version' must not be null!");
        Matcher matcher = PATTERN.matcher(version);
        if (!matcher.matches())
            throw new IllegalArgumentException("'version' must match: 'major.minor.patch(-SNAPSHOT)'!");
        this.version = version;
    }

    public boolean isSnapshot() {
        return version.endsWith("-SNAPSHOT");
    }

    @Override
    public int compareTo(Version o) {
        try {
            return Boolean.compare(o.isSnapshot(), this.isSnapshot());
        } catch (Exception e) {
            throw new IllegalArgumentException("'other' must not be null!");
        }
    }


    @Override
    public String toString() {
        return String.format(
                "Version (version=%s)", this.version);
    }
}
