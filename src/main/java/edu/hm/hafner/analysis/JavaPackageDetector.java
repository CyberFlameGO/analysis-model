package edu.hm.hafner.analysis;

import java.util.regex.Pattern;

import edu.hm.hafner.analysis.PackageDetectors.FileSystem;
import edu.hm.hafner.util.VisibleForTesting;

/**
 * Detects the package name of a Java file.
 *
 * @author Ullrich Hafner
 */
class JavaPackageDetector extends AbstractPackageDetector {
    private static final Pattern PACKAGE_PATTERN = Pattern.compile(
            "^\\s*package\\s*([a-z]+[.\\w]*)\\s*;.*");

    JavaPackageDetector() {
        this(new FileSystem());
    }

    @VisibleForTesting
    JavaPackageDetector(final FileSystem fileSystem) {
        super(fileSystem);
    }

    @Override
    Pattern getPattern() {
        return PACKAGE_PATTERN;
    }

    @Override
    public boolean accepts(final String fileName) {
        return fileName.endsWith(".java");
    }
}
