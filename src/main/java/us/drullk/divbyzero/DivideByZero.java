package us.drullk.divbyzero;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.fml.common.Mod;

@Mod(DivideByZero.MODID)
public class DivideByZero {
    public static final String MODID = "divbyzero";
    private static final Logger LOGGER = LogUtils.getLogger();

    @SuppressWarnings("divzero")
	public DivideByZero() {
        // Get maximum memory available to the JVM
        long maxMemoryBytes = Runtime.getRuntime().maxMemory();
        long maxMemoryMB = maxMemoryBytes / (1024 * 1024);
        long totalMemoryBytes = Runtime.getRuntime().totalMemory();
        long totalMemoryMB = totalMemoryBytes / (1024 * 1024);
        long freeMemoryBytes = Runtime.getRuntime().freeMemory();
        long freeMemoryMB = freeMemoryBytes / (1024 * 1024);

        LOGGER.info("Maximum JVM memory: {} bytes ({} MB)", maxMemoryBytes, maxMemoryMB);
        LOGGER.info("Total JVM memory: {} bytes ({} MB)", totalMemoryBytes, totalMemoryMB);
        LOGGER.info("Free JVM memory: {} bytes ({} MB)", freeMemoryBytes, freeMemoryMB);

        LOGGER.warn("Dividing by zero!!!");
        // Crash the JVM intentionally for testing host server config
        LOGGER.error("Result of dividing by zero: {}", 1 / 0); // This should not ever print

        throw new IllegalStateException("You survived division by zero, prepare to crash");
    }
}
